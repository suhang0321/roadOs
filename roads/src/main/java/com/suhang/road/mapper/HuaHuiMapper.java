package com.suhang.road.mapper;

import com.suhang.road.po.HuaHui;
import com.suhang.road.povo.HuaHuiVo;

import java.util.List;

public interface HuaHuiMapper {
    public List<HuaHui> findHuaHuisByBlock(HuaHuiVo huaHuiVo)throws Exception;

    public List<HuaHui> findHuaHuisAll(HuaHuiVo huaHuiVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public HuaHui findHuaHuiById(int id)throws Exception;

    public List<HuaHui> getHuaHuisAll()throws Exception;

    public List<HuaHui> getHuaHuisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateHuaHuiList(List<HuaHui> huaHuis)throws Exception;

    public void deleteHuaHuisByIds(String[] hm_ids)throws Exception;

    public void insertHuaHui(HuaHui huaHui)throws Exception;
}
