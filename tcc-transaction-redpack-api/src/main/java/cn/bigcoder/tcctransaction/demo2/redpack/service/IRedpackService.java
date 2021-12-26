package cn.bigcoder.tcctransaction.demo2.redpack.service;

import cn.bigcoder.tcctransaction.demo2.redpack.dto.RedpackOrderDTO;
import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 * @description:
 **/
public interface IRedpackService {

    @EnableTcc
    int placeOrder(RedpackOrderDTO orderDTO);
}
