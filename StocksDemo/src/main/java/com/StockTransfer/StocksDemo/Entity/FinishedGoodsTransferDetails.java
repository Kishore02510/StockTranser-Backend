package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FinishedGoodsTransferDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int finishedgoodstransferdetailsid;

    private int productid;
    private int quantity;
    private float amountperunit;

    @Column(precision = 15, scale = 2)
    private BigDecimal nettotalamount;

    @ManyToOne
    @JoinColumn(name = "finishedgoodstransferid")
    private FinishedGoodsTransfer request;

    public FinishedGoodsTransferDetails() {}

    public FinishedGoodsTransferDetails(int productid, int quantity, float amountperunit,
                                        BigDecimal nettotalamount, FinishedGoodsTransfer request) {
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

    public float getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(float amountperunit) {
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
}
