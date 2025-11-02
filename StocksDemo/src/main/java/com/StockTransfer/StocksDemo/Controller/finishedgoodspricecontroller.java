package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsPriceDTO;
import com.StockTransfer.StocksDemo.Entity.finishedgoodsprice;
import com.StockTransfer.StocksDemo.Service.finishedgoodspriceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class finishedgoodspricecontroller {

    @Autowired
    private finishedgoodspriceservice fgpService;

    @PostMapping("/saverequest")
    public ResponseEntity<String> saveRequest(@RequestBody finishedgoodsprice fgp){
        return fgpService.addTranserRequest(fgp);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<FinishedGoodsPriceDTO>> getProducts(){
        return fgpService.getFinishedProducts();
    }
}
