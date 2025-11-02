package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.Entity.Employees;
import com.StockTransfer.StocksDemo.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepo er;

    public ResponseEntity<List<Employees>> getEmployees(){
        return ResponseEntity.ok(er.findAll());
    }
    public ResponseEntity<String> saveEmpDetails(Employees emp){
        er.save(emp);
        return ResponseEntity.ok("Employee Details Saved Successfully...");
    }
}
