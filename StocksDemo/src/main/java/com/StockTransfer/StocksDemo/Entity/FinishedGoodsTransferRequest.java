package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Entity
public class FinishedGoodsTransferRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int finishedgoodstransferrequestid;
    @CreationTimestamp
    @Column(name = "transactiondatetime", updatable = false, nullable = false)
    private LocalDate finishedgoodstransferrequestdate;
    private int requestingofficeid ;

    private int receivingofficeid;

    private String remarks;

    private int sendingemployeeid ;

    private int activestatus;

    private int finishedgoodstransferrequestrefno;

    public FinishedGoodsTransferRequest(){

    }
    @ManyToOne
    @JoinColumn(name = "requestingofficeid", insertable = false, updatable = false)
    private Offices requestingOffice;

    @ManyToOne
    @JoinColumn(name = "receivingofficeid", insertable = false, updatable = false)
    private Offices receivingOffice;

    public FinishedGoodsTransferRequest(int finishedgoodstransferrequestid, LocalDate finishedgoodstransferrequestdate, String remarks, int sendingemployeeid, int activestatus, int finishedgoodstransferrequestrefno, Offices requestingOffice, Offices receivingOffice) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
        this.finishedgoodstransferrequestdate = finishedgoodstransferrequestdate;
        this.remarks = remarks;
        this.sendingemployeeid = sendingemployeeid;
        this.activestatus = activestatus;
        this.finishedgoodstransferrequestrefno = finishedgoodstransferrequestrefno;
        this.requestingOffice = requestingOffice;
        this.receivingOffice = receivingOffice;
    }

    public Offices getRequestingOffice() {
        return requestingOffice;
    }

    public void setRequestingOffice(Offices requestingOffice) {
        this.requestingOffice = requestingOffice;
    }

    public Offices getReceivingOffice() {
        return receivingOffice;
    }

    public void setReceivingOffice(Offices receivingOffice) {
        this.receivingOffice = receivingOffice;
    }

    public int getFinishedgoodstransferrequestid() {
        return finishedgoodstransferrequestid;
    }

    public void setFinishedgoodstransferrequestid(int finishedgoodstransferrequestid) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
    }

    public LocalDate getFinishedgoodstransferrequestdate() {
        return finishedgoodstransferrequestdate;
    }

    public void setFinishedgoodstransferrequestdate(LocalDate finishedgoodstransferrequestdate) {
        this.finishedgoodstransferrequestdate = finishedgoodstransferrequestdate;
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

    public int getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(int activestatus) {
        this.activestatus = activestatus;
    }

    public int getFinishedgoodstransferrequestrefno() {
        return finishedgoodstransferrequestrefno;
    }

    public FinishedGoodsTransferRequest(int finishedgoodstransferrequestid, LocalDate finishedgoodstransferrequestdate, int requestingofficeid, int receivingofficeid, String remarks, int sendingemployeeid, int activestatus, int finishedgoodstransferrequestrefno) {
        this.finishedgoodstransferrequestid = finishedgoodstransferrequestid;
        this.finishedgoodstransferrequestdate = finishedgoodstransferrequestdate;
        this.remarks = remarks;
        this.sendingemployeeid = sendingemployeeid;
        this.activestatus = activestatus;
        this.finishedgoodstransferrequestrefno = finishedgoodstransferrequestrefno;
    }

    public void setFinishedgoodstransferrequestrefno(int finishedgoodstransferrequestrefno) {
        this.finishedgoodstransferrequestrefno = finishedgoodstransferrequestrefno;
    }

    @OneToMany(mappedBy = "finishedGoodsTransferRequest", cascade = CascadeType.ALL)
    private List<FinishedGoodsTransferRequestDetails> finishedGoodsTransferRequestDetails;

    public List<FinishedGoodsTransferRequestDetails> getFinishedGoodsTransferRequestDetails() {
        return finishedGoodsTransferRequestDetails;
    }

    public void setFinishedGoodsTransferRequestDetails(List<FinishedGoodsTransferRequestDetails> finishedGoodsTransferRequestDetails) {
        this.finishedGoodsTransferRequestDetails = finishedGoodsTransferRequestDetails;
    }
}
