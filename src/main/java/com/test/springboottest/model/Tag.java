package com.test.springboottest.model;

import java.util.Date;

public class Tag {
    private Integer id;

    private String name;

    private Date gmtCreate;

    private Date gmtModified;

    public Tag(Integer id, String name, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Tag() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}