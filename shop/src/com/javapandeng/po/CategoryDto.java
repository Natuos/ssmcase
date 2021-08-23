package com.javapandeng.po;

import java.util.List;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/8/5
 * Time:17:01
 *
 * 一级类目和它的二级类目列表
 */


public class CategoryDto {

    private ItemCategory father;

    private List<ItemCategory> children;

    public ItemCategory getFather() {
        return father;
    }

    public void setFather(ItemCategory father) {
        this.father = father;
    }

    public List<ItemCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ItemCategory> children) {
        this.children = children;
    }
}
