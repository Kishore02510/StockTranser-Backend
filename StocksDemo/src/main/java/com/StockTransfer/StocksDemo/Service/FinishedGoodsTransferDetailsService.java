package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.TransferReportDTO;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsTransferDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinishedGoodsTransferDetailsService {

    @Autowired
    private FinishedGoodsTransferDetailsRepository ftds;
    public List<TransferReportDTO> getTransferProdDetails(String strFromdate, String strToDate){

        List<Object[]> results = ftds.getTransferProdDetails(strFromdate, strToDate);
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
            dto.setFinishedgoodstransferrefno((String) obj[7]);
            dto.setFinishedgoodstransferrequestrefno((String) obj[8]);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
