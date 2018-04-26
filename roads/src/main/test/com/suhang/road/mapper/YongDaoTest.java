package com.suhang.road.mapper;

import com.suhang.road.po.YongDao;
import com.suhang.road.povo.YongDaoVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class YongDaoTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findYongDaoByBlockTest()throws Exception {
//        YongDaoMapper yongDaoMapper = (YongDaoMapper) applicationContext.getBean("yongDaoMapper");
//        List<YongDao>yongDaos = yongDaoMapper.findYongDaosByBlock("center");
//        System.out.println(yongDaos);
//    }

    @Test
    public void insetYongDaoTest()throws Exception {
        YongDaoMapper yongDaoMapper = (YongDaoMapper) applicationContext.getBean("yongDaoMapper");
        YongDao yongDao =new YongDao();
        yongDao.setYd_logo("yd");
        yongDao.setYd_name("火山板甬道");
        yongDao.setYd_location("百花园");
        yongDao.setYd_direction("南北");
        yongDao.setYd_length("5200m");
        yongDao.setYd_width("1m");
        yongDao.setYd_area("5200平方米");
        yongDao.setYd_block("center");
        yongDaoMapper.insertYongDao(yongDao);
    }

//    @Test
//    public void findYongDaoAllTest()throws Exception {
//        YongDaoMapper yongDaoMapper = (YongDaoMapper) applicationContext.getBean("yongDaoMapper");
//        System.out.println(yongDaoMapper.findYongDaosAll());
//    }

    @Test
    public void updateYongDaoListTest()throws Exception {
        YongDaoMapper yongDaoMapper = (YongDaoMapper) applicationContext.getBean("yongDaoMapper");
        List<YongDao>yongDaos = new ArrayList<YongDao>();
        YongDao yongDao = new YongDao();
        yongDao.setYd_id(1);
        yongDao.setYd_logo("yd");
        yongDao.setYd_name("火山板甬道");
        yongDao.setYd_location("百花园");
        yongDao.setYd_direction("南北");
        yongDao.setYd_length("520m");
        yongDao.setYd_width("1m");
        yongDao.setYd_area("520平方米");
        yongDao.setYd_block("center");
        YongDao yongDao1 = new YongDao();
        yongDao1.setYd_id(2);
        yongDao1.setYd_logo("YD");
        yongDao1.setYd_name("火山板甬道");
        yongDao1.setYd_location("百花园");
        yongDao1.setYd_direction("东西");
        yongDao1.setYd_length("5200m");
        yongDao1.setYd_width("1m");
        yongDao1.setYd_area("5200平方米");
        yongDao1.setYd_block("center");
        yongDaos.add(yongDao);
        yongDaos.add(yongDao1);
        yongDaoMapper.updateYongDaoList(yongDaos);
    }

    @Test
    public void deleteYongDaosByIds()throws Exception {
        YongDaoMapper yongDaoMapper = (YongDaoMapper) applicationContext.getBean("yongDaoMapper");
        String[] ids = {"1","2"};
        yongDaoMapper.deleteYongDaosByIds(ids);
    }
}
