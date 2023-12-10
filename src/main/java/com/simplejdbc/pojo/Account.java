package com.simplejdbc.pojo;

public class Account {

    private int Aid;
    private String AName;
    private String APassword;

    public Account() {
    }

    public Account(int aid, String AName, String APassword) {
        Aid = aid;
        this.AName = AName;
        this.APassword = APassword;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    public String getAPassword() {
        return APassword;
    }

    public void setAPassword(String APassword) {
        this.APassword = APassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Aid=" + Aid +
                ", AName='" + AName + '\'' +
                ", APassword='" + APassword + '\'' +
                '}';
    }
}
