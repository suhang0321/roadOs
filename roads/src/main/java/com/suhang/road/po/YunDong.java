package com.suhang.road.po;

public class YunDong {
    private int yd_id;
    private String yd_logo;
    private String yd_name;
    private String yd_unit;
    private String yd_location;
    private String yd_type;
    private String yd_block;

    @Override
    public String toString() {
        return
                "符号:" + yd_logo +
                ",名称:" + yd_name +
                ",单位㎡:" + yd_unit +
                ",位置:" + yd_location +
                ",类别:" + yd_type
               ;
    }

    public void setYd_id(int yd_id) {
        this.yd_id = yd_id;
    }

    public void setYd_logo(String yd_logo) {
        this.yd_logo = yd_logo;
    }

    public void setYd_name(String yd_name) {
        this.yd_name = yd_name;
    }

    public void setYd_unit(String yd_unit) {
        this.yd_unit = yd_unit;
    }

    public void setYd_location(String yd_location) {
        this.yd_location = yd_location;
    }

    public void setYd_type(String yd_type) {
        this.yd_type = yd_type;
    }

    public void setYd_block(String yd_block) {
        this.yd_block = yd_block;
    }

    public int getYd_id() {
        return yd_id;
    }

    public String getYd_logo() {
        return yd_logo;
    }

    public String getYd_name() {
        return yd_name;
    }

    public String getYd_unit() {
        return yd_unit;
    }

    public String getYd_location() {
        return yd_location;
    }

    public String getYd_type() {
        return yd_type;
    }

    public String getYd_block() {
        return yd_block;
    }
}