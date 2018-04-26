package com.suhang.road.serviceImp;

import com.suhang.road.mapper.XingDaoMapper;
import com.suhang.road.po.XingDaoShu;
import com.suhang.road.povo.XingDaoShuVo;
import com.suhang.road.service.XingDaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class XingDaoServiceImp implements XingDaoService {
    @Autowired
    private XingDaoMapper xingDaoMapper;


    @Override
    public List<XingDaoShu> findXingDaosByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc-1) *ps;
        XingDaoShuVo xingDaoShuVoall = new XingDaoShuVo();
        xingDaoShuVoall.setSnep(snep);
        xingDaoShuVoall.setPs(ps);
        XingDaoShuVo xingDaoShuVo = new XingDaoShuVo();
        xingDaoShuVo.setSnep(snep);
        xingDaoShuVo.setPs(ps);
        xingDaoShuVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return xingDaoMapper.findXingDaosAll(xingDaoShuVoall);

        }else {
            return xingDaoMapper.findXingDaosByBlock(xingDaoShuVo);
        }
    }

    @Override
    public void updateXingDaoList(List<XingDaoShu> xingDaoShuList) throws Exception {
        xingDaoMapper.updateXingDaoList(xingDaoShuList);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return xingDaoMapper.findCountAll();
    }

    @Override
    public List<XingDaoShu> getXingDaosAll() throws Exception {
        return xingDaoMapper.getXingDaosAll();
    }

    @Override
    public XingDaoShu findXingDaoById(int xd_id) throws Exception {
        return xingDaoMapper.findXingDaoById(xd_id);
    }

    @Override
    public List<XingDaoShu> getXingDaosByBlock(String block) throws Exception {
        return xingDaoMapper.getXingDaosByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return xingDaoMapper.findCountByBlock(block);
    }

    @Override
    public void deleteXingDaosByIds(String[] xd_ids) throws Exception {
        xingDaoMapper.deleteXingDaosByIds(xd_ids);
    }

    @Override
    public void insertXingDao(XingDaoShu xingDaoShu) throws Exception {
        xingDaoMapper.insertXingDao(xingDaoShu);
    }
}
