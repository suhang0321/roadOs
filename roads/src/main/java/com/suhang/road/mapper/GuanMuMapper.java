package com.suhang.road.mapper;

import com.suhang.road.po.GuanMu;
import com.suhang.road.povo.GuanMuVo;

import java.util.List;

public interface GuanMuMapper {
    public List<GuanMu> findGuanMusByBlock(GuanMuVo guanMuVo)throws Exception;

    public List<GuanMu> findGuanMusAll(GuanMuVo guanMuVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public GuanMu findGuanMuById(int id)throws Exception;

    public List<GuanMu> getGuanMusAll()throws Exception;

    public List<GuanMu> getGuanMusByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateGuanMuList(List<GuanMu> guanMus)throws Exception;

    public void deleteGuanMusByIds(String[] gm_ids)throws Exception;

    public void insertGuanMu(GuanMu guanMu)throws Exception;
}
