package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.Entity.Offices;
import com.StockTransfer.StocksDemo.Repository.OfficesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficesService {
    @Autowired
    private OfficesRepo or;
    public ResponseEntity<List<Offices>> getOffices(){
        return ResponseEntity.ok(or.findAll());
    }

    public ResponseEntity<String> saveOffices(Offices off){
        or.save(off);
        return ResponseEntity.ok("Offices Saved Successfully..");
    }
}
