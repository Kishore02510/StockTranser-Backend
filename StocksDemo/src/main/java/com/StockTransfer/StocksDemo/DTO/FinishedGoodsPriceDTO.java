package com.StockTransfer.StocksDemo.DTO;

import java.math.BigDecimal;

public class FinishedGoodsPriceDTO {
    int productid;
    String productname;
//    int officeid;

    public FinishedGoodsPriceDTO(int productid, String productname, BigDecimal sellingpriceperunit) {
        this.productid = productid;
        this.productname = productname;
        this.sellingpriceperunit = sellingpriceperunit;
    }

    BigDecimal  sellingpriceperunit;


    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

//    public int getOfficeid() {
//        return officeid;
//    }
//
//    public void setOfficeid(int officeid) {
//        this.officeid = officeid;
//    }

    public BigDecimal getSellingpriceperunit() {
        return sellingpriceperunit;
    }

    public void setSellingpriceperunit(BigDecimal sellingpriceperunit) {
        this.sellingpriceperunit = sellingpriceperunit;
    }
}
