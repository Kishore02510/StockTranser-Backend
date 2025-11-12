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
    @Column(unique = true)
    private String finishedgoodstransferrefno;

    private int issuingofficeid;

    private int  receivingofficeid;

    private String remarks ;

    private int activestatus ;

    @ManyToOne
    @JoinColumn(name = "finishedgoodstransferrequestid")
    private FinishedGoodsTransferRequest finishedGoodsTransferRequest;

    public FinishedGoodsTransferRequest getFinishedGoodsTransferRequest() {
        return finishedGoodsTransferRequest;
    }

    public void setFinishedGoodsTransferRequest(FinishedGoodsTransferRequest finishedGoodsTransferRequest) {
        this.finishedGoodsTransferRequest = finishedGoodsTransferRequest;
    }

    public int getFinishedgoodstransferid() {
        return finishedgoodstransferid;
    }

    public void setFinishedgoodstransferid(int finishedgoodstransferid) {
        this.finishedgoodstransferid = finishedgoodstransferid;
    }

    public LocalDate getFinishedgoodstransferdate() {
        return finishedgoodstransferdate;
    }

    public void setFinishedgoodstransferdate(LocalDate finishedgoodstransferdate) {
        this.finishedgoodstransferdate = finishedgoodstransferdate;
    }

    public String getFinishedgoodstransferrefno() {
        return finishedgoodstransferrefno;
    }

    public void setFinishedgoodstransferrefno(String finishedgoodstransferrefno) {
        this.finishedgoodstransferrefno = finishedgoodstransferrefno;
    }

    public int getIssuingofficeid() {
        return issuingofficeid;
    }

    public void setIssuingofficeid(int issuingofficeid) {
        this.issuingofficeid = issuingofficeid;
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

    public int getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(int activestatus) {
        this.activestatus = activestatus;
    }
}
