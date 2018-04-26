package com.suhang.road.controller;

import com.google.code.kaptcha.Constants;
import com.suhang.road.po.User;
import com.suhang.road.po.UserCustom;
import com.suhang.road.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserCustom userCustom, HttpServletRequest request, HttpServletResponse response,
                        Model model) throws Exception {
        Map<String, String> errors = new HashMap<>();
        String loginname = userCustom.getLoginname();
        if (loginname == null || loginname.trim().isEmpty()) {
            errors.put("loginname", "用户名不能为空");
        } else if (loginname.length() < 3 || loginname.length() > 20) {
            errors.put("loginname", "用户名长度应该在3到20位之间");
        }
        String loginpass = userCustom.getLoginpass();
        if (loginpass == null || loginpass.trim().isEmpty()) {
            errors.put("loginpass", "密码不能为空");
        } else if (loginpass.length() < 3 || loginpass.length() > 20) {
            errors.put("loginpass", "密码长度应该在3到20位之间");
        }
        String verifyCode = userCustom.getVerifyCode();
        String original = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (verifyCode == null || verifyCode.trim().isEmpty()) {
            errors.put("verifyCode", "验证码不能为空");
        } else if (!verifyCode.equalsIgnoreCase(original)) {
            errors.put("verifyCode", "验证码输入错误");
        }
        String block = userCustom.getBlock();
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            model.addAttribute("user", userCustom);
            if (block.equals("admin")) {
                return "forward:/jsps/user/adminlogin.jsp";
            } else if (block.equals("center") ) {
                return "forward:/jsps/user/centerlogin.jsp";
            } else if (block.equals("east")) {
                return "forward:/jsps/user/eastlogin.jsp";
            } else if (block.equals("nanhu")) {
                return "forward:/jsps/user/nanhulogin.jsp";
            } else if (block.equals("north")) {
                return "forward:/jsps/user/northlogin.jsp";
            } else if (block.equals("west")) {
                return "forward:/jsps/user/westlogin.jsp";
            }else if (block.equals("mingde")){
                return "forward:/jsps/user/mingdelogin.jsp";
            }else  if (block.equals("admin2")){
                return "forward:/jsps/user/admin2login.jsp";
            }
        }
        /**
         * 提交的用户名密码无误，并且验证码准确,执行下边代码，查询数据库，登陆
         */
        User userDb = userService.findUserByNamePassAndBlock(userCustom);
        if (userDb == null) {
            request.setAttribute("msg", "用户名密码错误或所选校区有误");
            model.addAttribute("user", userCustom);
            //根据不同的登陆入口，返回到不同的登陆界面
            if (block.equals("admin")) {
                return "forward:/jsps/user/adminlogin.jsp";
            } else if (block.equals("center")) {
                return "forward:/jsps/user/centerlogin.jsp";
            } else if (block.equals("east")) {
                return "forward:/jsps/user/eastlogin.jsp";
            } else if (block.equals("nanhu")) {
                return "forward:/jsps/user/nanhulogin.jsp";
            } else if (block.equals("north")) {
                return "forward:/jsps/user/northlogin.jsp";
            } else if (block.equals("west")) {
                return "forward:/jsps/user/westlogin.jsp";
            }else if (block.equals("mingde")){
                return "forward:/jsps/user/mingdelogin.jsp";
            }else if (block.equals("admin2")){
                return "forward:/jsps/user/admin2login.jsp";
            } else {
                request.setAttribute("code","error");
                request.setAttribute("msg","请选择正确的合法校区登陆");
                return "/jsps/msg.jsp";
            }
        }else {//查到用户数据信息，可以正常登陆执行下边代码
            request.getSession().setAttribute("sessionUser", userDb);//把数据库中的用户信息存到session中
            String loginnameDb = userDb.getLoginname();
            String blockDb = userDb.getBlock();
            loginnameDb = URLEncoder.encode("loginnameDb", "utf-8");
            Cookie cookie = new Cookie("loginnameDb", loginnameDb);
            cookie.setMaxAge(60 * 60 * 24 * 10);//保存10天
            response.addCookie(cookie);
            if (block.equals("admin")){
                return "/adminjsps/admin/main.jsp";
            }
            request.setAttribute("block",blockDb);
            return "/jsps/main.jsp";
        }

    }
    @RequestMapping("/quick")
    public String quick(HttpServletResponse response,HttpServletRequest request
            ,Model model)throws Exception{
        request.getSession().invalidate();
        return "redirect:/index.jsp";
    }
    @RequestMapping("/findUsersAll")
    public String findUsersAll (HttpServletResponse response, HttpServletRequest request,
                                Model model)throws Exception{
        List<User> users = userService.findUsersAll();
        request.setAttribute("userList",users);
        return "/adminjsps/admin/manage/manage.jsp";
    }

    @RequestMapping("/getUid")
    public  String getUid(HttpServletResponse response,HttpServletRequest request,
                          Model model)throws Exception{
        String uid = request.getParameter("uid");
        request.setAttribute("uid",uid);
        return "forward:/adminjsps/admin/pwd/pwd.jsp";
    }

    @RequestMapping("/updateNameAndPass")
    public String updateNameAndPass(HttpServletRequest request,HttpServletResponse response,
                                    Model model,UserCustom userCustom)throws Exception{
        /**
         * 对表单数据进行校验
         */
        String uid = request.getParameter("uid");
        Map<String ,String> errors = new HashMap<String,String>();
       String loginname = userCustom.getLoginname();
        if (loginname==null||loginname.trim().isEmpty()){
            errors.put("loginpass","用户名不能为空");
        }else if (loginname.length()<3||loginname.length()>20){
            errors.put("loginpass","请输入3到20位的用户密码");
        }

        String newloginpass = userCustom.getNewloginpass();
        if (newloginpass==null||newloginpass.trim().isEmpty()){
            errors.put("newloginpass","新密码不能为空");
        }else if (newloginpass.length()<3||newloginpass.length()>20){
            errors.put("newloginpass","新密码长度应该在3到20个字符之间！");
        }

        String reloginpass = userCustom.getReloginpass();
        if (reloginpass==null||reloginpass.trim().isEmpty()){
            errors.put("reloginpass","确认密码不能为空！");
        }else if (!reloginpass.equals(newloginpass)){
            errors.put("reloginpass","确认密码与新密码不相同！");
        }

        String verifyCode = userCustom.getVerifyCode();
        String original = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (verifyCode==null||verifyCode.trim().isEmpty()){
            errors.put("verifyCode","验证码不能为空");
        }else if (!verifyCode.equalsIgnoreCase(original)){
            errors.put("verifyCode","验证码输入错误！请核对后重新输入");
        }

        if (errors.size()>0){
            request.setAttribute("errors",errors);
            model.addAttribute("user",userCustom);
            request.setAttribute("msg","输入信息有误");
            return "forward:/adminjsps/admin/pwd/pwd.jsp";
        }

        /**
         * 判断已登陆用户权限
         */
        User userInSession = (User)request.getSession().getAttribute("sessionUser");
        if (userInSession==null||!userInSession.getBlock().equals("admin")){
            request.setAttribute("msg","您还没有登陆或没有权限进行此操作");
            return "/index.jsp";
        }
        userService.updateNameAndPassByUid(uid,loginname,newloginpass);
        request.setAttribute("msg","恭喜您修改密码成功");
        request.setAttribute("code","success");
        return "/adminjsps/admin/msg.jsp";
    }
}
