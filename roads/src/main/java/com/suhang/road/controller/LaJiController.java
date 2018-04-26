package com.suhang.road.controller;

import com.suhang.road.po.GuoPiXiang;
import com.suhang.road.po.LaJi;
import com.suhang.road.po.User;
import com.suhang.road.povo.GuoPiXiangVo;
import com.suhang.road.povo.LaJiVo;
import com.suhang.road.service.GuoPiXiangService;
import com.suhang.road.service.LaJiService;
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
@RequestMapping("/laji")
public class LaJiController {
    @Autowired
    private LaJiService laJiService;
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
        List<LaJi>laJis = laJiService.findLaJisByBlock(block,pc,ps);
        LaJiVo laJiVo = new LaJiVo();
        laJiVo.setUrl(getUrl(request));
        laJiVo.setPs(ps);
        laJiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = laJiService.findCountAll();
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            if (laJis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            request.setAttribute("user",user);

            return "/jsps/project/laji/lajilist.jsp";
        }else {
            int tr = laJiService.findCountByBlock(block);
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            request.setAttribute("user",user);

            return "/jsps/project/laji/lajilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LaJi>laJis = laJiService.findLaJisByBlock(block,pc,ps);
        LaJiVo laJiVo = new LaJiVo();
        laJiVo.setUrl(getUrl(request));
        laJiVo.setPs(ps);
        laJiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = laJiService.findCountAll();
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            if (laJis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            return "/jsps/project/laji/lajiedit.jsp";
        }else {
            int tr = laJiService.findCountByBlock(block);
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            return "/jsps/project/laji/lajiedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<LaJi>laJis = laJiService.findLaJisByBlock(block,pc,ps);
        LaJiVo laJiVo = new LaJiVo();
        laJiVo.setUrl(getUrl(request));
        laJiVo.setPs(ps);
        laJiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = laJiService.findCountAll();
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            if (laJis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            return "/jsps/project/laji/lajidelete.jsp";
        }else {
            int tr = laJiService.findCountByBlock(block);
            laJiVo.setTr(tr);
            laJiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", laJis);
            request.setAttribute("pb",laJiVo);
            return "/jsps/project/laji/lajidelete.jsp";
        }
    }


    @RequestMapping("/findLaJisByBlock")
    public String findLaJisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editLaJis")
    public String editLaJis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editLaJisSubmit")
    public String editLaJisSubmit(HttpServletRequest request, HttpServletResponse response,
                                  Model model, LaJiVo laJiVo) throws Exception {
        List<LaJi>laJis = laJiVo.getItemsList();
        if (laJis==null){
            return dataToList(request);
        }
        List<LaJi> old = new ArrayList<LaJi>();
        for (LaJi laJi:laJis){
            old.add(laJiService.findLaJiById(laJi.getLj_id()));
        }
        laJiService.updateLaJiList(laJis);
        for (LaJi laJiold:old){
            for (LaJi laJinew :laJis){
                if (laJiold.getLj_id()==laJinew.getLj_id()&&!laJiold.toString().equals(laJinew.toString())){
                    logService.insertLog("修改后",laJinew.getLj_block(),"垃圾桶表",laJinew.toString());
                    logService.insertLog("修改前",laJiold.getLj_block(),"垃圾桶表",laJiold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteLaJis")
    public String deleteLaJis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteLaJisSubmit")
    public String deleteLaJisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] lj_id) throws Exception{
        if (lj_id==null){
            return dataToList(request);
        }
        List<LaJi> old = new ArrayList<LaJi>();
        for (int i =0;i<lj_id.length;i++){
            old.add(laJiService.findLaJiById(Integer.parseInt(lj_id[i])));
        }
        laJiService.deleteLaJisByIds(lj_id);
        for (LaJi laJi:old){
            logService.insertLog("删除",laJi.getLj_block(),"垃圾桶表",laJi.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addLaJi")
    public String addLaJi(HttpServletRequest request, HttpServletResponse response,
                                      Model model,LaJi laJi) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = laJi.getLj_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            laJiService.insertLaJi(laJi);
            logService.insertLog("添加",laJi.getLj_block(),"垃圾桶表",laJi.toString());
            request.setAttribute("msg","添加垃圾桶成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
           return dataToList(request);
        }else
            laJiService.insertLaJi(laJi);
        logService.insertLog("添加",laJi.getLj_block(),"垃圾桶表",laJi.toString());

        request.setAttribute("msg","添加垃圾箱信息成功");
        return dataToList(request);
    }
}
