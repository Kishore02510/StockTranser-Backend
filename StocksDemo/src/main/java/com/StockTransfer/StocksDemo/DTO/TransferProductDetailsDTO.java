package com.StockTransfer.StocksDemo.DTO;

import java.math.BigDecimal;

public class TransferProductDetailsDTO {
    private int productid;
    private int requestedQuantity;
    private float amountperunit;

    private float totalamount;

    private int finishedgoodstransferrequestid;


    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public float getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(float amountperunit) {
        this.amountperunit = amountperunit;
    }

    public float getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(float totalamount) {
        this.totalamount = totalamount;
    }

    public int getFinishedgoodstransferrequestid() {
        return finishedgoodstransferrequestid;
    }

    public void setFinishedgoodstransferrequestid(int finishedgoodstransferrequestid) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
    }
}
