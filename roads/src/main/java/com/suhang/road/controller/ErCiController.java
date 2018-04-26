package com.suhang.road.controller;

import com.suhang.road.po.ErCiGongShui;
import com.suhang.road.po.User;
import com.suhang.road.po.ZhenGui;
import com.suhang.road.povo.ErCiGongShuiVo;
import com.suhang.road.povo.ZhenGuiVo;
import com.suhang.road.service.ErCiService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.ZhenGuiService;
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
@RequestMapping("/erci")
public class ErCiController {
    @Autowired
    private ErCiService erCiService;
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
        List<ErCiGongShui> erCiGongShuis = erCiService.findErCisByBlock(block,pc,ps);
        ErCiGongShuiVo erCiGongShuiVo = new ErCiGongShuiVo();
        erCiGongShuiVo.setUrl(getUrl(request));
        erCiGongShuiVo.setPs(ps);
        erCiGongShuiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){//为管理员用户和后勤服务集团管理员显示所有数据
            int tr = erCiService.findCountAll();
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            if (erCiGongShuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/erci/ercilist.jsp";
        }else {
            int tr = erCiService.findCountByBlock(block);
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/erci/ercilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ErCiGongShui> erCiGongShuis = erCiService.findErCisByBlock(block,pc,ps);
        ErCiGongShuiVo erCiGongShuiVo = new ErCiGongShuiVo();
        erCiGongShuiVo.setUrl(getUrl(request));
        erCiGongShuiVo.setPs(ps);
        erCiGongShuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = erCiService.findCountAll();
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            if (erCiGongShuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            return "forward:/jsps/project/erci/erciedit.jsp";
        }else {
            int tr = erCiService.findCountByBlock(block);
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            return "forward:/jsps/project/erci/erciedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ErCiGongShui> erCiGongShuis = erCiService.findErCisByBlock(block,pc,ps);
        ErCiGongShuiVo erCiGongShuiVo = new ErCiGongShuiVo();
        erCiGongShuiVo.setUrl(getUrl(request));
        erCiGongShuiVo.setPs(ps);
        erCiGongShuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = erCiService.findCountAll();
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            if (erCiGongShuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            return "forward:/jsps/project/erci/ercidelete.jsp";
        }else {
            int tr = erCiService.findCountByBlock(block);
            erCiGongShuiVo.setTr(tr);
            erCiGongShuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", erCiGongShuis);
            request.setAttribute("pb",erCiGongShuiVo);
            return "forward:/jsps/project/erci/ercidelete.jsp";
        }
    }


    @RequestMapping("/findErCisByBlock")
    public String findErCisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editErCis")
    public String editErCis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editErCisSubmit")
    public String editErCisSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, ErCiGongShuiVo erCiGongShuiVo) throws Exception {
        List<ErCiGongShui> erCiGongShuis = erCiGongShuiVo.getItemsList();
        if (erCiGongShuis==null){
            return dataToList(request);
        }
        List<ErCiGongShui> erCiGongShuisold = new ArrayList<ErCiGongShui>();
        for (ErCiGongShui erCiGongShui :erCiGongShuis){
            erCiGongShuisold.add(erCiService.findErCiById(erCiGongShui.getSj_id()));
        }
        erCiService.updateErCiList(erCiGongShuis);
        for (ErCiGongShui erCiGongShuiold :erCiGongShuisold){
            for (ErCiGongShui erCiGongShuinew :erCiGongShuis){
                if (erCiGongShuiold.getSj_id()==erCiGongShuinew.getSj_id()&&!erCiGongShuiold.toString().equals(erCiGongShuinew.toString())){
                    logService.insertLog("修改后",erCiGongShuinew.getSj_block(),"二次供水表",erCiGongShuinew.toString());
                    logService.insertLog("修改前",erCiGongShuiold.getSj_block(),"二次供水表",erCiGongShuiold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteErCis")
    public String deleteErCis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteErCisSubmit")
    public String deleteErCisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] sj_id) throws Exception{
        if (sj_id==null){
            return dataToList(request);
        }
        List<ErCiGongShui> erCiGongShuisold = new ArrayList<ErCiGongShui>();
        for (int i=0;i<sj_id.length;i++){
            erCiGongShuisold.add(erCiService.findErCiById(Integer.parseInt(sj_id[i])));
        }
        erCiService.deleteErCisByIds(sj_id);
        for (ErCiGongShui erCiGongShuiold :erCiGongShuisold){
            logService.insertLog("删除",erCiGongShuiold.getSj_block(),"二次供水表",erCiGongShuiold.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addErCi")
    public String addErCi(HttpServletRequest request, HttpServletResponse response,
                                      Model model,ErCiGongShui erCiGongShui) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = erCiGongShui.getSj_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            erCiService.insertErCi(erCiGongShui);
            logService.insertLog("添加",erCiGongShui.getSj_block(),"二次供水表",erCiGongShui.toString());
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加二次供水成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            erCiService.insertErCi(erCiGongShui);
        logService.insertLog("添加",erCiGongShui.getSj_block(),"二次供水表",erCiGongShui.toString());
        request.setAttribute("msg","添加二次供水信息成功");
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
