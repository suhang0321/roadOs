package com.suhang.road.po;

public class FangZhuan {
    private int fz_id;
    private String fz_logo;
    private String fz_name;
    private String fz_location;
    private String fz_direction;
    private String fz_length;
    private String fz_width;
    private String fz_area;
    private String fz_block;

    @Override
    public String toString() {
        return
                "符号:" + fz_logo +
                ", 道路名称:" + fz_name +
                ", 位置:" + fz_location +
                ", 方向:" + fz_direction +
                ", 长度:" + fz_length +
                ", 宽度:" + fz_width +
                ", 面积:" + fz_area
               ;
    }

    public void setFz_id(int fz_id) {
        this.fz_id = fz_id;
    }

    public void setFz_logo(String fz_logo) {
        this.fz_logo = fz_logo;
    }

    public void setFz_name(String fz_name) {
        this.fz_name = fz_name;
    }

    public void setFz_location(String fz_location) {
        this.fz_location = fz_location;
    }

    public void setFz_direction(String fz_direction) {
        this.fz_direction = fz_direction;
    }

    public void setFz_length(String fz_length) {
        this.fz_length = fz_length;
    }

    public void setFz_width(String fz_width) {
        this.fz_width = fz_width;
    }

    public void setFz_area(String fz_area) {
        this.fz_area = fz_area;
    }

    public void setFz_block(String fz_block) {
        this.fz_block = fz_block;
    }

    public int getFz_id() {
        return fz_id;
    }

    public String getFz_logo() {
        return fz_logo;
    }

    public String getFz_name() {
        return fz_name;
    }

    public String getFz_location() {
        return fz_location;
    }

    public String getFz_direction() {
        return fz_direction;
    }

    public String getFz_length() {
        return fz_length;
    }

    public String getFz_width() {
        return fz_width;
    }

    public String getFz_area() {
        return fz_area;
    }

    public String getFz_block() {
        return fz_block;
    }
}
