package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferDTO;
import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferRequestDTO;
import com.StockTransfer.StocksDemo.DTO.RequestReportDTO;
import com.StockTransfer.StocksDemo.DTO.TransferReportDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferDetails;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTransferDetailsService;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTransferRequestDetailsService;
import com.StockTransfer.StocksDemo.Service.FinishedGoodsTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FinishedGoodsTransferController {
    @Autowired
    private FinishedGoodsTransferService transferService;

    @Autowired
    private FinishedGoodsTransferDetailsService tds;

    @PostMapping("/savetransferreqdetails")
    public Map<String, Object> saveRequest(@RequestBody FinishedGoodsTransferDTO dto) {
        String msg = transferService.saveTransfer(dto);
        Map<String, Object> response = new HashMap<>();
        response.put("message", msg);
        return response;
    }

    @GetMapping("/transferReport")
    public ResponseEntity<List<TransferReportDTO>> getProductRequestDetails(@RequestParam String fromdate,
                                                                            @RequestParam String todate){
        List<TransferReportDTO> result = transferService.getTransferDetails(fromdate,todate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/transferProdReport")
    public ResponseEntity<List<TransferReportDTO>> getTransferProdDetails(@RequestParam String fromdate,
                                                                            @RequestParam String todate){
        List<TransferReportDTO> result = tds.getTransferProdDetails(fromdate,todate);
        return ResponseEntity.ok(result);
    }

}
