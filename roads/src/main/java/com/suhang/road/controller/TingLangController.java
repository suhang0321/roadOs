package com.suhang.road.controller;

import com.suhang.road.po.LuDeng;
import com.suhang.road.po.TingLang;
import com.suhang.road.po.User;
import com.suhang.road.povo.LuDengVo;
import com.suhang.road.povo.TingLangVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LuDengService;
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
@RequestMapping("/tinglang")
public class TingLangController {
    @Autowired
    private TingLangService tingLangService;
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
        List<TingLang>tingLangs = tingLangService.findTingLangsByBlock(block,pc,ps);
        TingLangVo tingLangVo = new TingLangVo();
        tingLangVo.setUrl(getUrl(request));
        tingLangVo.setPs(ps);
        tingLangVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = tingLangService.findCountAll();
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            if (tingLangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            request.setAttribute("user",user);

            return "/jsps/project/tinglang/tinglanglist.jsp";
        }else {
            int tr = tingLangService.findCountByBlock(block);
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            request.setAttribute("user",user);

            return "/jsps/project/tinglang/tinglanglist.jsp";
        }
    }
    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<TingLang>tingLangs = tingLangService.findTingLangsByBlock(block,pc,ps);
        TingLangVo tingLangVo = new TingLangVo();
        tingLangVo.setUrl(getUrl(request));
        tingLangVo.setPs(ps);
        tingLangVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = tingLangService.findCountAll();
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            if (tingLangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            return "/jsps/project/tinglang/tinglangedit.jsp";
        }else {
            int tr = tingLangService.findCountByBlock(block);
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            return "/jsps/project/tinglang/tinglangedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<TingLang>tingLangs = tingLangService.findTingLangsByBlock(block,pc,ps);
        TingLangVo tingLangVo = new TingLangVo();
        tingLangVo.setUrl(getUrl(request));
        tingLangVo.setPs(ps);
        tingLangVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = tingLangService.findCountAll();
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            if (tingLangs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            return "/jsps/project/tinglang/tinglangdelete.jsp";
        }else {
            int tr = tingLangService.findCountByBlock(block);
            tingLangVo.setTr(tr);
            tingLangVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", tingLangs);
            request.setAttribute("pb",tingLangVo);
            return "/jsps/project/tinglang/tinglangdelete.jsp";
        }
    }



    @RequestMapping("/findtinglangsByBlock")
    public String findtinglangsByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editTingLangs")
    public String editTingLangs(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editTingLangsSubmit")
    public String editTingLangsSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, TingLangVo tingLangVo) throws Exception {
        List<TingLang> tingLangs = tingLangVo.getItemsList();
        if (tingLangs==null){
            return dataToList(request);
        }
        List<TingLang> old = new ArrayList<TingLang>();
        for (TingLang tingLang:tingLangs){
            old.add(tingLangService.findTingLangById(tingLang.getLt_id()));
        }
        tingLangService.updateTingLangList(tingLangs);
        for (TingLang tingLangold :old){
            for (TingLang tinglangnew:tingLangs){
                if (tingLangold.getLt_id()==tinglangnew.getLt_id()&&!tingLangold.toString().equals(tinglangnew
                .toString())){
                    logService.insertLog("修改后",tinglangnew.getLt_block(),"亭廊表",tinglangnew.toString());
                    logService.insertLog("修改前",tingLangold.getLt_block(),"亭廊表",tingLangold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteTingLangs")
    public String deleteTingLangs(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteTingLangsSubmit")
    public String deleteTingLangsSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] lt_id) throws Exception{
        if (lt_id==null){
            return dataToList(request);
        }
        List<TingLang>old = new ArrayList<TingLang>();
        for (int i = 0;i<lt_id.length;i++){
            old.add(tingLangService.findTingLangById(Integer.parseInt(lt_id[i])));
        }
        tingLangService.deleteTingLangsByIds(lt_id);
        for (TingLang tingLang :old){
            logService.insertLog("删除",tingLang.getLt_block(),"亭廊表",tingLang.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addTingLang")
    public String addTingLang(HttpServletRequest request, HttpServletResponse response,
                                      Model model,TingLang tingLang) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = tingLang.getLt_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            tingLangService.insertTingLang(tingLang);
            logService.insertLog("添加",tingLang.getLt_block(),"亭廊表",tingLang.toString());
            request.setAttribute("msg","添加庭廊成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            tingLangService.insertTingLang(tingLang);
        logService.insertLog("添加",tingLang.getLt_block(),"亭廊表",tingLang.toString());
        request.setAttribute("msg","添加庭廊信息成功");
        return dataToList(request);
    }
}
