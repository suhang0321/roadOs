package com.suhang.road.mapper;

import com.suhang.road.po.QingXue;
import com.suhang.road.povo.QingXueVo;

import java.util.List;

public interface QingXueMapper {

    public List<QingXue> findQingXuesByBlock(QingXueVo qingXueVo)throws Exception;

    public List<QingXue> findQingXuesAll( QingXueVo qingXueVo)throws Exception;

    public Integer findCountAll ()throws Exception;

    public QingXue findQingXueById(int id)throws Exception;

    public List<QingXue> getQingXuesAll()throws Exception;

    public List<QingXue> getQingXuesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateQingXueList(List<QingXue> qingXues)throws Exception;

    public void deleteQingXuesByIds(String[] qx_ids)throws Exception;

    public void insertQingXue(QingXue qingXue)throws Exception;

}
