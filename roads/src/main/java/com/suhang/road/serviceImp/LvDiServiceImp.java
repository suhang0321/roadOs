package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LvDiMapper;
import com.suhang.road.po.LvDi;
import com.suhang.road.povo.LvDiVo;
import com.suhang.road.service.LvDiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LvDiServiceImp implements LvDiService {
    @Autowired
    private LvDiMapper lvDiMapper;


    @Override
    public List<LvDi> findLvDisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        LvDiVo lvDiVoall = new LvDiVo();
        lvDiVoall.setSnep(snep);
        lvDiVoall.setPs(ps);
        LvDiVo lvDiVo = new LvDiVo();
        lvDiVo.setSnep(snep);
        lvDiVo.setPs(ps);
        lvDiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return lvDiMapper.findLvDisAll(lvDiVoall);

        }else {
            return lvDiMapper.findLvDisByBlock(lvDiVo);
        }
    }

    @Override
    public void updateLvDiList(List<LvDi> lvDiList) throws Exception {
        lvDiMapper.updateLvDiList(lvDiList);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return lvDiMapper.findCountAll();
    }

    @Override
    public List<LvDi> getLvDisAll() throws Exception {
        return lvDiMapper.getLvDisAll();
    }

    @Override
    public LvDi findLvDiById(int ld_id) throws Exception {
        return lvDiMapper.findLvDiById(ld_id);
    }

    @Override
    public List<LvDi> getLvDisByBlock(String block) throws Exception {
        return lvDiMapper.getLvDisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return lvDiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteLvDisByIds(String[] ld_ids) throws Exception {
        lvDiMapper.deleteLvDisByIds(ld_ids);
    }

    @Override
    public void insertLvDi(LvDi lvDi) throws Exception {
        lvDiMapper.insertLvDi(lvDi);
    }
}
