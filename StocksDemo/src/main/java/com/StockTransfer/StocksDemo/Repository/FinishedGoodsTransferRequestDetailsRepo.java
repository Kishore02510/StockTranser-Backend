package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
        fgtrd.totalamount
    )
    FROM FinishedGoodsTransferRequest fgtr
    JOIN fgtr.finishedGoodsTransferRequestDetails fgtrd
    JOIN fgtrd.product p
    WHERE fgtr.finishedgoodstransferrequestid = :requestId
""")
    List<RequestProductDetailsDTO> getProductDetailsByRequestId(@Param("requestId") int requestId);


}
