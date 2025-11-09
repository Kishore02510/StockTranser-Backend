package com.StockTransfer.StocksDemo.DTO;

import java.util.List;

public class FinishedGoodsTransferDTO {
    private int issuingofzid;
    private int transferingofzid;
    private String remarks;
    private List<TransferProductDetailsDTO> products;

    public int getIssuingofzid() {
        return issuingofzid;
    }

    public void setIssuingofzid(int issuingofzid) {
        this.issuingofzid = issuingofzid;
    }

    public int getTransferingofzid() {
        return transferingofzid;
    }

    public void setTransferingofzid(int transferingofzid) {
        this.transferingofzid = transferingofzid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<TransferProductDetailsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<TransferProductDetailsDTO> products) {
        this.products = products;
    }
}
