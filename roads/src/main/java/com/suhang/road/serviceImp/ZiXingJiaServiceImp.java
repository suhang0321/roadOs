package com.suhang.road.serviceImp;

import com.suhang.road.mapper.ZiXingJiaMapper;
import com.suhang.road.po.ZiXingJia;
import com.suhang.road.povo.ZiXingJiaVo;
import com.suhang.road.service.ZiXingJiaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZiXingJiaServiceImp implements ZiXingJiaService {
    @Autowired
    private ZiXingJiaMapper ziXingJiaMapper;


    @Override
    public List<ZiXingJia> findZiXingJiasByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        ZiXingJiaVo ziXingJiaVoall = new ZiXingJiaVo();
        ziXingJiaVoall.setSnep(snep);
        ziXingJiaVoall.setPs(ps);
        ZiXingJiaVo ziXingJiaVo = new ZiXingJiaVo();
        ziXingJiaVo.setSnep(snep);
        ziXingJiaVo.setPs(ps);
        ziXingJiaVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return ziXingJiaMapper.findZiXingJiasAll(ziXingJiaVoall);
        }else {
            return ziXingJiaMapper.findZiXingJiasByBlock(ziXingJiaVo);
        }
    }

    @Override
    public void updateZiXingJiaList(List<ZiXingJia> ziXingJias) throws Exception {
        ziXingJiaMapper.updateZiXingJiaList(ziXingJias);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return ziXingJiaMapper.findCountAll();
    }

    @Override
    public ZiXingJia findZiXingById(int cj_id) throws Exception {
        return ziXingJiaMapper.findZiXingById(cj_id);
    }

    @Override
    public List<ZiXingJia> getZiXingJiasAll() throws Exception {
        return ziXingJiaMapper.getZiXingJiasAll();
    }

    @Override
    public List<ZiXingJia> getZiXingJiasByBlock(String block) throws Exception {
        return ziXingJiaMapper.getZiXingJiasByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return ziXingJiaMapper.findCountByBlock(block);
    }

    @Override
    public void deleteZiXingJiasByIds(String[] cj_ids) throws Exception {
        ziXingJiaMapper.deleteZiXingJiasByIds(cj_ids);
    }

    @Override
    public void insertZiXingJia(ZiXingJia ziXingJia) throws Exception {
        ziXingJiaMapper.insertZiXingJia(ziXingJia);
    }
}
