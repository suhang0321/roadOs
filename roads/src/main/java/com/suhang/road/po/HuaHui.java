package com.suhang.road.po;

public class HuaHui {
    private int hh_id;
    private String hh_logo;
    private String hh_name;
    private String hh_location;
    private String hh_type;
    private String hh_kind;
    private String hh_num;
    private String hh_resource;
    private String hh_block;

    @Override
    public String toString() {
        return
                "符号:" + hh_logo +
                ",名称:" + hh_name +
                ",位置:" + hh_location +
                ",类别:" + hh_type +
                ",品种:" + hh_kind +
                ",数量:" + hh_num +
                ",来源:" + hh_resource
                ;
    }

    public void setHh_id(int hh_id) {
        this.hh_id = hh_id;
    }

    public void setHh_logo(String hh_logo) {
        this.hh_logo = hh_logo;
    }

    public void setHh_name(String hh_name) {
        this.hh_name = hh_name;
    }

    public void setHh_location(String hh_location) {
        this.hh_location = hh_location;
    }

    public void setHh_type(String hh_type) {
        this.hh_type = hh_type;
    }

    public void setHh_kind(String hh_kind) {
        this.hh_kind = hh_kind;
    }

    public void setHh_num(String hh_num) {
        this.hh_num = hh_num;
    }

    public void setHh_resource(String hh_resource) {
        this.hh_resource = hh_resource;
    }

    public void setHh_block(String hh_block) {
        this.hh_block = hh_block;
    }

    public int getHh_id() {
        return hh_id;
    }

    public String getHh_logo() {
        return hh_logo;
    }

    public String getHh_name() {
        return hh_name;
    }

    public String getHh_location() {
        return hh_location;
    }

    public String getHh_type() {
        return hh_type;
    }

    public String getHh_kind() {
        return hh_kind;
    }

    public String getHh_num() {
        return hh_num;
    }

    public String getHh_resource() {
        return hh_resource;
    }

    public String getHh_block() {
        return hh_block;
    }
}
