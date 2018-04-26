package com.suhang.road.mapper;

import com.suhang.road.po.LaJi;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LaJiMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findTest()throws Exception {
//        LaJiMapper laJiMapper = (LaJiMapper) applicationContext.getBean("laJiMapper");
////        System.out.println(laJiMapper.findLaJisAll());
//        System.out.println(laJiMapper.findLaJisByBlock("center"));
//    }

    @Test
    public void inserLaJiTest()throws Exception {
        LaJiMapper laJiMapper = (LaJiMapper) applicationContext.getBean("laJiMapper");
        LaJi laJi = new LaJi();
        laJi.setLj_logo("lj");
        laJi.setLj_name("中转转");
        laJi.setLj_location("锅炉房");
        laJi.setLj_distance("");
        laJi.setLj_type("彩钢房");
        laJi.setLj_num("1处");
        laJi.setLj_year("8年");
        laJi.setLj_block("center");
        laJiMapper.insertLaJi(laJi);
    }

    @Test
    public void updateLaJiTest()throws Exception {
        LaJiMapper laJiMapper = (LaJiMapper) applicationContext.getBean("laJiMapper");
        LaJi laJi = new LaJi();
        laJi.setLj_id(1);
        laJi.setLj_logo("lj");
        laJi.setLj_name("中转转");
        laJi.setLj_location("锅炉房");
        laJi.setLj_distance("");
        laJi.setLj_type("彩钢房");
        laJi.setLj_num("1处");
        laJi.setLj_year("10年");
        laJi.setLj_block("center");
        LaJi laJi1 = new LaJi();
        laJi1.setLj_id(2);
        laJi1.setLj_logo("lj");
        laJi1.setLj_name("中转转");
        laJi1.setLj_location("锅炉房");
        laJi1.setLj_distance("");
        laJi1.setLj_type("彩钢房");
        laJi1.setLj_num("1处");
        laJi1.setLj_year("8年");
        laJi1.setLj_block("center");
        List<LaJi> laJis = new ArrayList<LaJi>();
        laJis.add(laJi);
        laJis.add(laJi1);
        laJiMapper.updateLaJiList(laJis);
    }

    @Test
    public void deleteTest()throws Exception {
        LaJiMapper laJiMapper = (LaJiMapper) applicationContext.getBean("laJiMapper");
        String[] lj_ids = {"1","2"};
        laJiMapper.deleteLaJisByIds(lj_ids);
    }
}
