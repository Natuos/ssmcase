package com.javapandeng.po;

import java.io.Serializable;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/8/6
 * Time:11:29
 */


public class Sc implements Serializable {

    private Integer id;
    /**
     * 商品id
     */
    private Integer itemId;
    /**
     * 商品对象
     */
    private Item item;

    /**
     *
     * 收藏者id
     */
    private Integer userId;

    public Sc(Integer id, Integer itemId, Integer userId) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
    }

    public Sc() {
    }

    @Override
    public String toString() {
        return "Sc{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", item=" + item +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
