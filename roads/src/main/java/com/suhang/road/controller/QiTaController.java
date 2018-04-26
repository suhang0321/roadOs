package com.suhang.road.controller;

import com.suhang.road.mapper.QiTaMapper;
import com.suhang.road.po.QiTa;
import com.suhang.road.po.User;
import com.suhang.road.po.YunDong;
import com.suhang.road.povo.QiTaVo;
import com.suhang.road.povo.YunDongVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.QiTaService;
import com.suhang.road.service.YunDongService;
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
@RequestMapping("/qita")
public class QiTaController {
    @Autowired
    private QiTaService qiTaService;
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
        List<QiTa> qiTas = qiTaService.findQiTasByBlock(block,pc,ps);
        QiTaVo qiTaVo = new QiTaVo();
        qiTaVo.setUrl(getUrl(request));
        qiTaVo.setPs(ps);
        qiTaVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = qiTaService.findCountAll();
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            if (qiTas.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qita/qitalist.jsp";
        }else {
            int tr = qiTaService.findCountByBlock(block);
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/qita/qitalist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QiTa> qiTas = qiTaService.findQiTasByBlock(block,pc,ps);
        QiTaVo qiTaVo = new QiTaVo();
        qiTaVo.setUrl(getUrl(request));
        qiTaVo.setPs(ps);
        qiTaVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qiTaService.findCountAll();
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            if (qiTas.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            return "forward:/jsps/project/qita/qitaedit.jsp";
        }else {
            int tr = qiTaService.findCountByBlock(block);
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            return "forward:/jsps/project/qita/qitaedit.jsp";
        }
    }
    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<QiTa> qiTas = qiTaService.findQiTasByBlock(block,pc,ps);
        QiTaVo qiTaVo = new QiTaVo();
        qiTaVo.setUrl(getUrl(request));
        qiTaVo.setPs(ps);
        qiTaVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = qiTaService.findCountAll();
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            if (qiTas.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            return "forward:/jsps/project/qita/qitadelete.jsp";
        }else {
            int tr = qiTaService.findCountByBlock(block);
            qiTaVo.setTr(tr);
            qiTaVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", qiTas);
            request.setAttribute("pb",qiTaVo);
            return "forward:/jsps/project/qita/qitadelete.jsp";
        }
    }




    @RequestMapping("/findQiTasByBlock")
    public String findQiTasByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editQiTas")
    public String editQiTas(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editQiTasSubmit")
    public String editQiTasSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, QiTaVo qiTaVo) throws Exception {
        List<QiTa> qiTas = qiTaVo.getItemsList();
        if (qiTas ==null){
            return dataToList(request);
        }
        List<QiTa>old = new ArrayList<QiTa>();
        for (QiTa qiTa:qiTas){
            old.add(qiTaService.findQiTaById(qiTa.getQt_id()));
        }
        qiTaService.updateQiTaList(qiTas);
        for (QiTa qiTaold :old){
            for (QiTa qiTanew :qiTas){
                if (qiTaold.getQt_id()==qiTanew.getQt_id()&&!qiTaold.toString().equals(qiTanew.toString())){
                    logService.insertLog("修改后",qiTanew.getQt_block(),"其他类土地表",qiTanew.toString());
                    logService.insertLog("修改前",qiTaold.getQt_block(),"其他类土地表",qiTaold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteQiTss")
    public String deleteQiTss(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteQiTasSubmit")
    public String deleteQiTasSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] qt_id) throws Exception{
        if (qt_id==null){
            return dataToList(request);
        }
        List<QiTa> old = new ArrayList<QiTa>();
        for (int i=0;i<qt_id.length;i++){
            old.add(qiTaService.findQiTaById(Integer.parseInt(qt_id[i])));
        }
        qiTaService.deleteQiTasByIds(qt_id);
        for (QiTa qiTa:old){
            logService.insertLog("删除",qiTa.getQt_block(),"其他类土地表",qiTa.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addQiTa")
    public String addQiTa(HttpServletRequest request, HttpServletResponse response,
                                      Model model,QiTa qiTa) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = qiTa.getQt_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            qiTaService.insertQiTa(qiTa);
            logService.insertLog("添加",qiTa.getQt_block(),"其他类土地表",qiTa.toString());
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加其他类土地信息成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            qiTaService.insertQiTa(qiTa);
        request.setAttribute("msg","添加其他类土地信息成功");
        logService.insertLog("添加",qiTa.getQt_block(),"其他类土地表",qiTa.toString());
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
