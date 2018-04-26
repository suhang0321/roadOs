package com.suhang.road.service;

import com.suhang.road.po.LuoYeQiaoMu;

import java.util.List;

public interface LuoYeService {
    public List<LuoYeQiaoMu>findLuoYesByBlock(String block,int pc,int ps)throws Exception;

    public void updateLuoYeList(List<LuoYeQiaoMu> luoYeQiaoMus)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<LuoYeQiaoMu> getLuoYesAll()throws Exception;

    public LuoYeQiaoMu findLuoYeById(int qm_id)throws Exception;

    public List<LuoYeQiaoMu> getLuoYesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteLuoYesByIds(String[] qm_ids)throws Exception;

    public void insertLuoYe(LuoYeQiaoMu luoYeQiaoMu)throws Exception;
}
