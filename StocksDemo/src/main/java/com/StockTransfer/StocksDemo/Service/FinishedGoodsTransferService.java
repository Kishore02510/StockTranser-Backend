package com.StockTransfer.StocksDemo.Service;


import com.StockTransfer.StocksDemo.DTO.FinishedGoodsTransferDTO;
import com.StockTransfer.StocksDemo.DTO.RequestReportDTO;
import com.StockTransfer.StocksDemo.DTO.TransferProductDetailsDTO;
import com.StockTransfer.StocksDemo.DTO.TransferReportDTO;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransfer;
import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferDetails;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferDetailsRepository;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRepository;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestDetailsRepo;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinishedGoodsTransferService {

    @Autowired
    private FinishedGoodsTransferRepository transferRepo;

    @Autowired
    private FinishedGoodsTransferDetailsRepository detailsRepo;

    @Autowired
    private FinishedGoodsTransferRequestDetailsRepo fgtrd;

    public String saveTransfer(FinishedGoodsTransferDTO dto) {
        try {
            // Create and save master record
            FinishedGoodsTransfer transfer = new FinishedGoodsTransfer();
            transfer.setIssuingofficeid(dto.getIssuingofzid());
            transfer.setReceivingofficeid(dto.getTransferingofzid());
            transfer.setRemarks(dto.getRemarks());
            transfer.setActivestatus(0);
            transferRepo.save(transfer);

            // Loop through products and save each detail record
            for (TransferProductDetailsDTO prod : dto.getProducts()) {
                FinishedGoodsTransferDetails details = new FinishedGoodsTransferDetails();
                details.setProductid(prod.getProductid());
                details.setQuantity(prod.getRequestedQuantity());
                fgtrd.updateReceivedQuantity(prod.getRequestedQuantity(),prod.getProductid(),prod.getFinishedgoodstransferrequestid());
                details.setAmountperunit(prod.getAmountperunit());
//                System.out.println("prod.getRequestedQuantity() -> "+ prod.getRequestedQuantity());
//                System.out.println("prod.getAmountperunit -->"+ prod.getAmountperunit());

                BigDecimal total = BigDecimal.valueOf(
                        prod.getRequestedQuantity() * (int)prod.getAmountperunit()
                );
//                System.out.println("total -> "+total);
                details.setNettotalamount(total);

                details.setRequest(transfer);
                detailsRepo.save(details);
            }

            return "Transfer request saved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while saving transfer request: " + e.getMessage();
        }
    }

    public List<TransferReportDTO> getTransferDetails(String strFromdate, String strToDate){

        List<Object[]> results = transferRepo.getTransferDetails(strFromdate, strToDate);
        List<TransferReportDTO> dtoList = new ArrayList<>();
        for (Object[] obj : results) {
            TransferReportDTO dto = new TransferReportDTO();

            dto.setFinishedGoodsTransferId((Integer) obj[0]);
            dto.setTransactionDate((String) obj[1]);
            dto.setIssuingOffice((String) obj[2]);
            dto.setTransferingOffice((String) obj[3]);
            dto.setRemarks((String) obj[4]);
            dto.setStatus((String) obj[5]);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<TransferReportDTO> getTransferProdDetails(String strFromdate, String strToDate){

        List<Object[]> results = detailsRepo.getTransferProdDetails(strFromdate, strToDate);
        List<TransferReportDTO> dtoList = new ArrayList<>();
        for (Object[] obj : results) {
            TransferReportDTO dto = new TransferReportDTO();

            dto.setFinishedGoodsTransferId((Integer) obj[0]);
            dto.setProductId((Integer) obj[1]);
            dto.setProductName((String) obj[2]);
            dto.setAmountPerUnit(obj[3] != null ? ((Number) obj[3]).doubleValue() : 0.0);
            dto.setNetTotalAmount(obj[4] != null ? ((Number) obj[4]).doubleValue() : 0.0);
            dto.setQuantity(obj[5] != null ? ((Number) obj[5]).intValue() : 0);
            dto.setTransactionDate((String) obj[6]);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
