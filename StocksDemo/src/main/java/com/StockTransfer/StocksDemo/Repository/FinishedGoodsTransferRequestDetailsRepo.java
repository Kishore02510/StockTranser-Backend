package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FinishedGoodsTransferRequestDetailsRepo extends JpaRepository<FinishedGoodsTransferRequestDetails,Integer> {


    @Query("""
    SELECT new com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO(
        fgtr.finishedgoodstransferrequestid,
        p.productid,
        p.productname,
        fgtrd.requestedQuantity,
        fgtrd.receivedQuantity,
        fgtrd.totalamount,fgtrd.amountperunit
    )
    FROM FinishedGoodsTransferRequest fgtr
    JOIN fgtr.finishedGoodsTransferRequestDetails fgtrd
    JOIN fgtrd.product p
    WHERE fgtr.finishedgoodstransferrequestid = :requestId
""")
    List<RequestProductDetailsDTO> getProductDetailsByRequestId(@Param("requestId") int requestId);


    @Modifying
    @Transactional
    @Query(value = """
        UPDATE public.finished_goods_transfer_request_details
        SET received_quantity = :receivedQuantity
        WHERE productid = :productId
          AND finishedgoodstransferrequestid = :requestId
        """, nativeQuery = true)
    int updateReceivedQuantity(@Param("receivedQuantity") int receivedQuantity,
                               @Param("productId") int productId,
                               @Param("requestId") int requestId);

    @Query(value = """
            select fgtr.finishedgoodstransferrequestid,p.productid,p.productname,fgtrd.amountperunit,fgtrd.totalamount,
                   to_char(transactiondatetime,'dd-mm-yyyy') as requestdate,fgtrd.received_quantity,fgtrd.requested_quantity
                   from public.finished_goods_transfer_request as fgtr
                   join public.finished_goods_transfer_request_details as fgtrd
                     on fgtrd.finishedgoodstransferrequestid = fgtr.finishedgoodstransferrequestid
                   join public.products as p on p.productid = fgtrd.productid
                   where transactiondatetime between TO_DATE(:fromdate, 'DD-MM-YYYY') and TO_DATE(:todate, 'DD-MM-YYYY')
                                                                                                                               		
    """, nativeQuery = true)
    List<Object[]> getProdRequestDetails(@Param("fromdate") String fromdate,
                                         @Param("todate") String todate);

}
