package com.suhang.road.controller;

import com.suhang.road.po.LuoYeQiaoMu;
import com.suhang.road.po.QiaoMu;
import com.suhang.road.po.User;
import com.suhang.road.povo.LuoYeQiaoMuVo;
import com.suhang.road.povo.QiaoMuVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LuoYeService;
import com.suhang.road.service.QiaoMuService;
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
@RequestMapping("/luoye")
public class LuoYeController {
    @Autowired
    private LuoYeService luoYeService;
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
        List<LuoYeQiaoMu> luoYeQiaoMus = luoYeService.findLuoYesByBlock(block,pc,ps);
        LuoYeQiaoMuVo luoYeQiaoMuVo = new LuoYeQiaoMuVo();
        luoYeQiaoMuVo.setUrl(getUrl(request));
        luoYeQiaoMuVo.setPs(ps);
        luoYeQiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = luoYeService.findCountAll();
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            if (luoYeQiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/luoye/luoyelist.jsp";
        }else {
            int tr = luoYeService.findCountByBlock(block);
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/luoye/luoyelist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LuoYeQiaoMu> luoYeQiaoMus = luoYeService.findLuoYesByBlock(block,pc,ps);
        LuoYeQiaoMuVo luoYeQiaoMuVo = new LuoYeQiaoMuVo();
        luoYeQiaoMuVo.setUrl(getUrl(request));
        luoYeQiaoMuVo.setPs(ps);
        luoYeQiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = luoYeService.findCountAll();
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            if (luoYeQiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            return "/jsps/project/luoye/luoyeedit.jsp";
        }else {
            int tr = luoYeService.findCountByBlock(block);
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            return "/jsps/project/luoye/luoyeedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LuoYeQiaoMu> luoYeQiaoMus = luoYeService.findLuoYesByBlock(block,pc,ps);
        LuoYeQiaoMuVo luoYeQiaoMuVo = new LuoYeQiaoMuVo();
        luoYeQiaoMuVo.setUrl(getUrl(request));
        luoYeQiaoMuVo.setPs(ps);
        luoYeQiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = luoYeService.findCountAll();
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            if (luoYeQiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            return "/jsps/project/luoye/luoyedelete.jsp";
        }else {
            int tr = luoYeService.findCountByBlock(block);
            luoYeQiaoMuVo.setTr(tr);
            luoYeQiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luoYeQiaoMus);
            request.setAttribute("pb",luoYeQiaoMuVo);
            return "/jsps/project/luoye/luoyedelete.jsp";
        }
    }


    @RequestMapping("/findLuoYesByBlock")
    public String findLuoYesByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
        return dataToList(request);
    }


    @RequestMapping("/editLuoYes")
    public String editLuoYes(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editLuoYesSubmit")
    public String editLuoYesSubmit(HttpServletRequest request, HttpServletResponse response,
                                   Model model, LuoYeQiaoMuVo luoYeQiaoMuVo) throws Exception {
        List<LuoYeQiaoMu> luoYeQiaoMus = luoYeQiaoMuVo.getItemsList();
        if (luoYeQiaoMus==null){
            return dataToList(request);
        }
        List<LuoYeQiaoMu> old = new ArrayList<LuoYeQiaoMu>();
        for (LuoYeQiaoMu luoYeQiaoMu:luoYeQiaoMus){
            old.add(luoYeService.findLuoYeById(luoYeQiaoMu.getQm_id()));
        }
        luoYeService.updateLuoYeList(luoYeQiaoMus);
        for (LuoYeQiaoMu luoYeQiaoMuold :old){
            for (LuoYeQiaoMu luoYeQiaoMunew:luoYeQiaoMus){
                if (luoYeQiaoMuold.getQm_id()==luoYeQiaoMunew.getQm_id() && !luoYeQiaoMuold.toString().equals(luoYeQiaoMunew.toString())){
                    logService.insertLog("修改后",luoYeQiaoMunew.getQm_block(),"落叶乔木表",luoYeQiaoMunew.toString());
                    logService.insertLog("修改前",luoYeQiaoMuold.getQm_block(),"落叶乔木表",luoYeQiaoMuold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteLuoYes")
    public String deleteLuoYes(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteLuoYesSubmit")
    public String deleteLuoYesSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] qm_id) throws Exception{
        if (qm_id==null){
            return  dataToList(request);
        }
        List<LuoYeQiaoMu> old = new ArrayList<LuoYeQiaoMu>();
        for (int i=0;i<qm_id.length;i++){
            old.add(luoYeService.findLuoYeById(Integer.parseInt(qm_id[i])));
        }
        luoYeService.deleteLuoYesByIds(qm_id);
        for (LuoYeQiaoMu luoYeQiaoMu :old){
            logService.insertLog("删除",luoYeQiaoMu.getQm_block(),"落叶乔木表",luoYeQiaoMu.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addLuoYe")
    public String addLuoYe(HttpServletRequest request, HttpServletResponse response,
                                      Model model, LuoYeQiaoMu luoYeQiaoMu) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = luoYeQiaoMu.getQm_block();
        String typeform = luoYeQiaoMu.getQm_type();
        String kindform = luoYeQiaoMu.getQm_kind();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||typeform.equals("error")||kindform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            luoYeService.insertLuoYe(luoYeQiaoMu);
            logService.insertLog("添加",luoYeQiaoMu.getQm_block(),"落叶乔木表",luoYeQiaoMu.toString());
            request.setAttribute("msg","添加校园落叶乔木成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            luoYeService.insertLuoYe(luoYeQiaoMu);
        logService.insertLog("添加",luoYeQiaoMu.getQm_block(),"落叶乔木表",luoYeQiaoMu.toString());
        request.setAttribute("msg","添加校园落叶乔木信息成功");
        return dataToList(request);
    }
}
