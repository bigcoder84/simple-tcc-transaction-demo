package cn.bigcoder.tcctransaction.demo2.inventory.service;

import cn.bigcoder.tcctransaction.demo2.inventory.dto.InventoryOrderDTO;
import cn.bigcoder.tcctransaction.demo2.redpack.dto.RedpackOrderDTO;
import cn.bigcoder.tcctransaction.demo2.redpack.service.IRedpackService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
@DubboService(timeout = 900000000, cluster = "failfast")
public class InventoryService implements IInventoryService {

    private Logger log = LoggerFactory.getLogger(InventoryService.class);
    @DubboReference
    private IRedpackService redpackService;


    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public int placeOrder(InventoryOrderDTO inventoryOrderDTO) {
        log.info("tryOrder");
        //int i = 1 / 0;

        // 事务参与者
        RedpackOrderDTO redpackOrderDTO = new RedpackOrderDTO();
        redpackOrderDTO.setOrderNo(UUID.randomUUID().toString());
        redpackOrderDTO.setAmount(10);
        redpackOrderDTO.setItemId(inventoryOrderDTO.getItemId());
        redpackService.placeOrder(redpackOrderDTO);
        return 0;
    }

    @Override
    public int cancelPlaceOrder(InventoryOrderDTO orderDTO) {
        log.info("cancelOrder");
        return 0;
    }

    public void confirmOrder(InventoryOrderDTO orderDTO) {
        log.info("confirmOrder");
    }

    public void cancelOrder(InventoryOrderDTO orderDTO) {
        log.info("cancelOrder");
    }

}
