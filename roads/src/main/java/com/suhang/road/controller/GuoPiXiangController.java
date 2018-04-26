package com.suhang.road.controller;

import com.suhang.road.po.GuoPiXiang;
import com.suhang.road.po.User;
import com.suhang.road.po.ZiXingJia;
import com.suhang.road.povo.GuoPiXiangVo;
import com.suhang.road.povo.ZiXingJiaVo;
import com.suhang.road.service.GuoPiXiangService;
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
@RequestMapping("/guopixiang")
public class GuoPiXiangController {
    @Autowired
    private GuoPiXiangService guoPiXiangService;
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
        List<GuoPiXiang>guoPiXiangs = guoPiXiangService.findGuoPiXiangsByBlock(block,pc,ps);
        GuoPiXiangVo guoPiXiangVo = new GuoPiXiangVo();
        guoPiXiangVo.setUrl(getUrl(request));
        guoPiXiangVo.setPs(ps);
        guoPiXiangVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = guoPiXiangService.findCountAll();
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            if (guoPiXiangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            request.setAttribute("user",user);

            return "/jsps/project/guopixiang/guopixianglist.jsp";
        }else {
            int tr = guoPiXiangService.findCountByBlock(block);
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            request.setAttribute("user",user);

            return "/jsps/project/guopixiang/guopixianglist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<GuoPiXiang>guoPiXiangs = guoPiXiangService.findGuoPiXiangsByBlock(block,pc,ps);
        GuoPiXiangVo guoPiXiangVo = new GuoPiXiangVo();
        guoPiXiangVo.setUrl(getUrl(request));
        guoPiXiangVo.setPs(ps);
        guoPiXiangVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = guoPiXiangService.findCountAll();
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            if (guoPiXiangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            return "/jsps/project/guopixiang/guopixiangedit.jsp";
        }else {
            int tr = guoPiXiangService.findCountByBlock(block);
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            return "/jsps/project/guopixiang/guopixiangedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<GuoPiXiang>guoPiXiangs = guoPiXiangService.findGuoPiXiangsByBlock(block,pc,ps);
        GuoPiXiangVo guoPiXiangVo = new GuoPiXiangVo();
        guoPiXiangVo.setUrl(getUrl(request));
        guoPiXiangVo.setPs(ps);
        guoPiXiangVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = guoPiXiangService.findCountAll();
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            if (guoPiXiangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            return "/jsps/project/guopixiang/guopixiangdelete.jsp";
        }else {
            int tr = guoPiXiangService.findCountByBlock(block);
            guoPiXiangVo.setTr(tr);
            guoPiXiangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", guoPiXiangs);
            request.setAttribute("pb",guoPiXiangVo);
            return "/jsps/project/guopixiang/guopixiangdelete.jsp";
        }
    }


    @RequestMapping("/findGuoPiXiangsByBlock")
    public String findGuoPiXiangsByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editGuoPiXiangs")
    public String editGuoPiXiangs(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
        return dataToEdit(request);
    }


    @RequestMapping("/editGuoPiXiangsSubmit")
    public String editGuoPiXiangsSubmit(HttpServletRequest request, HttpServletResponse response,
                                        Model model, GuoPiXiangVo guoPiXiangVo) throws Exception {
        List<GuoPiXiang> guoPiXiangs = guoPiXiangVo.getItemsList();
        if (guoPiXiangs==null){
            return dataToList(request);
        }
        List<GuoPiXiang> old = new ArrayList<GuoPiXiang>();
        for (GuoPiXiang guoPiXiang :guoPiXiangs){
            old.add(guoPiXiangService.findGuoPiXiangById(guoPiXiang.getPx_id()));
        }
        guoPiXiangService.updateGuoPiXiangList(guoPiXiangs);
        for (GuoPiXiang guoPiXiangold :old){
            for (GuoPiXiang guoPiXiangnew :guoPiXiangs){
                if (guoPiXiangold.getPx_id()==guoPiXiangnew.getPx_id()&&!guoPiXiangold.toString().equals(guoPiXiangnew.toString())){
                    logService.insertLog("修改后",guoPiXiangnew.getPx_block(),"果皮箱表",guoPiXiangnew.toString());
                    logService.insertLog("修改前",guoPiXiangold.getPx_block(),"果皮箱表",guoPiXiangold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteGuoPiXiangs")
    public String deleteGuoPiXiangs(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
       return dataToDelete(request);
    }


    @RequestMapping("/deleteGuoPiXiangsSubmit")
    public String deleteGuoPiXiangsSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] px_id) throws Exception{
        if (px_id==null){
            return dataToList(request);
        }
        List<GuoPiXiang> old = new ArrayList<GuoPiXiang>();
        for (int i=0;i<px_id.length;i++){
            old.add(guoPiXiangService.findGuoPiXiangById(Integer.parseInt(px_id[i])));
        }
        guoPiXiangService.deleteGuoPiXiangsByIds(px_id);
        for (GuoPiXiang guoPiXiang:old){
            logService.insertLog("删除",guoPiXiang.getPx_block(),"果皮箱表",guoPiXiang.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addGuoPiXiang")
    public String addGuoPiXiang(HttpServletRequest request, HttpServletResponse response,
                                      Model model,GuoPiXiang guoPiXiang) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = guoPiXiang.getPx_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            guoPiXiangService.insertGuoPiXiang(guoPiXiang);
            logService.insertLog("添加",guoPiXiang.getPx_block(),"果皮箱表",guoPiXiang.toString());
            request.setAttribute("msg","添加果皮箱成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            guoPiXiangService.insertGuoPiXiang(guoPiXiang);
        logService.insertLog("添加",guoPiXiang.getPx_block(),"果皮箱表",guoPiXiang.toString());

        request.setAttribute("msg","添加果皮箱信息成功");
        return dataToList(request);
    }
}
