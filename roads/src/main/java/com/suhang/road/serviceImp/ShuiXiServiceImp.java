package com.suhang.road.serviceImp;

import com.suhang.road.mapper.ShuiXiMapper;
import com.suhang.road.po.ShuiXi;
import com.suhang.road.povo.ShuiXiVo;
import com.suhang.road.service.ShuiXiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShuiXiServiceImp implements ShuiXiService {
    @Autowired
    private ShuiXiMapper shuiXiMapper;
    @Override
    public List<ShuiXi> findShuiXisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        ShuiXiVo shuiXiVoall = new ShuiXiVo();
        shuiXiVoall.setSnep(snep);
        shuiXiVoall.setPs(ps);
        ShuiXiVo shuiXiVo = new ShuiXiVo();
        shuiXiVo.setSnep(snep);
        shuiXiVo.setPs(ps);
        shuiXiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return shuiXiMapper.findShuiXisAll(shuiXiVoall);
        } else {
            return shuiXiMapper.findShuiXisByBlock(shuiXiVo);
        }
    }

    @Override
    public void updateShuiXiList(List<ShuiXi> shuiXis) throws Exception {
        shuiXiMapper.updateShuiXiList(shuiXis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return shuiXiMapper.findCountAll();
    }

    @Override
    public ShuiXi findShuiXiById(int sx_id) throws Exception {
        return shuiXiMapper.findShuiXiById(sx_id);
    }

    @Override
    public List<ShuiXi> getShuiXisAll() throws Exception {
        return shuiXiMapper.getShuiXisAll();
    }

    @Override
    public List<ShuiXi> getShuiXisByBlock(String block) throws Exception {
        return shuiXiMapper.getShuiXisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return shuiXiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteShuiXisByIds(String[] sx_ids) throws Exception {
        shuiXiMapper.deleteShuiXisByIds(sx_ids);
    }

    @Override
    public void insertShuiXi(ShuiXi shuiXi) throws Exception {
        shuiXiMapper.insertShuiXi(shuiXi);
    }
}
