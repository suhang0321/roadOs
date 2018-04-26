package com.suhang.road.po;

public class LvDi {
    private int  ld_id;
    private String ld_logo;
    private String ld_name;
    private String ld_location;
    private String ld_direction;
    private String ld_length;
    private String ld_width;
    private String ld_area;
    private String ld_block;

    @Override
    public String toString() {
        return
                "符号:" + ld_logo +
                ",名称:" + ld_name +
                ",位置:" + ld_location +
                ",方向:" + ld_direction +
                ",长度:" + ld_length +
                ",宽度:" + ld_width +
                ",面积:" + ld_area
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

    public void setLd_direction(String ld_direction) {
        this.ld_direction = ld_direction;
    }

    public void setLd_length(String ld_length) {
        this.ld_length = ld_length;
    }

    public void setLd_width(String ld_width) {
        this.ld_width = ld_width;
    }

    public void setLd_area(String ld_area) {
        this.ld_area = ld_area;
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

    public String getLd_direction() {
        return ld_direction;
    }

    public String getLd_length() {
        return ld_length;
    }

    public String getLd_width() {
        return ld_width;
    }

    public String getLd_area() {
        return ld_area;
    }

    public String getLd_block() {
        return ld_block;
    }
}
