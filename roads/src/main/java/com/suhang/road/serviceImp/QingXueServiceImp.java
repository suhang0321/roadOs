package com.suhang.road.serviceImp;

import com.suhang.road.mapper.QingXueMapper;
import com.suhang.road.po.QingXue;
import com.suhang.road.povo.QingXueVo;
import com.suhang.road.service.QingXueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QingXueServiceImp implements QingXueService {
    @Autowired
    private QingXueMapper qingXueMapper;
    @Override
    public List<QingXue> findQingXuesByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        QingXueVo qingXueVoall = new QingXueVo();
        qingXueVoall.setSnep(snep);
        qingXueVoall.setPs(ps);
        QingXueVo qingXueVo = new QingXueVo();
        qingXueVo.setSnep(snep);
        qingXueVo.setPs(ps);
        qingXueVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return qingXueMapper.findQingXuesAll(qingXueVoall);
        } else {
            return qingXueMapper.findQingXuesByBlock(qingXueVo);
        }
    }

    @Override
    public void updateQingXueList(List<QingXue> qingXues) throws Exception {
        qingXueMapper.updateQingXueList(qingXues);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return qingXueMapper.findCountAll();
    }

    @Override
    public QingXue findQingXueById(int qx_id) throws Exception {
        return qingXueMapper.findQingXueById(qx_id);
    }

    @Override
    public List<QingXue> getQingXuesAll() throws Exception {
        return qingXueMapper.getQingXuesAll();
    }

    @Override
    public List<QingXue> getQingXuesByBlock(String block) throws Exception {
        return qingXueMapper.getQingXuesByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return qingXueMapper.findCountByBlock(block);
    }

    @Override
    public void deleteQingXuesByIds(String[] qx_ids) throws Exception {
        qingXueMapper.deleteQingXuesByIds(qx_ids);
    }

    @Override
    public void insertQingXue(QingXue qingXue) throws Exception {
        qingXueMapper.insertQingXue(qingXue);
    }
}
