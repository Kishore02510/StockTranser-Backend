package com.StockTransfer.StocksDemo.DTO;

public class RequestProductDetailsDTO {

    private int finishedgoodstransferrequestid;
    private int productid ;
    private int requestedqty;
    private int receivedqty;
    private String productname;
    private int totalamount;
    private int amountperunit;

    public RequestProductDetailsDTO() {

    }

    public int getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(int amountperunit) {
        this.amountperunit = amountperunit;
    }

    public RequestProductDetailsDTO(int finishedgoodstransferrequestid, int productid, String productname,
                                    int requestedQuantity, int receivedQuantity, int totalamount, int amountperunit) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
        this.productid = productid;
        this.productname = productname;
        this.requestedqty = requestedQuantity;
        this.receivedqty = receivedQuantity;
        this.totalamount = totalamount;
        this.amountperunit = amountperunit;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getRequestedqty() {
        return requestedqty;
    }

    public void setRequestedqty(int requestedqty) {
        this.requestedqty = requestedqty;
    }

    public int getReceivedqty() {
        return receivedqty;
    }

    public void setReceivedqty(int receivedqty) {
        this.receivedqty = receivedqty;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }
}
