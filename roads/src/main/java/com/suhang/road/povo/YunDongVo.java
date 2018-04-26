package com.suhang.road.povo;

import com.suhang.road.po.YunDong;

import java.util.List;

public class YunDongVo {
    private YunDong yunDong;
    private List<YunDong> itemsList;
    private int pc;
    private int ps;
    private int tr;
    private int tp;
    private String url;
    private String block;
    private int snep;

    @Override
    public String toString() {
        return "YunDongVo{" +
                "yunDong=" + yunDong +
                ", itemsList=" + itemsList +
                ", pc=" + pc +
                ", ps=" + ps +
                ", tr=" + tr +
                ", tp=" + tp +
                ", url='" + url + '\'' +
                ", block='" + block + '\'' +
                ", snep=" + snep +
                '}';
    }

    public void setYunDong(YunDong yunDong) {
        this.yunDong = yunDong;
    }

    public void setItemsList(List<YunDong> itemsList) {
        this.itemsList = itemsList;
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

    public YunDong getYunDong() {
        return yunDong;
    }

    public List<YunDong> getItemsList() {
        return itemsList;
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
