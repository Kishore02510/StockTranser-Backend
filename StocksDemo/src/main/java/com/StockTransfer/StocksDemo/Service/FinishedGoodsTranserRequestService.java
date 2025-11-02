package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Entity.finishedgoodsprice;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsPriceRepo;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishedGoodsTranserRequestService {

    @Autowired
    private FinishedGoodsTransferRequestRepo fgtReq;

    public ResponseEntity<String> addTranserRequest(FinishedGoodsTransferRequest fgtrequest){
        fgtReq.save(fgtrequest);
        return new ResponseEntity<>("Request Saved Successufully...", HttpStatus.CREATED);
    }


    public List<RequestDetailsDTO> getRequestDetails(int requestid){

        return fgtReq.getRequestDetails(requestid);
    }

    public List<RequestDetailsDTO> getRequestDetails(){

        return fgtReq.getRequestDetails();
    }

}
