package com.suhang.road.serviceImp;

import com.suhang.road.mapper.YunDongMapper;
import com.suhang.road.po.YunDong;
import com.suhang.road.povo.YunDongVo;
import com.suhang.road.service.YunDongService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class YunDongServiceImp implements YunDongService {
    @Autowired
    private YunDongMapper yunDongMapper;
    @Override
    public List<YunDong> findYunDongsByBlock(String block, int pc, int ps) throws Exception {
        int snep = (pc - 1) * ps;
        YunDongVo yunDongVoall = new YunDongVo();
        yunDongVoall.setSnep(snep);
        yunDongVoall.setPs(ps);
        YunDongVo yunDongVo = new YunDongVo();
        yunDongVo.setSnep(snep);
        yunDongVo.setPs(ps);
        yunDongVo.setBlock(block);
        if (block.equals("admin")||block.equals("admin2")) {
            return yunDongMapper.findYunDongsAll(yunDongVoall);
        } else {
            return yunDongMapper.findYunDongsByBlock(yunDongVo);
        }
    }

    @Override
    public void updateYunDongList(List<YunDong> yunDongs) throws Exception {
        yunDongMapper.updateYunDongList(yunDongs);
    }

    @Override
    public Integer findCountAll() throws Exception {
        return yunDongMapper.findCountAll();
    }

    @Override
    public List<YunDong> getYunDongsAll() throws Exception {
        return yunDongMapper.getYunDongsAll();
    }

    @Override
    public YunDong findYunDongById(int yd_id) throws Exception {
        return yunDongMapper.findYunDongById(yd_id);
    }

    @Override
    public List<YunDong> getYunDongsByBlock(String block) throws Exception {
        return yunDongMapper.getYunDongsByBlock(block);
    }

    @Override
    public Integer findCountByBlock(String block) throws Exception {
        return yunDongMapper.findCountByBlock(block);
    }

    @Override
    public void deleteYunDongsByIds(String[] yd_ids) throws Exception {
        yunDongMapper.deleteYunDongsByIds(yd_ids);
    }

    @Override
    public void insertYunDong(YunDong yunDong) throws Exception {
        yunDongMapper.insertYunDong(yunDong);
    }
}
