package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.Entity.Employees;
import com.StockTransfer.StocksDemo.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpControler {
    @Autowired
    private EmpService es;
    @PostMapping("/saveEmpDetail")
    public ResponseEntity<String> saveEmpDetails(@RequestBody Employees emp){
        return es.saveEmpDetails(emp);
    }

    @GetMapping("/getemployeedetails")
    public ResponseEntity<List<Employees>> getEmpDetail(){
        return es.getEmployees();
    }
}
