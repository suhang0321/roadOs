package com.suhang.road.po;

public class ErCiGongShui {
    private int sj_id;
    private String sj_logo;
    private String sj_name;
    private String sj_location;
    private String sj_unit;
    private String sj_type;
    private String sj_num;
    private String sj_year;
    private String sj_block;

    @Override
    public String toString() {
        return
                "符号:" + sj_logo +
                ", 名称:" + sj_name +
                ", 位置:" + sj_location +
                ", 单位:" + sj_unit +
                ", 类别:" + sj_type +
                ", 数量:" + sj_num +
                ", 年代:" + sj_year
               ;
    }

    public void setSj_id(int sj_id) {
        this.sj_id = sj_id;
    }

    public void setSj_logo(String sj_logo) {
        this.sj_logo = sj_logo;
    }

    public void setSj_name(String sj_name) {
        this.sj_name = sj_name;
    }

    public void setSj_location(String sj_location) {
        this.sj_location = sj_location;
    }

    public void setSj_unit(String sj_unit) {
        this.sj_unit = sj_unit;
    }

    public void setSj_type(String sj_type) {
        this.sj_type = sj_type;
    }

    public void setSj_num(String sj_num) {
        this.sj_num = sj_num;
    }

    public void setSj_year(String sj_year) {
        this.sj_year = sj_year;
    }

    public void setSj_block(String sj_block) {
        this.sj_block = sj_block;
    }

    public int getSj_id() {
        return sj_id;
    }

    public String getSj_logo() {
        return sj_logo;
    }

    public String getSj_name() {
        return sj_name;
    }

    public String getSj_location() {
        return sj_location;
    }

    public String getSj_unit() {
        return sj_unit;
    }

    public String getSj_type() {
        return sj_type;
    }

    public String getSj_num() {
        return sj_num;
    }

    public String getSj_year() {
        return sj_year;
    }

    public String getSj_block() {
        return sj_block;
    }
}
