package com.example.tcctransactiona.controller;

import com.example.tcctransactiona.dto.OrderDTO;
import com.example.tcctransactiona.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
@RestController
public class TestController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/test")
    public String test(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setItemId(90);
        orderDTO.setItemId(1111);
        orderService.placeOrder(orderDTO);
        return "success";
    }
}
