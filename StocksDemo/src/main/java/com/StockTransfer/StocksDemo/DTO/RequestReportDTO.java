package com.StockTransfer.StocksDemo.DTO;

import java.time.LocalDate;

public class RequestReportDTO {

    private String requestDate;

    // Fields from first query
    private String requestingOffice;
    private String receivingOffice;
    private String remarks;
    private String status;

    // Fields from second query
    private Integer finishedGoodsTransferRequestId;
    private Integer productId;
    private String productName;
    private Double amountPerUnit;
    private Double totalAmount;

    private int receivedQuantity;

    private int requestedQuantity;

    private  String finishedgoodstransferrequestrefno;

    public String getFinishedgoodstransferrequestrefno() {
        return finishedgoodstransferrequestrefno;
    }

    public void setFinishedgoodstransferrequestrefno(String finishedgoodstransferrequestrefno) {
        this.finishedgoodstransferrequestrefno = finishedgoodstransferrequestrefno;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public int getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(int receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestingOffice() {
        return requestingOffice;
    }

    public void setRequestingOffice(String requestingOffice) {
        this.requestingOffice = requestingOffice;
    }

    public String getReceivingOffice() {
        return receivingOffice;
    }

    public void setReceivingOffice(String receivingOffice) {
        this.receivingOffice = receivingOffice;
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

    public Integer getFinishedGoodsTransferRequestId() {
        return finishedGoodsTransferRequestId;
    }

    public void setFinishedGoodsTransferRequestId(Integer finishedGoodsTransferRequestId) {
        this.finishedGoodsTransferRequestId = finishedGoodsTransferRequestId;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
