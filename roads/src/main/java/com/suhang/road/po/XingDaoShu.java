package com.suhang.road.po;

public class XingDaoShu {
    private int xd_id;
    private String xd_logo;
    private String xd_name;
    private String xd_location;
    private String xd_direction;
    private String xd_kind;
    private String xd_num;
    private String xd_year;
    private String xd_block;

    @Override
    public String toString() {
        return
                "符号:" + xd_logo +
                ",名称:" + xd_name +
                ",位置:" + xd_location +
                ",方向:" + xd_direction +
                ",品种:" + xd_kind +
                ",数量:" + xd_num +
                ",年代:" + xd_year
                ;
    }

    public void setXd_id(int xd_id) {
        this.xd_id = xd_id;
    }

    public void setXd_logo(String xd_logo) {
        this.xd_logo = xd_logo;
    }

    public void setXd_name(String xd_name) {
        this.xd_name = xd_name;
    }

    public void setXd_location(String xd_location) {
        this.xd_location = xd_location;
    }

    public void setXd_direction(String xd_direction) {
        this.xd_direction = xd_direction;
    }

    public void setXd_kind(String xd_kind) {
        this.xd_kind = xd_kind;
    }

    public void setXd_num(String xd_num) {
        this.xd_num = xd_num;
    }

    public void setXd_year(String xd_year) {
        this.xd_year = xd_year;
    }

    public void setXd_block(String xd_block) {
        this.xd_block = xd_block;
    }

    public int getXd_id() {
        return xd_id;
    }

    public String getXd_logo() {
        return xd_logo;
    }

    public String getXd_name() {
        return xd_name;
    }

    public String getXd_location() {
        return xd_location;
    }

    public String getXd_direction() {
        return xd_direction;
    }

    public String getXd_kind() {
        return xd_kind;
    }

    public String getXd_num() {
        return xd_num;
    }

    public String getXd_year() {
        return xd_year;
    }

    public String getXd_block() {
        return xd_block;
    }
}
