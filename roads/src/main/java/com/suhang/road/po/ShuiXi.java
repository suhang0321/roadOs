package com.suhang.road.po;

public class ShuiXi {
    private int sx_id;
    private String sx_logo;
    private String sx_name;
    private String sx_location;
    private String sx_unit;
    private String sx_type;
    private String sx_num;
    private String sx_year;
    private String sx_block;

    @Override
    public String toString() {
        return
                "符号:" + sx_logo +
                ",名称:" + sx_name +
                ",位置:" + sx_location +
                ",单位:" + sx_unit +
                ",类别:" + sx_type +
                ",数量:" + sx_num +
                ",年代:" + sx_year
                ;
    }

    public void setSx_id(int sx_id) {
        this.sx_id = sx_id;
    }

    public void setSx_logo(String sx_logo) {
        this.sx_logo = sx_logo;
    }

    public void setSx_name(String sx_name) {
        this.sx_name = sx_name;
    }

    public void setSx_location(String sx_location) {
        this.sx_location = sx_location;
    }

    public void setSx_unit(String sx_unit) {
        this.sx_unit = sx_unit;
    }

    public void setSx_type(String sx_type) {
        this.sx_type = sx_type;
    }

    public void setSx_num(String sx_num) {
        this.sx_num = sx_num;
    }

    public void setSx_year(String sx_year) {
        this.sx_year = sx_year;
    }

    public void setSx_block(String sx_block) {
        this.sx_block = sx_block;
    }

    public int getSx_id() {
        return sx_id;
    }

    public String getSx_logo() {
        return sx_logo;
    }

    public String getSx_name() {
        return sx_name;
    }

    public String getSx_location() {
        return sx_location;
    }

    public String getSx_unit() {
        return sx_unit;
    }

    public String getSx_type() {
        return sx_type;
    }

    public String getSx_num() {
        return sx_num;
    }

    public String getSx_year() {
        return sx_year;
    }

    public String getSx_block() {
        return sx_block;
    }
}