package com.suhang.road.service;

import com.suhang.road.po.HuaHui;

import java.util.List;

public interface HuaHuiService {
    public List<HuaHui>findHuaHuisByBlock(String block,int pc,int ps)throws Exception;

    public void updateHuaHuiList(List<HuaHui> huaHuis)throws Exception;

    public Integer findCountAll()throws Exception;

    public HuaHui findHuaHuiById(int hh_id)throws Exception;

    public List<HuaHui> getHuaHuisAll()throws Exception;

    public List<HuaHui> getHuaHuisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteHuaHuisByIds(String[] hh_ids)throws Exception;

    public void insertHuaHui(HuaHui huaHui)throws Exception;
}
