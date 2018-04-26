package com.suhang.road.service;

import com.suhang.road.po.GuanMu;
import net.sf.ehcache.transaction.xa.EhcacheXAException;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface GuanMuService {
    public List<GuanMu>findGuanMusByBlock(String block,int pc,int ps)throws Exception;

    public void updateGuanMuList(List<GuanMu> guanMus)throws Exception;

    public Integer findCountAll()throws Exception;

    public GuanMu findGuanMuById(int gm_id)throws Exception;

    public List<GuanMu> getGuanMusALL()throws Exception;

    public List<GuanMu> getGuanMusByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteGuanMusByIds(String[] gm_ids)throws Exception;

    public void insertGuanMu(GuanMu guanMu)throws Exception;
}
