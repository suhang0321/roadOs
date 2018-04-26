package com.suhang.road.mapper;

import com.suhang.road.po.HuaHui;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class HuaHuiMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findHuaHuisByBlockTest()throws Exception {
//        HuaHuiMapper huaHuiMapper = (HuaHuiMapper) applicationContext.getBean("huaHuiMapper");
//        System.out.println(huaHuiMapper.findHuaHuisByBlock("center"));
//    }
//
//    @Test
//    public void findHuaHuisAllTest()throws Exception {
//        HuaHuiMapper huaHuiMapper = (HuaHuiMapper) applicationContext.getBean("huaHuiMapper");
//        System.out.println(huaHuiMapper.findHuaHuisAll());
//    }

    @Test
    public void insertHuaHuiTest()throws Exception {
        HuaHuiMapper huaHuiMapper = (HuaHuiMapper) applicationContext.getBean("huaHuiMapper");
        HuaHui huaHui = new HuaHui();
        huaHui.setHh_logo("hh");
        huaHui.setHh_name("应季花卉");
        huaHui.setHh_location("前进大街");
        huaHui.setHh_type("两侧");
        huaHui.setHh_kind("海棠");
        huaHui.setHh_num("100株");
        huaHui.setHh_resource("采购");
        huaHui.setHh_block("center");
        huaHuiMapper.insertHuaHui(huaHui);
    }

    @Test
    public void updateHuaHuiListTest()throws Exception {
        HuaHuiMapper huaHuiMapper = (HuaHuiMapper) applicationContext.getBean("huaHuiMapper");
        List<HuaHui> huaHuis = new ArrayList<HuaHui>();
        HuaHui huaHui = new HuaHui();
        huaHui.setHh_id(3);
        huaHui.setHh_logo("hh1");
        huaHui.setHh_name("应季花卉1");
        huaHui.setHh_location("前进大街");
        huaHui.setHh_type("两侧");
        huaHui.setHh_kind("海棠");
        huaHui.setHh_num("700株");
        huaHui.setHh_resource("采购");
        huaHui.setHh_block("center");
        HuaHui huaHui1 = new HuaHui();
        huaHui1.setHh_id(4);
        huaHui1.setHh_logo("hh2");
        huaHui1.setHh_name("应季花卉2");
        huaHui1.setHh_location("前进大街");
        huaHui1.setHh_type("两侧");
        huaHui1.setHh_kind("海棠");
        huaHui1.setHh_num("800株");
        huaHui1.setHh_resource("采购");
        huaHui1.setHh_block("center");
        HuaHui huaHui12 = new HuaHui();
        huaHui12.setHh_id(5);
        huaHui12.setHh_logo("hh");
        huaHui12.setHh_name("应季花卉");
        huaHui12.setHh_location("前进大街");
        huaHui12.setHh_type("两侧");
        huaHui12.setHh_kind("海棠");
        huaHui12.setHh_num("800株");
        huaHui12.setHh_resource("采购");
        huaHui12.setHh_block("center"); HuaHui huaHui13 = new HuaHui();
        huaHui13.setHh_id(6);
        huaHui13.setHh_logo("hh");
        huaHui13.setHh_name("应季花卉");
        huaHui13.setHh_location("前进大街");
        huaHui13.setHh_type("两侧");
        huaHui13.setHh_kind("海棠");
        huaHui13.setHh_num("800株");
        huaHui13.setHh_resource("采购");
        huaHui13.setHh_block("center");
        huaHuis.add(huaHui);
        huaHuis.add(huaHui1);
        huaHuis.add(huaHui12);
        huaHuis.add(huaHui13);
        huaHuiMapper.updateHuaHuiList(huaHuis);
    }

    @Test
    public void deleteHuaHuisTest()throws Exception {
        HuaHuiMapper huaHuiMapper = (HuaHuiMapper) applicationContext.getBean("huaHuiMapper");
        String[] hh_ids = {"1","2"};
        huaHuiMapper.deleteHuaHuisByIds(hh_ids);
    }
}
