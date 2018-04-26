package com.suhang.road.po;

public class JiaShan {
    private int js_id;
    private String js_logo;
    private String js_name;
    private String js_location;
    private String js_unit;
    private String js_type;
    private String js_num;
    private String js_year;
    private String js_block;

    @Override
    public String toString() {
        return
                "符号:" + js_logo +
                ",名称:" + js_name +
                        ",位置:"+js_location+
                ",单位:" + js_unit +
                ",类别:" + js_type +
                ",数量:" + js_num +
                ",年代:" + js_year
                ;
    }

    public void setJs_id(int js_id) {
        this.js_id = js_id;
    }

    public void setJs_logo(String js_logo) {
        this.js_logo = js_logo;
    }

    public void setJs_name(String js_name) {
        this.js_name = js_name;
    }

    public void setJs_location(String js_location) {
        this.js_location = js_location;
    }

    public void setJs_unit(String js_unit) {
        this.js_unit = js_unit;
    }

    public void setJs_type(String js_type) {
        this.js_type = js_type;
    }

    public void setJs_num(String js_num) {
        this.js_num = js_num;
    }

    public void setJs_year(String js_year) {
        this.js_year = js_year;
    }

    public void setJs_block(String js_block) {
        this.js_block = js_block;
    }

    public int getJs_id() {
        return js_id;
    }

    public String getJs_logo() {
        return js_logo;
    }

    public String getJs_name() {
        return js_name;
    }

    public String getJs_location() {
        return js_location;
    }

    public String getJs_unit() {
        return js_unit;
    }

    public String getJs_type() {
        return js_type;
    }

    public String getJs_num() {
        return js_num;
    }

    public String getJs_year() {
        return js_year;
    }

    public String getJs_block() {
        return js_block;
    }
}
