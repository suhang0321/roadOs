package com.suhang.road.mapper;

import com.suhang.road.po.LuDeng;
import com.suhang.road.povo.LuDengVo;

import java.util.List;

public interface LuDengMapper {
    public List<LuDeng>findLuDengsByBlock(LuDengVo luDengVo)throws Exception;

    public List<LuDeng> findLuDengsAll(LuDengVo luDengVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public LuDeng findLuDengById(int id)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateLuDengList(List<LuDeng> luDengs)throws Exception;

    public void deleteLuDengsByIds(String[] ld_ids)throws Exception;

    public void insertLuDeng(LuDeng luDeng )throws Exception;
}
