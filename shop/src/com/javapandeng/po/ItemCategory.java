package com.javapandeng.po;

import java.io.Serializable;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/8/4
 * Time:10:08
 */

//为什么要实现序列化：有的时候我们想要把一个Java对象变成字节流的形式传出去，
// 有的时候我们想要从一个字节流中恢复一个Java对象
public class ItemCategory implements Serializable {

    //主键
    private Integer id;
    //类目名称
    private String name;
    //父id
    private Integer pid;
    //是否已删除
    private Integer isDelete;

    public ItemCategory() {

    }

    public ItemCategory(Integer id, String name, Integer pid, Integer isDelete) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", isDelete=" + isDelete +
                '}';
    }
}
