package com.suhang.road.po;

public class TingChe {
    private int tc_id;
    private String tc_logo;
    private String tc_name;
    private String tc_location;
    private String tc_unit;
    private String tc_type;
    private String tc_num;
    private String tc_capacity;
    private String tc_block;

    @Override
    public String toString() {
        return
                "符号:" + tc_logo +
                ",名称:" + tc_name +
                ",位置:" + tc_location +
                ",单位:" + tc_unit +
                ",类别:" + tc_type +
                ",数量:" + tc_num +
                ",车位:" + tc_capacity
                ;
    }

    public void setTc_id(int tc_id) {
        this.tc_id = tc_id;
    }

    public void setTc_logo(String tc_logo) {
        this.tc_logo = tc_logo;
    }

    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
    }

    public void setTc_location(String tc_location) {
        this.tc_location = tc_location;
    }

    public void setTc_unit(String tc_unit) {
        this.tc_unit = tc_unit;
    }

    public void setTc_type(String tc_type) {
        this.tc_type = tc_type;
    }

    public void setTc_num(String tc_num) {
        this.tc_num = tc_num;
    }

    public void setTc_capacity(String tc_capacity) {
        this.tc_capacity = tc_capacity;
    }

    public void setTc_block(String tc_block) {
        this.tc_block = tc_block;
    }

    public int getTc_id() {
        return tc_id;
    }

    public String getTc_logo() {
        return tc_logo;
    }

    public String getTc_name() {
        return tc_name;
    }

    public String getTc_location() {
        return tc_location;
    }

    public String getTc_unit() {
        return tc_unit;
    }

    public String getTc_type() {
        return tc_type;
    }

    public String getTc_num() {
        return tc_num;
    }

    public String getTc_capacity() {
        return tc_capacity;
    }

    public String getTc_block() {
        return tc_block;
    }
}