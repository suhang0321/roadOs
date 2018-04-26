package com.suhang.road.po;

public class Log {
    private long l_id;
    private String l_time;
    private String l_operation;
    private String l_block;
    private String l_table;
    private String l_content;

    @Override
    public String toString() {
        return "Log{" +
                "l_id=" + l_id +
                ", l_time='" + l_time + '\'' +
                ", l_operation='" + l_operation + '\'' +
                ", l_block='" + l_block + '\'' +
                ", l_table='" + l_table + '\'' +
                ", l_content='" + l_content + '\'' +
                '}';
    }

    public void setL_id(long l_id) {
        this.l_id = l_id;
    }

    public void setL_time(String l_time) {
        this.l_time = l_time;
    }

    public void setL_operation(String l_operation) {
        this.l_operation = l_operation;
    }

    public void setL_block(String l_block) {
        this.l_block = l_block;
    }

    public void setL_table(String l_table) {
        this.l_table = l_table;
    }

    public void setL_content(String l_content) {
        this.l_content = l_content;
    }

    public long getL_id() {
        return l_id;
    }

    public String getL_time() {
        return l_time;
    }

    public String getL_operation() {
        return l_operation;
    }

    public String getL_block() {
        return l_block;
    }

    public String getL_table() {
        return l_table;
    }

    public String getL_content() {
        return l_content;
    }
}