package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class FinishedGoodsTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int finishedgoodstransferid;

    @CreationTimestamp
    @Column(name = "transactiondatetime", updatable = false, nullable = false)
    private LocalDate finishedgoodstransferdate;

    private int finishedgoodstransferrefno;

    private int issuingofficeid;

    private int  receivingofficeid;

    private String remarks ;

    private int activestatus ;


}
