package com.suhang.road.service;

import com.suhang.road.po.JiaShan;

import java.util.List;

public interface JiaShanService {
    public List<JiaShan> findJiaShansByBlock(String block, int pc, int ps)throws Exception;

    public void updateJiaShanList(List<JiaShan> jiaShans)throws Exception;

    public Integer findCountAll()throws Exception;

    public List<JiaShan> getJiaShansAll()throws Exception;

    public JiaShan findJiaShanById(int js_id)throws Exception;

    public List<JiaShan> getJiaShansByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void deleteJiaShansByIds(String[] js_ids)throws Exception;

    public void insertJiaShan(JiaShan jiaShan)throws Exception;

}
