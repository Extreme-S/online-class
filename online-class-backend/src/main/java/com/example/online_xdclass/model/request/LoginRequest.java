package com.example.online_xdclass.model.request;

/**
 * 登录 request
 */
public class LoginRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
