package com.suhang.road.mapper;

import com.suhang.road.po.QiaoMu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class QiaoMuMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

//    @Test
//    public void findQiaoMusByBlockTest()throws Exception {
//        QiaoMuMapper qiaoMuMapper = (QiaoMuMapper) applicationContext.getBean("qiaoMuMapper");
//        System.out.println(qiaoMuMapper.findQiaoMusByBlock("center"));
//    }

//    @Test
//    public void findQiaoMusAllTest()throws Exception {
//        QiaoMuMapper qiaoMuMapper = (QiaoMuMapper) applicationContext.getBean("qiaoMuMapper");
//        System.out.println(qiaoMuMapper.findQiaoMusAll());
//    }

    @Test
    public void insertQiaoMuTest()throws Exception {
        QiaoMuMapper qiaoMuMapper = (QiaoMuMapper) applicationContext.getBean("qiaoMuMapper");
        QiaoMu qiaoMu = new QiaoMu();
        qiaoMu.setLs_logo("ls");
        qiaoMu.setLs_name("常绿乔木");
        qiaoMu.setLs_location("前进大街");
        qiaoMu.setLs_type("成片");
        qiaoMu.setLs_kind("红松");
        qiaoMu.setLs_num("20棵");
        qiaoMu.setLs_year("30年");
        qiaoMu.setLs_block("center");
        qiaoMuMapper.insertQiaoMu(qiaoMu);
    }

    @Test
    public void updateQiaoMuListTest()throws Exception {
        QiaoMuMapper qiaoMuMapper = (QiaoMuMapper) applicationContext.getBean("qiaoMuMapper");
        List<QiaoMu> qiaoMus = new ArrayList<QiaoMu>();
        QiaoMu qiaoMu = new QiaoMu();
        qiaoMu.setLs_id(1);
        qiaoMu.setLs_logo("ls");
        qiaoMu.setLs_name("常绿乔木");
        qiaoMu.setLs_location("前进大街");
        qiaoMu.setLs_type("点状");
        qiaoMu.setLs_kind("红松");
        qiaoMu.setLs_num("20棵");
        qiaoMu.setLs_year("60年");
        qiaoMu.setLs_block("center");
        QiaoMu qiaoMu1 = new QiaoMu();
        qiaoMu1.setLs_id(2);
        qiaoMu1.setLs_logo("ls");
        qiaoMu1.setLs_name("常绿乔木");
        qiaoMu1.setLs_location("前进大街");
        qiaoMu1.setLs_type("成片");
        qiaoMu1.setLs_kind("红松");
        qiaoMu1.setLs_num("20棵");
        qiaoMu1.setLs_year("80年");
        qiaoMu1.setLs_block("center");
        qiaoMus.add(qiaoMu);
        qiaoMus.add(qiaoMu1);
        qiaoMuMapper.updateQiaoMuList(qiaoMus);

    }

    @Test
    public void deleteQiaoMusTest() throws Exception{
        QiaoMuMapper qiaoMuMapper = (QiaoMuMapper) applicationContext.getBean("qiaoMuMapper");
        String[] ls_ids = {"1","2"};
        qiaoMuMapper.deleteQiaoMusByIds(ls_ids);
    }
}
