package com.suhang.road.serviceImp;

import com.suhang.road.mapper.BaiYouMapper;
import com.suhang.road.po.BaiYou;
import com.suhang.road.povo.BaiYouVo;
import com.suhang.road.service.BaiYouService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BaiYouServiceImp implements BaiYouService {
    @Autowired
    private BaiYouMapper projectMapper;
    @Override
    public List<BaiYou> findBaiYousByBlock(String block,int pc ,int ps) throws Exception {
        int snep = (pc-1) *ps;
        BaiYouVo baiYouVoall = new BaiYouVo();
        baiYouVoall.setSnep(snep);
        baiYouVoall.setPs(ps);
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setSnep(snep);
        baiYouVo.setPs(ps);
        baiYouVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            List<BaiYou> baiYouList = projectMapper.findBaiYousAll(baiYouVoall);
            return baiYouList;
        }else {
            List<BaiYou> baiYous = projectMapper.findBaiYousByBlock(baiYouVo);
            return baiYous;
        }
    }



    @Override
    public void updateBaiYouList(List<BaiYou> baiYouList) throws Exception {
        projectMapper.updateBaiYouList(baiYouList);
    }

    @Override
    public List<BaiYou> findBaiYousAll1() throws Exception {
        return projectMapper.findBaiYousAll1();
    }

    @Override
    public BaiYou findBaiYouById(int by_id) throws Exception {
        return projectMapper.findBaiYouById(by_id);
    }

    @Override
    public List<BaiYou> findBaiYousByBlock1(String block) throws Exception {
        return projectMapper.findBaiYousByBlock1(block);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return projectMapper.findCountAll();
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return projectMapper.findCountByBlock(block);
    }

    @Override
    public void deleteBaiYouByIds(String[] by_ids) throws Exception {
        projectMapper.deleteBaiYousByIds(by_ids);
    }

    @Override
    public void insertBaiYou(BaiYou baiYou) throws Exception {
//        String by_id = UUID.randomUUID().toString().replaceAll("\\-","");
//        baiYou.setBy_id(by_id);
        projectMapper.insertBaiYou(baiYou);
    }
}
