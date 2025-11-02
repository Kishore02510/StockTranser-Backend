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

    @Query("""
    SELECT new com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO(
        fgtr.finishedgoodstransferrequestid,
        rco.officename,
        rqo.officename,
        fgtr.remarks,
        CAST(fgtr.finishedgoodstransferrequestdate AS string)
    )
    FROM FinishedGoodsTransferRequest fgtr
    JOIN fgtr.receivingOffice rco
    JOIN fgtr.requestingOffice rqo
    ORDER BY fgtr.finishedgoodstransferrequestdate
    """)
    List<RequestDetailsDTO> getRequestDetails();

}
