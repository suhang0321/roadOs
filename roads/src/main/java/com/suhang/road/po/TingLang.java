package com.suhang.road.po;

public class TingLang {
    private int lt_id;
    private String lt_logo;
    private String lt_name;
    private String lt_location;
    private String lt_unit;
    private String lt_type;
    private String lt_num;
    private String lt_year;
    private String lt_block;

    @Override
    public String toString() {
        return
                "符号:" + lt_logo +
                ",名称:" + lt_name +
                ",位置:" + lt_location +
                ",单位:" + lt_unit +
                ",类别:" + lt_type +
                ",数量:" + lt_num +
                ",年代:" + lt_year
                ;
    }

    public void setLt_id(int lt_id) {
        this.lt_id = lt_id;
    }

    public void setLt_logo(String lt_logo) {
        this.lt_logo = lt_logo;
    }

    public void setLt_name(String lt_name) {
        this.lt_name = lt_name;
    }

    public void setLt_location(String lt_location) {
        this.lt_location = lt_location;
    }

    public void setLt_unit(String lt_unit) {
        this.lt_unit = lt_unit;
    }

    public void setLt_type(String lt_type) {
        this.lt_type = lt_type;
    }

    public void setLt_num(String lt_num) {
        this.lt_num = lt_num;
    }

    public void setLt_year(String lt_year) {
        this.lt_year = lt_year;
    }

    public void setLt_block(String lt_block) {
        this.lt_block = lt_block;
    }

    public int getLt_id() {
        return lt_id;
    }

    public String getLt_logo() {
        return lt_logo;
    }

    public String getLt_name() {
        return lt_name;
    }

    public String getLt_location() {
        return lt_location;
    }

    public String getLt_unit() {
        return lt_unit;
    }

    public String getLt_type() {
        return lt_type;
    }

    public String getLt_num() {
        return lt_num;
    }

    public String getLt_year() {
        return lt_year;
    }

    public String getLt_block() {
        return lt_block;
    }
}
