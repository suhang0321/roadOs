package com.suhang.road.controller;

import com.suhang.road.po.LvDi;
import com.suhang.road.po.User;
import com.suhang.road.po.XingDaoShu;
import com.suhang.road.povo.LvDiVo;
import com.suhang.road.povo.XingDaoShuVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LvDiService;
import com.suhang.road.service.XingDaoService;
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
@RequestMapping("/xingdao")
public class XingDaoController {
    @Autowired
    private XingDaoService xingDaoService;
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
        List<XingDaoShu>xingDaoShus = xingDaoService.findXingDaosByBlock(block,pc,ps);
        XingDaoShuVo xingDaoShuVo = new XingDaoShuVo();
        xingDaoShuVo.setUrl(getUrl(request));
        xingDaoShuVo.setPs(ps);
        xingDaoShuVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = xingDaoService.findCountAll();
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            if (xingDaoShus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            request.setAttribute("user",user);

            return "/jsps/project/xingdao/xingdaolist.jsp";
        }else {
            int tr = xingDaoService.findCountByBlock(block);
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            request.setAttribute("user",user);

            return "/jsps/project/xingdao/xingdaolist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<XingDaoShu>xingDaoShus = xingDaoService.findXingDaosByBlock(block,pc,ps);
        XingDaoShuVo xingDaoShuVo = new XingDaoShuVo();
        xingDaoShuVo.setUrl(getUrl(request));
        xingDaoShuVo.setPs(ps);
        xingDaoShuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = xingDaoService.findCountAll();
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            if (xingDaoShus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            return "/jsps/project/xingdao/xingdaoedit.jsp";
        }else {
            int tr = xingDaoService.findCountByBlock(block);
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            return "/jsps/project/xingdao/xingdaoedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<XingDaoShu>xingDaoShus = xingDaoService.findXingDaosByBlock(block,pc,ps);
        XingDaoShuVo xingDaoShuVo = new XingDaoShuVo();
        xingDaoShuVo.setUrl(getUrl(request));
        xingDaoShuVo.setPs(ps);
        xingDaoShuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = xingDaoService.findCountAll();
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            if (xingDaoShus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            request.setAttribute("user",user);

            return "/jsps/project/xingdao/xingdaodelete.jsp";
        }else {
            int tr = xingDaoService.findCountByBlock(block);
            xingDaoShuVo.setTr(tr);
            xingDaoShuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", xingDaoShus);
            request.setAttribute("pb",xingDaoShuVo);
            request.setAttribute("user",user);

            return "/jsps/project/xingdao/xingdaodelete.jsp";
        }
    }


    @RequestMapping("/findXingDaosByBlock")
    public String findXingDaosByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editXingDaos")
    public String editXingDaos(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editXingDaosSubmit")
    public String editXingDaosSubmit(HttpServletRequest request, HttpServletResponse response,
                                     Model model, XingDaoShuVo xingDaoShuVo) throws Exception {
        List<XingDaoShu> xingDaoShus = xingDaoShuVo.getItemsList();
        if (xingDaoShus==null){
            return dataToList(request);
        }
        List<XingDaoShu> old = new ArrayList<XingDaoShu>();
        for (XingDaoShu xingDaoShu :xingDaoShus){
            old.add(xingDaoService.findXingDaoById(xingDaoShu.getXd_id()));
        }
        xingDaoService.updateXingDaoList(xingDaoShus);
        for (XingDaoShu xingDaoShuold :old){
            for (XingDaoShu xingDaoShunew :xingDaoShus){
                if (xingDaoShunew.getXd_id()==xingDaoShuold.getXd_id()&&!xingDaoShuold.toString().equals(xingDaoShunew.toString())){
                    logService.insertLog("修改后",xingDaoShunew.getXd_block(),"行道树表",xingDaoShunew.toString());
                    logService.insertLog("修改前",xingDaoShuold.getXd_block(),"行道树表",xingDaoShuold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteXingDaos")
    public String deleteXingDaos(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
        return dataToDelete(request);
    }


    @RequestMapping("/deleteXingDaosSubmit")
    public String deleteXingDaosSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] xd_id) throws Exception{
        if (xd_id==null){
            return dataToList(request);
        }
        List<XingDaoShu> old = new ArrayList<XingDaoShu>();
        for (int i=0;i<xd_id.length;i++){
            old.add(xingDaoService.findXingDaoById(Integer.parseInt(xd_id[i])));
        }
        xingDaoService.deleteXingDaosByIds(xd_id);
        for (XingDaoShu xingDaoShu :old){
            logService.insertLog("删除",xingDaoShu.getXd_block(),"行道树表",xingDaoShu.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addXingDao")
    public String addXingDao(HttpServletRequest request, HttpServletResponse response,
                                      Model model, XingDaoShu xingDaoShu) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = xingDaoShu.getXd_block();
        String dirctionform =xingDaoShu.getXd_direction();
        String kindform = xingDaoShu.getXd_kind();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||dirctionform.equals("error")||kindform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
            return dataToList(request);
        }else if (blockuser.equals("admin")){
            xingDaoService.insertXingDao(xingDaoShu);
            logService.insertLog("添加",xingDaoShu.getXd_block(),"行道树表",xingDaoShu.toString());
            request.setAttribute("msg","添加校园行道树成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            xingDaoService.insertXingDao(xingDaoShu);
        logService.insertLog("添加",xingDaoShu.getXd_block(),"行道树表",xingDaoShu.toString());
        request.setAttribute("msg","添加校园行道树信息成功");
        return dataToList(request);
    }
}
