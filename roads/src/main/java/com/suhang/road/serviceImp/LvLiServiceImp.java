package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LvLiMapper;
import com.suhang.road.po.LvLi;
import com.suhang.road.povo.LvLiVo;
import com.suhang.road.service.LvLiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LvLiServiceImp implements LvLiService {
    @Autowired
    private LvLiMapper lvLiMapper;
    @Override
    public List<LvLi> findLvLisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        LvLiVo lvLiVoall = new LvLiVo();
        lvLiVoall.setSnep(snep);
        lvLiVoall.setPs(ps);
        LvLiVo lvLiVo = new LvLiVo();
        lvLiVo.setSnep(snep);
        lvLiVo.setPs(ps);
        lvLiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return lvLiMapper.findLvLisAll(lvLiVoall);
        } else {
            return lvLiMapper.findLvLisByBlock(lvLiVo);
        }
    }

    @Override
    public void updateLvLiList(List<LvLi> lvLis) throws Exception {
        lvLiMapper.updateLvLiList(lvLis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return lvLiMapper.findCountAll();
    }

    @Override
    public List<LvLi> getLvLisAll() throws Exception {
        return lvLiMapper.getLvLisAll();
    }

    @Override
    public LvLi findLvLiById(int ll_id) throws Exception {
        return lvLiMapper.findLvLiById(ll_id);
    }

    @Override
    public List<LvLi> getLvLisByBlock(String block) throws Exception {
        return lvLiMapper.getLvLisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return lvLiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteLvLisByIds(String[] ll_ids) throws Exception {
        lvLiMapper.deleteLvLisByIds(ll_ids);
    }

    @Override
    public void insertLvLi(LvLi lvLi) throws Exception {
        lvLiMapper.insertLvLi(lvLi);
    }
}
