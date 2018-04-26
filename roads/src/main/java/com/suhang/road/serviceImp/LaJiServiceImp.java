package com.suhang.road.serviceImp;

import com.suhang.road.mapper.LaJiMapper;
import com.suhang.road.po.LaJi;
import com.suhang.road.povo.LaJiVo;
import com.suhang.road.service.LaJiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LaJiServiceImp implements LaJiService {
    @Autowired
    private LaJiMapper laJiMapper;


    @Override
    public List<LaJi> findLaJisByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        LaJiVo laJiVoall = new LaJiVo();
        laJiVoall.setSnep(snep);
        laJiVoall.setPs(ps);
        LaJiVo laJiVo = new LaJiVo();
        laJiVo.setSnep(snep);
        laJiVo.setPs(ps);
        laJiVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return laJiMapper.findLaJisAll(laJiVoall);
        } else {
            return laJiMapper.findLaJisByBlock(laJiVo);
        }
    }

    @Override
    public void updateLaJiList(List<LaJi> laJis) throws Exception {
        laJiMapper.updateLaJiList(laJis);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return laJiMapper.findCountAll();
    }

    @Override
    public LaJi findLaJiById(int lj_id) throws Exception {
        return laJiMapper.findLaJiById(lj_id);
    }

    @Override
    public List<LaJi> getLaJisAll() throws Exception {
        return laJiMapper.getLaJisAll();
    }

    @Override
    public List<LaJi> getLaJisByBlock(String block) throws Exception {
        return laJiMapper.getLaJisByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return laJiMapper.findCountByBlock(block);
    }

    @Override
    public void deleteLaJisByIds(String[] lj_ids) throws Exception {
        laJiMapper.deleteLaJisByIds(lj_ids);
    }

    @Override
    public void insertLaJi(LaJi laJi) throws Exception {
        laJiMapper.insertLaJi(laJi);
    }
}
