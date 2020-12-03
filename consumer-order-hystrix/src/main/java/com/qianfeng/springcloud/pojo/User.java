package com.qianfeng.springcloud.pojo;

import java.util.Date;

public class User {
    private Long id;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(Long id) {
        this.id = id;
        this.date = new Date();
    }

    public User() {
    }
}
