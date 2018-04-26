package com.suhang.road.controller;

import com.suhang.road.po.JiaShan;
import com.suhang.road.po.TingLang;
import com.suhang.road.po.User;
import com.suhang.road.povo.JiaShanVo;
import com.suhang.road.povo.TingLangVo;
import com.suhang.road.service.JiaShanService;
import com.suhang.road.service.LogService;
import com.suhang.road.service.TingLangService;
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
@RequestMapping("/jiashan")
public class JiaShanController {
    @Autowired
    private JiaShanService jiaShanService;
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
        List<JiaShan> jiaShans = jiaShanService.findJiaShansByBlock(block,pc,ps);
        JiaShanVo jiaShanVo = new JiaShanVo();
        jiaShanVo.setUrl(getUrl(request));
        jiaShanVo.setPs(ps);
        jiaShanVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = jiaShanService.findCountAll();
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            if (jiaShans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            request.setAttribute("user",user);

            return "/jsps/project/jiashan/jiashanlist.jsp";
        }else {
            int tr = jiaShanService.findCountByBlock(block);
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            request.setAttribute("user",user);

            return "/jsps/project/jiashan/jiashanlist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<JiaShan> jiaShans = jiaShanService.findJiaShansByBlock(block,pc,ps);
        JiaShanVo jiaShanVo = new JiaShanVo();
        jiaShanVo.setUrl(getUrl(request));
        jiaShanVo.setPs(ps);
        jiaShanVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = jiaShanService.findCountAll();
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            if (jiaShans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            return "/jsps/project/jiashan/jiashanedit.jsp";
        }else {
            int tr = jiaShanService.findCountByBlock(block);
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            return "/jsps/project/jiashan/jiashanedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<JiaShan> jiaShans = jiaShanService.findJiaShansByBlock(block,pc,ps);
        JiaShanVo jiaShanVo = new JiaShanVo();
        jiaShanVo.setUrl(getUrl(request));
        jiaShanVo.setPs(ps);
        jiaShanVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = jiaShanService.findCountAll();
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            if (jiaShans.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            return "/jsps/project/jiashan/jiashandelete.jsp";
        }else {
            int tr = jiaShanService.findCountByBlock(block);
            jiaShanVo.setTr(tr);
            jiaShanVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", jiaShans);
            request.setAttribute("pb",jiaShanVo);
            return "/jsps/project/jiashan/jiashandelete.jsp";
        }
    }



    @RequestMapping("/findJiaShansByBlock")
    public String findJiaShansByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editJiaShans")
    public String editJiaShans(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editJiaShansSubmit")
    public String editJiaShansSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, JiaShanVo jiaShanVo) throws Exception {
        List<JiaShan> jiaShans = jiaShanVo.getItemsList();
        if (jiaShans==null){
            return dataToList(request);
        }
        List<JiaShan> old = new ArrayList<JiaShan>();
        for (JiaShan jiaShan:jiaShans){
            old.add(jiaShanService.findJiaShanById(jiaShan.getJs_id()));
        }
        jiaShanService.updateJiaShanList(jiaShans);
        for (JiaShan jiaShanold :old){
            for (JiaShan jiaShannew :jiaShans){
                if(jiaShanold.getJs_id()==jiaShannew.getJs_id()&&!jiaShanold.toString().equals(jiaShannew.toString())){
                    logService.insertLog("修改后",jiaShannew.getJs_block(),"假山表",jiaShannew.toString());
                    logService.insertLog("修改前",jiaShanold.getJs_block(),"假山表",jiaShanold.toString());
                    request.setAttribute("msg","信息修改成功");
                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteJiaShans")
    public String deleteJiaShans(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteJiaShansSubmit")
    public String deleteJiaShansSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] js_id) throws Exception{
        if (js_id==null){
            return dataToList(request);
        }
        List<JiaShan> old = new ArrayList<JiaShan>();
        for (int i=0;i<js_id.length;i++){
            old.add(jiaShanService.findJiaShanById(Integer.parseInt(js_id[i])));
        }
        jiaShanService.deleteJiaShansByIds(js_id);
        for (JiaShan jiaShan :old){
            logService.insertLog("删除",jiaShan.getJs_block(),"假山表",jiaShan.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addJiaShan")
    public String addJiaShan(HttpServletRequest request, HttpServletResponse response,
                                      Model model,JiaShan jiaShan) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = jiaShan.getJs_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            jiaShanService.insertJiaShan(jiaShan);
            logService.insertLog("添加",jiaShan.getJs_block(),"假山表",jiaShan.toString());
            request.setAttribute("msg","添加假山成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            jiaShanService.insertJiaShan(jiaShan);
        logService.insertLog("添加",jiaShan.getJs_block(),"假山表",jiaShan.toString());
        request.setAttribute("msg","添加假山信息成功");
        return dataToList(request);
    }
}
