package com.suhang.road.serviceImp;

import com.suhang.road.mapper.GuoPiXiangMapper;
import com.suhang.road.po.GuoPiXiang;
import com.suhang.road.povo.GuoPiXiangVo;
import com.suhang.road.service.GuoPiXiangService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuoPiXiangServiceImp implements GuoPiXiangService {
    @Autowired
    private GuoPiXiangMapper guoPiXiangMapper;


    @Override
    public List<GuoPiXiang> findGuoPiXiangsByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        GuoPiXiangVo guoPiXiangVoall = new GuoPiXiangVo();
        guoPiXiangVoall.setSnep(snep);
        guoPiXiangVoall.setPs(ps);
        GuoPiXiangVo guoPiXiangVo = new GuoPiXiangVo();
        guoPiXiangVo.setSnep(snep);
        guoPiXiangVo.setPs(ps);
        guoPiXiangVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return guoPiXiangMapper.findGuoPiXiangsAll(guoPiXiangVoall);
        }else {
            return guoPiXiangMapper.findGuoPiXiangsByBlock(guoPiXiangVo);
        }
    }

    @Override
    public void updateGuoPiXiangList(List<GuoPiXiang> guoPiXiangs) throws Exception {
        guoPiXiangMapper.updateGuoPiXiangList(guoPiXiangs);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return guoPiXiangMapper.findCountAll();
    }

    @Override
    public GuoPiXiang findGuoPiXiangById(int px_id) throws Exception {
        return guoPiXiangMapper.findGuoPiXiangById(px_id);
    }

    @Override
    public List<GuoPiXiang> getGuoPiXiangsAll() throws Exception {
        return guoPiXiangMapper.getGuoPiXiangsAll();
    }

    @Override
    public List<GuoPiXiang> getGuoPiXiangsByBlock(String block) throws Exception {
        return guoPiXiangMapper.getGuoPiXiangsByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return guoPiXiangMapper.findCountByBlock(block);
    }

    @Override
    public void deleteGuoPiXiangsByIds(String[] px_ids) throws Exception {
        guoPiXiangMapper.deleteGuoPiXiangsByIds(px_ids);
    }

    @Override
    public void insertGuoPiXiang(GuoPiXiang guoPiXiang) throws Exception {
        guoPiXiangMapper.insertGuoPiXiang(guoPiXiang);
    }
}
