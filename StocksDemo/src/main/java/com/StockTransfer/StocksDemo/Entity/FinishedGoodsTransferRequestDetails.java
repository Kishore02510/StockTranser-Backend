package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;

@Entity
public class FinishedGoodsTransferRequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int finishedgoodstransferrequestdetailsid;
    @ManyToOne
    @JoinColumn(name = "finishedgoodstransferrequestid")
    private FinishedGoodsTransferRequest finishedGoodsTransferRequest;

    public FinishedGoodsTransferRequest getRequest() {
        return finishedGoodsTransferRequest;
    }

    public void setRequest(FinishedGoodsTransferRequest request) {
        this.finishedGoodsTransferRequest = request;
    }

    private int productid ;

    private int requestedQuantity;

    private int amountperunit;

    private int receivedQuantity;
    private int totalamount;

    public FinishedGoodsTransferRequestDetails(FinishedGoodsTransferRequest request, int productid, int requestedQuantity, int amountperunit,int totalamount) {
        this.finishedGoodsTransferRequest = request;
        this.productid = productid;
        this.requestedQuantity = requestedQuantity;
        this.amountperunit = amountperunit;
        this.totalamount = requestedQuantity*amountperunit;
    }

    public int getFinishedgoodstransferrequestdetailsid() {
        return finishedgoodstransferrequestdetailsid;
    }

    public void setFinishedgoodstransferrequestdetailsid(int finishedgoodstransferrequestdetailsid) {
        this.finishedgoodstransferrequestdetailsid = finishedgoodstransferrequestdetailsid;
    }

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

    public int getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(int amountperunit) {
        this.amountperunit = amountperunit;
    }

    public int getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(int receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    public FinishedGoodsTransferRequestDetails(){

    }

    @ManyToOne
    @JoinColumn(name = "productid" ,insertable = false, updatable = false)
    private Products product;
//
//    public products getProduct() {
//        return product;
//    }
//
//    public void setProduct(products product) {
//        this.product = product;
//    }

}
