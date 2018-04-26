package com.suhang.road.service;

import com.suhang.road.po.ErCiGongShui;

import java.util.List;

public interface ErCiService {
    public List<ErCiGongShui> findErCisByBlock(String block, int pc, int ps)throws Exception;

    public void updateErCiList(List<ErCiGongShui> erCiGongShuis)throws Exception;

    public Integer findCountAll()throws Exception;

    public ErCiGongShui findErCiById(int sj_id)throws Exception;

    public List<ErCiGongShui> getErCisAll()throws Exception;

    public List<ErCiGongShui> getErCisByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteErCisByIds(String[] sj_ids)throws Exception;

    public void insertErCi(ErCiGongShui erCiGongShui)throws Exception;
}
