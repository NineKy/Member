package org.example;

import java.time.LocalDateTime;

public class Admin {
    private String        id;
    private String        pw;
    private String        name;
    private String        mobileNumber;
    private LocalDateTime registeredAt = LocalDateTime.now();

    public Admin(String id, String pw, String name, String mobileNumber) {
        this.id           = id;
        this.pw           = pw;
        this.name         = name;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return
               "관리자 id='" + id + '\'' +
               ", 관리자 pw='" + pw + '\'' +
               ", 관리자 이름='" + name + '\'' +
               ", 관리자 전화번호='" + mobileNumber + '\'' +
               ", 관리자 등록일자=" + registeredAt
               ;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
