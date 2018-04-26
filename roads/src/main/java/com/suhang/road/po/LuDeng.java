package com.suhang.road.po;

public class LuDeng {
    private int ld_id;
    private String ld_logo;
    private String ld_name;
    private String ld_location;
    private String ld_distance;
    private String ld_type;
    private String ld_num;
    private String ld_year;
    private String ld_block;

    @Override
    public String toString() {
        return
                "符号:" + ld_logo +
                ",名称:" + ld_name +
                ",位置:" + ld_location +
                ",间距:" + ld_distance +
                ",类别:" + ld_type +
                ",数量:" + ld_num +
                ",年代:" + ld_year
                ;
    }

    public void setLd_id(int ld_id) {
        this.ld_id = ld_id;
    }

    public void setLd_logo(String ld_logo) {
        this.ld_logo = ld_logo;
    }

    public void setLd_name(String ld_name) {
        this.ld_name = ld_name;
    }

    public void setLd_location(String ld_location) {
        this.ld_location = ld_location;
    }

    public void setLd_distance(String ld_distance) {
        this.ld_distance = ld_distance;
    }

    public void setLd_type(String ld_type) {
        this.ld_type = ld_type;
    }

    public void setLd_num(String ld_num) {
        this.ld_num = ld_num;
    }

    public void setLd_year(String ld_year) {
        this.ld_year = ld_year;
    }

    public void setLd_block(String ld_block) {
        this.ld_block = ld_block;
    }

    public int getLd_id() {
        return ld_id;
    }

    public String getLd_logo() {
        return ld_logo;
    }

    public String getLd_name() {
        return ld_name;
    }

    public String getLd_location() {
        return ld_location;
    }

    public String getLd_distance() {
        return ld_distance;
    }

    public String getLd_type() {
        return ld_type;
    }

    public String getLd_num() {
        return ld_num;
    }

    public String getLd_year() {
        return ld_year;
    }

    public String getLd_block() {
        return ld_block;
    }
}
