package org.example.domain;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
    private String id;
    private String pw;
    private String memberName;
    private String mobileNumber;


    //G > 일반, S > 우수
    private String grade = "G";

    private Integer mileage = 0;
    private Admin manager;

    private LocalDateTime registeredAt = LocalDateTime.now();


    public Member(String id, String pw, String memberName, String mobileNumber) {
        this.id           = id;
        this.pw           = pw;
        this.memberName   = memberName;
        this.mobileNumber = mobileNumber;
    }

    public Member(String id, String pw, String memberName, String mobileNumber, String grade, int mileage, Admin manager) {
        this.id           = id;
        this.pw           = pw;
        this.memberName   = memberName;
        this.mobileNumber = mobileNumber;
        grade = grade;
        this.mileage      = mileage;
        this.manager      = manager;
    }


    @Override
    public String toString() {
        String s = "사용자 ID='" + id + '\'' +
                   ", 사용자 비밀번호='" + pw + '\'' +
                   ", 사용자 이름='" + memberName + '\'' +
                   ", 사용자 전화번호='" + mobileNumber + '\'' +
                   ", 사용자 등급(G-일반, S-우수)='" + grade + '\'' +
                   ", 마일리지 금액=" + mileage+
                   ", 등록일자=" + registeredAt;

        if(manager != null)
            s += manager.getId();

        return s;
    }

    public String toStringMasked(){
        String s = "사용자 id='" + allMasking(id) + '\'' +
                                ", 사용자 pw='" + indexMasking(2, pw) + '\'' +
                                ", 사용자 이름='" + allMasking(memberName) + '\'' +
                                ", 사용자 전화번호='" + allMasking(mobileNumber) + '\'' +
                                ", 사용자 등급(G-일반, S-우수)='" + allMasking(grade) + '\'' +
                                ", 마일리지 금액=" + allMasking(String.valueOf(mileage)) +
                                ", 등록일자=" + allMasking(registeredAt.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));


        if(manager != null)
            s += allMasking(manager.getId());

        return s;
    }


    public String allMasking(String str){
        String ss = "";
        for(int i=0; i<str.length(); i++){
            ss += "*";
        }

        return ss;
    }

    public String indexMasking(int idx, String str){
        String ss = str.substring(0, idx);
        for(int i=0; i<str.length()-idx; i++){
            ss += "*";
        }

        return ss;
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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        grade = grade;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Admin getManager() {
        return manager;
    }

    public void setManager(Admin manager) {
        this.manager = manager;
    }
}
