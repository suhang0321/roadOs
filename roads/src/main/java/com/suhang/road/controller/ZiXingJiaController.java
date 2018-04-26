package com.suhang.road.controller;

import com.suhang.road.po.HuaHui;
import com.suhang.road.po.User;
import com.suhang.road.po.ZiXingJia;
import com.suhang.road.povo.HuaHuiVo;
import com.suhang.road.povo.ZiXingJiaVo;
import com.suhang.road.service.HuaHuiService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.ZiXingJiaService;
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
@RequestMapping("/zixingjia")
public class ZiXingJiaController {
    @Autowired
    private ZiXingJiaService ziXingJiaService;
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
        List<ZiXingJia>ziXingJias = ziXingJiaService.findZiXingJiasByBlock(block,pc,ps);
        ZiXingJiaVo ziXingJiaVo = new ZiXingJiaVo();
        ziXingJiaVo.setUrl(getUrl(request));
        ziXingJiaVo.setPs(ps);
        ziXingJiaVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = ziXingJiaService.findCountAll();
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            if (ziXingJias.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            request.setAttribute("user",user);

            return "/jsps/project/zixingjia/zixingjialist.jsp";
        }else {
            int tr = ziXingJiaService.findCountByBlock(block);
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            request.setAttribute("user",user);

            return "/jsps/project/zixingjia/zixingjialist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ZiXingJia>ziXingJias = ziXingJiaService.findZiXingJiasByBlock(block,pc,ps);
        ZiXingJiaVo ziXingJiaVo = new ZiXingJiaVo();
        ziXingJiaVo.setUrl(getUrl(request));
        ziXingJiaVo.setPs(ps);
        ziXingJiaVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = ziXingJiaService.findCountAll();
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            if (ziXingJias.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            return "/jsps/project/zixingjia/zixingjiaedit.jsp";
        }else {
            int tr = ziXingJiaService.findCountByBlock(block);
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            return "/jsps/project/zixingjia/zixingjiaedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ZiXingJia>ziXingJias = ziXingJiaService.findZiXingJiasByBlock(block,pc,ps);
        ZiXingJiaVo ziXingJiaVo = new ZiXingJiaVo();
        ziXingJiaVo.setUrl(getUrl(request));
        ziXingJiaVo.setPs(ps);
        ziXingJiaVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = ziXingJiaService.findCountAll();
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            if (ziXingJias.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            return "/jsps/project/zixingjia/zixingjiadelete.jsp";
        }else {
            int tr = ziXingJiaService.findCountByBlock(block);
            ziXingJiaVo.setTr(tr);
            ziXingJiaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", ziXingJias);
            request.setAttribute("pb",ziXingJiaVo);
            return "/jsps/project/zixingjia/zixingjiadelete.jsp";
        }
    }


    @RequestMapping("/findZiXingJiasByBlock")
    public String findZiXingJiasByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editZiXingJias")
    public String editZiXingJias(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
        return dataToEdit(request);
    }


    @RequestMapping("/editZiXingJiasSubmit")
    public String editZiXingJiasSubmit(HttpServletRequest request, HttpServletResponse response,
                                       Model model, ZiXingJiaVo ziXingJiaVo) throws Exception {
        List<ZiXingJia> ziXingJias = ziXingJiaVo.getItemsList();
        if (ziXingJias==null){
            return dataToList(request);
        }
        List<ZiXingJia> old = new ArrayList<ZiXingJia>();
        for (ZiXingJia ziXingJia:ziXingJias){
            old.add(ziXingJiaService.findZiXingById(ziXingJia.getCj_id()));
        }
        ziXingJiaService.updateZiXingJiaList(ziXingJias);
        for (ZiXingJia ziXingJiaold :old){
            for (ZiXingJia ziXingJianew:ziXingJias){
                if (ziXingJiaold.getCj_id()==ziXingJianew.getCj_id()&&!ziXingJiaold.toString().equals(ziXingJianew.toString())){
                    logService.insertLog("修改后",ziXingJianew.getCj_block(),"自行架表",ziXingJianew.toString());
                    logService.insertLog("修改前",ziXingJiaold.getCj_block(),"自行架表",ziXingJiaold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteZiXingJias")
    public String deleteZiXingJias(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteZiXingJiasSubmit")
    public String deleteZiXingJiasSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] cj_id) throws Exception{
        if (cj_id==null){
            return dataToList(request);
        }
        List<ZiXingJia> old = new ArrayList<ZiXingJia>();
        for (int i=0;i<cj_id.length;i++){
            old.add(ziXingJiaService.findZiXingById(Integer.parseInt(cj_id[i])));
        }
        ziXingJiaService.deleteZiXingJiasByIds(cj_id);
        for (ZiXingJia ziXingJia:old){
            logService.insertLog("删除",ziXingJia.getCj_block(),"自行架表",ziXingJia.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addZiXingJia")
    public String addZiXingJia(HttpServletRequest request, HttpServletResponse response,
                                      Model model,ZiXingJia ziXingJia) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = ziXingJia.getCj_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            ziXingJiaService.insertZiXingJia(ziXingJia);
            logService.insertLog("添加",ziXingJia.getCj_block(),"自行架表",ziXingJia.toString());
            request.setAttribute("msg","添加自行架成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            ziXingJiaService.insertZiXingJia(ziXingJia);
        logService.insertLog("添加",ziXingJia.getCj_block(),"自行架表",ziXingJia.toString());
        request.setAttribute("msg","添加自行架信息成功");
        return dataToList(request);
    }
}
