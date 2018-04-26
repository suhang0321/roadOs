package com.suhang.road.mapper;

import com.suhang.road.po.JiaShan;
import com.suhang.road.povo.JiaShanVo;

import java.util.LinkedList;
import java.util.List;

public interface JiaShanMapper {
    public List<JiaShan> findJiaShansByBlock(JiaShanVo jiaShanVo)throws Exception;

    public List<JiaShan> findJiaShansAll(JiaShanVo jiaShanVo)throws Exception;

    public Integer findCountAll()throws Exception;

    public JiaShan findJiaShanById(int id)throws Exception;

    public List<JiaShan> getJiaShansAll()throws Exception;

    public List<JiaShan> getJiaShansByBlock(String block)throws Exception;

    public Integer findCountByBlock(String block)throws Exception;

    public void updateJiaShanList(List<JiaShan> jiaShans)throws Exception;

    public void deleteJiaShansByIds(String[] js_ids)throws Exception;

    public void insertJiaShan(JiaShan jiaShan)throws Exception;
}
