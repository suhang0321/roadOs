package com.suhang.road.mapper;

import com.suhang.road.po.LuoYeQiaoMu;
import com.suhang.road.povo.LuoYeQiaoMuVo;

import java.util.List;

public interface LuoYeQiaoMuMapper {
    public List<LuoYeQiaoMu> findLuoYeQiaoMusByBlock(LuoYeQiaoMuVo luoYeQiaoMuVo)throws Exception;

    public List<LuoYeQiaoMu> findLuoYeQiaoMusAll(LuoYeQiaoMuVo luoYeQiaoMuVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public LuoYeQiaoMu findLuoYeById(int id)throws Exception;

    public List<LuoYeQiaoMu> getLuoYesAll()throws Exception;

    public List<LuoYeQiaoMu> getLuoYesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateLuoYeQiaoMuList(List<LuoYeQiaoMu> luoYeQiaoMus)throws Exception;

    public void deleteLuoYeQiaoMusByIds(String[] qm_ids)throws Exception;

    public void insertLuoYeQiaoMu(LuoYeQiaoMu luoYeQiaoMu)throws Exception;
}
