package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.RequestDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestProductDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.RequestReportDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferRequest;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Object[]> results = fgtReq.getRequestDetails();
        List<RequestDetailsDTO> dtoList = new ArrayList<>();

        for (Object[] obj : results) {
            RequestDetailsDTO dto = new RequestDetailsDTO();
            dto.setRequestId((Integer) obj[0]);
            dto.setReceivingOfficeId((Integer) obj[1]);
            dto.setRequestingOfficeId((Integer) obj[2]);
            dto.setRequestingOfficeName((String) obj[3]);
            dto.setReceivingOfficeName((String) obj[4]);
            dto.setTransactionDateTime((Date) obj[5]);
            dto.setRemarks((String) obj[6]);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public List<RequestReportDTO> getRequestDetails(String strFromdate,String strToDate){

        List<Object[]> results = fgtReq.getRequestDetails(strFromdate, strToDate);
        List<RequestReportDTO> dtoList = new ArrayList<>();
        for (Object[] obj : results) {
            RequestReportDTO dto = new RequestReportDTO();

            dto.setRequestDate((String) obj[0]);
            dto.setRequestingOffice((String) obj[1]);
            dto.setReceivingOffice((String) obj[2]);
            dto.setRemarks((String) obj[3]);
            dto.setStatus((String) obj[4]);
            dtoList.add(dto);
        }
        return dtoList;
    }


}
