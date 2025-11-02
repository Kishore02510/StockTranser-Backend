package com.StockTransfer.StocksDemo.DTO;
import java.util.List;

public class FinishedGoodsTransferRequestDTO {
    private int requestingofficeid;
    private int receivingofficeid;
    private String remarks;
    private int sendingemployeeid;
    private List<ProductRequest> products;



    public static class ProductRequest {
        private int productid;
        private int requestedQuantity;
        private int amountperunit;


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
    }

    public int getRequestingofficeid() {
        return requestingofficeid;
    }

    public void setRequestingofficeid(int requestingofficeid) {
        this.requestingofficeid = requestingofficeid;
    }

    public int getReceivingofficeid() {
        return receivingofficeid;
    }

    public void setReceivingofficeid(int receivingofficeid) {
        this.receivingofficeid = receivingofficeid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getSendingemployeeid() {
        return sendingemployeeid;
    }

    public void setSendingemployeeid(int sendingemployeeid) {
        this.sendingemployeeid = sendingemployeeid;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }

}
