package com.test.springboottest.model;

import java.util.Date;

public class AdminUserWithBLOBs extends AdminUser {
    private String hobby;

    private String motto;

    private String mdInfo;

    public AdminUserWithBLOBs(Integer id, String username, String password, Date birthDate, String nickname, String email, String github, String qq, String wecaht, String avatar, Date gmtCreate, Date gmtModified, String hobby, String motto, String mdInfo) {
        super(id, username, password, birthDate, nickname, email, github, qq, wecaht, avatar, gmtCreate, gmtModified);
        this.hobby = hobby;
        this.motto = motto;
        this.mdInfo = mdInfo;
    }

    public AdminUserWithBLOBs() {
        super();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    public String getMdInfo() {
        return mdInfo;
    }

    public void setMdInfo(String mdInfo) {
        this.mdInfo = mdInfo == null ? null : mdInfo.trim();
    }
}