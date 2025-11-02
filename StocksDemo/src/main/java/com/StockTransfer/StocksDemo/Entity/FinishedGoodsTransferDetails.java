package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FinishedGoodsTransferDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int finishedgoodstransferdetailsid;

//    private int finishedgoodstransferid;
    private int productid ;
    private int quantity;
    private int amountperunit;
    private BigDecimal nettotalamount;
    @ManyToOne
    @JoinColumn(name = "finishedgoodstransferid")
    private FinishedGoodsTransfer request;

//    public int getFinishedgoodstransferid() {
//        return finishedgoodstransferid;
//    }
//
//    public void setFinishedgoodstransferid(int finishedgoodstransferid) {
//        this.finishedgoodstransferid = finishedgoodstransferid;
//    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(int amountperunit) {
        this.amountperunit = amountperunit;
    }

    public BigDecimal getNettotalamount() {
        return nettotalamount;
    }

    public void setNettotalamount(BigDecimal nettotalamount) {
        this.nettotalamount = nettotalamount;
    }

    public FinishedGoodsTransfer getRequest() {
        return request;
    }

    public void setRequest(FinishedGoodsTransfer request) {
        this.request = request;
    }

    public FinishedGoodsTransferDetails( int productid, int quantity, int amountperunit, BigDecimal nettotalamount, FinishedGoodsTransfer request) {
        this.productid = productid;
        this.quantity = quantity;
        this.amountperunit = amountperunit;
        this.nettotalamount = nettotalamount;
        this.request = request;
    }

    public int getFinishedgoodstransferdetailsid() {
        return finishedgoodstransferdetailsid;
    }

    public void setFinishedgoodstransferdetailsid(int finishedgoodstransferdetailsid) {
        this.finishedgoodstransferdetailsid = finishedgoodstransferdetailsid;
    }
}
