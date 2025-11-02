package com.StockTransfer.StocksDemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Offices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeid;
    private String officename;

    public Offices() {

    }

    public Offices(int officeid, String officename) {
        this.officeid = officeid;
        this.officename = officename;
    }

    public int getOfficeid() {
        return officeid;
    }

    public void setOfficeid(int officeid) {
        this.officeid = officeid;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }
}
