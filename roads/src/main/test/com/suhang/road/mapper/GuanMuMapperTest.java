package com.suhang.road.mapper;

import com.suhang.road.po.GuanMu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class GuanMuMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findGuanMuByBlockTest() throws Exception{
//        GuanMuMapper guanMuMapper = (GuanMuMapper) applicationContext.getBean("guanMuMapper");
//        System.out.println(guanMuMapper.findGuanMusByBlock("center"));
//    }
//
//    @Test
//    public void findGuanMusAllTest()throws Exception {
//        GuanMuMapper guanMuMapper = (GuanMuMapper) applicationContext.getBean("guanMuMapper");
//        System.out.println(guanMuMapper.findGuanMusAll());
//    }

    @Test
    public void insertGuanMu()throws Exception {
        GuanMuMapper guanMuMapper = (GuanMuMapper) applicationContext.getBean("guanMuMapper");
        GuanMu guanMu = new GuanMu();
        guanMu.setGm_logo("gm");
        guanMu.setGm_name("花灌木");
        guanMu.setGm_location("前进大街");
        guanMu.setGm_type("成片");
        guanMu.setGm_kind("丁香");
        guanMu.setGm_num("30株");
        guanMu.setGm_year("20年");
        guanMu.setGm_block("center");
        guanMuMapper.insertGuanMu(guanMu);
    }

    @Test
    public void updateGuanMuList()throws Exception {
        GuanMuMapper guanMuMapper = (GuanMuMapper) applicationContext.getBean("guanMuMapper");
        List<GuanMu> guanMus = new ArrayList<GuanMu>();
        GuanMu guanMu = new GuanMu();
        guanMu.setGm_id(1);
        guanMu.setGm_logo("gm1");
        guanMu.setGm_name("花灌木");
        guanMu.setGm_location("前进大街");
        guanMu.setGm_type("成片");
        guanMu.setGm_kind("丁香");
        guanMu.setGm_num("30株");
        guanMu.setGm_year("20年");
        guanMu.setGm_block("center");
        GuanMu guanMu1 = new GuanMu();
        guanMu1.setGm_id(2);
        guanMu1.setGm_logo("gm2");
        guanMu1.setGm_name("花灌木");
        guanMu1.setGm_location("前进大街");
        guanMu1.setGm_type("成片");
        guanMu1.setGm_kind("丁香");
        guanMu1.setGm_num("30株");
        guanMu1.setGm_year("20年");
        guanMu1.setGm_block("center");
        guanMus.add(guanMu);
        guanMus.add(guanMu1);
        guanMuMapper.updateGuanMuList(guanMus);
    }

    @Test
    public void deleteGuanMuListTest()throws Exception {
        GuanMuMapper guanMuMapper = (GuanMuMapper) applicationContext.getBean("guanMuMapper");
        String[] gm_ids = {"1","2"};
        guanMuMapper.deleteGuanMusByIds(gm_ids);
    }
}
