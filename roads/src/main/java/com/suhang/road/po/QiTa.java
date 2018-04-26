package com.suhang.road.po;

public class QiTa {
    private int qt_id;
    private String qt_logo;
    private String qt_name;
    private String qt_unit;
    private String qt_location;
    private String qt_type;
    private String qt_block;

    @Override
    public String toString() {
        return
                "符号:" + qt_logo +
                ",名称:" + qt_name +
                ",单位:" + qt_unit +
                ",位置:" + qt_location +
                ",类别:" + qt_type
                ;
    }

    public void setQt_id(int qt_id) {
        this.qt_id = qt_id;
    }

    public void setQt_logo(String qt_logo) {
        this.qt_logo = qt_logo;
    }

    public void setQt_name(String qt_name) {
        this.qt_name = qt_name;
    }

    public void setQt_unit(String qt_unit) {
        this.qt_unit = qt_unit;
    }

    public void setQt_location(String qt_location) {
        this.qt_location = qt_location;
    }

    public void setQt_type(String qt_type) {
        this.qt_type = qt_type;
    }

    public void setQt_block(String qt_block) {
        this.qt_block = qt_block;
    }

    public int getQt_id() {
        return qt_id;
    }

    public String getQt_logo() {
        return qt_logo;
    }

    public String getQt_name() {
        return qt_name;
    }

    public String getQt_unit() {
        return qt_unit;
    }

    public String getQt_location() {
        return qt_location;
    }

    public String getQt_type() {
        return qt_type;
    }

    public String getQt_block() {
        return qt_block;
    }
}