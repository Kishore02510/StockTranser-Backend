package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class finishedgoodsprice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int officeid;

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
    private Products product;

    @Column(name = "sellingpriceperunit", precision = 19, scale = 2, nullable = false)
    private BigDecimal sellingpriceperunit;

    @CreationTimestamp
    @Column(name = "transactiondatetime", updatable = false, nullable = false)
    private LocalDateTime transactionDateTime;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOfficeid() {
        return officeid;
    }

    public void setOfficeid(int officeid) {
        this.officeid = officeid;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public BigDecimal getSellingpriceperunit() {
        return sellingpriceperunit;
    }

    public void setSellingpriceperunit(BigDecimal sellingpriceperunit) {
        this.sellingpriceperunit = sellingpriceperunit;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}
