package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Entity.finishedgoodsprice;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTranserRequestService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FinishedGoodsTransferRequestController {

    @Autowired
    private FinishedGoodsTranserRequestService fgtrService;

    @PostMapping("/savetransferrequest")
    public ResponseEntity<String> saveRequest(@RequestBody FinishedGoodsTransferRequest fgtr){
        return fgtrService.addTranserRequest(fgtr);
    }

    @GetMapping("/products/{requestId}")
    public ResponseEntity<List<RequestDetailsDTO>> getProductsByRequestId(@PathVariable int requestId) {
        List<RequestDetailsDTO> result = fgtrService.getRequestDetails(requestId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/requestdetails")
    public ResponseEntity<List<RequestDetailsDTO>> getProductsByRequestId() {
        List<RequestDetailsDTO> result = fgtrService.getRequestDetails();
        return ResponseEntity.ok(result);
    }

}
