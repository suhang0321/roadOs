package com.suhang.road.povo;

import com.suhang.road.po.LuoYeQiaoMu;

import java.util.List;

public class LuoYeQiaoMuVo {
    private LuoYeQiaoMu luoYeQiaoMu;
    private List<LuoYeQiaoMu> itemsList;
    private int pc;
    private int ps;
    private int tr;
    private int tp;
    private String url;
    private String block;
    private int snep;

    @Override
    public String toString() {
        return "LuoYeQiaoMuVo{" +
                "luoYeQiaoMu=" + luoYeQiaoMu +
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

    public void setLuoYeQiaoMu(LuoYeQiaoMu luoYeQiaoMu) {
        this.luoYeQiaoMu = luoYeQiaoMu;
    }

    public void setItemsList(List<LuoYeQiaoMu> itemsList) {
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

    public LuoYeQiaoMu getLuoYeQiaoMu() {
        return luoYeQiaoMu;
    }

    public List<LuoYeQiaoMu> getItemsList() {
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