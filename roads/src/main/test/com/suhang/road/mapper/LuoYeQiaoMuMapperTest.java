package com.suhang.road.mapper;

import com.suhang.road.po.LuoYeQiaoMu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LuoYeQiaoMuMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findLuoYeByBlockTest()throws Exception {
//        LuoYeQiaoMuMapper luoYeQiaoMuMapper = (LuoYeQiaoMuMapper) applicationContext.getBean("luoYeQiaoMuMapper");
//        System.out.println(luoYeQiaoMuMapper.findLuoYeQiaoMusByBlock("center"));
//    }
//
//    @Test
//    public void findLuoYeAllTest()throws Exception {
//        LuoYeQiaoMuMapper luoYeQiaoMuMapper = (LuoYeQiaoMuMapper) applicationContext.getBean("luoYeQiaoMuMapper");
//        System.out.println(luoYeQiaoMuMapper.findLuoYeQiaoMusAll());
//    }

    @Test
    public void insertLuoYeTest()throws Exception {
        LuoYeQiaoMuMapper luoYeQiaoMuMapper = (LuoYeQiaoMuMapper) applicationContext.getBean("luoYeQiaoMuMapper");
        LuoYeQiaoMu luoYeQiaoMu =new LuoYeQiaoMu();
        luoYeQiaoMu.setQm_logo("qm");
        luoYeQiaoMu.setQm_name("落叶乔木");
        luoYeQiaoMu.setQm_location("前进大街");
        luoYeQiaoMu.setQm_type("成片");
        luoYeQiaoMu.setQm_kind("杨松");
        luoYeQiaoMu.setQm_num("20棵");
        luoYeQiaoMu.setQm_year("20年");
        luoYeQiaoMu.setQm_block("center");
        luoYeQiaoMuMapper.insertLuoYeQiaoMu(luoYeQiaoMu);
    }

    @Test
    public void updateLuoYeTest()throws Exception {
        LuoYeQiaoMuMapper luoYeQiaoMuMapper = (LuoYeQiaoMuMapper) applicationContext.getBean("luoYeQiaoMuMapper");
        List<LuoYeQiaoMu> luoYeQiaoMus = new ArrayList<LuoYeQiaoMu>();
        LuoYeQiaoMu luoYeQiaoMu =new LuoYeQiaoMu();
        luoYeQiaoMu.setQm_id(1);
        luoYeQiaoMu.setQm_logo("qm");
        luoYeQiaoMu.setQm_name("落叶乔木");
        luoYeQiaoMu.setQm_location("前进大街");
        luoYeQiaoMu.setQm_type("成片");
        luoYeQiaoMu.setQm_kind("柳松");
        luoYeQiaoMu.setQm_num("20棵");
        luoYeQiaoMu.setQm_year("10年");
        luoYeQiaoMu.setQm_block("center");
        LuoYeQiaoMu luoYeQiaoMu1 =new LuoYeQiaoMu();
        luoYeQiaoMu1.setQm_id(2);
        luoYeQiaoMu1.setQm_logo("qm");
        luoYeQiaoMu1.setQm_name("落叶乔木");
        luoYeQiaoMu1.setQm_location("前进大街");
        luoYeQiaoMu1.setQm_type("成片");
        luoYeQiaoMu1.setQm_kind("柳松");
        luoYeQiaoMu1.setQm_num("20棵");
        luoYeQiaoMu1.setQm_year("80年");
        luoYeQiaoMu1.setQm_block("center");
        luoYeQiaoMus.add(luoYeQiaoMu);
        luoYeQiaoMus.add(luoYeQiaoMu1);
        luoYeQiaoMuMapper.updateLuoYeQiaoMuList(luoYeQiaoMus);
    }

    @Test
    public void deleteLuoYeListTest()throws Exception {
        LuoYeQiaoMuMapper luoYeQiaoMuMapper = (LuoYeQiaoMuMapper) applicationContext.getBean("luoYeQiaoMuMapper");
        String[] qm_ids = {"1","2"};
        luoYeQiaoMuMapper.deleteLuoYeQiaoMusByIds(qm_ids);
    }
}
