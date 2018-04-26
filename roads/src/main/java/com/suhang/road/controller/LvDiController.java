package com.suhang.road.controller;

import com.suhang.road.po.CaoPing;
import com.suhang.road.po.LvDi;
import com.suhang.road.po.User;
import com.suhang.road.povo.CaoPingVo;
import com.suhang.road.povo.LvDiVo;
import com.suhang.road.service.CaoPingService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LvDiService;
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
@RequestMapping("/lvdi")
public class LvDiController {
    @Autowired
    private LvDiService lvDiService;
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
        List<LvDi>lvDis = lvDiService.findLvDisByBlock(block,pc,ps);
        LvDiVo lvDiVo = new LvDiVo();
        lvDiVo.setUrl(getUrl(request));
        lvDiVo.setPs(ps);
        lvDiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = lvDiService.findCountAll();
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            if (lvDis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            request.setAttribute("user",user);

            return "/jsps/project/lvdi/lvdilist.jsp";
        }else {
            int tr = lvDiService.findCountByBlock(block);
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            request.setAttribute("user",user);

            return "/jsps/project/lvdi/lvdilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LvDi>lvDis = lvDiService.findLvDisByBlock(block,pc,ps);
        LvDiVo lvDiVo = new LvDiVo();
        lvDiVo.setUrl(getUrl(request));
        lvDiVo.setPs(ps);
        lvDiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = lvDiService.findCountAll();
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            if (lvDis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            return "/jsps/project/lvdi/lvdiedit.jsp";
        }else {
            int tr = lvDiService.findCountByBlock(block);
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            return "/jsps/project/lvdi/lvdiedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LvDi>lvDis = lvDiService.findLvDisByBlock(block,pc,ps);
        LvDiVo lvDiVo = new LvDiVo();
        lvDiVo.setUrl(getUrl(request));
        lvDiVo.setPs(ps);
        lvDiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = lvDiService.findCountAll();
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            if (lvDis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            return "/jsps/project/lvdi/lvdidelete.jsp";
        }else {
            int tr = lvDiService.findCountByBlock(block);
            lvDiVo.setTr(tr);
            lvDiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvDis);
            request.setAttribute("pb",lvDiVo);
            return "/jsps/project/lvdi/lvdidelete.jsp";
        }
    }

    @RequestMapping("/findLvDisByBlock")
    public String findLvDisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editLvDis")
    public String editLvDis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editLvDisSubmit")
    public String editLvDisSubmit(HttpServletRequest request, HttpServletResponse response,
                                  Model model, LvDiVo lvDiVo) throws Exception {
        List<LvDi> lvDis = lvDiVo.getItemsList();
        if (lvDis==null){
            return dataToList(request);
        }
        List<LvDi>old = new ArrayList<LvDi>();
        for (LvDi lvDi :lvDis){
            old.add(lvDiService.findLvDiById(lvDi.getLd_id()));
        }
        lvDiService.updateLvDiList(lvDis);
        for (LvDi lvDiold :old){
            for (LvDi lvDinew :lvDis){
                if (lvDiold.getLd_id()==lvDinew.getLd_id() &&!lvDiold.toString().equals(lvDinew.toString())){
                    logService.insertLog("修改后",lvDinew.getLd_block(),"绿地表",lvDinew.toString());
                    logService.insertLog("修改前",lvDiold.getLd_block(),"绿地表",lvDiold.toString());
                    request.setAttribute("msg","修改信息成功");
                }
            }
        }
       return dataToList(request);
    }


    @RequestMapping("/deleteLvDis")
    public String deleteLvDis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteLvDisSubmit")
    public String deleteLvDisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] ld_id) throws Exception{
        if (ld_id==null){
            return dataToList(request);
        }
        List<LvDi>old = new ArrayList<LvDi>();
        for (int i=0;i<ld_id.length;i++){
            old.add(lvDiService.findLvDiById(Integer.parseInt(ld_id[i])));
        }
        lvDiService.deleteLvDisByIds(ld_id);
        for (LvDi lvDi:old){
            logService.insertLog("删除",lvDi.getLd_block(),"绿地表",lvDi.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addLvDi")
    public String addLvDi(HttpServletRequest request, HttpServletResponse response,
                                      Model model, LvDi lvDi) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = lvDi.getLd_block();
        String dirctionform = lvDi.getLd_direction();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            lvDiService.insertLvDi(lvDi);
            logService.insertLog("添加",lvDi.getLd_block(),"绿地表",lvDi.toString());
            request.setAttribute("msg","添加校园绿地成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            lvDiService.insertLvDi(lvDi);
        logService.insertLog("添加",lvDi.getLd_block(),"绿地表",lvDi.toString());
        request.setAttribute("msg","添加校园绿地信息成功");
        return dataToList(request);
    }
}
