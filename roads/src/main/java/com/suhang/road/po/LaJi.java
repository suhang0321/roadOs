package com.suhang.road.po;

public class LaJi {
    private int lj_id;
    private String lj_logo;
    private String lj_name;
    private String lj_location;
    private String lj_distance;
    private String lj_type;
    private String lj_num;
    private String lj_year;
    private String lj_block;

    @Override
    public String toString() {
        return
                "符号:" + lj_logo +
                ",名称:" + lj_name +
                ",位置:" + lj_location +
                ",间距:" + lj_distance +
                ",类别:" + lj_type +
                ",数量:" + lj_num +
                ",年代:" + lj_year
                ;
    }

    public void setLj_id(int lj_id) {
        this.lj_id = lj_id;
    }

    public void setLj_logo(String lj_logo) {
        this.lj_logo = lj_logo;
    }

    public void setLj_name(String lj_name) {
        this.lj_name = lj_name;
    }

    public void setLj_location(String lj_location) {
        this.lj_location = lj_location;
    }

    public void setLj_distance(String lj_distance) {
        this.lj_distance = lj_distance;
    }

    public void setLj_type(String lj_type) {
        this.lj_type = lj_type;
    }

    public void setLj_num(String lj_num) {
        this.lj_num = lj_num;
    }

    public void setLj_year(String lj_year) {
        this.lj_year = lj_year;
    }

    public void setLj_block(String lj_block) {
        this.lj_block = lj_block;
    }

    public int getLj_id() {
        return lj_id;
    }

    public String getLj_logo() {
        return lj_logo;
    }

    public String getLj_name() {
        return lj_name;
    }

    public String getLj_location() {
        return lj_location;
    }

    public String getLj_distance() {
        return lj_distance;
    }

    public String getLj_type() {
        return lj_type;
    }

    public String getLj_num() {
        return lj_num;
    }

    public String getLj_year() {
        return lj_year;
    }

    public String getLj_block() {
        return lj_block;
    }
}
