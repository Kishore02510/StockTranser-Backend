package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestReportDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTranserRequestService;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTransferRequestDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FinishedGoodsTransferRequestController {

    @Autowired
    private FinishedGoodsTranserRequestService fgtrService;

    @Autowired
    private FinishedGoodsTransferRequestDetailsService fgtrds;

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

    @GetMapping("/reqREport")
    public ResponseEntity<List<RequestReportDTO>> getReqReport(@RequestParam String fromdate,
                                                               @RequestParam String todate){
        List<RequestReportDTO> result = fgtrService.getRequestDetails(fromdate,todate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reqProdReport")
    public ResponseEntity<List<RequestReportDTO>> getProductRequestDetails(@RequestParam String fromdate,
                                                               @RequestParam String todate){
        List<RequestReportDTO> result = fgtrds.getProductRequestDetails(fromdate,todate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getReqDetailsForApproval")
    public ResponseEntity<List<RequestReportDTO>> getTransferRequestDetailsForApproval(){

        List<RequestReportDTO> result = fgtrService.getRequestDetailsForApproval();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getReqProdDetailsForApproval/{requestid}")
    public ResponseEntity<List<RequestProductDetailsDTO>> getTransferRequestProdDetailsForApproval(@PathVariable("requestid") Integer requestid){

        List<RequestProductDetailsDTO> result = fgtrds.getRequestDetailsForApproval(requestid);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/getReqDetailsForApproval")
    public ResponseEntity<String> updateStatus(
            @RequestParam int requestid,
            @RequestParam int argStatus) {
        String message = fgtrService.updateStatus(argStatus,requestid);
        return ResponseEntity.ok(message);
    }


}
