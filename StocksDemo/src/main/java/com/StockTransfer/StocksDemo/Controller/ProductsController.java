package com.StockTransfer.StocksDemo.Controller;

import com.StockTransfer.StocksDemo.Entity.Products;
import com.StockTransfer.StocksDemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductService ps;

    @GetMapping("/getproducts")
    public ResponseEntity<List<Products>> getProducts(){
        return ResponseEntity.ok(ps.funView());
    }

}
