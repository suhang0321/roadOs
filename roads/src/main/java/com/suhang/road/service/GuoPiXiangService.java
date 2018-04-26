package com.suhang.road.service;

import com.suhang.road.po.GuoPiXiang;

import java.util.List;

public interface GuoPiXiangService {
    public List<GuoPiXiang>findGuoPiXiangsByBlock(String block,int pc, int ps)throws Exception;

    public void updateGuoPiXiangList(List<GuoPiXiang> guoPiXiangs)throws Exception;

    public Integer findCountAll()throws Exception;

    public GuoPiXiang findGuoPiXiangById(int px_id)throws Exception;

    public List<GuoPiXiang> getGuoPiXiangsAll()throws Exception;

    public List<GuoPiXiang>  getGuoPiXiangsByBlock(String block) throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteGuoPiXiangsByIds(String[] px_ids)throws Exception;

    public void insertGuoPiXiang(GuoPiXiang guoPiXiang)throws Exception;
}
