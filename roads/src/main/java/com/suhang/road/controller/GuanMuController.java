package com.suhang.road.controller;

import com.suhang.road.po.GuanMu;
import com.suhang.road.po.LuoYeQiaoMu;
import com.suhang.road.po.User;
import com.suhang.road.povo.GuanMuVo;
import com.suhang.road.povo.LuoYeQiaoMuVo;
import com.suhang.road.service.GuanMuService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LuoYeService;
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
@RequestMapping("/guanmu")
public class GuanMuController {
    @Autowired
    private GuanMuService guanMuService;
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
        List<GuanMu> guanMus = guanMuService.findGuanMusByBlock(block,pc,ps);
        GuanMuVo guanMuVo = new GuanMuVo();
        guanMuVo.setUrl(getUrl(request));
        guanMuVo.setPs(ps);
        guanMuVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = guanMuService.findCountAll();
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            if (guanMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/guanmu/guanmulist.jsp";
        }else {
            int tr = guanMuService.findCountByBlock(block);
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/guanmu/guanmulist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<GuanMu> guanMus = guanMuService.findGuanMusByBlock(block,pc,ps);
        GuanMuVo guanMuVo = new GuanMuVo();
        guanMuVo.setUrl(getUrl(request));
        guanMuVo.setPs(ps);
        guanMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = guanMuService.findCountAll();
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            if (guanMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            return "/jsps/project/guanmu/guanmuedit.jsp";
        }else {
            int tr = guanMuService.findCountByBlock(block);
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            return "/jsps/project/guanmu/guanmuedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<GuanMu> guanMus = guanMuService.findGuanMusByBlock(block,pc,ps);
        GuanMuVo guanMuVo = new GuanMuVo();
        guanMuVo.setUrl(getUrl(request));
        guanMuVo.setPs(ps);
        guanMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = guanMuService.findCountAll();
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            if (guanMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            return "/jsps/project/guanmu/guanmudelete.jsp";
        }else {
            int tr = guanMuService.findCountByBlock(block);
            guanMuVo.setTr(tr);
            guanMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guanMus);
            request.setAttribute("pb",guanMuVo);
            return "/jsps/project/guanmu/guanmudelete.jsp";
        }
    }


    @RequestMapping("/findGuanMusByBlock")
    public String findGuanMusByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editGuanMus")
    public String editGuanMus(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
        return dataToEdit(request);
    }


    @RequestMapping("/editGuanMusSubmit")
    public String editGuanMusSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, GuanMuVo guanMuVo) throws Exception {
        List<GuanMu>guanMus = guanMuVo.getItemsList();
        if (guanMus==null){
            return dataToList(request);
        }
        List<GuanMu> old = new ArrayList<GuanMu>();
        for (GuanMu guanMu :guanMus){
            old.add(guanMuService.findGuanMuById(guanMu.getGm_id()));
        }
        guanMuService.updateGuanMuList(guanMus);
        for (GuanMu guanMuold:old){
            for (GuanMu guanMunew:guanMus){
                if (guanMuold.getGm_id()==guanMunew.getGm_id()&&!guanMuold.toString().equals(guanMunew.toString())){
                    logService.insertLog("修改后",guanMunew.getGm_block(),"花灌木表",guanMunew.toString());
                    logService.insertLog("修改前",guanMuold.getGm_block(),"花灌木表",guanMuold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteGuanMus")
    public String deleteGuanMus(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
        return dataToDelete(request);
    }


    @RequestMapping("/deleteGuanMusSubmit")
    public String deleteGuanMusSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] gm_id) throws Exception{
        if (gm_id==null){
            return dataToList(request);
        }
        List<GuanMu> old = new ArrayList<GuanMu>();
        for (int i=0;i<gm_id.length;i++){
            old.add(guanMuService.findGuanMuById(Integer.parseInt(gm_id[i])));
        }
        guanMuService.deleteGuanMusByIds(gm_id);
        for (GuanMu guanMu:old){
            logService.insertLog("删除",guanMu.getGm_block(),"花灌木表",guanMu.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addGuanMu")
    public String addGuanMu(HttpServletRequest request, HttpServletResponse response,
                                      Model model, GuanMu guanMu) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = guanMu.getGm_block();
        String typeform = guanMu.getGm_type();
        String kindform = guanMu.getGm_kind();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||typeform.equals("error")||kindform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            guanMuService.insertGuanMu(guanMu);
            logService.insertLog("添加",guanMu.getGm_block(),"花灌木表",guanMu.toString());
            request.setAttribute("msg","添加花灌木成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            guanMuService.insertGuanMu(guanMu);
        logService.insertLog("添加",guanMu.getGm_block(),"花灌木表",guanMu.toString());
        request.setAttribute("msg","添加花灌木信息成功");
        return dataToList(request);
    }
}
