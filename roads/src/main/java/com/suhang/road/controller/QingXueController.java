package com.suhang.road.controller;

import com.suhang.road.mapper.QingXueMapper;
import com.suhang.road.po.QingXue;
import com.suhang.road.po.TingChe;
import com.suhang.road.po.User;
import com.suhang.road.povo.QingXueVo;
import com.suhang.road.povo.TingCheVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.QingXueService;
import com.suhang.road.service.TingCheService;
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
@RequestMapping("/qingxue")
public class QingXueController {
    @Autowired
    private QingXueService qingXueService;
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
        List<QingXue> qingXues = qingXueService.findQingXuesByBlock(block,pc,ps);
        QingXueVo qingXueVo = new QingXueVo();
        qingXueVo.setUrl(getUrl(request));
        qingXueVo.setPs(ps);
        qingXueVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = qingXueService.findCountAll();
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            if (qingXues.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qingxue/qingxuelist.jsp";
        }else {
            int tr = qingXueService.findCountByBlock(block);
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qingxue/qingxuelist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QingXue> qingXues = qingXueService.findQingXuesByBlock(block,pc,ps);
        QingXueVo qingXueVo = new QingXueVo();
        qingXueVo.setUrl(getUrl(request));
        qingXueVo.setPs(ps);
        qingXueVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qingXueService.findCountAll();
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            if (qingXues.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            return "forward:/jsps/project/qingxue/qingxueedit.jsp";
        }else {
            int tr = qingXueService.findCountByBlock(block);
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            return "forward:/jsps/project/qingxue/qingxueedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QingXue> qingXues = qingXueService.findQingXuesByBlock(block,pc,ps);
        QingXueVo qingXueVo = new QingXueVo();
        qingXueVo.setUrl(getUrl(request));
        qingXueVo.setPs(ps);
        qingXueVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qingXueService.findCountAll();
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            if (qingXues.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qingxue/qingxuedelete.jsp";
        }else {
            int tr = qingXueService.findCountByBlock(block);
            qingXueVo.setTr(tr);
            qingXueVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qingXues);
            request.setAttribute("pb",qingXueVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qingxue/qingxuedelete.jsp";
        }
    }




    @RequestMapping("/findQingXuesByBlock")
    public String findQingXuesByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editQingXues")
    public String editQingXues(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editQingXuesSubmit")
    public String editQingXuesSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, QingXueVo qingXueVo) throws Exception {
        List<QingXue> qingXues = qingXueVo.getItemsList();
        if (qingXues==null){
            return dataToList(request);
        }
        List<QingXue> old = new ArrayList<QingXue>();
        for (QingXue qingXue:qingXues){
            old.add(qingXueService.findQingXueById(qingXue.getQx_id()));
        }
        qingXueService.updateQingXueList(qingXues);
        for (QingXue qingXueold :old){
            for (QingXue qingXuenew :qingXues){
                if (qingXuenew.getQx_id()==qingXueold.getQx_id()&&!qingXueold.toString().equals(qingXuenew.toString())){
                    logService.insertLog("修改后",qingXuenew.getQx_block(),"道路清雪表",qingXuenew.toString());
                    logService.insertLog("修改前",qingXueold.getQx_block(),"道路清雪表",qingXueold.toString());
                    request.setAttribute("msg","信息修改成功");
                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteQingXues")
    public String deleteQingXues(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteQingXuesSubmit")
    public String deleteQingXuesSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] qx_id) throws Exception{
        if (qx_id==null){
            return dataToList(request);
        }
        List<QingXue> old = new ArrayList<QingXue>();
        for (int i=0;i<qx_id.length;i++){
            old.add(qingXueService.findQingXueById(Integer.parseInt(qx_id[i])));
        }
        qingXueService.deleteQingXuesByIds(qx_id);
        for (QingXue qingXue:old){
            logService.insertLog("删除",qingXue.getQx_block(),"道路清雪表",qingXue.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addQingXue")
    public String addQingXue(HttpServletRequest request, HttpServletResponse response,
                                      Model model,QingXue qingXue) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = qingXue.getQx_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            qingXueService.insertQingXue(qingXue);
            logService.insertLog("添加",qingXue.getQx_block(),"道路清雪表",qingXue.toString());
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加道路清雪信息成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            qingXueService.insertQingXue(qingXue);
        logService.insertLog("添加",qingXue.getQx_block(),"道路清雪表",qingXue.toString());
        request.setAttribute("msg","添加道路清雪信息成功");
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
