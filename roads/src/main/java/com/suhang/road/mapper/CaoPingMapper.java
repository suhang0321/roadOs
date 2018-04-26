package com.suhang.road.mapper;

import com.suhang.road.po.CaoPing;
import com.suhang.road.povo.CaoPingVo;

import java.util.List;

public interface CaoPingMapper {
    public List<CaoPing> findCaoPingsByBlock(CaoPingVo caoPingVo)throws Exception;

    public List<CaoPing> findCaoPingsAll(CaoPingVo caoPingVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public CaoPing findCaoPingById(int id)throws Exception;

    public List<CaoPing> getCaoPingsAll()throws Exception;

    public List<CaoPing> getCaoPingsByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateCaoPingList(List<CaoPing> caoPingList)throws Exception;

    public void deleteCaoPingsByIds(String[] yd_ids)throws Exception;

    public void insertCaoPing(CaoPing caoPing)throws Exception;

}
