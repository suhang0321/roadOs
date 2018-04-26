package com.suhang.road.po;

public class ZhenGui {
    private int zg_id;
    private String zg_logo;
    private String zg_name;
    private String zg_location;
    private String zg_distance;
    private String zg_protect;
    private String zg_num;
    private String zg_year;
    private String zg_block;

    @Override
    public String toString() {
        return
                "符号:" + zg_logo +
                ",名称:" + zg_name +
                ",位置:" + zg_location +
                ",胸径:" + zg_distance +
                ",保护措施:" + zg_protect +
                ",数量:" + zg_num +
                ",年代:" + zg_year
                ;
    }

    public void setZg_id(int zg_id) {
        this.zg_id = zg_id;
    }

    public void setZg_logo(String zg_logo) {
        this.zg_logo = zg_logo;
    }

    public void setZg_name(String zg_name) {
        this.zg_name = zg_name;
    }

    public void setZg_location(String zg_location) {
        this.zg_location = zg_location;
    }

    public void setZg_distance(String zg_distance) {
        this.zg_distance = zg_distance;
    }

    public void setZg_protect(String zg_protect) {
        this.zg_protect = zg_protect;
    }

    public void setZg_num(String zg_num) {
        this.zg_num = zg_num;
    }

    public void setZg_year(String zg_year) {
        this.zg_year = zg_year;
    }

    public void setZg_block(String zg_block) {
        this.zg_block = zg_block;
    }

    public int getZg_id() {
        return zg_id;
    }

    public String getZg_logo() {
        return zg_logo;
    }

    public String getZg_name() {
        return zg_name;
    }

    public String getZg_location() {
        return zg_location;
    }

    public String getZg_distance() {
        return zg_distance;
    }

    public String getZg_protect() {
        return zg_protect;
    }

    public String getZg_num() {
        return zg_num;
    }

    public String getZg_year() {
        return zg_year;
    }

    public String getZg_block() {
        return zg_block;
    }
}