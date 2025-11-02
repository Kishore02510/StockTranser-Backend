package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequestDetails;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestDetailsRepo;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishedGoodsTransferRequestDetailsService {

    @Autowired
    private FinishedGoodsTransferRequestDetailsRepo fgtReqRepo;

    public ResponseEntity<String> addTranserDetails(FinishedGoodsTransferRequestDetails fgtrd){
        fgtReqRepo.save(fgtrd);
        return new ResponseEntity<>("Request Saved Successufully...", HttpStatus.CREATED);
    }

    public List<RequestProductDetailsDTO> getProdDetails(int requestid){
        return fgtReqRepo.getProductDetailsByRequestId(requestid);
    }

}
