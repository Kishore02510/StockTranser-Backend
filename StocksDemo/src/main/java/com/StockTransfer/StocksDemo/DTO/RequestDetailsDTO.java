package com.StockTransfer.StocksDemo.DTO;

import java.sql.Date;

public class RequestDetailsDTO {
    private int finishedgoodstransferrequestid ;
    private String issuingofz ;
    private String transferingToOfz;
    private String remarks;
    private String transactiondatetime;

    public RequestDetailsDTO(int finishedgoodstransferrequestid, String issuingofz, String transferingtoofz) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
        this.issuingofz = issuingofz;
        this.transferingToOfz = transferingtoofz;
    }

    public RequestDetailsDTO() {

    }

    public int getFinishedgoodstransferrequestid() {
        return finishedgoodstransferrequestid;
    }

    public void setFinishedgoodstransferrequestid(int finishedgoodstransferrequestid) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
    }

    public String getIssuingofz() {
        return issuingofz;
    }

    public void setIssuingofz(String issuingofz) {
        this.issuingofz = issuingofz;
    }

    public String getTransferingToOfz() {
        return transferingToOfz;
    }

    public void setTransferingToOfz(String transferingToOfz) {
        this.transferingToOfz = transferingToOfz;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getTransactiondatetime() {
        return transactiondatetime;
    }
    public void setTransactiondatetime(String transactiondatetime) {
        this.transactiondatetime = transactiondatetime;
    }

    public RequestDetailsDTO(int finishedgoodstransferrequestid, String issuingofz, String transferingToOfz, String remarks, String transactiondatetime) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
        this.issuingofz = issuingofz;
        this.transferingToOfz = transferingToOfz;
        this.remarks = remarks;
        this.transactiondatetime = transactiondatetime;
    }

    private Integer requestId;
    private Integer receivingOfficeId;
    private Integer requestingOfficeId;
    private String requestingOfficeName;
    private String receivingOfficeName;
    private Date transactionDateTime;


    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getReceivingOfficeId() {
        return receivingOfficeId;
    }

    public void setReceivingOfficeId(Integer receivingOfficeId) {
        this.receivingOfficeId = receivingOfficeId;
    }

    public Integer getRequestingOfficeId() {
        return requestingOfficeId;
    }

    public void setRequestingOfficeId(Integer requestingOfficeId) {
        this.requestingOfficeId = requestingOfficeId;
    }

    public String getRequestingOfficeName() {
        return requestingOfficeName;
    }

    public void setRequestingOfficeName(String requestingOfficeName) {
        this.requestingOfficeName = requestingOfficeName;
    }

    public String getReceivingOfficeName() {
        return receivingOfficeName;
    }

    public void setReceivingOfficeName(String receivingOfficeName) {
        this.receivingOfficeName = receivingOfficeName;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    //    public RequestDetailsDTO(int productid, int requestedqty, int receivedqty, String productname) {
//        this.productid = productid;
//        this.requestedqty = requestedqty;
//        this.receivedqty = receivedqty;
//        this.productname = productname;
//    }

}
