package com.suhang.road.po;

public class CaoPing {
    private int cp_id;
    private String cp_logo;
    private String cp_name;
    private String cp_location;
    private String cp_direction;
    private String cp_length;
    private String cp_width;
    private String cp_area;
    private String cp_block;

    @Override
    public String toString() {
        return
                "符号:" + cp_logo +
                ", 名称:" + cp_name +
                ", 位置:" + cp_location +
                ", 方向:" + cp_direction +
                ", 长度:" + cp_length +
                ", 宽度:" + cp_width +
                ", 面积:" + cp_area
                ;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public void setCp_logo(String cp_logo) {
        this.cp_logo = cp_logo;
    }

    public void setCp_name(String cp_name) {
        this.cp_name = cp_name;
    }

    public void setCp_location(String cp_location) {
        this.cp_location = cp_location;
    }

    public void setCp_direction(String cp_direction) {
        this.cp_direction = cp_direction;
    }

    public void setCp_length(String cp_length) {
        this.cp_length = cp_length;
    }

    public void setCp_width(String cp_width) {
        this.cp_width = cp_width;
    }

    public void setCp_area(String cp_area) {
        this.cp_area = cp_area;
    }

    public void setCp_block(String cp_block) {
        this.cp_block = cp_block;
    }

    public int getCp_id() {
        return cp_id;
    }

    public String getCp_logo() {
        return cp_logo;
    }

    public String getCp_name() {
        return cp_name;
    }

    public String getCp_location() {
        return cp_location;
    }

    public String getCp_direction() {
        return cp_direction;
    }

    public String getCp_length() {
        return cp_length;
    }

    public String getCp_width() {
        return cp_width;
    }

    public String getCp_area() {
        return cp_area;
    }

    public String getCp_block() {
        return cp_block;
    }
}
