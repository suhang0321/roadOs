package com.suhang.road.controller;

import com.suhang.road.po.BaiYou;
import com.suhang.road.po.FangZhuan;
import com.suhang.road.po.User;
import com.suhang.road.povo.BaiYouVo;
import com.suhang.road.povo.FangZhuanVo;
import com.suhang.road.service.BaiYouService;
import com.suhang.road.service.FangZhuanService;
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
@RequestMapping("/fangzhuan")
public class FangZhuanController {
    @Autowired
    private FangZhuanService fangZhuanService;

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
        List<FangZhuan> fangZhuans = fangZhuanService.findFangZhuansByBlock(block,pc,ps);
        FangZhuanVo fangZhuanVo = new FangZhuanVo();
        fangZhuanVo.setUrl(getUrl(request));
        fangZhuanVo.setPs(ps);
        fangZhuanVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = fangZhuanService.findCountAll();
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            if (fangZhuans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            request.setAttribute("user",user);

            return "/jsps/project/fangzhuan/fangzhuanlist.jsp";
        }else {
            int tr = fangZhuanService.findCountByBlock(block);
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            request.setAttribute("user",user);

            return "/jsps/project/fangzhuan/fangzhuanlist.jsp";
        }
    }
    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<FangZhuan> fangZhuans = fangZhuanService.findFangZhuansByBlock(block,pc,ps);
        FangZhuanVo fangZhuanVo = new FangZhuanVo();
        fangZhuanVo.setUrl(getUrl(request));
        fangZhuanVo.setPs(ps);
        fangZhuanVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = fangZhuanService.findCountAll();
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            if (fangZhuans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            return "/jsps/project/fangzhuan/fangzhuanedit.jsp";
        }else {
            int tr = fangZhuanService.findCountByBlock(block);
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            return "/jsps/project/fangzhuan/fangzhuanedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<FangZhuan> fangZhuans = fangZhuanService.findFangZhuansByBlock(block,pc,ps);
        FangZhuanVo fangZhuanVo = new FangZhuanVo();
        fangZhuanVo.setUrl(getUrl(request));
        fangZhuanVo.setPs(ps);
        fangZhuanVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = fangZhuanService.findCountAll();
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            if (fangZhuans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            return "/jsps/project/fangzhuan/fangzhuandelete.jsp";
        }else {
            int tr = fangZhuanService.findCountByBlock(block);
            fangZhuanVo.setTr(tr);
            fangZhuanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", fangZhuans);
            request.setAttribute("pb",fangZhuanVo);
            return "/jsps/project/fangzhuan/fangzhuandelete.jsp";
        }
    }


    @RequestMapping("/findFangZhuansByBlock")
    public String findFangZhuansByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editFangZhuan")
    public String editFangZhuan(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editFangZhuanSubmit")
    public String editFangZhuanSubmit(HttpServletRequest request, HttpServletResponse response,
                                   Model model, FangZhuanVo fangZhuanVo) throws Exception {
        List<FangZhuan> fangZhuans = fangZhuanVo.getItemsList();
        if (fangZhuans==null){
            return dataToList(request);
        }
        List<FangZhuan> old = new ArrayList<FangZhuan>();
        for (FangZhuan fangZhuan :fangZhuans){
            old.add(fangZhuanService.findFangZhuanById(fangZhuan.getFz_id()));
        }
        fangZhuanService.updateFangZhuanList(fangZhuans);
        for (FangZhuan fangZhuanold :old){
            for (FangZhuan fangZhuannew :fangZhuans){
                if (fangZhuanold.getFz_id()==fangZhuannew.getFz_id()&& !fangZhuanold.toString().equals(fangZhuannew.toString())){
                    logService.insertLog("修改后",fangZhuannew.getFz_block(),"方砖道路表",fangZhuannew.toString());
                    logService.insertLog("修改前",fangZhuanold.getFz_block(),"方砖道路表",fangZhuanold.toString());
                    request.setAttribute("msg","修改信息成功");
                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteFangZhuans")
    public String deleteFangZhuans(HttpServletRequest request, HttpServletResponse response,
                                   Model model, FangZhuanVo fangZhuanVo) throws Exception{
        return dataToDelete(request);
    }


    @RequestMapping("/deleteFangZhuansSubmit")
    public String deleteFangZhuansSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] fz_id) throws Exception{
        if (fz_id==null){
            return dataToList(request);
        }
        List<FangZhuan> old = new ArrayList<FangZhuan>();
        for (int i =0;i<fz_id.length;i++){
            old.add(fangZhuanService.findFangZhuanById(Integer.parseInt(fz_id[i])));
        }
        fangZhuanService.deleteFangZhuanByIds(fz_id);
        for (FangZhuan fangZhuan :old) {
            logService.insertLog("删除",fangZhuan.getFz_block(),"方砖道路表",fangZhuan.toString());
        }
        request.setAttribute("msg","删除信息成功");
       return dataToList(request);
    }


    @RequestMapping("/addFangZhuan")
    public String addFangZhuan(HttpServletRequest request, HttpServletResponse response,
                                      Model model,FangZhuan fangZhuan) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = fangZhuan.getFz_block();
        String dirctionform = fangZhuan.getFz_direction();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            fangZhuanService.insertFangZhuan(fangZhuan);
            logService.insertLog("添加",fangZhuan.getFz_block(),"方砖道路表",fangZhuan.toString());
            request.setAttribute("msg","添加方砖道路信息成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            fangZhuanService.insertFangZhuan(fangZhuan);
        logService.insertLog("添加",fangZhuan.getFz_block(),"方砖道路表",fangZhuan.toString());
        request.setAttribute("msg","添加方砖道路信息成功");
        return dataToList(request);
    }
}
