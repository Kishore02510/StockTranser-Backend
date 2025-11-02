package com.StockTransfer.StocksDemo.Service;

import com.StockTransfer.StocksDemo.Entity.Products;
import com.StockTransfer.StocksDemo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo pr;

    public List<Products> funView(){
        return pr.findAll();
    }

}
