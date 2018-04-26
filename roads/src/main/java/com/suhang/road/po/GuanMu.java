package com.suhang.road.po;

public class GuanMu {
    private int gm_id;
    private String gm_logo;
    private String gm_name;
    private String gm_location;
    private String gm_type;
    private String gm_kind;
    private String gm_num;
    private String gm_year;
    private String gm_block;

    @Override
    public String toString() {
        return
                "符号:" + gm_logo +
                ",名称:" + gm_name +
                ",位置:" + gm_location +
                ",类别:" + gm_type +
                ",品种:" + gm_kind +
                ",数目:" + gm_num +
                ",年代:" + gm_year
               ;
    }

    public void setGm_id(int gm_id) {
        this.gm_id = gm_id;
    }

    public void setGm_logo(String gm_logo) {
        this.gm_logo = gm_logo;
    }

    public void setGm_name(String gm_name) {
        this.gm_name = gm_name;
    }

    public void setGm_location(String gm_location) {
        this.gm_location = gm_location;
    }

    public void setGm_type(String gm_type) {
        this.gm_type = gm_type;
    }

    public void setGm_kind(String gm_kind) {
        this.gm_kind = gm_kind;
    }

    public void setGm_num(String gm_num) {
        this.gm_num = gm_num;
    }

    public void setGm_year(String gm_year) {
        this.gm_year = gm_year;
    }

    public void setGm_block(String gm_block) {
        this.gm_block = gm_block;
    }

    public int getGm_id() {
        return gm_id;
    }

    public String getGm_logo() {
        return gm_logo;
    }

    public String getGm_name() {
        return gm_name;
    }

    public String getGm_location() {
        return gm_location;
    }

    public String getGm_type() {
        return gm_type;
    }

    public String getGm_kind() {
        return gm_kind;
    }

    public String getGm_num() {
        return gm_num;
    }

    public String getGm_year() {
        return gm_year;
    }

    public String getGm_block() {
        return gm_block;
    }
}
