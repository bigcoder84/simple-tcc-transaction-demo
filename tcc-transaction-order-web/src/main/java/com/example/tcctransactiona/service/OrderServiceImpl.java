package com.example.tcctransactiona.service;

import cn.bigcoder.tcctransaction.demo2.inventory.dto.InventoryOrderDTO;
import cn.bigcoder.tcctransaction.demo2.inventory.service.IInventoryService;
import cn.bigcoder.tcctransaction.demo2.redpack.dto.RedpackOrderDTO;
import cn.bigcoder.tcctransaction.demo2.redpack.service.IRedpackService;
import com.example.tcctransactiona.dto.OrderDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    private Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @DubboReference
    private IInventoryService inventoryService;
    @DubboReference
    private IRedpackService redpackService;


    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public int placeOrder(OrderDTO orderDTO) {
        //事务参与者1
        InventoryOrderDTO inventoryOrderDTO = new InventoryOrderDTO();
        inventoryOrderDTO.setOrderNo(UUID.randomUUID().toString());
        inventoryOrderDTO.setAmount(10);
        inventoryOrderDTO.setItemId(orderDTO.getItemId());
        int result = inventoryService.placeOrder(inventoryOrderDTO);

        // 事务参与者2
        //RedpackOrderDTO redpackOrderDTO = new RedpackOrderDTO();
        //redpackOrderDTO.setOrderNo(UUID.randomUUID().toString());
        //redpackOrderDTO.setAmount(10);
        //redpackOrderDTO.setItemId(orderDTO.getItemId());
        //redpackService.placeOrder(redpackOrderDTO);

        int i = 1 / 0;
        return 0;
    }

    public void confirmOrder(OrderDTO orderDTO) {
        log.info("confirmOrder");
    }

    public void cancelOrder(OrderDTO orderDTO) {
        log.info("cancelOrder");
    }
}
