package com.suhang.road.controller;

import com.suhang.road.po.LaJi;
import com.suhang.road.po.LuDeng;
import com.suhang.road.po.User;
import com.suhang.road.povo.LaJiVo;
import com.suhang.road.povo.LuDengVo;
import com.suhang.road.service.LaJiService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LuDengService;
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
@RequestMapping("/ludeng")
public class LuDengController {
    @Autowired
    private LuDengService luDengService;
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
        List<LuDeng>luDengs = luDengService.findLuDengsByBlock(block,pc,ps);
        LuDengVo luDengVo = new LuDengVo();
        luDengVo.setUrl(getUrl(request));
        luDengVo.setPs(ps);
        luDengVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("Admin2")){
            int tr = luDengService.findCountAll();
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            if (luDengs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            request.setAttribute("user",user);

            return "/jsps/project/ludeng/ludenglist.jsp";
        }else {
            int tr = luDengService.findCountByBlock(block);
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            request.setAttribute("user",user);

            return "/jsps/project/ludeng/ludenglist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LuDeng>luDengs = luDengService.findLuDengsByBlock(block,pc,ps);
        LuDengVo luDengVo = new LuDengVo();
        luDengVo.setUrl(getUrl(request));
        luDengVo.setPs(ps);
        luDengVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = luDengService.findCountAll();
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            if (luDengs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            return "/jsps/project/ludeng/ludengedit.jsp";
        }else {
            int tr = luDengService.findCountByBlock(block);
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            return "/jsps/project/ludeng/ludengedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LuDeng>luDengs = luDengService.findLuDengsByBlock(block,pc,ps);
        LuDengVo luDengVo = new LuDengVo();
        luDengVo.setUrl(getUrl(request));
        luDengVo.setPs(ps);
        luDengVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = luDengService.findCountAll();
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            if (luDengs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            return "/jsps/project/ludeng/ludengdelete.jsp";
        }else {
            int tr = luDengService.findCountByBlock(block);
            luDengVo.setTr(tr);
            luDengVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", luDengs);
            request.setAttribute("pb",luDengVo);
            return "/jsps/project/ludeng/ludengdelete.jsp";
        }
    }


    @RequestMapping("/findLuDengsByBlock")
    public String findLuDengsByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editLuDengs")
    public String editLuDengs(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editLuDengsSubmit")
    public String editLuDengsSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, LuDengVo luDengVo) throws Exception {
        List<LuDeng> luDengs = luDengVo.getItemsList();
        if (luDengs==null){
            return dataToList(request);
        }
        List<LuDeng> old = new ArrayList<LuDeng>();
        for (LuDeng luDeng:luDengs){
            old.add(luDengService.findLuDengById(luDeng.getLd_id()));
        }
        luDengService.updateLuDengList(luDengs);
        for (LuDeng luDengold :old){
            for (LuDeng luDengnew:luDengs){
                if (luDengold.getLd_id()==luDengnew.getLd_id()&& !luDengold.toString().equals(luDengnew.toString())){
                    logService.insertLog("修改后",luDengnew.getLd_block(),"路灯表",luDengnew.toString());
                    logService.insertLog("修改前",luDengold.getLd_block(),"路灯表",luDengold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteLuDengs")
    public String deleteLuDengs(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteLuDengsSubmit")
    public String deleteLuDengsSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] ld_id) throws Exception{
        if (ld_id==null){
            return dataToList(request);
        }
        List<LuDeng> old = new ArrayList<LuDeng>();
        for (int i = 0;i<ld_id.length;i++){
            old.add(luDengService.findLuDengById(Integer.parseInt(ld_id[i])));
        }
        luDengService.deleteLuDengsByIds(ld_id);
        for (LuDeng luDeng:old){
            logService.insertLog("删除",luDeng.getLd_block(),"路灯表",luDeng.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addLuDeng")
    public String addLuDeng(HttpServletRequest request, HttpServletResponse response,
                                      Model model,LuDeng luDeng) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = luDeng.getLd_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            luDengService.insertLuDeng(luDeng);
            logService.insertLog("添加",luDeng.getLd_block(),"路灯表",luDeng.toString());
            request.setAttribute("msg","添加路灯成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            luDengService.insertLuDeng(luDeng);
        logService.insertLog("添加",luDeng.getLd_block(),"路灯表",luDeng.toString());
        request.setAttribute("msg","添加路灯信息成功");
        return dataToList(request);
    }
}
