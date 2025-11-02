package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employees,Integer> {
}
