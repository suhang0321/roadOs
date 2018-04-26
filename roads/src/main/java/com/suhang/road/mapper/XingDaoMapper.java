package com.suhang.road.mapper;

import com.suhang.road.po.XingDaoShu;
import com.suhang.road.povo.XingDaoShuVo;

import java.util.List;

public interface XingDaoMapper {
    public List<XingDaoShu> findXingDaosByBlock(XingDaoShuVo xingDaoShuVo)throws Exception;

    public List<XingDaoShu> findXingDaosAll(XingDaoShuVo xingDaoShuVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public XingDaoShu findXingDaoById(int id )throws Exception;

    public List<XingDaoShu> getXingDaosAll()throws Exception;

    public List<XingDaoShu> getXingDaosByBlock(String block)throws Exception;

    public void updateXingDaoList(List<XingDaoShu> xingDaoShus)throws Exception;

    public void deleteXingDaosByIds(String[] xd_ids)throws Exception;

    public void insertXingDao(XingDaoShu xingDaoShu)throws Exception;
}
