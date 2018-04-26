package com.suhang.road.controller;

import com.suhang.road.po.*;
import com.suhang.road.service.*;
import com.suhang.road.util.GetInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/sum")
public class SumController {
    @Autowired
    private BaiYouService baiYouService;
    @Autowired
    private FangZhuanService fangZhuanService;
    @Autowired
    private YongDaoService yongDaoService;
    @Autowired
    private CaoPingService caoPingService;
    @Autowired
    private LvDiService lvDiService;
    @Autowired
    private QiaoMuService qiaoMuService;
    @Autowired
    private LuoYeService luoYeService;
    @Autowired
    private XingDaoService xingDaoService;
    @Autowired
    private GuanMuService guanMuService;
    @Autowired
    private HuaHuiService huaHuiService;
    @Autowired
    private ZiXingJiaService ziXingJiaService;
    @Autowired
    private GuoPiXiangService guoPiXiangService;
    @Autowired
    private LaJiService laJiService;
    @Autowired
    private JiaShanService jiaShanService;
    @Autowired
    private TingLangService tingLangService;
    @Autowired
    private QingXueService qingXueService;
    @Autowired
    private ShuiXiService shuiXiService;
    @Autowired
    private ZhenGuiService zhenGuiService;
    @Autowired
    private ErCiService erCiService;
    @Autowired
    private LvLiService lvLiService;
    @Autowired
    private TingCheService tingCheService;
    @Autowired
    private YunDongService yunDongService;

    @RequestMapping("/sumTable")
    public String sumTable(HttpServletRequest request, HttpServletResponse response,
                           Model model)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        GetInteger getInteger = new GetInteger();
        if (block.equals("admin")||block.equals("admin2")){
            int baiyounumadmin = baiYouService.findCountAll();
            int baiyouareaadmin = 0;
            List<BaiYou> baiYouList = baiYouService.findBaiYousAll1();
            for (BaiYou baiYou:baiYouList){
                baiyouareaadmin+=getInteger.getInteger(baiYou.getBy_area());
            }
            request.setAttribute("baiyounum",baiyounumadmin);
            request.setAttribute("baiyouarea",baiyouareaadmin);
            int fangzhuannumadmin = fangZhuanService.findCountAll();
            int fangzhuanareaadmin = 0;
            List<FangZhuan> fangZhuans = fangZhuanService.findFangZhuansAllNoFenye();
            for (FangZhuan fangZhuan:fangZhuans){
                fangzhuanareaadmin+= getInteger.getInteger(fangZhuan.getFz_area());
            }
            request.setAttribute("fangzhuannum",fangzhuannumadmin);
            request.setAttribute("fangzhuanarea",fangzhuanareaadmin);
            int yongdaonumadmin = yongDaoService.findCountAll();
            int yongdaoareaadmin = 0;
            List<YongDao> yongDaos = yongDaoService.getYongDaosAll();
            for (YongDao yongDao:yongDaos){
                yongdaoareaadmin += getInteger.getInteger(yongDao.getYd_area());
            }
            request.setAttribute("yongdaonum",yongdaonumadmin);
            request.setAttribute("yongdaoarea",yongdaoareaadmin);
            int caopingnumadmin = caoPingService.findCountAll();
            int caopingareaadmin = 0;
            List<CaoPing> caoPings = caoPingService.getCaoPingsAll();
            for (CaoPing caoPing:caoPings){
                caopingareaadmin += getInteger.getInteger(caoPing.getCp_area());
            }
            request.setAttribute("caopingnum",caopingnumadmin);
            request.setAttribute("caopingarea",caopingareaadmin);
           int lvdinumadmin = lvDiService.findCountAll();
           int lvdiareaadmin = 0;
           List<LvDi> lvDis = lvDiService.getLvDisAll();
           for (LvDi lvDi:lvDis){
               lvdiareaadmin += getInteger.getInteger(lvDi.getLd_area());
           }
           request.setAttribute("lvdinum",lvdinumadmin);
           request.setAttribute("lvdiarea",lvdiareaadmin);
           int qiaomunumadmin =0;
           List<QiaoMu>qiaoMus = qiaoMuService.getQiaoMusAll();
            for (QiaoMu qiaoMu:qiaoMus){
                qiaomunumadmin += getInteger.getInteger(qiaoMu.getLs_num());
            }
            request.setAttribute("qiaomunum",qiaomunumadmin);
            int luoyenumadmin = 0;
            List<LuoYeQiaoMu> luoYeQiaoMus = luoYeService.getLuoYesAll();
            for (LuoYeQiaoMu luoYeQiaoMu:luoYeQiaoMus){
                luoyenumadmin += getInteger.getInteger(luoYeQiaoMu.getQm_num());
            }
            request.setAttribute("luoyenum",luoyenumadmin);
            int xingdaonumadmin = 0;
            List<XingDaoShu> xingDaoShus = xingDaoService.getXingDaosAll();
            for (XingDaoShu xingDaoShu :xingDaoShus){
                xingdaonumadmin += getInteger.getInteger(xingDaoShu.getXd_num());
            }
            request.setAttribute("xingdaoshunum" ,xingdaonumadmin);
            int guanmunumadmin = 0;
            List<GuanMu> guanMus = guanMuService.getGuanMusALL();
            for (GuanMu guanMu:guanMus){
                guanmunumadmin += getInteger.getInteger(guanMu.getGm_num());
            }
            request.setAttribute("guanmunum" ,guanmunumadmin);
            int huahuinumadmin = 0;
            List<HuaHui> huaHuis = huaHuiService.getHuaHuisAll();
            for (HuaHui huaHui:huaHuis){
                huahuinumadmin += getInteger.getInteger(huaHui.getHh_num());
            }
            request.setAttribute("huahuinum",huahuinumadmin);
            int zixingjianumadmin = 0;
            List<ZiXingJia> ziXingJias = ziXingJiaService.getZiXingJiasAll();
            for (ZiXingJia ziXingJia:ziXingJias){
                zixingjianumadmin += getInteger.getInteger(ziXingJia.getCj_num());
            }
            request.setAttribute("zixingjianum",zixingjianumadmin);
            int guopixiangnumadmin = 0;
            List<GuoPiXiang> guoPiXiangs = guoPiXiangService.getGuoPiXiangsAll();
            for (GuoPiXiang guoPiXiang:guoPiXiangs){
                guopixiangnumadmin += getInteger.getInteger(guoPiXiang.getPx_num());
            }
            request.setAttribute("guopixiangnum",guopixiangnumadmin);
            int lajinumadmin = 0;
            List<LaJi> laJis = laJiService.getLaJisAll();
            for (LaJi laJi:laJis){
                lajinumadmin += getInteger.getInteger(laJi.getLj_num());
            }
            request.setAttribute("lajinum",lajinumadmin);
            int jiashannumadmin = 0;
            List<JiaShan> jiaShans = jiaShanService.getJiaShansAll();
            for (JiaShan jiaShan:jiaShans){
                jiashannumadmin += getInteger.getInteger(jiaShan.getJs_num());
            }
            request.setAttribute("jiashannum",jiashannumadmin);
            int tinglangnumadmin = 0;
            List<TingLang>tingLangs = tingLangService.getTingLangsAll();
            for (TingLang tingLang:tingLangs){
                tinglangnumadmin += getInteger.getInteger(tingLang.getLt_num());
            }
            request.setAttribute("tinglangnum",tinglangnumadmin);
            int qingxuenumadmin = 0;
            int qingxueunitadmin = 0;
            List<QingXue> qingXues = qingXueService.getQingXuesAll();
            for (QingXue qingXue:qingXues){
                qingxuenumadmin += getInteger.getInteger(qingXue.getQx_num());
                qingxueunitadmin += getInteger.getInteger(qingXue.getQx_unit());
            }
            request.setAttribute("qingxuenum",qingxuenumadmin);
            request.setAttribute("qingxueunit",qingxueunitadmin);
            int shuixinumadmin = 0;
//            int shuixiunitadmin = 0;
            List<ShuiXi> shuiXis = shuiXiService.getShuiXisAll();
            for (ShuiXi shuiXi:shuiXis){
                shuixinumadmin += getInteger.getInteger(shuiXi.getSx_num());
//                shuixiunitadmin += getInteger.getInteger(shuiXi.getSx_unit());
            }
            request.setAttribute("shuixinum",shuixinumadmin);
//            request.setAttribute("shuixiunit",shuixiunitadmin);
            int zhenguinumadmin = 0;
            List<ZhenGui> zhenGuis = zhenGuiService.getZhenGuisAll();
            for (ZhenGui zhenGui:zhenGuis){
                zhenguinumadmin += getInteger.getInteger(zhenGui.getZg_num());
            }
            request.setAttribute("zhenguinum",zhenguinumadmin);

            int ercinumadmin = 0;
            int erciunitadmin = 0;
            List<ErCiGongShui> erCiGongShuis = erCiService.getErCisAll();
            for (ErCiGongShui erCiGongShui:erCiGongShuis){
                ercinumadmin +=getInteger.getInteger(erCiGongShui.getSj_num());
                erciunitadmin += getInteger.getInteger(erCiGongShui.getSj_unit());
            }
            request.setAttribute("ercinum",ercinumadmin);
            request.setAttribute("erciunit",erciunitadmin);
            int lvlinumadmin = 0;
            List<LvLi>lvLis = lvLiService.getLvLisAll();
            for (LvLi lvLi:lvLis){
                lvlinumadmin += getInteger.getInteger(lvLi.getLl_num());
            }
            request.setAttribute("lvlinum",lvlinumadmin);
            int tingchenumadmin = 0;
            int tingcheunitadmin = 0;
            List<TingChe> tingChes = tingCheService.getTingChesAll();
            for (TingChe tingChe:tingChes){
                tingchenumadmin += getInteger.getInteger(tingChe.getTc_num());
                tingcheunitadmin += getInteger.getInteger(tingChe.getTc_unit());
            }
            request.setAttribute("tingchenum",tingchenumadmin);
            request.setAttribute("tingcheunit",tingcheunitadmin);
            int yundongunitadmin = 0;
            List<YunDong> yunDongs = yunDongService.getYunDongsAll();
            for (YunDong yunDong:yunDongs){
                yundongunitadmin += getInteger.getInteger(yunDong.getYd_unit());
            }
            request.setAttribute("yundongunit",yundongunitadmin);
            return "forward:/jsps/project/sum/sum.jsp";
        }else {




            int baiyounum = baiYouService.findCountByBlock(block);
            int baiyouarea = 0;
            List<BaiYou> baiYouList = baiYouService.findBaiYousByBlock1(block);
            for (BaiYou baiYou:baiYouList){
                baiyouarea+=getInteger.getInteger(baiYou.getBy_area());
            }
            request.setAttribute("baiyounum",baiyounum);
            request.setAttribute("baiyouarea",baiyouarea);

            int fangzhuannum = fangZhuanService.findCountByBlock(block);
            int fangzhuanarea = 0;
            List<FangZhuan> fangZhuans = fangZhuanService.findFangZhuansByBlockNoFenye(block);
            for (FangZhuan fangZhuan:fangZhuans){
                fangzhuanarea+= getInteger.getInteger(fangZhuan.getFz_area());
            }
            request.setAttribute("fangzhuannum",fangzhuannum);
            request.setAttribute("fangzhuanarea",fangzhuanarea);


            int yongdaonum = yongDaoService.findCountByBlock(block);
            int yongdaoarea = 0;
            List<YongDao> yongDaos = yongDaoService.getYongDaosByBlock(block);
            for (YongDao yongDao:yongDaos){
                yongdaoarea += getInteger.getInteger(yongDao.getYd_area());
            }
            request.setAttribute("yongdaonum",yongdaonum);
            request.setAttribute("yongdaoarea",yongdaoarea);


            int caopingnum = caoPingService.findCountByBlock(block);
            int caopingarea = 0;
            List<CaoPing> caoPings = caoPingService.getCaoPingsByBlock(block);
            for (CaoPing caoPing:caoPings){
                caopingarea += getInteger.getInteger(caoPing.getCp_area());
            }
            request.setAttribute("caopingnum",caopingnum);
            request.setAttribute("caopingarea",caopingarea);


            int lvdinum = lvDiService.findCountByBlock(block);
            int lvdiarea = 0;
            List<LvDi> lvDis = lvDiService.getLvDisByBlock(block);
            for (LvDi lvDi:lvDis){
                lvdiarea += getInteger.getInteger(lvDi.getLd_area());
            }
            request.setAttribute("lvdinum",lvdinum);
            request.setAttribute("lvdiarea",lvdiarea);


            int qiaomunum =0;
            List<QiaoMu>qiaoMus = qiaoMuService.getQiaoMuByBlock(block);
            for (QiaoMu qiaoMu:qiaoMus){
                qiaomunum += getInteger.getInteger(qiaoMu.getLs_num());
            }
            request.setAttribute("qiaomunum",qiaomunum);


            int luoyenum = 0;
            List<LuoYeQiaoMu> luoYeQiaoMus = luoYeService.getLuoYesByBlock(block);
            for (LuoYeQiaoMu luoYeQiaoMu:luoYeQiaoMus){
                luoyenum += getInteger.getInteger(luoYeQiaoMu.getQm_num());
            }
            request.setAttribute("luoyenum",luoyenum);


            int xingdaonum = 0;
            List<XingDaoShu> xingDaoShus = xingDaoService.getXingDaosByBlock(block);
            for (XingDaoShu xingDaoShu :xingDaoShus){
                xingdaonum += getInteger.getInteger(xingDaoShu.getXd_num());
            }
            request.setAttribute("xingdaoshunum" ,xingdaonum);


            int guanmunum = 0;
            List<GuanMu> guanMus = guanMuService.getGuanMusByBlock(block);
            for (GuanMu guanMu:guanMus){
                guanmunum += getInteger.getInteger(guanMu.getGm_num());
            }
            request.setAttribute("guanmunum" ,guanmunum);


            int huahuinum = 0;
            List<HuaHui> huaHuis = huaHuiService.getHuaHuisByBlock(block);
            for (HuaHui huaHui:huaHuis){
                huahuinum += getInteger.getInteger(huaHui.getHh_num());
            }
            request.setAttribute("huahuinum",huahuinum);


            int zixingjianum = 0;
            List<ZiXingJia> ziXingJias = ziXingJiaService.getZiXingJiasByBlock(block);
            for (ZiXingJia ziXingJia:ziXingJias){
                zixingjianum += getInteger.getInteger(ziXingJia.getCj_num());
            }
            request.setAttribute("zixingjianum",zixingjianum);


            int guopixiangnum = 0;
            List<GuoPiXiang> guoPiXiangs = guoPiXiangService.getGuoPiXiangsByBlock(block);
            for (GuoPiXiang guoPiXiang:guoPiXiangs){
                guopixiangnum += getInteger.getInteger(guoPiXiang.getPx_num());
            }
            request.setAttribute("guopixiangnum",guopixiangnum);


            int lajinum = 0;
            List<LaJi> laJis = laJiService.getLaJisByBlock(block);
            for (LaJi laJi:laJis){
                lajinum += getInteger.getInteger(laJi.getLj_num());
            }
            request.setAttribute("lajinum",lajinum);


            int jiashannum = 0;
            List<JiaShan> jiaShans = jiaShanService.getJiaShansByBlock(block);
            for (JiaShan jiaShan:jiaShans){
                jiashannum += getInteger.getInteger(jiaShan.getJs_num());
            }
            request.setAttribute("jiashannum",jiashannum);


            int tinglangnum = 0;
            List<TingLang>tingLangs = tingLangService.getTingLangsByBlock(block);
            for (TingLang tingLang:tingLangs){
                tinglangnum += getInteger.getInteger(tingLang.getLt_num());
            }
            request.setAttribute("tinglangnum",tinglangnum);


            int qingxuenum = 0;
            int qingxueunit = 0;
            List<QingXue> qingXues = qingXueService.getQingXuesByBlock(block);
            for (QingXue qingXue:qingXues){
                qingxuenum += getInteger.getInteger(qingXue.getQx_num());
                qingxueunit += getInteger.getInteger(qingXue.getQx_unit());
            }
            request.setAttribute("qingxuenum",qingxuenum);
            request.setAttribute("qingxueunit",qingxueunit);


            int shuixinum = 0;
//            int shuixiunitadmin = 0;
            List<ShuiXi> shuiXis = shuiXiService.getShuiXisByBlock(block);
            for (ShuiXi shuiXi:shuiXis){
                shuixinum += getInteger.getInteger(shuiXi.getSx_num());
//                shuixiunitadmin += getInteger.getInteger(shuiXi.getSx_unit());
            }
            request.setAttribute("shuixinum",shuixinum);
//            request.setAttribute("shuixiunit",shuixiunitadmin);


            int zhenguinum = 0;
            List<ZhenGui> zhenGuis = zhenGuiService.getZhenGuisByBlock(block);
            for (ZhenGui zhenGui:zhenGuis){
                zhenguinum += getInteger.getInteger(zhenGui.getZg_num());
            }
            request.setAttribute("zhenguinum",zhenguinum);


            int ercinum = 0;
            int erciunit= 0;
            List<ErCiGongShui> erCiGongShuis = erCiService.getErCisByBlock(block);
            for (ErCiGongShui erCiGongShui:erCiGongShuis){
                ercinum +=getInteger.getInteger(erCiGongShui.getSj_num());
                erciunit += getInteger.getInteger(erCiGongShui.getSj_unit());
            }
            request.setAttribute("ercinum",ercinum);
            request.setAttribute("erciunit",erciunit);


            int lvlinum= 0;
            List<LvLi>lvLis = lvLiService.getLvLisByBlock(block);
            for (LvLi lvLi:lvLis){
                lvlinum += getInteger.getInteger(lvLi.getLl_num());
            }
            request.setAttribute("lvlinum",lvlinum);


            int tingchenum = 0;
            int tingcheunit= 0;
            List<TingChe> tingChes = tingCheService.getTingChesByBlock(block);
            for (TingChe tingChe:tingChes){
                tingchenum += getInteger.getInteger(tingChe.getTc_num());
                tingcheunit += getInteger.getInteger(tingChe.getTc_unit());
            }
            request.setAttribute("tingchenum",tingchenum);
            request.setAttribute("tingcheunit",tingcheunit);


            int yundongunit = 0;
            List<YunDong> yunDongs = yunDongService.getYunDongsByBlock(block);
            for (YunDong yunDong:yunDongs){
                yundongunit += getInteger.getInteger(yunDong.getYd_unit());
            }
            request.setAttribute("yundongunit",yundongunit);
            return "forward:/jsps/project/sum/sum.jsp";
        }


    }

}
