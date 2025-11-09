package com.StockTransfer.StocksDemo.DTO;

public class TransferReportDTO {
    private Integer finishedGoodsTransferId;
    private String transactionDate;   // For both requestdate / transferdate

    // Header-level fields (from first query)
    private String issuingOffice;
    private String transferingOffice;
    private String remarks;
    private String status;

    // Detail-level fields (from second query)
    private Integer productId;
    private String productName;
    private Double amountPerUnit;
    private Double netTotalAmount;
    private Integer quantity;

    public Integer getFinishedGoodsTransferId() {
        return finishedGoodsTransferId;
    }

    public void setFinishedGoodsTransferId(Integer finishedGoodsTransferId) {
        this.finishedGoodsTransferId = finishedGoodsTransferId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getIssuingOffice() {
        return issuingOffice;
    }

    public void setIssuingOffice(String issuingOffice) {
        this.issuingOffice = issuingOffice;
    }

    public String getTransferingOffice() {
        return transferingOffice;
    }

    public void setTransferingOffice(String transferingOffice) {
        this.transferingOffice = transferingOffice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmountPerUnit() {
        return amountPerUnit;
    }

    public void setAmountPerUnit(Double amountPerUnit) {
        this.amountPerUnit = amountPerUnit;
    }

    public Double getNetTotalAmount() {
        return netTotalAmount;
    }

    public void setNetTotalAmount(Double netTotalAmount) {
        this.netTotalAmount = netTotalAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
