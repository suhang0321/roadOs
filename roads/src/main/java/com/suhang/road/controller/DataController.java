package com.suhang.road.controller;

import com.suhang.road.util.DataUnixUtil;
import com.suhang.road.util.DataUtil;
import com.suhang.road.util.FileUtil;
import com.suhang.road.util.FileWinUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/data")
public class DataController {
/**
 * unix系统下的方法
 */


    @RequestMapping("/beifen")
    public String beifen(HttpServletRequest request, HttpServletResponse response,
                         Model model)throws Exception{
        String file = new DataUnixUtil().exportSql();
        request.setAttribute("msg","数据备份成功,已成功在服务器保存备份文件："+file);
        request.setAttribute("code","success");
        return "forward:/adminjsps/admin/msg.jsp";
    }

    @RequestMapping("/huanyuan")
    public String huanyuan(HttpServletRequest request, HttpServletResponse response,
                         Model model)throws Exception{
        ArrayList<String> files = new FileUtil().getFiles("/tmp/export/");
        request.setAttribute("itemsList",files);
        return "forward:/adminjsps/admin/data/huanyuanlist.jsp";
    }


    @RequestMapping("/huanyuanSubmit")
    public String huanyuanSubmit(HttpServletRequest request, HttpServletResponse response,
                           Model model)throws Exception{
        String filename = request.getParameter("huanyuanfile");
        String filenameall = filename + ".sql";
        new DataUnixUtil().importSql(filenameall);
        String date = filename.substring(0,14);
        request.setAttribute("msg","数据还原成功，数据更新为"+date+"的数据");
        request.setAttribute("code","success");
        return "forward:/adminjsps/admin/msg.jsp";
    }



    /**
     * windows系统下的方法（服务器）
     */

//    @RequestMapping("/beifen")
//    public String beifen(HttpServletRequest request, HttpServletResponse response,
//                         Model model)throws Exception{
//        String file = new DataUtil().export();
//        request.setAttribute("msg","数据备份成功,已成功在服务器保存备份文件："+file);
//        request.setAttribute("code","success");
//        return "forward:/adminjsps/admin/msg.jsp";
//    }
//
//    @RequestMapping("/huanyuan")
//    public String huanyuan(HttpServletRequest request, HttpServletResponse response,
//                           Model model)throws Exception{
//        ArrayList<String> files =new FileWinUtil().getFiles("D:\\sql");
//        request.setAttribute("itemsList",files);
//        return "forward:/adminjsps/admin/data/huanyuanlist.jsp";
//    }
//
//
//    @RequestMapping("/huanyuanSubmit")
//    public String huanyuanSubmit(HttpServletRequest request, HttpServletResponse response,
//                                 Model model)throws Exception{
//        String filename = request.getParameter("huanyuanfile");
//        String filenameall = filename + ".sql";
//        new DataUtil().importSql(filenameall);
//        String date = filename.substring(0,14);
//        request.setAttribute("msg","数据还原成功，数据更新为"+date+"的数据");
//        request.setAttribute("code","success");
//        return "forward:/adminjsps/admin/msg.jsp";
//    }


}
