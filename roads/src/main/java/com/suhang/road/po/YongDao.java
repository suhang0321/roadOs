package com.suhang.road.po;

public class YongDao {
    private int yd_id;
    private String yd_logo;
    private String yd_name;
    private String yd_location;
    private String yd_direction;
    private String yd_length;
    private String yd_width;
    private String yd_area;
    private String yd_block;

    @Override
    public String toString() {
        return
                "符号:" + yd_logo +
                ",道路名称:" + yd_name +
                ",位置:" + yd_location +
                ",方向:" + yd_direction +
                ",长度:" + yd_length +
                ",宽度:" + yd_width +
                ",面积:" + yd_area
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

    public void setYd_location(String yd_location) {
        this.yd_location = yd_location;
    }

    public void setYd_direction(String yd_direction) {
        this.yd_direction = yd_direction;
    }

    public void setYd_length(String yd_length) {
        this.yd_length = yd_length;
    }

    public void setYd_width(String yd_width) {
        this.yd_width = yd_width;
    }

    public void setYd_area(String yd_area) {
        this.yd_area = yd_area;
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

    public String getYd_location() {
        return yd_location;
    }

    public String getYd_direction() {
        return yd_direction;
    }

    public String getYd_length() {
        return yd_length;
    }

    public String getYd_width() {
        return yd_width;
    }

    public String getYd_area() {
        return yd_area;
    }

    public String getYd_block() {
        return yd_block;
    }
}
