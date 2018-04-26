package com.suhang.road.po;

public class LvLi {
    private int ll_id;
    private String ll_logo;
    private String ll_name;
    private String ll_location;
    private String ll_unit;
    private String ll_kind;
    private String ll_num;
    private String ll_year;
    private String ll_block;

    @Override
    public String toString() {
        return
                "符号:" + ll_logo +
                ",名称:" + ll_name +
                ",位置:" + ll_location +
                ",单位:" + ll_unit +
                ",品种:" + ll_kind +
                ",数量:" + ll_num +
                ",年代:" + ll_year
                ;
    }

    public void setLl_id(int ll_id) {
        this.ll_id = ll_id;
    }

    public void setLl_logo(String ll_logo) {
        this.ll_logo = ll_logo;
    }

    public void setLl_name(String ll_name) {
        this.ll_name = ll_name;
    }

    public void setLl_location(String ll_location) {
        this.ll_location = ll_location;
    }

    public void setLl_unit(String ll_unit) {
        this.ll_unit = ll_unit;
    }

    public void setLl_kind(String ll_kind) {
        this.ll_kind = ll_kind;
    }

    public void setLl_num(String ll_num) {
        this.ll_num = ll_num;
    }

    public void setLl_year(String ll_year) {
        this.ll_year = ll_year;
    }

    public void setLl_block(String ll_block) {
        this.ll_block = ll_block;
    }

    public int getLl_id() {
        return ll_id;
    }

    public String getLl_logo() {
        return ll_logo;
    }

    public String getLl_name() {
        return ll_name;
    }

    public String getLl_location() {
        return ll_location;
    }

    public String getLl_unit() {
        return ll_unit;
    }

    public String getLl_kind() {
        return ll_kind;
    }

    public String getLl_num() {
        return ll_num;
    }

    public String getLl_year() {
        return ll_year;
    }

    public String getLl_block() {
        return ll_block;
    }
}