package com.javapandeng.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/8/5
 * Time:14:04
 */

//公告
public class Message implements Serializable {
    //主键
    private Integer id;
    //姓名
    private String name;
    //内容
    private String content;
    //手机号
    private String phone;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Message(Integer id, String name, String content, String phone) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.phone = phone;
    }

    public Message() {
    }
}
