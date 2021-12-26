package cn.bigcoder.tcctransaction.demo2.redpack.tcctransaction.service;

import cn.bigcoder.tcctransaction.demo2.redpack.dto.RedpackOrderDTO;
import cn.bigcoder.tcctransaction.demo2.redpack.service.IRedpackService;
import org.apache.dubbo.config.annotation.DubboService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
@DubboService(timeout = 900000000, cluster = "failfast")
public class RedpackService implements IRedpackService {

    private Logger log = LoggerFactory.getLogger(RedpackService.class);


    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder", transactionContextEditor = DubboTransactionContextEditor.class)
    public int placeOrder(RedpackOrderDTO inventoryOrderDTO) {
        log.info("tryOrder");
        return 0;
    }

    public void confirmOrder(RedpackOrderDTO orderDTO) {
        log.info("confirmOrder");
    }

    public void cancelOrder(RedpackOrderDTO orderDTO) {
        log.info("cancelOrder");
    }

}
