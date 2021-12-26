package cn.bigcoder.tcctransaction.demo2.inventory.dto;

import java.io.Serializable;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
public class InventoryOrderDTO implements Serializable {
    private String orderNo;
    private Integer amount;
    private Integer itemId;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
