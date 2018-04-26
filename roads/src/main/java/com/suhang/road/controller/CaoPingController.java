package com.suhang.road.controller;

import com.suhang.road.po.CaoPing;
import com.suhang.road.po.User;
import com.suhang.road.po.YongDao;
import com.suhang.road.povo.CaoPingVo;
import com.suhang.road.povo.YongDaoVo;
import com.suhang.road.service.CaoPingService;
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
@RequestMapping("/caoping")
public class CaoPingController {
    @Autowired
    private CaoPingService caoPingService;
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
        List<CaoPing>caoPings = caoPingService.findCaoPingsByBlock(block,pc,ps);
        CaoPingVo caoPingVo = new CaoPingVo();
        caoPingVo.setUrl(getUrl(request));
        caoPingVo.setPs(ps);
        caoPingVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = caoPingService.findCountAll();
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            if (caoPings.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            request.setAttribute("user",user);

            return "/jsps/project/caoping/caopinglist.jsp";
        }else {
            int tr = caoPingService.findCountByBlock(block);
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            request.setAttribute("user",user);

            return "/jsps/project/caoping/caopinglist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<CaoPing>caoPings = caoPingService.findCaoPingsByBlock(block,pc,ps);
        CaoPingVo caoPingVo = new CaoPingVo();
        caoPingVo.setUrl(getUrl(request));
        caoPingVo.setPs(ps);
        caoPingVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = caoPingService.findCountAll();
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            if (caoPings.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            return "/jsps/project/caoping/caopingedit.jsp";
        }else {
            int tr = caoPingService.findCountByBlock(block);
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            return "/jsps/project/caoping/caopingedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<CaoPing>caoPings = caoPingService.findCaoPingsByBlock(block,pc,ps);
        CaoPingVo caoPingVo = new CaoPingVo();
        caoPingVo.setUrl(getUrl(request));
        caoPingVo.setPs(ps);
        caoPingVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = caoPingService.findCountAll();
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            if (caoPings.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            return "/jsps/project/caoping/caopingdelete.jsp";
        }else {
            int tr = caoPingService.findCountByBlock(block);
            caoPingVo.setTr(tr);
            caoPingVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", caoPings);
            request.setAttribute("pb",caoPingVo);
            return "/jsps/project/caoping/caopingdelete.jsp";
        }
    }


    @RequestMapping("/findCaoPingsByBlock")
    public String findCaoPingsByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
        return dataToList(request);
    }


    @RequestMapping("/editCaoPings")
    public String editCaoPings(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
        return dataToEdit(request);
    }


    @RequestMapping("/editCaoPingsSubmit")
    public String editCaoPingsSubmit(HttpServletRequest request, HttpServletResponse response,
                                     Model model, CaoPingVo caoPingVo) throws Exception {
        List<CaoPing> caoPings = caoPingVo.getItemsList();
        List<CaoPing> old = new ArrayList<CaoPing>();
        for (CaoPing caoPing:caoPings){
            old.add(caoPingService.findCaoPingById((caoPing.getCp_id())));
        }
        if (caoPings==null){
            return dataToList(request);
        }
        caoPingService.updateCaoPingList(caoPings);
        for (CaoPing caoPingold:old){
            for (CaoPing caoPingnew:caoPings ){
                if (caoPingold.getCp_id()==caoPingnew.getCp_id()&&!caoPingold.toString().equals(caoPingnew.toString())){
                    logService.insertLog("修改后",caoPingnew.getCp_block(),"校园草坪表",caoPingnew.toString());
                    logService.insertLog("修改前",caoPingold.getCp_block(),"校园草坪表",caoPingold.toString());
                    request.setAttribute("msg","修改信息成功");

                }
            }
        }
       return dataToList(request);
    }


    @RequestMapping("/deleteCaoPings")
    public String deleteCaoPings(HttpServletRequest request, HttpServletResponse response,
                                   Model model, CaoPingVo caoPingVo) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteCaoPingsSubmit")
    public String deleteCaoPingsSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] cp_id) throws Exception{
        if (cp_id==null){
            return dataToList(request);
        }
        List<CaoPing> old = new ArrayList<CaoPing>();
        for (int i=0;i<cp_id.length;i++){
            old.add(caoPingService.findCaoPingById(Integer.parseInt(cp_id[i])));
        }
        caoPingService.deleteCaoPingsByIds(cp_id);
        for (CaoPing caoPingold :old){
            logService.insertLog("删除",caoPingold.getCp_block(),"校园草坪表",caoPingold.toString());
        }
        request.setAttribute("msg","删除信息成功");
        return dataToList(request);
    }


    @RequestMapping("/addCaoPing")
    public String addCaoPing(HttpServletRequest request, HttpServletResponse response,
                                      Model model, CaoPing caoPing) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = caoPing.getCp_block();
        String dirctionform = caoPing.getCp_direction();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            caoPingService.insertCaoPing(caoPing);
            request.setAttribute("msg","添加校园草坪成功");
            logService.insertLog("添加",caoPing.getCp_block(),"校园草坪表",caoPing.toString());
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            caoPingService.insertCaoPing(caoPing);
        logService.insertLog("添加",caoPing.getCp_block(),"校园草坪表",caoPing.toString());
        request.setAttribute("msg","添加校园草坪信息成功");
        return dataToList(request);
    }
}
