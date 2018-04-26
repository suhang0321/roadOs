package com.suhang.road.mapper;

import com.suhang.road.po.BaiYou;
import com.suhang.road.po.User;
import com.suhang.road.po.UserCustom;
import com.suhang.road.povo.BaiYouVo;
import com.suhang.road.povo.LogVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

    @Test
    public void findUserByUidTest()throws Exception {
        UserMapper usermapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = usermapper.findUserByUid("1");
        System.out.println(user.getLoginname());
    }

    @Test
    public void finfUserByNamePassAndBlockTest()throws Exception {
        UserMapper usermapper = (UserMapper) applicationContext.getBean("userMapper");
        UserCustom userCustom = new UserCustom();
        userCustom.setLoginname("admin");
        userCustom.setLoginpass("admin");
        userCustom.setBlock("admin");
        User user = usermapper.findUserByNamePassAndBlock(userCustom);
        System.out.println(user);
    }

    @Test
    public void findBaiyousByBlockTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setBlock("center");
        baiYouVo.setSnep(0);
        baiYouVo.setPs(5);
        List<BaiYou> baiYous = projectMapper.findBaiYousByBlock(baiYouVo);
        System.out.println(baiYous);
    }

    @Test
    public void findCountAllTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        System.out.println(projectMapper.findCountAll());
        System.out.println(projectMapper.findCountByBlock("center"));
    }

    @Test
    public void findBaiyousAllTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setSnep(0);
        baiYouVo.setPs(5);
        List<BaiYou> baiYous = projectMapper.findBaiYousAll(baiYouVo);
        System.out.println(baiYous);
    }

    @Test
    public void updateBaiYouListTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        List<BaiYou> baiYouList = new ArrayList<BaiYou>();
        BaiYou baiYou1 = new BaiYou();
        baiYou1.setBy_id(1);
        baiYou1.setBy_logo("BY");
        baiYou1.setBy_name("皇后大道a");
        baiYou1.setBy_direction("东西");
        baiYou1.setBy_length("520M");
        baiYou1.setBy_width("6M");
        baiYou1.setBy_area("3120㎡");
        baiYou1.setBy_block("center");
        BaiYou baiyou2  =new BaiYou();
        baiyou2.setBy_id(2);
        baiyou2.setBy_logo("BY");
        baiyou2.setBy_name("中央大街a");
        baiyou2.setBy_direction("东西");
        baiyou2.setBy_length("520M");
        baiyou2.setBy_width("6M");
        baiyou2.setBy_area("3120㎡");
        baiyou2.setBy_block("center");
        BaiYou baiyou3 = new BaiYou();
        baiyou3.setBy_id(3);
        baiyou3.setBy_logo("BY");
        baiyou3.setBy_name("富民街");
        baiyou3.setBy_direction("其他");
        baiyou3.setBy_length("500M");
        baiyou3.setBy_width("5M");
        baiyou3.setBy_area("2500㎡");
        baiyou3.setBy_block("north");
        baiYouList.add(baiYou1);
        baiYouList.add(baiyou2);
        baiYouList.add(baiyou3);
        projectMapper.updateBaiYouList(baiYouList);
    }

    @Test
    public void deleteBaiyousByIdsTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        String[] ids = {"1","2"};
        projectMapper.deleteBaiYousByIds(ids);
    }

    @Test
    public void insertBaiYouTest()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        BaiYou baiYou = new BaiYou();
//        baiYou.setBy_id(1);
        baiYou.setBy_logo("BY");
        baiYou.setBy_name("皇后大道");
        baiYou.setBy_direction("南北");
        baiYou.setBy_length("500M");
        baiYou.setBy_width("5M");
        baiYou.setBy_area("2500㎡");
        baiYou.setBy_block("center");
        projectMapper.insertBaiYou(baiYou);
    }
    @Test
    public void insertBaiYouTest2()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        BaiYou baiYou = new BaiYou();
//        baiYou.setBy_id(2);
        baiYou.setBy_logo("BY");
        baiYou.setBy_name("人民大街");
        baiYou.setBy_direction("东西");
        baiYou.setBy_length("500M");
        baiYou.setBy_width("5M");
        baiYou.setBy_area("2500㎡");
        baiYou.setBy_block("center");
        projectMapper.insertBaiYou(baiYou);
    }
    @Test
    public void insertBaiYouTest3()throws Exception {
        BaiYouMapper projectMapper = (BaiYouMapper) applicationContext.getBean("baiYouMapper");
        BaiYou baiYou = new BaiYou();
//        baiYou.setBy_id(3);
        baiYou.setBy_logo("BY");
        baiYou.setBy_name("自由大路");
        baiYou.setBy_direction("东西");
        baiYou.setBy_length("500M");
        baiYou.setBy_width("5M");
        baiYou.setBy_area("2500㎡");
        baiYou.setBy_block("center");
        projectMapper.insertBaiYou(baiYou);
    }

    @Test
    public void updateNameAndPassByUidTest()throws Exception {
        UserMapper usermapper = (UserMapper) applicationContext.getBean("userMapper");
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginname","admindongqu");
        map.put("loginpass","123");
        map.put("uid","2");
        usermapper.updateNameAndPassByUid(map);
    }

    @Test
    public void findLogsAllTest()throws Exception {
        LogMapper logMapper = (LogMapper) applicationContext.getBean("logMapper");
        LogVo logVo = new LogVo();
        logVo.setSnep(0);
        logVo.setPs(6);
        System.out.println(logMapper.findLogsAll(logVo));

    }

    @Test
    public void findLogCountAllTest()throws Exception {
        LogMapper logMapper = (LogMapper) applicationContext.getBean("logMapper");
        long num = logMapper.findLogCountAll();
        System.out.println(num);
    }

    @Test
    public void findLogByOpertionTest()throws Exception {
        LogMapper logMapper = (LogMapper) applicationContext.getBean("logMapper");
        LogVo logVo = new LogVo();
        logVo.setSnep(0);
        logVo.setPs(6);
        logVo.setL_operation("修改");
        System.out.println(logMapper.findLogsByOperation(logVo));
    }

    @Test
    public void findCountByOperationTest()throws Exception {
        LogMapper logMapper = (LogMapper) applicationContext.getBean("logMapper");
        LogVo logVo = new LogVo();
        logVo.setL_operation("修改");
        System.out.println(logMapper.findCountByOperation(logVo));
    }

    @Test
    public void findLogsByMultyTest()throws Exception {
        LogMapper logMapper = (LogMapper) applicationContext.getBean("logMapper");
        LogVo logVo = new LogVo();
        logVo.setSnep(0);
        logVo.setPs(6);
        logVo.setL_operation("");
        logVo.setBlock("");
        logVo.setL_table("自行架表");
        System.out.println(logMapper.findLogsByMulty(logVo));
        System.out.println(logMapper.findCountByMulty(logVo));
    }
}
