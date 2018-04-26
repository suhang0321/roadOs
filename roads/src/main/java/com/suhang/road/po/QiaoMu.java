package com.suhang.road.po;

public class QiaoMu {
    private int ls_id;
    private String ls_logo;
    private String ls_name;
    private String ls_location;
    private String ls_type;
    private String ls_kind;
    private String ls_num;
    private String ls_year;
    private String ls_block;

    @Override
    public String toString() {
        return
                "符号:" + ls_logo +
                ",名称:" + ls_name +
                ",位置:" + ls_location +
                ",类别:" + ls_type +
                ",品种:" + ls_kind +
                ",数量:" + ls_num +
                ",年代:" + ls_year
                ;
    }

    public void setLs_id(int ls_id) {
        this.ls_id = ls_id;
    }

    public void setLs_logo(String ls_logo) {
        this.ls_logo = ls_logo;
    }

    public void setLs_name(String ls_name) {
        this.ls_name = ls_name;
    }

    public void setLs_location(String ls_location) {
        this.ls_location = ls_location;
    }

    public void setLs_type(String ls_type) {
        this.ls_type = ls_type;
    }

    public void setLs_kind(String ls_kind) {
        this.ls_kind = ls_kind;
    }

    public void setLs_num(String ls_num) {
        this.ls_num = ls_num;
    }

    public void setLs_year(String ls_year) {
        this.ls_year = ls_year;
    }

    public void setLs_block(String ls_block) {
        this.ls_block = ls_block;
    }

    public int getLs_id() {
        return ls_id;
    }

    public String getLs_logo() {
        return ls_logo;
    }

    public String getLs_name() {
        return ls_name;
    }

    public String getLs_location() {
        return ls_location;
    }

    public String getLs_type() {
        return ls_type;
    }

    public String getLs_kind() {
        return ls_kind;
    }

    public String getLs_num() {
        return ls_num;
    }

    public String getLs_year() {
        return ls_year;
    }

    public String getLs_block() {
        return ls_block;
    }
}
