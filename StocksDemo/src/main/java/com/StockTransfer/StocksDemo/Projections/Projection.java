package com.StockTransfer.StocksDemo.Projections;

import java.math.BigDecimal;

public interface Projection {
    int getProductid();
    String getProductname();
    BigDecimal getSellingpriceperunit();
}
