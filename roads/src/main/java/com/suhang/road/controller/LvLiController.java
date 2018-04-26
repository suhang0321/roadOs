package com.suhang.road.controller;

import com.suhang.road.po.LvLi;
import com.suhang.road.po.QingXue;
import com.suhang.road.po.User;
import com.suhang.road.povo.LvLiVo;
import com.suhang.road.povo.QingXueVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LvLiService;
import com.suhang.road.service.QingXueService;
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
@RequestMapping("/lvli")
public class LvLiController {
    @Autowired
    private LvLiService lvLiService;
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
        List<LvLi> lvLis = lvLiService.findLvLisByBlock(block,pc,ps);
        LvLiVo lvLiVo = new LvLiVo();
        lvLiVo.setUrl(getUrl(request));
        lvLiVo.setPs(ps);
        lvLiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = lvLiService.findCountAll();
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            if (lvLis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/lvli/lvlilist.jsp";
        }else {
            int tr = lvLiService.findCountByBlock(block);
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/lvli/lvlilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LvLi> lvLis = lvLiService.findLvLisByBlock(block,pc,ps);
        LvLiVo lvLiVo = new LvLiVo();
        lvLiVo.setUrl(getUrl(request));
        lvLiVo.setPs(ps);
        lvLiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = lvLiService.findCountAll();
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            if (lvLis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            return "forward:/jsps/project/lvli/lvliedit.jsp";
        }else {
            int tr = lvLiService.findCountByBlock(block);
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            return "forward:/jsps/project/lvli/lvliedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LvLi> lvLis = lvLiService.findLvLisByBlock(block,pc,ps);
        LvLiVo lvLiVo = new LvLiVo();
        lvLiVo.setUrl(getUrl(request));
        lvLiVo.setPs(ps);
        lvLiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = lvLiService.findCountAll();
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            if (lvLis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            return "forward:/jsps/project/lvli/lvlidelete.jsp";
        }else {
            int tr = lvLiService.findCountByBlock(block);
            lvLiVo.setTr(tr);
            lvLiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", lvLis);
            request.setAttribute("pb",lvLiVo);
            return "forward:/jsps/project/lvli/lvlidelete.jsp";
        }
    }



    @RequestMapping("/findLvLisByBlock")
    public String findLvLisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editLvLis")
    public String editLvLis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editLvLisSubmit")
    public String editLvLisSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, LvLiVo lvLiVo) throws Exception {
        List<LvLi> lvLis = lvLiVo.getItemsList();
        if (lvLis==null){
            return dataToList(request);
        }
        List<LvLi> old = new ArrayList<LvLi>();
        for (LvLi lvLi:lvLis){
            old.add(lvLiService.findLvLiById(lvLi.getLl_id()));
        }
        lvLiService.updateLvLiList(lvLis);
        for (LvLi lvLiold :old){
            for (LvLi lvLinew :lvLis){
                if (lvLiold.getLl_id()==lvLinew.getLl_id()&&!lvLiold.toString().equals(lvLinew.toString())){
                    logService.insertLog("修改后",lvLinew.getLl_block(),"绿篱表",lvLinew.toString());
                    logService.insertLog("修改前",lvLiold.getLl_block(),"绿篱表",lvLiold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteLvLis")
    public String deleteLvLis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteLvLisSubmit")
    public String deleteLvLisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] ll_id) throws Exception{
        if (ll_id==null){
            return dataToList(request);
        }
        List<LvLi> old = new ArrayList<LvLi>();
        for (int i=0;i<ll_id.length;i++){
            old.add(lvLiService.findLvLiById(Integer.parseInt(ll_id[i])));
        }
        lvLiService.deleteLvLisByIds(ll_id);
        for (LvLi lvLi:old){
            logService.insertLog("删除",lvLi.getLl_block(),"绿篱表",lvLi.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addLvLi")
    public String addLvLi(HttpServletRequest request, HttpServletResponse response,
                                      Model model,LvLi lvLi) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = lvLi.getLl_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            lvLiService.insertLvLi(lvLi);
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加绿篱成功");
            logService.insertLog("添加",lvLi.getLl_block(),"绿篱表",lvLi.toString());
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            lvLiService.insertLvLi(lvLi);
        request.setAttribute("msg","添加绿篱信息成功");
        logService.insertLog("添加",lvLi.getLl_block(),"绿篱表",lvLi.toString());
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
