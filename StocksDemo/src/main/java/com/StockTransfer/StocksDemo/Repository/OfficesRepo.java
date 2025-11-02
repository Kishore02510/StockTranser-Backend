package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.Entity.Offices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficesRepo extends JpaRepository<Offices,Integer> {
}
