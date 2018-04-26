package com.suhang.road.serviceImp;

import com.suhang.road.mapper.YongDaoMapper;
import com.suhang.road.po.YongDao;
import com.suhang.road.povo.YongDaoVo;
import com.suhang.road.service.YongDaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class YongDaoServiceImp implements YongDaoService {
    @Autowired
    private YongDaoMapper yongDaoMapper;
    @Override
    public List<YongDao> findYongDaosByBlock(String block,int pc,int ps) throws Exception {
        int snep = (pc-1) *ps;
        YongDaoVo yongDaoVoall = new YongDaoVo();
        yongDaoVoall.setSnep(snep);
        yongDaoVoall.setPs(ps);
        YongDaoVo yongDaoVo = new YongDaoVo();
        yongDaoVo.setSnep(snep);
        yongDaoVo.setPs(ps);
        yongDaoVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")){
            return yongDaoMapper.findYongDaosAll(yongDaoVoall);

        }else {
            return yongDaoMapper.findYongDaosByBlock(yongDaoVo);
        }

    }

    @Override
    public void updateYongDaoList(List<YongDao> yongDaoList) throws Exception {
        yongDaoMapper.updateYongDaoList(yongDaoList);
    }

    @Override
    public List<YongDao> getYongDaosAll() throws Exception {
        return yongDaoMapper.getYongDaosAll();
    }

    @Override
    public List<YongDao> getYongDaosByBlock(String block) throws Exception {
        return yongDaoMapper.getYongDaosByBlock(block);
    }

    @Override
    public YongDao findYongDaoById(int yd_id) throws Exception {
        return yongDaoMapper.findYongDaoById(yd_id);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return yongDaoMapper.findCountAll();
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return yongDaoMapper.findCountByBlock(block);
    }

    @Override
    public void deleteYongDaosByIds(String[] yd_ids) throws Exception {
        yongDaoMapper.deleteYongDaosByIds(yd_ids);
    }

    @Override
    public void insertYongDao(YongDao yongDao) throws Exception {
        yongDaoMapper.insertYongDao(yongDao);
    }
}
