package com.suhang.road.serviceImp;

import com.suhang.road.mapper.ErCiMapper;
import com.suhang.road.po.ErCiGongShui;
import com.suhang.road.povo.ErCiGongShuiVo;
import com.suhang.road.service.ErCiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ErCiServiceImp implements ErCiService {
    @Autowired
    private ErCiMapper erCiMapper;
    @Override
    public List<ErCiGongShui> findErCisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        ErCiGongShuiVo erCiGongShuiVoall = new ErCiGongShuiVo();
        erCiGongShuiVoall.setSnep(snep);
        erCiGongShuiVoall.setPs(ps);
        ErCiGongShuiVo erCiGongShuiVo = new ErCiGongShuiVo();
        erCiGongShuiVo.setSnep(snep);
        erCiGongShuiVo.setPs(ps);
        erCiGongShuiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return erCiMapper.findErCisAll(erCiGongShuiVoall);
        } else {
            return erCiMapper.findErCisByBlock(erCiGongShuiVo);
        }    }

    @Override
    public void updateErCiList(List<ErCiGongShui> erCiGongShuis) throws Exception {
        erCiMapper.updateErCiList(erCiGongShuis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return erCiMapper.findCountAll();
    }

    @Override
    public ErCiGongShui findErCiById(int sj_id) throws Exception {
        return erCiMapper.findErCiById(sj_id);
    }

    @Override
    public List<ErCiGongShui> getErCisAll() throws Exception {
        return erCiMapper.getErCisAll();
    }

    @Override
    public List<ErCiGongShui> getErCisByBlock(String block) throws Exception {
        return erCiMapper.getErCisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return erCiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteErCisByIds(String[] sj_ids) throws Exception {
        erCiMapper.deleteErCisByIds(sj_ids);
    }

    @Override
    public void insertErCi(ErCiGongShui erCiGongShui) throws Exception {
        erCiMapper.insertErCi(erCiGongShui);
    }
}
