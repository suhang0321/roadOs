package com.suhang.road.po;

public class QingXue {
    private int qx_id;
    private String qx_logo;
    private String qx_name;
    private String qx_size;
    private String qx_unit;
    private String qx_type;
    private String qx_num;
    private String qx_tools;
    private String qx_block;

    @Override
    public String toString() {
        return
                "符号:" + qx_logo +
                ",名称:" + qx_name +
                ",规格:" + qx_size +
                ",单位:" + qx_unit +
                ",类别:" + qx_type +
                ",数量:" + qx_num +
                ",方式:" + qx_tools
                ;
    }

    public void setQx_id(int qx_id) {
        this.qx_id = qx_id;
    }

    public void setQx_logo(String qx_logo) {
        this.qx_logo = qx_logo;
    }

    public void setQx_name(String qx_name) {
        this.qx_name = qx_name;
    }

    public void setQx_size(String qx_size) {
        this.qx_size = qx_size;
    }

    public void setQx_unit(String qx_unit) {
        this.qx_unit = qx_unit;
    }

    public void setQx_type(String qx_type) {
        this.qx_type = qx_type;
    }

    public void setQx_num(String qx_num) {
        this.qx_num = qx_num;
    }

    public void setQx_tools(String qx_tools) {
        this.qx_tools = qx_tools;
    }

    public void setQx_block(String qx_block) {
        this.qx_block = qx_block;
    }

    public int getQx_id() {
        return qx_id;
    }

    public String getQx_logo() {
        return qx_logo;
    }

    public String getQx_name() {
        return qx_name;
    }

    public String getQx_size() {
        return qx_size;
    }

    public String getQx_unit() {
        return qx_unit;
    }

    public String getQx_type() {
        return qx_type;
    }

    public String getQx_num() {
        return qx_num;
    }

    public String getQx_tools() {
        return qx_tools;
    }

    public String getQx_block() {
        return qx_block;
    }
}