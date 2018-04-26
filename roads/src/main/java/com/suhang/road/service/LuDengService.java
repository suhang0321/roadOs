package com.suhang.road.service;

import com.suhang.road.po.LuDeng;

import java.util.List;

public interface LuDengService {
    public List<LuDeng> findLuDengsByBlock(String block,int pc, int ps)throws Exception;

    public void updateLuDengList(List<LuDeng> luDengs)throws Exception;

    public Integer findCountAll()throws Exception;

    public LuDeng findLuDengById(int ld_id)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteLuDengsByIds(String[] ld_ids)throws Exception;

    public void insertLuDeng(LuDeng luDeng)throws Exception;
}
