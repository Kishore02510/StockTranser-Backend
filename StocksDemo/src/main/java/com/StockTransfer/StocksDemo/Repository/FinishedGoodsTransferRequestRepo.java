package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedGoodsTransferRequestRepo extends JpaRepository<FinishedGoodsTransferRequest,Integer> {

    @Query("""
        SELECT new com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO(
            fgtr.finishedgoodstransferrequestid,
            r.officename,
            s.officename
        )
        FROM FinishedGoodsTransferRequest fgtr
        JOIN fgtr.receivingOffice r
        JOIN fgtr.requestingOffice s
        WHERE fgtr.finishedgoodstransferrequestid = :requestId
    """)
    List<RequestDetailsDTO> getRequestDetails(@Param("requestId") int requestId);

    @Query(value = """
    SELECT 
        fgtr.finishedgoodstransferrequestid,
        fgtr.receivingofficeid,
        fgtr.requestingofficeid,
        o1.officename AS requestingOfficeName,
        o2.officename AS receivingOfficeName,
        fgtr.transactiondatetime,fgtr.remarks
    FROM public.finished_goods_transfer_request AS fgtr
    JOIN public.offices AS o1 ON o1.officeid = fgtr.requestingofficeid
    JOIN public.offices AS o2 ON o2.officeid = fgtr.receivingofficeid
    """, nativeQuery = true)
    List<Object[]> getRequestDetails();

    @Query(value = """
    
        select to_char(transactiondatetime,'dd-mm-yyyy') as requestdate , o1.officename as requestingoffice,
                o2.officename as receivingofficeid,remarks,case when activestatus = 0 then 'Data Entered'
              when activestatus = 1 then 'Approved'
              when activestatus = 9 then 'Rejected' end as status
              from public.finished_goods_transfer_request as fgtr
              join public.offices as o1 on o1.officeid = fgtr.requestingofficeid
              join public.offices as o2 on o2.officeid = fgtr.receivingofficeid
              where transactiondatetime between TO_DATE(:fromdate, 'DD-MM-YYYY') and TO_DATE(:todate, 'DD-MM-YYYY')
    """, nativeQuery = true)
    List<Object[]> getRequestDetails(@Param("fromdate") String fromdate,
                                     @Param("todate") String todate);




}
