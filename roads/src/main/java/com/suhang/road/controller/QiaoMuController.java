package com.suhang.road.controller;

import com.suhang.road.po.QiaoMu;
import com.suhang.road.po.User;
import com.suhang.road.po.XingDaoShu;
import com.suhang.road.povo.QiaoMuVo;
import com.suhang.road.povo.XingDaoShuVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.QiaoMuService;
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
@RequestMapping("/qiaomu")
public class QiaoMuController {
    @Autowired
    private QiaoMuService qiaoMuService;
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
        List<QiaoMu>qiaoMus = qiaoMuService.findQiaoMusByBlock(block,pc,ps);
        QiaoMuVo qiaoMuVo = new QiaoMuVo();
        qiaoMuVo.setUrl(getUrl(request));
        qiaoMuVo.setPs(ps);
        qiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = qiaoMuService.findCountAll();
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            if (qiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/qiaomu/qiaomulist.jsp";
        }else {
            int tr = qiaoMuService.findCountByBlock(block);
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            request.setAttribute("user",user);

            return "/jsps/project/qiaomu/qiaomulist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QiaoMu>qiaoMus = qiaoMuService.findQiaoMusByBlock(block,pc,ps);
        QiaoMuVo qiaoMuVo = new QiaoMuVo();
        qiaoMuVo.setUrl(getUrl(request));
        qiaoMuVo.setPs(ps);
        qiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qiaoMuService.findCountAll();
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            if (qiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            return "/jsps/project/qiaomu/qiaomuedit.jsp";
        }else {
            int tr = qiaoMuService.findCountByBlock(block);
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            return "/jsps/project/qiaomu/qiaomuedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QiaoMu>qiaoMus = qiaoMuService.findQiaoMusByBlock(block,pc,ps);
        QiaoMuVo qiaoMuVo = new QiaoMuVo();
        qiaoMuVo.setUrl(getUrl(request));
        qiaoMuVo.setPs(ps);
        qiaoMuVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qiaoMuService.findCountAll();
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            if (qiaoMus.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            return "/jsps/project/qiaomu/qiaomudelete.jsp";
        }else {
            int tr = qiaoMuService.findCountByBlock(block);
            qiaoMuVo.setTr(tr);
            qiaoMuVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiaoMus);
            request.setAttribute("pb",qiaoMuVo);
            return "/jsps/project/qiaomu/qiaomudelete.jsp";
        }
    }


    @RequestMapping("/findQiaoMusByBlock")
    public String findQiaoMusByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
       return dataToList(request);
    }


    @RequestMapping("/editQiaoMus")
    public String editQiaoMus(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editQiaoMusSubmit")
    public String editQiaoMusSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, QiaoMuVo qiaoMuVo) throws Exception {
        List<QiaoMu> qiaoMus = qiaoMuVo.getItemsList();
        if (qiaoMus==null){
            return dataToList(request);
        }
        List<QiaoMu> old = new ArrayList<QiaoMu>();
        for (QiaoMu qiaoMu:qiaoMus){
            old.add(qiaoMuService.findQiaoMuById(qiaoMu.getLs_id()));
        }
        qiaoMuService.updateQiaoMuList(qiaoMus);
        for (QiaoMu qiaoMuold :old){
            for (QiaoMu qiaoMunew :qiaoMus){
                if (qiaoMuold.getLs_id()==qiaoMunew.getLs_id()&&!qiaoMuold.toString().equals(qiaoMunew.toString())) {
                    logService.insertLog("修改后", qiaoMunew.getLs_block(), "常绿乔木表", qiaoMunew.toString());
                    logService.insertLog("修改前", qiaoMuold.getLs_block(), "常绿乔木表", qiaoMuold.toString());
                    request.setAttribute("msg", "信息修改成功");
                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteQiaoMus")
    public String deleteQiaoMus(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
        return dataToDelete(request);
    }


    @RequestMapping("/deleteQiaoMusSubmit")
    public String deleteQiaoMusSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] ls_id) throws Exception{
        if (ls_id==null){
            return dataToList(request);
        }
        List<QiaoMu> old = new ArrayList<QiaoMu>();
        for (int i =0;i<ls_id.length;i++){
            old.add(qiaoMuService.findQiaoMuById(Integer.parseInt(ls_id[i])));
        }
        qiaoMuService.deleteQiaoMusByIds(ls_id);
        for (QiaoMu qiaoMu:old){
            logService.insertLog("删除",qiaoMu.getLs_block(),"常绿乔木表",qiaoMu.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addQiaoMu")
    public String addQiaoMu(HttpServletRequest request, HttpServletResponse response,
                                      Model model, QiaoMu qiaoMu) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = qiaoMu.getLs_block();
        String typeform = qiaoMu.getLs_type();
        String kindform = qiaoMu.getLs_kind();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")||typeform.equals("error")||kindform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            qiaoMuService.insertQiaoMu(qiaoMu);
            logService.insertLog("添加",qiaoMu.getLs_block(),"常绿乔木表",qiaoMu.toString());
            request.setAttribute("msg","添加校园常绿乔木成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
            return dataToList(request);
        }else
            qiaoMuService.insertQiaoMu(qiaoMu);
        logService.insertLog("添加",qiaoMu.getLs_block(),"常绿乔木表",qiaoMu.toString());
        request.setAttribute("msg","添加校园常绿乔木信息成功");
        return dataToList(request);
    }
}
