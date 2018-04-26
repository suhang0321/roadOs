package com.suhang.road.po;

public class User {
    private String uid;
    private String loginname;
    private String loginpass;
    private String block;
    private String head;

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {

        return head;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", loginname='" + loginname + '\'' +
                ", loginpass='" + loginpass + '\'' +
                ", block='" + block + '\'' +
                '}';
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getUid() {

        return uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public String getBlock() {
        return block;
    }
}
