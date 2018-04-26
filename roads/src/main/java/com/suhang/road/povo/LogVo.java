package com.suhang.road.povo;

public class LogVo {
    private String l_operation;
    private String l_block;
    private String l_table;
    private int pc;
    private int ps;
    private int tr;
    private int tp;
    private String url;
    private String block;
    private int snep;

    @Override
    public String toString() {
        return "LogVo{" +
                "l_operation='" + l_operation + '\'' +
                ", l_block='" + l_block + '\'' +
                ", l_table='" + l_table + '\'' +
                ", pc=" + pc +
                ", ps=" + ps +
                ", tr=" + tr +
                ", tp=" + tp +
                ", url='" + url + '\'' +
                ", block='" + block + '\'' +
                ", snep=" + snep +
                '}';
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

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setSnep(int snep) {
        this.snep = snep;
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

    public int getPc() {
        return pc;
    }

    public int getPs() {
        return ps;
    }

    public int getTr() {
        return tr;
    }

    public int getTp() {
        return tp;
    }

    public String getUrl() {
        return url;
    }

    public String getBlock() {
        return block;
    }

    public int getSnep() {
        return snep;
    }
}