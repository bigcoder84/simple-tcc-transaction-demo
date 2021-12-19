package cn.bigcoder.tcctransaction.demo2.service;

import cn.bigcoder.tcctransaction.demo2.dto.InventoryOrderDTO;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 * @description:
 **/
public interface IInventoryService {
    int placeOrder(InventoryOrderDTO orderDTO);
}
