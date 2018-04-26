package com.suhang.road.service;

import com.suhang.road.po.FangZhuan;

import java.util.List;

public interface FangZhuanService {
    public List<FangZhuan> findFangZhuansByBlock(String block,int pc ,int ps)throws Exception;

    public void updateFangZhuanList(List<FangZhuan> fangZhuanList)throws Exception;

    public List<FangZhuan> findFangZhuansAllNoFenye()throws Exception;

    public FangZhuan findFangZhuanById(int fz_id)throws Exception;

    public List<FangZhuan> findFangZhuansByBlockNoFenye(String block)throws Exception;

    public Integer findCountAll()throws Exception;

    public  Integer findCountByBlock(String block)throws Exception;

    public void deleteFangZhuanByIds(String[] fz_ids)throws Exception;

    public void insertFangZhuan(FangZhuan fangZhuan)throws Exception;
}
