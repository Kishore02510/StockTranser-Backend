package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsPriceDTO;
import com.StockTransfer.StocksDemo.Entity.finishedgoodsprice;
import com.StockTransfer.StocksDemo.Repository.FinishedGoodsPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class finishedgoodspriceservice {
    @Autowired
    private FinishedGoodsPriceRepo fgprepo;
    public ResponseEntity<String> addTranserRequest(finishedgoodsprice fgp){
        fgprepo.save(fgp);
        return new ResponseEntity<>("Request Successufully...", HttpStatus.CREATED);
    }

    public ResponseEntity<List<FinishedGoodsPriceDTO>> getFinishedProducts(){

        return ResponseEntity.ok(fgprepo.fungetFinishedProducts());
    }
}
