package com.StockTransfer.StocksDemo.DTO;

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



//    public RequestDetailsDTO(int productid, int requestedqty, int receivedqty, String productname) {
//        this.productid = productid;
//        this.requestedqty = requestedqty;
//        this.receivedqty = receivedqty;
//        this.productname = productname;
//    }

}
