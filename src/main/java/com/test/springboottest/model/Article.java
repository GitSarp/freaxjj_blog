package com.test.springboottest.model;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isRelease;

    private Boolean hot;

    private Integer tagId;

    public Article(Integer id, String title, Date gmtCreate, Date gmtModified, Boolean isRelease, Integer tagId,Boolean hot) {
        this.id = id;
        this.title = title;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isRelease = isRelease;
        this.tagId = tagId;
        this.hot=hot;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Boolean getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Boolean isRelease) {
        this.isRelease = isRelease;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}