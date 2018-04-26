package com.suhang.road.controller;

import com.suhang.road.po.ShuiXi;
import com.suhang.road.po.User;
import com.suhang.road.po.ZhenGui;
import com.suhang.road.povo.ShuiXiVo;
import com.suhang.road.povo.ZhenGuiVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.ShuiXiService;
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
@RequestMapping("/zhengui")
public class ZhenGuiController {
    @Autowired
    private ZhenGuiService zhenGuiService;
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
        List<ZhenGui>zhenGuis = zhenGuiService.findZhenGuisByBlock(block,pc,ps);
        ZhenGuiVo zhenGuiVo = new ZhenGuiVo();
        zhenGuiVo.setUrl(getUrl(request));
        zhenGuiVo.setPs(ps);
        zhenGuiVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = zhenGuiService.findCountAll();
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            if (zhenGuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            request.setAttribute("user",user);

            return "/jsps/project/zhengui/zhenguilist.jsp";
        }else {
            int tr = zhenGuiService.findCountByBlock(block);
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            request.setAttribute("user",user);

            return "/jsps/project/zhengui/zhenguilist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ZhenGui>zhenGuis = zhenGuiService.findZhenGuisByBlock(block,pc,ps);
        ZhenGuiVo zhenGuiVo = new ZhenGuiVo();
        zhenGuiVo.setUrl(getUrl(request));
        zhenGuiVo.setPs(ps);
        zhenGuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = zhenGuiService.findCountAll();
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            if (zhenGuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            return "/jsps/project/zhengui/zhenguiedit.jsp";
        }else {
            int tr = zhenGuiService.findCountByBlock(block);
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            return "/jsps/project/zhengui/zhenguiedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<ZhenGui>zhenGuis = zhenGuiService.findZhenGuisByBlock(block,pc,ps);
        ZhenGuiVo zhenGuiVo = new ZhenGuiVo();
        zhenGuiVo.setUrl(getUrl(request));
        zhenGuiVo.setPs(ps);
        zhenGuiVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = zhenGuiService.findCountAll();
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            if (zhenGuis.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            return "/jsps/project/zhengui/zhenguidelete.jsp";
        }else {
            int tr = zhenGuiService.findCountByBlock(block);
            zhenGuiVo.setTr(tr);
            zhenGuiVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", zhenGuis);
            request.setAttribute("pb",zhenGuiVo);
            return "/jsps/project/zhengui/zhenguidelete.jsp";
        }
    }


    @RequestMapping("/findZhenGuisByBlock")
    public String findZhenGuisByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editZhenGuis")
    public String editZhenGuis(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editZhenGuisSubmit")
    public String editZhenGuisSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, ZhenGuiVo zhenGuiVo) throws Exception {
        List<ZhenGui>zhenGuis = zhenGuiVo.getItemsList();
        if (zhenGuis==null){
            return dataToList(request);
        }
        List<ZhenGui> old = new ArrayList<ZhenGui>();
        for (ZhenGui zhenGui:zhenGuis){
            old.add(zhenGuiService.findZhenGuiById(zhenGui.getZg_id()));
        }
        for (ZhenGui zhenGuiold :old){
            for (ZhenGui zhenGuinew :zhenGuis){
                if (zhenGuiold.getZg_id()==zhenGuinew.getZg_id()&&!zhenGuiold.toString().equals(zhenGuinew.toString())){
                    logService.insertLog("修改后",zhenGuinew.getZg_block(),"珍贵树种表",zhenGuinew.toString());
                    logService.insertLog("修改前",zhenGuiold.getZg_block(),"珍贵树种表",zhenGuiold.toString());
                    zhenGuiService.updateZhenGuiList(zhenGuis);

                }
            }
        }
        request.setAttribute("msg","信息修改成功");
        return dataToList(request);
    }


    @RequestMapping("/deleteZhenGuis")
    public String deleteZhenGuis(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteZhenGuisSubmit")
    public String deleteZhenGuisSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] zg_id) throws Exception{
        if (zg_id==null){
            return dataToList(request);
        }
        List<ZhenGui> old = new ArrayList<ZhenGui>();
        for (int i=0;i<zg_id.length;i++){
            old.add(zhenGuiService.findZhenGuiById(Integer.parseInt(zg_id[i])));
        }
        zhenGuiService.deleteZhenGuisByIds(zg_id);
        for (ZhenGui zhenGui:old){
            logService.insertLog("删除",zhenGui.getZg_block(),"珍贵树种表",zhenGui.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addZhenGui")
    public String addZhenGui(HttpServletRequest request, HttpServletResponse response,
                                      Model model,ZhenGui zhenGui) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = zhenGui.getZg_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            zhenGuiService.insertZhenGui(zhenGui);
            logService.insertLog("添加",zhenGui.getZg_block(),"珍贵树种表",zhenGui.toString());
            request.setAttribute("msg","添加珍贵树种成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            zhenGuiService.insertZhenGui(zhenGui);
        logService.insertLog("添加",zhenGui.getZg_block(),"珍贵树种表",zhenGui.toString());
        request.setAttribute("msg","添加珍贵树种信息成功");
        return dataToList(request);
    }
}
