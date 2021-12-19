package com.example.tcctransactiona.service;

import com.example.tcctransactiona.dto.OrderDTO;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 * @description:
 **/
public interface IOrderService {

    int placeOrder(OrderDTO orderDTO);
}
