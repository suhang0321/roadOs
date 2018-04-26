package com.suhang.road.po;

public class BaiYou {
    private int by_id;
    private String by_logo;
    private String by_name;
    private String by_direction;
    private String by_length;
    private String by_width;
    private String by_area;
    private String by_block;

    @Override
    public String toString() {
        return

                "符号:" + by_logo  +" "+
                "道路名称:" + by_name  +" "+
                "方向:" + by_direction  +" "+
                "长度:" + by_length  +" "+
                "宽度:" + by_width  +" "+
                "面积:" + by_area
                ;
    }

    public void setBy_id(int by_id) {
        this.by_id = by_id;
    }

    public void setBy_logo(String by_logo) {
        this.by_logo = by_logo;
    }

    public void setBy_name(String by_name) {
        this.by_name = by_name;
    }

    public void setBy_direction(String by_direction) {
        this.by_direction = by_direction;
    }

    public void setBy_length(String by_length) {
        this.by_length = by_length;
    }

    public void setBy_width(String by_width) {
        this.by_width = by_width;
    }

    public void setBy_area(String by_area) {
        this.by_area = by_area;
    }

    public void setBy_block(String by_block) {
        this.by_block = by_block;
    }

    public int getBy_id() {
        return by_id;
    }

    public String getBy_logo() {
        return by_logo;
    }

    public String getBy_name() {
        return by_name;
    }

    public String getBy_direction() {
        return by_direction;
    }

    public String getBy_length() {
        return by_length;
    }

    public String getBy_width() {
        return by_width;
    }

    public String getBy_area() {
        return by_area;
    }

    public String getBy_block() {
        return by_block;
    }
}
