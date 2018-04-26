package com.suhang.road.controller;

import com.suhang.road.po.Log;
import com.suhang.road.povo.LogVo;
import com.suhang.road.service.LogService;
import com.suhang.road.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {
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


    @RequestMapping("/findLogsAll")
    public String findLogsAll(HttpServletRequest request, HttpServletResponse response,
                              Model model)throws Exception{
        int pc = getPc(request);
        int ps = ConstantUtil.AMOUNTLOG_EACH_PAGE;
        int tr = logService.findLogCountAll();
        int tp = getTp(tr,ps);
        List<Log> logs = logService.findLogsAll(pc,ps);
        LogVo logVo = new LogVo();
        logVo.setUrl(getUrl(request));
        logVo.setPs(ps);
        logVo.setPc(pc);
        logVo.setTr(tr);
        logVo.setTp(tp);
        request.setAttribute("pb",logVo);
        request.setAttribute("itemsList",logs);
        return "forward:/adminjsps/admin/log/loglist.jsp";
    }

    @RequestMapping("/findLogsByOperation")
    public String findLogsByOperation(HttpServletRequest request, HttpServletResponse response,
                              Model model)throws Exception{
        String l_opertion = request.getParameter("l_operation");
        int pc = getPc(request);
        int ps = ConstantUtil.AMOUNTLOG_EACH_PAGE;
        int tr = logService.findCountByOperation(l_opertion);
        int tp = getTp(tr,ps);
        List<Log> logs = logService.findLogsByOperation(l_opertion,pc,ps);
        LogVo logVo = new LogVo();
        logVo.setUrl(getUrl(request));
        logVo.setPs(ps);
        logVo.setPc(pc);
        logVo.setTr(tr);
        logVo.setTp(tp);
        request.setAttribute("pb",logVo);
        request.setAttribute("itemsList",logs);
        return "forward:/adminjsps/admin/log/loglist.jsp";
    }

    @RequestMapping("/findLogsByMulty")
    public String findLogsByMulty(HttpServletRequest request, HttpServletResponse response,
                                      Model model)throws Exception{
        String l_operation = request.getParameter("l_operation");
        String l_block = request.getParameter("l_block");
        String l_table = request.getParameter("l_table");
        int pc = getPc(request);
        int ps = ConstantUtil.AMOUNTLOG_EACH_PAGE;
        int tr = logService.findCountByMulty(l_operation,l_block,l_table);
        int tp = getTp(tr,ps);
        List<Log> logs = logService.findLogsByMulty(l_operation,l_block,l_table,pc,ps);
        LogVo logVo = new LogVo();
        logVo.setUrl(getUrl(request));
        logVo.setPs(ps);
        logVo.setPc(pc);
        logVo.setTr(tr);
        logVo.setTp(tp);
        request.setAttribute("pb",logVo);
        request.setAttribute("itemsList",logs);
        return "forward:/adminjsps/admin/log/loglist.jsp";
    }
}
