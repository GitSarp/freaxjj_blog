package com.test.springboottest.model;

import java.util.Date;

public class AdminUser {
    private Integer id;

    private String username;

    private String password;

    private Date birthDate;

    private String nickname;

    private String email;

    private String github;

    private String qq;

    private String wecaht;

    private String avatar;

    private Date gmtCreate;

    private Date gmtModified;

    public AdminUser(Integer id, String username, String password, Date birthDate, String nickname, String email, String github, String qq, String wecaht, String avatar, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.nickname = nickname;
        this.email = email;
        this.github = github;
        this.qq = qq;
        this.wecaht = wecaht;
        this.avatar = avatar;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AdminUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github == null ? null : github.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWecaht() {
        return wecaht;
    }

    public void setWecaht(String wecaht) {
        this.wecaht = wecaht == null ? null : wecaht.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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