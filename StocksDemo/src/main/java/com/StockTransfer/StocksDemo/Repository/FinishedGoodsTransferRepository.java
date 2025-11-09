package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FinishedGoodsTransferRepository extends JpaRepository<FinishedGoodsTransfer, Integer> {

    @Query(value = """
            select fgtr.finishedgoodstransferid, to_char(transactiondatetime,'dd-mm-yyyy') as requestdate , o1.officename as issuingoffice,
                o2.officename as transferingoffice,remarks,case when activestatus = 0 then 'Data Entered'
                when activestatus = 1 then 'Approved'
                when activestatus = 9 then 'Rejected' end as status
                from public.finished_goods_transfer as fgtr
                join public.offices as o1 on o1.officeid = fgtr.issuingofficeid
                join public.offices as o2 on o2.officeid = fgtr.receivingofficeid
                where transactiondatetime between TO_DATE(:fromdate, 'DD-MM-YYYY') and TO_DATE(:todate, 'DD-MM-YYYY')
    """, nativeQuery = true)
    List<Object[]> getTransferDetails(@Param("fromdate") String fromdate,
                                     @Param("todate") String todate);
}
