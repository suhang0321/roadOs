package com.suhang.road.po;

public class GuoPiXiang {
    private int px_id;
    private String px_logo;
    private String px_name;
    private String px_location;
    private String px_distance;
    private String px_kind;
    private String px_num;
    private String px_year;
    private String px_block;

    @Override
    public String toString() {
        return

                "符号:" + px_logo +
                ",名称:" + px_name +
                ",位置:" + px_location +
                ",间距:" + px_distance +
                ",品种:" + px_kind +
                ",数量:" + px_num +
                ",年代:" + px_year
                ;
    }

    public void setPx_id(int px_id) {
        this.px_id = px_id;
    }

    public void setPx_logo(String px_logo) {
        this.px_logo = px_logo;
    }

    public void setPx_name(String px_name) {
        this.px_name = px_name;
    }

    public void setPx_location(String px_location) {
        this.px_location = px_location;
    }

    public void setPx_distance(String px_distance) {
        this.px_distance = px_distance;
    }

    public void setPx_kind(String px_kind) {
        this.px_kind = px_kind;
    }

    public void setPx_num(String px_num) {
        this.px_num = px_num;
    }

    public void setPx_year(String px_year) {
        this.px_year = px_year;
    }

    public void setPx_block(String px_block) {
        this.px_block = px_block;
    }

    public int getPx_id() {
        return px_id;
    }

    public String getPx_logo() {
        return px_logo;
    }

    public String getPx_name() {
        return px_name;
    }

    public String getPx_location() {
        return px_location;
    }

    public String getPx_distance() {
        return px_distance;
    }

    public String getPx_kind() {
        return px_kind;
    }

    public String getPx_num() {
        return px_num;
    }

    public String getPx_year() {
        return px_year;
    }

    public String getPx_block() {
        return px_block;
    }
}
