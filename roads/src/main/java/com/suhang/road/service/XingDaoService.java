package com.suhang.road.service;

import com.suhang.road.po.XingDaoShu;

import java.util.List;

public interface XingDaoService {
    public List<XingDaoShu> findXingDaosByBlock(String block ,int pc,int ps)throws Exception;

    public void updateXingDaoList(List<XingDaoShu> xingDaoShuList)throws Exception;

    public Integer findCountAll()throws Exception;


    public List<XingDaoShu> getXingDaosAll()throws Exception;

    public XingDaoShu findXingDaoById(int xd_id)throws Exception;

    public List<XingDaoShu> getXingDaosByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteXingDaosByIds(String[] xd_ids)throws Exception;

    public void insertXingDao(XingDaoShu xingDaoShu)throws Exception;
}
