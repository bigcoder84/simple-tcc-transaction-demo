package com.example.tcctransactiona.dto;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-19
 **/
public class OrderDTO {
    private Integer itemId;
    private Integer amount;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
