package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestReportDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequestDetails;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestDetailsRepo;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//        System.out.println(" requestid -> "+ requestid);
        return fgtReqRepo.getProductDetailsByRequestId(requestid);
    }

    public List<RequestReportDTO> getProductRequestDetails(String fromDate, String toDate) {
        List<Object[]> results = fgtReqRepo.getProdRequestDetails(fromDate, toDate);
        List<RequestReportDTO> dtoList = new ArrayList<>();

        for (Object[] obj : results) {
            RequestReportDTO dto = new RequestReportDTO();
            dto.setFinishedGoodsTransferRequestId((Integer) obj[0]);
            dto.setProductId((Integer) obj[1]);
            dto.setProductName((String) obj[2]);
            dto.setAmountPerUnit(obj[3] != null ? ((Number) obj[3]).doubleValue() : 0.0);
            dto.setTotalAmount(obj[4] != null ? ((Number) obj[4]).doubleValue() : 0.0);
            dto.setRequestDate((String) obj[5]);
            dto.setReceivedQuantity((Integer) obj[6]);
            dto.setRequestedQuantity((Integer)obj[7]);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
