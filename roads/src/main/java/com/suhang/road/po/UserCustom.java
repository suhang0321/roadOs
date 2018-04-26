package com.suhang.road.po;

public class UserCustom extends User {
    private String verifyCode;
    private String newloginpass;
    private String reloginpass;

    @Override
    public String toString() {
        return "UserCustom{" +
                "verifyCode='" + verifyCode + '\'' +
                ", newloginpass='" + newloginpass + '\'' +
                ", reloginpass='" + reloginpass + '\'' +
                '}';
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setNewloginpass(String newloginpass) {
        this.newloginpass = newloginpass;
    }

    public void setReloginpass(String reloginpass) {
        this.reloginpass = reloginpass;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public String getNewloginpass() {
        return newloginpass;
    }

    public String getReloginpass() {
        return reloginpass;
    }
}
