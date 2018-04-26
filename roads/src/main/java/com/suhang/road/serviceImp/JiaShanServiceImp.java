package com.suhang.road.serviceImp;

import com.suhang.road.mapper.JiaShanMapper;
import com.suhang.road.po.JiaShan;
import com.suhang.road.povo.JiaShanVo;
import com.suhang.road.service.JiaShanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JiaShanServiceImp implements JiaShanService {
    @Autowired
    private JiaShanMapper jiaShanMapper;
    @Override
    public List<JiaShan> findJiaShansByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        JiaShanVo jiaShanVoall = new JiaShanVo();
        jiaShanVoall.setSnep(snep);
        jiaShanVoall.setPs(ps);
        JiaShanVo jiaShanVo = new JiaShanVo();
        jiaShanVo.setSnep(snep);
        jiaShanVo.setPs(ps);
        jiaShanVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return jiaShanMapper.findJiaShansAll(jiaShanVoall);
        } else {
            return jiaShanMapper.findJiaShansByBlock(jiaShanVo);
        }
    }

    @Override
    public void updateJiaShanList(List<JiaShan> jiaShans) throws Exception {
        jiaShanMapper.updateJiaShanList(jiaShans);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return jiaShanMapper.findCountAll();
    }

    @Override
    public List<JiaShan> getJiaShansAll() throws Exception {
        return jiaShanMapper.getJiaShansAll();
    }

    @Override
    public JiaShan findJiaShanById(int js_id) throws Exception {
        return jiaShanMapper.findJiaShanById(js_id);
    }

    @Override
    public List<JiaShan> getJiaShansByBlock(String block) throws Exception {
        return jiaShanMapper.getJiaShansByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return jiaShanMapper.findCountByBlock(block);
    }

    @Override
    public void deleteJiaShansByIds(String[] js_ids) throws Exception {
        jiaShanMapper.deleteJiaShansByIds(js_ids);
    }

    @Override
    public void insertJiaShan(JiaShan jiaShan) throws Exception {
        jiaShanMapper.insertJiaShan(jiaShan);
    }
}
