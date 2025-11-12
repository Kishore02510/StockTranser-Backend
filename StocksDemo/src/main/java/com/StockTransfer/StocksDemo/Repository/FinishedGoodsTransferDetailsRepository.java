package com.StockTransfer.StocksDemo.Repository;

import com.StockTransfer.StocksDemo.Entity.FinishedGoodsTransferDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface FinishedGoodsTransferDetailsRepository extends JpaRepository<FinishedGoodsTransferDetails, Integer> {

    @Query(value = """
            select fgt.finishedgoodstransferid,p.productid,p.productname,amountperunit,nettotalamount,quantity,to_char(fgt.transactiondatetime,'dd-mm-yyyy') as transferdate,
            fgt.finishedgoodstransferrefno,fgtr.finishedgoodstransferrequestrefno
                from public.finished_goods_transfer as fgt
                join public.finished_goods_transfer_details as fgtd
                on fgt.finishedgoodstransferid = fgtd.finishedgoodstransferid
                join public.finished_goods_transfer_request as fgtr
                 on fgtr.finishedgoodstransferrequestid = fgt.finishedgoodstransferrequestid
                join public.products as p on p.productid = fgtd.productid
                where fgt.transactiondatetime between TO_DATE(:fromdate, 'DD-MM-YYYY') and TO_DATE(:todate, 'DD-MM-YYYY')
                                                                                                                               		
    """, nativeQuery = true)
    List<Object[]> getTransferProdDetails(@Param("fromdate") String fromdate,
                                         @Param("todate") String todate);
}
