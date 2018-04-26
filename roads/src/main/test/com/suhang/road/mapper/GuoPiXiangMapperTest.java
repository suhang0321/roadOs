package com.suhang.road.mapper;

import com.suhang.road.po.GuoPiXiang;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class GuoPiXiangMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findGuoPiXiangTest()throws Exception {
//        GuoPiXiangMapper guoPiXiangMapper = (GuoPiXiangMapper) applicationContext.getBean("guoPiXiangMapper");
//        System.out.println(guoPiXiangMapper.findGuoPiXiangsAll());
//        System.out.println(guoPiXiangMapper.findGuoPiXiangsByBlock("center"));
//    }

    @Test
    public void insertGuoPiXiangTest()throws Exception {
        GuoPiXiangMapper guoPiXiangMapper = (GuoPiXiangMapper) applicationContext.getBean("guoPiXiangMapper");
        GuoPiXiang guoPiXiang = new GuoPiXiang();
        guoPiXiang.setPx_logo("px");
        guoPiXiang.setPx_name("果皮箱");
        guoPiXiang.setPx_location("前进大街");
        guoPiXiang.setPx_distance("50m");
        guoPiXiang.setPx_kind("喷塑");
        guoPiXiang.setPx_num("20个");
        guoPiXiang.setPx_year("5年");
        guoPiXiang.setPx_block("center");
        guoPiXiangMapper.insertGuoPiXiang(guoPiXiang);
    }

    @Test
    public void updateTest()throws Exception {
        GuoPiXiangMapper guoPiXiangMapper = (GuoPiXiangMapper) applicationContext.getBean("guoPiXiangMapper");
        List<GuoPiXiang> guoPiXiangs = new ArrayList<GuoPiXiang>();
        GuoPiXiang guoPiXiang = new GuoPiXiang();
        guoPiXiang.setPx_id(1);
        guoPiXiang.setPx_logo("px");
        guoPiXiang.setPx_name("果皮箱");
        guoPiXiang.setPx_location("前进大街");
        guoPiXiang.setPx_distance("50m");
        guoPiXiang.setPx_kind("喷塑");
        guoPiXiang.setPx_num("20个");
        guoPiXiang.setPx_year("5年");
        guoPiXiang.setPx_block("center");
        GuoPiXiang guoPiXiang1 = new GuoPiXiang();
        guoPiXiang1.setPx_id(2);
        guoPiXiang1.setPx_logo("px");
        guoPiXiang1.setPx_name("果皮箱");
        guoPiXiang1.setPx_location("前进大街");
        guoPiXiang1.setPx_distance("50m");
        guoPiXiang1.setPx_kind("喷塑");
        guoPiXiang1.setPx_num("20个");
        guoPiXiang1.setPx_year("6年");
        guoPiXiang1.setPx_block("center");
        guoPiXiangs.add(guoPiXiang);
        guoPiXiangs.add(guoPiXiang1);
        guoPiXiangMapper.updateGuoPiXiangList(guoPiXiangs);
    }

    @Test
    public void deleteTest()throws Exception {
        GuoPiXiangMapper guoPiXiangMapper = (GuoPiXiangMapper) applicationContext.getBean("guoPiXiangMapper");
        String[] px_ids = {"1","2"};
        guoPiXiangMapper.deleteGuoPiXiangsByIds(px_ids);
    }
}
