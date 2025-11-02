package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.DTO.FinishedGoodsPriceDTO;
import com.StockTransfer.StocksDemo.Entity.finishedgoodsprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedGoodsPriceRepo extends JpaRepository<finishedgoodsprice, Integer> {

    @Query("SELECT new com.StockTransfer.StocksDemo.DTO.FinishedGoodsPriceDTO(p.productid, p.productname, fgp.sellingpriceperunit) " +
            "FROM finishedgoodsprice fgp " +
            "JOIN fgp.product p " +
            "ORDER BY p.productname")
    List<FinishedGoodsPriceDTO> fungetFinishedProducts();

}
