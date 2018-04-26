package com.suhang.road.mapper;

import com.suhang.road.po.XingDaoShu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class XingDaoMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findXingDaosByBlockTest()throws Exception {
//        XingDaoMapper xingDaoMapper = (XingDaoMapper) applicationContext.getBean("xingDaoMapper");
//        System.out.println(xingDaoMapper.findXingDaosByBlock("center"));
//    }

//    @Test
//    public void findXingDaosAllTest()throws Exception {
//        XingDaoMapper xingDaoMapper = (XingDaoMapper) applicationContext.getBean("xingDaoMapper");
//        System.out.println(xingDaoMapper.findXingDaosAll());
//    }

    @Test
    public void insertXingDaoTest()throws Exception {
        XingDaoMapper xingDaoMapper = (XingDaoMapper) applicationContext.getBean("xingDaoMapper");
        XingDaoShu xingDaoShu = new XingDaoShu();
        xingDaoShu.setXd_logo("xd");
        xingDaoShu.setXd_name("行道树");
        xingDaoShu.setXd_location("人民大街");
        xingDaoShu.setXd_direction("南北");
        xingDaoShu.setXd_kind("柳树");
        xingDaoShu.setXd_num("30棵");
        xingDaoShu.setXd_year("70年");
        xingDaoShu.setXd_block("center");
        xingDaoMapper.insertXingDao(xingDaoShu);

    }

    @Test
    public void updateXingDaoListTest()throws Exception {
        XingDaoMapper xingDaoMapper = (XingDaoMapper) applicationContext.getBean("xingDaoMapper");
        List<XingDaoShu> xingDaoShus =new ArrayList<XingDaoShu>();
        XingDaoShu xingDaoShu = new XingDaoShu();
        xingDaoShu.setXd_id(1);
        xingDaoShu.setXd_logo("xd");
        xingDaoShu.setXd_name("行道树");
        xingDaoShu.setXd_location("前进大街");
        xingDaoShu.setXd_direction("南北");
        xingDaoShu.setXd_kind("柳树");
        xingDaoShu.setXd_num("30棵");
        xingDaoShu.setXd_year("60年");
        xingDaoShu.setXd_block("center");
        XingDaoShu xingDaoShu1 = new XingDaoShu();
        xingDaoShu1.setXd_id(2);
        xingDaoShu1.setXd_logo("xd");
        xingDaoShu1.setXd_name("行道树");
        xingDaoShu1.setXd_location("前进大街");
        xingDaoShu1.setXd_direction("南北");
        xingDaoShu1.setXd_kind("柳树");
        xingDaoShu1.setXd_num("30棵");
        xingDaoShu1.setXd_year("60年");
        xingDaoShu1.setXd_block("center");
        xingDaoShus.add(xingDaoShu);
        xingDaoShus.add(xingDaoShu1);
        xingDaoMapper.updateXingDaoList(xingDaoShus);
    }

    @Test
    public void deleteXingDaosByIdsTest()throws Exception {
        XingDaoMapper xingDaoMapper = (XingDaoMapper) applicationContext.getBean("xingDaoMapper");
        String[] xd_ids = {"1","2","3"};
        xingDaoMapper.deleteXingDaosByIds(xd_ids);
    }
}
