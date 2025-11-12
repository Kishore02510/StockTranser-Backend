package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequestDetails;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestDetailsRepo;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTransferRequestDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FinishedGoodsRequestDetailsController {

    @Autowired
    private FinishedGoodsTransferRequestDetailsService fds;

    @Autowired
    private FinishedGoodsTransferRequestRepo fgtrRepo;

    @Autowired
    private FinishedGoodsTransferRequestDetailsRepo fgtrDetails;
    @PostMapping("/saverequestdetails")
    public ResponseEntity<String> saveRequest(@RequestBody FinishedGoodsTransferRequestDetails fgd){
        return fds.addTranserDetails(fgd);
    }

    @PostMapping("/savereqdetails")
    public ResponseEntity<?> saveFinishedGoodsRequest(@RequestBody FinishedGoodsTransferRequestDTO fgtRDTO) {
        // 1. Save main request
        FinishedGoodsTransferRequest request = new FinishedGoodsTransferRequest();
        Long nextSeq = fgtrRepo.getNextSequence();  // e.g., 1, 2, 3

        String refNo = String.format("STR-%03d", nextSeq);  // STR-001, STR-002
        request.setFinishedgoodstransferrequestrefno(refNo);
        request.setRequestingofficeid(fgtRDTO.getRequestingofficeid());
        request.setReceivingofficeid(fgtRDTO.getReceivingofficeid());
        request.setRemarks(fgtRDTO.getRemarks());
        request.setSendingemployeeid(fgtRDTO.getSendingemployeeid());
        request.setActivestatus(0); // example
        fgtrRepo.save(request); // save to get ID

        // 2. Save each product detail
        for (FinishedGoodsTransferRequestDTO.ProductRequest pr : fgtRDTO.getProducts()) {
            FinishedGoodsTransferRequestDetails detail = new FinishedGoodsTransferRequestDetails();
            detail.setRequest(request);
            detail.setRequestedQuantity(pr.getRequestedQuantity());
            detail.setProductid(pr.getProductid());
            detail.setAmountperunit(pr.getAmountperunit());
            detail.setReceivedQuantity(0);
            detail.setTotalamount(pr.getRequestedQuantity() * pr.getAmountperunit());
            fgtrDetails.save(detail);
        }

        return ResponseEntity.ok(Map.of("status", "success", "message", "Request saved successfully../n Request Ref Code : "+refNo));
    }


    @GetMapping("/productdetails/{FGTRId}")
    public ResponseEntity<List<RequestProductDetailsDTO>> getProdDetails(@PathVariable int FGTRId){
        System.out.println(" FGTRId --> "+ FGTRId);
        return ResponseEntity.ok(fds.getProdDetails(FGTRId));
    }

}
