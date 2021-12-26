package cn.bigcoder.tcctransaction.demo2.inventory.service;

import cn.bigcoder.tcctransaction.demo2.inventory.dto.InventoryOrderDTO;
import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 * @description:
 **/
public interface IInventoryService {

    @EnableTcc
    int placeOrder(InventoryOrderDTO orderDTO);

    int cancelPlaceOrder(InventoryOrderDTO orderDTO);
}
