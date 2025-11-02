package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.Entity.Offices;
import com.StockTransfer.StocksDemo.Service.OfficesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OfficeController {

    @Autowired
    private OfficesService os;
    @GetMapping("/getoffices")
    public ResponseEntity<List<Offices>> getOffices(){
        return os.getOffices();
    }

    @PostMapping("/saveoffices")
    public ResponseEntity<String> addOffices(@RequestBody Offices off){
        return os.saveOffices(off);
    }
}
