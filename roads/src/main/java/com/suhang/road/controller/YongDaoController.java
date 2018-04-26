package com.suhang.road.controller;

import com.suhang.road.po.FangZhuan;
import com.suhang.road.po.User;
import com.suhang.road.po.YongDao;
import com.suhang.road.povo.FangZhuanVo;
import com.suhang.road.povo.YongDaoVo;
import com.suhang.road.service.FangZhuanService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.YongDaoService;
import com.suhang.road.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/yongdao")
public class YongDaoController {
    @Autowired
    private YongDaoService yongDaoService;
    @Autowired
    private LogService logService;

    private int getPc(HttpServletRequest request) {
        int pc = 1;
        String param = request.getParameter("pc");
        if (param != null && !param.trim().isEmpty()) {
            try {
                pc = Integer.parseInt(param);
            } catch (RuntimeException e) {
            }
        }
        return pc;
    }

    private int getTp(int tr, int ps) { //totalpage totalrecord pagesize 总页数，总记录数，一页多少条记录
        int tp = tr / ps;
        return tr % ps == 0 ? tp : tp + 1;
    }
    private String getUrl(HttpServletRequest request){
        String url1 = request.getRequestURI();//得到/roads/baiyou/findBaiYousByBlock.action
        String url2 = request.getQueryString();//得到block=xxx
        String url = url1 + "?" + url2;
        int index = url.lastIndexOf("&pc=");
        if (index != -1) {
            url = url.substring(0, index);
        }
        return url;
    }

    private String dataToList(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<YongDao> yongDaos = yongDaoService.findYongDaosByBlock(block,pc,ps);
        YongDaoVo yongDaoVo = new YongDaoVo();
        yongDaoVo.setUrl(getUrl(request));
        yongDaoVo.setPs(ps);
        yongDaoVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = yongDaoService.findCountAll();
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            if (yongDaos.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            request.setAttribute("user",user);

            return "/jsps/project/yongdao/yongdaolist.jsp";
        }else {
            int tr = yongDaoService.findCountByBlock(block);
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            request.setAttribute("user",user);

            return "/jsps/project/yongdao/yongdaolist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<YongDao> yongDaos = yongDaoService.findYongDaosByBlock(block,pc,ps);
        YongDaoVo yongDaoVo = new YongDaoVo();
        yongDaoVo.setUrl(getUrl(request));
        yongDaoVo.setPs(ps);
        yongDaoVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = yongDaoService.findCountAll();
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            if (yongDaos.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            request.setAttribute("user",user);

            return "/jsps/project/yongdao/yongdaoedit.jsp";
        }else {
            int tr = yongDaoService.findCountByBlock(block);
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            request.setAttribute("user",user);

            return "/jsps/project/yongdao/yongdaoedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<YongDao> yongDaos = yongDaoService.findYongDaosByBlock(block,pc,ps);
        YongDaoVo yongDaoVo = new YongDaoVo();
        yongDaoVo.setUrl(getUrl(request));
        yongDaoVo.setPs(ps);
        yongDaoVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = yongDaoService.findCountAll();
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            if (yongDaos.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            return "/jsps/project/yongdao/yongdaodelete.jsp";
        }else {
            int tr = yongDaoService.findCountByBlock(block);
            yongDaoVo.setTr(tr);
            yongDaoVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yongDaos);
            request.setAttribute("pb",yongDaoVo);
            return "/jsps/project/yongdao/yongdaodelete.jsp";
        }
    }

    @RequestMapping("/findYongDaosByBlock")
    public String findYongDaosByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editYongDaos")
    public String editYongDaos(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
        return dataToEdit(request);
            }


    @RequestMapping("/editYongDaosSubmit")
    public String editYongDaosSubmit(HttpServletRequest request, HttpServletResponse response,
                                     Model model, YongDaoVo yongDaoVo) throws Exception {
        List<YongDao> yongDaos = yongDaoVo.getItemsList();
        if (yongDaos==null){
            return dataToList(request);
        }
        List<YongDao> old = new ArrayList<YongDao>();
        for (YongDao yongDao:yongDaos){
            old.add(yongDaoService.findYongDaoById(yongDao.getYd_id()));
        }
        yongDaoService.updateYongDaoList(yongDaos);
        for (YongDao yongDaoold:old){
            for (YongDao yongDaonew :yongDaos){
                if (yongDaoold.getYd_id()==yongDaonew.getYd_id()&&!yongDaoold.toString().equals(yongDaonew.toString())){
                    logService.insertLog("修改后",yongDaonew.getYd_block(),"甬道表",yongDaonew.toString());
                    logService.insertLog("修改前",yongDaoold.getYd_block(),"甬道表",yongDaoold.toString());
                    request.setAttribute("msg","添加信息成功");

                }
            }
        }
        return  dataToList(request);
    }


    @RequestMapping("/deleteYongDaos")
    public String deleteYongDaos(HttpServletRequest request, HttpServletResponse response,
                                   Model model, YongDaoVo yongDaoVo) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteYongDaosSubmit")
    public String deleteYongDaosSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] yd_id) throws Exception{
        if (yd_id==null){
            return dataToList(request);
        }
        List<YongDao> old = new ArrayList<YongDao>();
        for (int i =0;i<yd_id.length;i++){
            old.add(yongDaoService.findYongDaoById(Integer.parseInt(yd_id[i])));
        }
        yongDaoService.deleteYongDaosByIds(yd_id);
        for (YongDao yongDao :old){
            logService.insertLog("删除",yongDao.getYd_block(),"甬道表",yongDao.toString());
        }
        request.setAttribute("msg","删除信息成功");
        return dataToList(request);
    }


    @RequestMapping("/addYongDao")
    public String addYongDao(HttpServletRequest request, HttpServletResponse response,
                                      Model model, YongDao yongDao) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = yongDao.getYd_block();
        String dirctionform = yongDao.getYd_direction();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            yongDaoService.insertYongDao(yongDao);
            logService.insertLog("添加",yongDao.getYd_block(),"甬道表",yongDao.toString());
            request.setAttribute("msg","添加校园甬路成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
           return dataToList(request);
        }else
            yongDaoService.insertYongDao(yongDao);
        logService.insertLog("添加",yongDao.getYd_block(),"甬道表",yongDao.toString());
        request.setAttribute("msg","添加校园甬道信息成功");
        return dataToList(request);
    }
}
