package com.suhang.road.mapper;

import com.suhang.road.po.GuoPiXiang;
import com.suhang.road.povo.GuoPiXiangVo;

import java.util.List;

public interface GuoPiXiangMapper {
    public List<GuoPiXiang> findGuoPiXiangsByBlock(GuoPiXiangVo guoPiXiangVo)throws Exception;

    public List<GuoPiXiang> findGuoPiXiangsAll(GuoPiXiangVo guoPiXiangVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public GuoPiXiang findGuoPiXiangById(int id)throws Exception;

    public List<GuoPiXiang> getGuoPiXiangsAll()throws Exception;

    public List<GuoPiXiang> getGuoPiXiangsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateGuoPiXiangList(List<GuoPiXiang> guoPiXiangs)throws Exception;

    public void deleteGuoPiXiangsByIds(String[] px_ids)throws Exception;

    public void insertGuoPiXiang(GuoPiXiang guoPiXiang)throws Exception;
}
