package com.suhang.road.controller;

import com.suhang.road.po.BaiYou;
import com.suhang.road.po.User;
import com.suhang.road.povo.BaiYouVo;
import com.suhang.road.service.BaiYouService;
import com.suhang.road.service.LogService;
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
@RequestMapping("/baiyou")
public class BaiYouController {
    @Autowired
    private BaiYouService projectService;
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
        List<BaiYou> baiYous = projectService.findBaiYousByBlock(block,pc,ps);
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setUrl(getUrl(request));
        baiYouVo.setPs(ps);
        baiYouVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = projectService.findCountAll();
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            if (baiYous.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            request.setAttribute("user",user);
            return "/jsps/project/baiyou/baiyoulist.jsp";
        }else {
            int tr = projectService.findCountByBlock(block);
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            request.setAttribute("user",user);
            return "/jsps/project/baiyou/baiyoulist.jsp";
        }
    }
    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<BaiYou> baiYous = projectService.findBaiYousByBlock(block,pc,ps);
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setUrl(getUrl(request));
        baiYouVo.setPs(ps);
        baiYouVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = projectService.findCountAll();
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            if (baiYous.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            return "/jsps/project/baiyou/baiyouedit.jsp";
        }else {
            int tr = projectService.findCountByBlock(block);
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            return "/jsps/project/baiyou/baiyouedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<BaiYou> baiYous = projectService.findBaiYousByBlock(block,pc,ps);
        BaiYouVo baiYouVo = new BaiYouVo();
        baiYouVo.setUrl(getUrl(request));
        baiYouVo.setPs(ps);
        baiYouVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = projectService.findCountAll();
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            if (baiYous.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            return "/jsps/project/baiyou/baiyoudelete.jsp";
        }else {
            int tr = projectService.findCountByBlock(block);
            baiYouVo.setTr(tr);
            baiYouVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", baiYous);
            request.setAttribute("pb",baiYouVo);
            return "/jsps/project/baiyou/baiyoudelete.jsp";
        }
    }

    @RequestMapping("/findBaiyousByBlock")
    public String findBaiyousByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editBaiYou")
    public String editBaiYou(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editBaiYouSubmit")
    public String editBaiYouSubmit(HttpServletRequest request, HttpServletResponse response,
                                   Model model, BaiYouVo baiYouVo) throws Exception {
        List<BaiYou> baiYous = baiYouVo.getItemsList();
        List<BaiYou> baiyousold = new ArrayList<BaiYou>();
        if(baiYous==null){
            return dataToList(request);
        }
       //执行更新操作之前拿到修改数据的id，根据id查询到的商品为未做修改的前的商品信息
        for (BaiYou baiYou:baiYous) {
            baiyousold.add(projectService.findBaiYouById(baiYou.getBy_id()));
        }

        //程序执行到这获取到修改信息之前的全部原始数据，封装到baiyousold中
        projectService.updateBaiYouList(baiYous);
        for (BaiYou baiYouold :baiyousold){
            for (BaiYou baiYounew:baiYous){
               if (baiYouold.getBy_id()==baiYounew.getBy_id()&& !baiYouold.toString().equals(baiYounew.toString())) {
                   logService.insertLog("修改后", baiYouold.getBy_block(), "柏油马路表", baiYounew.toString());
                   logService.insertLog("修改前", baiYouold.getBy_block(), "柏油马路表", baiYouold.toString());
                   request.setAttribute("msg","修改信息成功");

               }
            }
        }
        return dataToList(request);

    }


    @RequestMapping("/deleteBaiYous")
    public String deleteBaiYous(HttpServletRequest request, HttpServletResponse response,
                                   Model model, BaiYouVo baiYouVo) throws Exception{
        return dataToDelete(request);
    }


    @RequestMapping("/deleteBaiYousSubmit")
    public String deleteBaiYousSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] by_id) throws Exception{
        if (by_id==null){
            return dataToList(request);
        }
        //删除信息之前先拿到原始数据，删除操作完成后，在插入日志表
        List<BaiYou> baiYousold = new ArrayList<BaiYou>();
        for (int i=0;i<by_id.length;i++){
            baiYousold.add(projectService.findBaiYouById(Integer.parseInt(by_id[i])));

        }
        projectService.deleteBaiYouByIds(by_id);
        //删除完成将原始数据插入到日志表
        for (BaiYou baiYou:baiYousold) {
            logService.insertLog("删除",baiYou.getBy_block(),"柏油马路表",baiYou.toString());
        }
        request.setAttribute("msg","删除信息成功");
        return dataToList(request);
//        User user = (User) request.getSession().getAttribute("sessionUser");
//        String block = user.getBlock();
//        List<BaiYou> baiYouList = projectService.findBaiYousByBlock(block);
//        request.setAttribute("itemsList", baiYouList);
//        request.setAttribute("msg","删除数据成功");
//        return "/jsps/project/baiyou/baiyoulist.jsp";
    }


    @RequestMapping("/addBaiYou")
    public String addBaiYou(HttpServletRequest request, HttpServletResponse response,
                                      Model model,BaiYou baiYou) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = baiYou.getBy_block();
        String dirctionform = baiYou.getBy_direction();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            projectService.insertBaiYou(baiYou);
            logService.insertLog("添加",blockform,"柏油马路表",baiYou.toString());
            request.setAttribute("msg","添加柏油马路信息成功");
            return dataToList(request);

        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
        projectService.insertBaiYou(baiYou);
        logService.insertLog("添加",blockform,"柏油马路表",baiYou.toString());
        request.setAttribute("msg","添加柏油马路信息成功");
        return dataToList(request);
    }
}
//if (baiYouold.getBy_id()==baiYounew.getBy_id()&& (!baiYouold.getBy_logo().equals(baiYounew.getBy_logo())||
//        !baiYouold.getBy_name().equals(baiYounew.getBy_name()) ||!baiYouold.getBy_length().equals(baiYounew.getBy_length())||
//        !baiYouold.getBy_width().equals(baiYounew.getBy_width())||!baiYouold.getBy_area().equals(baiYounew.getBy_area())
//        )
//        ){