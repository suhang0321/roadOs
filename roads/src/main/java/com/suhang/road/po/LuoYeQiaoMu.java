package com.suhang.road.po;

public class LuoYeQiaoMu {
    private int qm_id;
    private String qm_logo;
    private String qm_name;
    private String qm_location;
    private String qm_type;
    private String qm_kind;
    private String qm_num;
    private String qm_year;
    private String qm_block;

    @Override
    public String toString() {
        return
                "符号:" + qm_logo +
                ",名称:" + qm_name +
                ",位置:" + qm_location +
                ",类别:" + qm_type +
                ",品种:" + qm_kind +
                ",数量:" + qm_num +
                ",年代:" + qm_year
                ;
    }

    public void setQm_id(int qm_id) {
        this.qm_id = qm_id;
    }

    public void setQm_logo(String qm_logo) {
        this.qm_logo = qm_logo;
    }

    public void setQm_name(String qm_name) {
        this.qm_name = qm_name;
    }

    public void setQm_location(String qm_location) {
        this.qm_location = qm_location;
    }

    public void setQm_type(String qm_type) {
        this.qm_type = qm_type;
    }

    public void setQm_kind(String qm_kind) {
        this.qm_kind = qm_kind;
    }

    public void setQm_num(String qm_num) {
        this.qm_num = qm_num;
    }

    public void setQm_year(String qm_year) {
        this.qm_year = qm_year;
    }

    public void setQm_block(String qm_block) {
        this.qm_block = qm_block;
    }

    public int getQm_id() {
        return qm_id;
    }

    public String getQm_logo() {
        return qm_logo;
    }

    public String getQm_name() {
        return qm_name;
    }

    public String getQm_location() {
        return qm_location;
    }

    public String getQm_type() {
        return qm_type;
    }

    public String getQm_kind() {
        return qm_kind;
    }

    public String getQm_num() {
        return qm_num;
    }

    public String getQm_year() {
        return qm_year;
    }

    public String getQm_block() {
        return qm_block;
    }
}
