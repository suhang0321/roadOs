package com.suhang.road.controller;

import com.suhang.road.po.JiaShan;
import com.suhang.road.po.ShuiXi;
import com.suhang.road.po.User;
import com.suhang.road.povo.JiaShanVo;
import com.suhang.road.povo.ShuiXiVo;
import com.suhang.road.service.JiaShanService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.ShuiXiService;
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
@RequestMapping("/shuixi")
public class ShuiXiController {
    @Autowired
    private ShuiXiService shuiXiService;
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
        List<ShuiXi> shuiXis = shuiXiService.findShuiXisByBlock(block,pc,ps);
        ShuiXiVo shuiXiVo = new ShuiXiVo();
        shuiXiVo.setUrl(getUrl(request));
        shuiXiVo.setPs(ps);
        shuiXiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = shuiXiService.findCountAll();
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            if (shuiXis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            request.setAttribute("user",user);

            return "/jsps/project/shuixi/shuixilist.jsp";
        }else {
            int tr = shuiXiService.findCountByBlock(block);
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            request.setAttribute("user",user);

            return "/jsps/project/shuixi/shuixilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ShuiXi> shuiXis = shuiXiService.findShuiXisByBlock(block,pc,ps);
        ShuiXiVo shuiXiVo = new ShuiXiVo();
        shuiXiVo.setUrl(getUrl(request));
        shuiXiVo.setPs(ps);
        shuiXiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = shuiXiService.findCountAll();
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            if (shuiXis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            return "/jsps/project/shuixi/shuixiedit.jsp";
        }else {
            int tr = shuiXiService.findCountByBlock(block);
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            return "/jsps/project/shuixi/shuixiedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ShuiXi> shuiXis = shuiXiService.findShuiXisByBlock(block,pc,ps);
        ShuiXiVo shuiXiVo = new ShuiXiVo();
        shuiXiVo.setUrl(getUrl(request));
        shuiXiVo.setPs(ps);
        shuiXiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = shuiXiService.findCountAll();
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            if (shuiXis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            return "/jsps/project/shuixi/shuixidelete.jsp";
        }else {
            int tr = shuiXiService.findCountByBlock(block);
            shuiXiVo.setTr(tr);
            shuiXiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", shuiXis);
            request.setAttribute("pb",shuiXiVo);
            return "/jsps/project/shuixi/shuixidelete.jsp";
        }
    }




    @RequestMapping("/findShuiXisByBlock")
    public String findShuiXisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editShuiXis")
    public String editShuiXis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editShuiXisSubmit")
    public String editShuiXisSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, ShuiXiVo  shuiXiVo) throws Exception {
        List<ShuiXi> shuiXis = shuiXiVo.getItemsList();
        if (shuiXis ==null){
            return dataToList(request);
        }
        List<ShuiXi> old = new ArrayList<ShuiXi>();
        for (ShuiXi shuiXi:shuiXis){
            old.add(shuiXiService.findShuiXiById(shuiXi.getSx_id()));
        }
        shuiXiService.updateShuiXiList(shuiXis);
        for (ShuiXi shuiXiold :old){
            for (ShuiXi shuiXinew:shuiXis){
                if (shuiXiold.getSx_id()==shuiXinew.getSx_id()&&!shuiXiold.toString().equals(shuiXinew.toString())){
                    logService.insertLog("修改后",shuiXinew.getSx_block(),"水系表",shuiXinew.toString());
                    logService.insertLog("修改前",shuiXiold.getSx_block(),"水系表",shuiXiold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteShuiXis")
    public String deleteShuiXis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteShuiXisSubmit")
    public String deleteShuiXisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] sx_id) throws Exception{
        if (sx_id==null){
            return dataToList(request);
        }
        List<ShuiXi>old = new ArrayList<ShuiXi>();
        for (int i =0;i<sx_id.length;i++){
            old.add(shuiXiService.findShuiXiById(Integer.parseInt(sx_id[i])));
        }
        shuiXiService.deleteShuiXisByIds(sx_id);
        for (ShuiXi shuiXi:old){
            logService.insertLog("删除",shuiXi.getSx_block(),"水系表",shuiXi.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addJiaShan")
    public String addJiaShan(HttpServletRequest request, HttpServletResponse response,
                                      Model model,ShuiXi shuiXi) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = shuiXi.getSx_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            shuiXiService.insertShuiXi(shuiXi);
            logService.insertLog("添加",shuiXi.getSx_block(),"水系表",shuiXi.toString());
            request.setAttribute("msg","添加水系统成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            shuiXiService.insertShuiXi(shuiXi);
        logService.insertLog("添加",shuiXi.getSx_block(),"水系表",shuiXi.toString());
        request.setAttribute("msg","添加水系统信息成功");
        return dataToList(request);
    }
}
