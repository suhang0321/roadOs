package com.suhang.road.controller;

import com.suhang.road.po.ErCiGongShui;
import com.suhang.road.po.TingChe;
import com.suhang.road.po.User;
import com.suhang.road.povo.ErCiGongShuiVo;
import com.suhang.road.povo.TingCheVo;
import com.suhang.road.service.ErCiService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.TingCheService;
import com.suhang.road.util.ConstantUtil;
import org.omg.CORBA.TCKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tingche")
public class TingCheController {
    @Autowired
    private TingCheService tingCheService;
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
        List<TingChe> tingChes = tingCheService.findTingChesByBlock(block,pc,ps);
        TingCheVo tingCheVo = new TingCheVo();
        tingCheVo.setUrl(getUrl(request));
        tingCheVo.setPs(ps);
        tingCheVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = tingCheService.findCountAll();
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            if (tingChes.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/tingche/tingchelist.jsp";
        }else {
            int tr = tingCheService.findCountByBlock(block);
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/tingche/tingchelist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<TingChe> tingChes = tingCheService.findTingChesByBlock(block,pc,ps);
        TingCheVo tingCheVo = new TingCheVo();
        tingCheVo.setUrl(getUrl(request));
        tingCheVo.setPs(ps);
        tingCheVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = tingCheService.findCountAll();
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            if (tingChes.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/tingche/tingcheedit.jsp";
        }else {
            int tr = tingCheService.findCountByBlock(block);
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/tingche/tingcheedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<TingChe> tingChes = tingCheService.findTingChesByBlock(block,pc,ps);
        TingCheVo tingCheVo = new TingCheVo();
        tingCheVo.setUrl(getUrl(request));
        tingCheVo.setPs(ps);
        tingCheVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = tingCheService.findCountAll();
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            if (tingChes.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            return "forward:/jsps/project/tingche/tingchedelete.jsp";
        }else {
            int tr = tingCheService.findCountByBlock(block);
            tingCheVo.setTr(tr);
            tingCheVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingChes);
            request.setAttribute("pb",tingCheVo);
            return "forward:/jsps/project/tingche/tingchedelete.jsp";
        }
    }

    @RequestMapping("/findTingChesByBlock")
    public String findTingChesByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editTingChes")
    public String editTingChes(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editTingChesSubmit")
    public String editTingChesSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, TingCheVo tingCheVo) throws Exception {
        List<TingChe> tingChes = tingCheVo.getItemsList();
        if (tingChes==null){
            return dataToList(request);
        }
        List<TingChe> old = new ArrayList<TingChe>();
        for (TingChe tingChe:tingChes){
            old.add(tingCheService.findTingCheById(tingChe.getTc_id()));
        }
        tingCheService.updateTingCheList(tingChes);
        for (TingChe tingCheold :old){
            for(TingChe tingChenew:tingChes){
                if (tingCheold.getTc_id()==tingChenew.getTc_id()&&!tingCheold.toString().equals(tingChenew.toString())){
                    logService.insertLog("修改后",tingChenew.getTc_block(),"停车场表",tingChenew.toString());
                    logService.insertLog("修改前",tingCheold.getTc_block(),"停车场表",tingCheold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteTingChes")
    public String deleteTingChes(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteTingChesSubmit")
    public String deleteTingChesSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] tc_id) throws Exception{
        if (tc_id==null){
            return dataToList(request);
        }
        List<TingChe> old = new ArrayList<TingChe>();
        for (int i = 0;i<tc_id.length;i++){
            old.add(tingCheService.findTingCheById(Integer.parseInt(tc_id[i])));
        }
        tingCheService.deleteTingChesByIds(tc_id);
        for (TingChe tingChe:old){
            logService.insertLog("删除",tingChe.getTc_block(),"停车场表",tingChe.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addTingChe")
    public String addTingChe(HttpServletRequest request, HttpServletResponse response,
                                      Model model,TingChe tingChe) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = tingChe.getTc_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            tingCheService.insertTingChe(tingChe);
            logService.insertLog("添加",tingChe.getTc_block(),"停车场表",tingChe.toString());
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加停车场成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            tingCheService.insertTingChe(tingChe);
        logService.insertLog("添加",tingChe.getTc_block(),"停车场表",tingChe.toString());
        request.setAttribute("msg","添加停车场信息成功");
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
