package com.suhang.road.mapper;

import com.suhang.road.po.FangZhuan;
import com.suhang.road.povo.FangZhuanVo;

import java.util.List;

public interface FangZhuanMapper {
    public List<FangZhuan> findFangZhuansByBlock(FangZhuanVo fangZhuanVo)throws Exception;

    public List<FangZhuan> findFangZhuansAll(FangZhuanVo fangZhuanVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public FangZhuan findFangZhuanById(int id)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public List<FangZhuan> findFangZhuansAllNoFenye()throws Exception;

    public List<FangZhuan> findFangZhuanByBlockNoFenye(String block)throws Exception;

    public void updateFangZhuanList(List<FangZhuan> fangZhuanList)throws Exception;

    public void deleteFangZhuansByIds(String[] fz_ids)throws Exception;

    public void insertFangZhuan(FangZhuan fangZhuan)throws Exception;
}
