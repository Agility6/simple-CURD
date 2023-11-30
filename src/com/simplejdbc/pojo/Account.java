package com.simplejdbc.pojo;

public class Account {

    private Integer aid;
    private String username;
    private String password;

    public Account(Integer aid, String username, String password) {
        this.aid = aid;
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    /** get/set */
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password +
                '}';
    }
}
