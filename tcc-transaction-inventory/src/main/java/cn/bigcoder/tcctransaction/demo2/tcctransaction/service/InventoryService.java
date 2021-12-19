package cn.bigcoder.tcctransaction.demo2.tcctransaction.service;

import cn.bigcoder.tcctransaction.demo2.dto.InventoryOrderDTO;
import cn.bigcoder.tcctransaction.demo2.service.IInventoryService;
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
public class InventoryService implements IInventoryService {

    private Logger log = LoggerFactory.getLogger(InventoryService.class);


    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder", transactionContextEditor = DubboTransactionContextEditor.class)
    public int placeOrder(InventoryOrderDTO inventoryOrderDTO) {
        log.info("tryOrder");
        return 0;
    }

    public void confirmOrder(InventoryOrderDTO orderDTO) {
        log.info("confirmOrder");
    }

    public void cancelOrder(InventoryOrderDTO orderDTO) {
        log.info("cancelOrder");
    }

}
