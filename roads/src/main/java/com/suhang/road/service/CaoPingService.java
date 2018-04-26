package com.suhang.road.service;

import com.suhang.road.po.CaoPing;

import java.util.List;

public interface CaoPingService {

    public List<CaoPing> findCaoPingsByBlock(String block,int pc,int ps)throws Exception;

    public void updateCaoPingList(List<CaoPing> caoPingList)throws Exception;

    public Integer findCountAll()throws Exception;

    public CaoPing findCaoPingById(int cp_id)throws Exception;

    public List<CaoPing> getCaoPingsAll()throws Exception;

    public List<CaoPing> getCaoPingsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteCaoPingsByIds(String[] cp_ids)throws Exception;

    public void insertCaoPing(CaoPing caoPing)throws Exception;
}
