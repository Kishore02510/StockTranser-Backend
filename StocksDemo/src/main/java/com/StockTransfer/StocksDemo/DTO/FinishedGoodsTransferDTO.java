package com.StockTransfer.StocksDemo.DTO;

public class FinishedGoodsTransferDTO {
    private int finishedrequesttransferid;
    private int productid;
    private int issuingofficeid;
    private int receivingofficeid;
    private int activestatus;

    private String remarks;

    public static class ProductDetails{
        private int amountperunit;
        private int nettotalamount;
        private int quantity;

    }




}
