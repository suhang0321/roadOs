package com.suhang.road.controller;

import com.suhang.road.po.GuanMu;
import com.suhang.road.po.HuaHui;
import com.suhang.road.po.User;
import com.suhang.road.povo.GuanMuVo;
import com.suhang.road.povo.HuaHuiVo;
import com.suhang.road.service.GuanMuService;
import com.suhang.road.service.HuaHuiService;
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
@RequestMapping("/huahui")
public class HuaHuiController {
    @Autowired
    private HuaHuiService huaHuiService;
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
        List<HuaHui>huaHuis = huaHuiService.findHuaHuisByBlock(block,pc,ps);
        HuaHuiVo huaHuiVo = new HuaHuiVo();
        huaHuiVo.setUrl(getUrl(request));
        huaHuiVo.setPs(ps);
        huaHuiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr =huaHuiService.findCountAll();
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            if (huaHuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            request.setAttribute("user",user);

            return "/jsps/project/huahui/huahuilist.jsp";
        }else {
            int tr = huaHuiService.findCountByBlock(block);
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            request.setAttribute("user",user);

            return "/jsps/project/huahui/huahuilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<HuaHui>huaHuis = huaHuiService.findHuaHuisByBlock(block,pc,ps);
        HuaHuiVo huaHuiVo = new HuaHuiVo();
        huaHuiVo.setUrl(getUrl(request));
        huaHuiVo.setPs(ps);
        huaHuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr =huaHuiService.findCountAll();
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            if (huaHuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            return "/jsps/project/huahui/huahuiedit.jsp";
        }else {
            int tr = huaHuiService.findCountByBlock(block);
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            return "/jsps/project/huahui/huahuiedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<HuaHui>huaHuis = huaHuiService.findHuaHuisByBlock(block,pc,ps);
        HuaHuiVo huaHuiVo = new HuaHuiVo();
        huaHuiVo.setUrl(getUrl(request));
        huaHuiVo.setPs(ps);
        huaHuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr =huaHuiService.findCountAll();
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            if (huaHuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            return "/jsps/project/huahui/huahuidelete.jsp";
        }else {
            int tr = huaHuiService.findCountByBlock(block);
            huaHuiVo.setTr(tr);
            huaHuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", huaHuis);
            request.setAttribute("pb",huaHuiVo);
            return "/jsps/project/huahui/huahuidelete.jsp";
        }
    }


    @RequestMapping("/findHuaHuisByBlock")
    public String findHuaHuisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editHuaHuis")
    public String editHuaHuis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
      return dataToEdit(request);
    }


    @RequestMapping("/editHuaHuisSubmit")
    public String editHuaHuisSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, HuaHuiVo huaHuiVo) throws Exception {
        List<HuaHui> huaHuis = huaHuiVo.getItemsList();
        if (huaHuis ==null){
            return dataToList(request);
        }
        List<HuaHui> old = new ArrayList<HuaHui>();
        for (HuaHui huaHui:huaHuis){
            old.add(huaHuiService.findHuaHuiById(huaHui.getHh_id()));
        }
        huaHuiService.updateHuaHuiList(huaHuis);
        for (HuaHui huaHuiold :old){
            for (HuaHui huaHuinew :huaHuis){
                if (huaHuiold.getHh_id()==huaHuinew.getHh_id()&&!huaHuiold.toString().equals(huaHuinew.toString())){
                    logService.insertLog("修改后",huaHuinew.getHh_block(),"花卉表",huaHuinew.toString());
                    logService.insertLog("修改前",huaHuiold.getHh_block(),"花卉表",huaHuiold.toString());
                    request.setAttribute("msg","信息修改成功");
                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteHuaHuis")
    public String deleteHuaHuis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteHuaHuisSubmit")
    public String deleteHuaHuisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] hh_id) throws Exception{
        if (hh_id==null){
            return dataToList(request);
        }
        List<HuaHui>old = new ArrayList<HuaHui>();
        for (int i =0;i<hh_id.length;i++){
            old.add(huaHuiService.findHuaHuiById(Integer.parseInt(hh_id[i])));
        }
        huaHuiService.deleteHuaHuisByIds(hh_id);
        for (HuaHui huaHui :old){
            logService.insertLog("删除",huaHui.getHh_block(),"花卉表",huaHui.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addHuaHui")
    public String addHuaHui(HttpServletRequest request, HttpServletResponse response,
                                      Model model, HuaHui huaHui  ) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = huaHui.getHh_block();
        String kindform = huaHui.getHh_kind();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||kindform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            huaHuiService.insertHuaHui(huaHui);
            logService.insertLog("添加",huaHui.getHh_block(),"花卉表",huaHui.toString());
            request.setAttribute("msg","添加花卉成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            huaHuiService.insertHuaHui(huaHui);
        logService.insertLog("添加",huaHui.getHh_block(),"花卉表",huaHui.toString());
        request.setAttribute("msg","添加花卉信息成功");
        return dataToList(request);
    }
}
