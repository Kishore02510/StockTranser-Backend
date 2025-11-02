package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {
}
