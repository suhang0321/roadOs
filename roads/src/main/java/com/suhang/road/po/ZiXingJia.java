package com.suhang.road.po;

public class ZiXingJia {
    private int cj_id;
    private String cj_logo;
    private String cj_name;
    private String cj_location;
    private String cj_size;
    private String cj_kind;
    private String cj_num;
    private String cj_capacity;
    private String cj_block;

    @Override
    public String toString() {
        return
                "符号:" + cj_logo +
                ",名称:" + cj_name +
                ",位置:" + cj_location +
                ",规格:" + cj_size +
                ",品种:" + cj_kind +
                ",数量:" + cj_num +
                ",车位:" + cj_capacity
                ;
    }

    public void setCj_id(int cj_id) {
        this.cj_id = cj_id;
    }

    public void setCj_logo(String cj_logo) {
        this.cj_logo = cj_logo;
    }

    public void setCj_name(String cj_name) {
        this.cj_name = cj_name;
    }

    public void setCj_location(String cj_location) {
        this.cj_location = cj_location;
    }

    public void setCj_size(String cj_size) {
        this.cj_size = cj_size;
    }

    public void setCj_kind(String cj_kind) {
        this.cj_kind = cj_kind;
    }

    public void setCj_num(String cj_num) {
        this.cj_num = cj_num;
    }

    public void setCj_capacity(String cj_capacity) {
        this.cj_capacity = cj_capacity;
    }

    public void setCj_block(String cj_block) {
        this.cj_block = cj_block;
    }

    public int getCj_id() {
        return cj_id;
    }

    public String getCj_logo() {
        return cj_logo;
    }

    public String getCj_name() {
        return cj_name;
    }

    public String getCj_location() {
        return cj_location;
    }

    public String getCj_size() {
        return cj_size;
    }

    public String getCj_kind() {
        return cj_kind;
    }

    public String getCj_num() {
        return cj_num;
    }

    public String getCj_capacity() {
        return cj_capacity;
    }

    public String getCj_block() {
        return cj_block;
    }
}
