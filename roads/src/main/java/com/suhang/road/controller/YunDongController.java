package com.suhang.road.controller;

import com.suhang.road.po.LvLi;
import com.suhang.road.po.User;
import com.suhang.road.po.YunDong;
import com.suhang.road.povo.LvLiVo;
import com.suhang.road.povo.YunDongVo;
import com.suhang.road.service.LogService;
import com.suhang.road.service.LvLiService;
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
@RequestMapping("/yundong")
public class YunDongController {
    @Autowired
    private YunDongService yunDongService;
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
        List<YunDong> yunDongs = yunDongService.findYunDongsByBlock(block,pc,ps);
        YunDongVo yunDongVo = new YunDongVo();
        yunDongVo.setUrl(getUrl(request));
        yunDongVo.setPs(ps);
        yunDongVo.setPc(getPc(request));
        if (block.equals("admin")||block.equals("admin2")){
            int tr = yunDongService.findCountAll();
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            if (yunDongs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/yundong/yundonglist.jsp";
        }else {
            int tr = yunDongService.findCountByBlock(block);
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            request.setAttribute("user",user);

            return "forward:/jsps/project/yundong/yundonglist.jsp";
        }
    }

    private String dataToEdit(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<YunDong> yunDongs = yunDongService.findYunDongsByBlock(block,pc,ps);
        YunDongVo yunDongVo = new YunDongVo();
        yunDongVo.setUrl(getUrl(request));
        yunDongVo.setPs(ps);
        yunDongVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = yunDongService.findCountAll();
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            if (yunDongs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            return "forward:/jsps/project/yundong/yundongedit.jsp";
        }else {
            int tr = yunDongService.findCountByBlock(block);
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            return "forward:/jsps/project/yundong/yundongedit.jsp";
        }
    }

    private String dataToDelete(HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String block = user.getBlock();
        int pc= getPc(request);
        int ps = ConstantUtil.AMOUNT_EACH_PAGE;
        List<YunDong> yunDongs = yunDongService.findYunDongsByBlock(block,pc,ps);
        YunDongVo yunDongVo = new YunDongVo();
        yunDongVo.setUrl(getUrl(request));
        yunDongVo.setPs(ps);
        yunDongVo.setPc(getPc(request));
        if (block.equals("admin")){
            int tr = yunDongService.findCountAll();
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            if (yunDongs.isEmpty()){
                request.setAttribute("msg", "当前该项记录为空");
            }
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            return "forward:/jsps/project/yundong/yundongdelete.jsp";
        }else {
            int tr = yunDongService.findCountByBlock(block);
            yunDongVo.setTr(tr);
            yunDongVo.setTp(getTp(tr,ps));
            request.setAttribute("itemsList", yunDongs);
            request.setAttribute("pb",yunDongVo);
            return "forward:/jsps/project/yundong/yundongdelete.jsp";
        }
    }




    @RequestMapping("/findYunDongsByBlock")
    public String findYunDongsByBlock(HttpServletRequest request, HttpServletResponse response
                                     ) throws Exception {
      return dataToList(request);
    }


    @RequestMapping("/editYunDongs")
    public String editYunDongs(HttpServletRequest request, HttpServletResponse response,
                             Model model) throws Exception {
       return dataToEdit(request);
    }


    @RequestMapping("/editYunDongsSubmit")
    public String editYunDongsSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Model model, YunDongVo yunDongVo) throws Exception {
        List<YunDong> yunDongs = yunDongVo.getItemsList();
        if (yunDongs==null){
            return dataToList(request);
        }
        List<YunDong> old = new ArrayList<YunDong>();
        for (YunDong yunDong :yunDongs){
            old.add(yunDongService.findYunDongById(yunDong.getYd_id()));
        }
        yunDongService.updateYunDongList(yunDongs);
        for (YunDong yunDongold :old){
            for (YunDong yunDongnew :yunDongs){
                if (yunDongold.getYd_id()==yunDongnew.getYd_id()&&!yunDongold.toString().equals(yunDongnew.toString())){
                    logService.insertLog("修改后",yunDongnew.getYd_block(),"运动场表",yunDongnew.toString());
                    logService.insertLog("修改前",yunDongold.getYd_block(),"运动场表",yunDongold.toString());
                    request.setAttribute("msg","信息修改成功");

                }
            }
        }
        return dataToList(request);
    }


    @RequestMapping("/deleteYunDongs")
    public String deleteYunDongs(HttpServletRequest request, HttpServletResponse response,
                                   Model model) throws Exception{
      return dataToDelete(request);
    }


    @RequestMapping("/deleteYunDongsSubmit")
    public String deleteYunDongsSubmit(HttpServletRequest request, HttpServletResponse response,
                                Model model, String[] yd_id) throws Exception{
        if (yd_id==null){
            return dataToList(request);
        }
        List<YunDong> old = new ArrayList<YunDong>();
        for (int i=0;i<yd_id.length;i++){
            old.add(yunDongService.findYunDongById(Integer.parseInt(yd_id[i])));
        }
        yunDongService.deleteYunDongsByIds(yd_id);
        for (YunDong yunDong:old){
            logService.insertLog("删除",yunDong.getYd_block(),"运动场表",yunDong.toString());
        }
        request.setAttribute("msg","删除数据成功");
        return dataToList(request);
    }


    @RequestMapping("/addYunDong")
    public String addYunDong(HttpServletRequest request, HttpServletResponse response,
                                      Model model,YunDong yunDong) throws Exception{
        User user = (User) request.getSession().getAttribute("sessionUser");
        String blockuser = user.getBlock();
        String blockform = yunDong.getYd_block();
        if (blockform==null){
            return dataToList(request);
        }
        if(blockform.equals("error")){
            request.setAttribute("msg","下拉条内容不能不选");
           return dataToList(request);
        }else if (blockuser.equals("admin")){
            yunDongService.insertYunDong(yunDong);
            logService.insertLog("添加",yunDong.getYd_block(),"运动场表",yunDong.toString());
            System.out.println("=========================================================管理员添加信息成功========================================");
            request.setAttribute("msg","添加运动场信息成功");
            return dataToList(request);
        }else if (!blockuser.equals(blockform)){
            request.setAttribute("msg","只能添加本校区的数据");
          return dataToList(request);
        }else
            yunDongService.insertYunDong(yunDong);
        logService.insertLog("添加",yunDong.getYd_block(),"运动场表",yunDong.toString());

        request.setAttribute("msg","添加运动场信息成功");
        System.out.println("=====================================普通用户添加信息成功======================================");
        return dataToList(request);
    }
}
