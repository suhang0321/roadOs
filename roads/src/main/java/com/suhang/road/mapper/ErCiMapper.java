package com.suhang.road.mapper;

import com.suhang.road.po.ErCiGongShui;
import com.suhang.road.povo.ErCiGongShuiVo;

import java.util.List;

public interface ErCiMapper {
    public List<ErCiGongShui>findErCisByBlock(ErCiGongShuiVo erCiGongShuiVo)throws Exception;

    public List<ErCiGongShui> findErCisAll(ErCiGongShuiVo erCiGongShuiVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public ErCiGongShui findErCiById(int id)throws Exception;

    public List<ErCiGongShui> getErCisAll()throws Exception;

    public List<ErCiGongShui> getErCisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateErCiList(List<ErCiGongShui> erCiGongShuis)throws Exception;

    public void deleteErCisByIds(String[] sj_ids)throws Exception;

    public void insertErCi(ErCiGongShui erCiGongShui)throws Exception;

}
