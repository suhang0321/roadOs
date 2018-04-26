package com.suhang.road.povo;

import com.suhang.road.po.BaiYou;

import java.util.List;

public class BaiYouVo {
    private BaiYou baiYou;
    private List<BaiYou> itemsList;
    private int pc;
    private int ps;
    private int tr;
    private int tp;
    private String url;
    private String block;
    private int snep;

    public void setSnep(int snep) {
        this.snep = snep;
    }

    public int getSnep() {

        return snep;
    }

    @Override
    public String toString() {
        return "BaiYouVo{" +
                "baiYou=" + baiYou +
                ", itemsList=" + itemsList +
                ", pc=" + pc +
                ", ps=" + ps +
                ", tr=" + tr +
                ", tp=" + tp +
                ", url='" + url + '\'' +
                ", block='" + block + '\'' +
                '}';
    }

    public void setBaiYou(BaiYou baiYou) {
        this.baiYou = baiYou;
    }

    public void setItemsList(List<BaiYou> itemsList) {
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

    public BaiYou getBaiYou() {
        return baiYou;
    }

    public List<BaiYou> getItemsList() {
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
}
