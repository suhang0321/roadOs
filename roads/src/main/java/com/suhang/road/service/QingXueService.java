package com.suhang.road.service;

import com.suhang.road.po.QingXue;

import java.util.List;

public interface QingXueService {

    public List<QingXue> findQingXuesByBlock(String block, int pc, int ps)throws Exception;

    public void updateQingXueList(List<QingXue> qingXues)throws Exception;

    public Integer findCountAll()throws Exception;

    public QingXue findQingXueById(int qx_id)throws Exception;

    public List<QingXue> getQingXuesAll()throws Exception;

    public List<QingXue> getQingXuesByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteQingXuesByIds(String[] qx_ids)throws Exception;

    public void insertQingXue( QingXue qingXue)throws Exception;
}
