package com.suhang.road.interceptor;

import com.suhang.road.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        /**
         * index初始页面，login六大管理员登陆界面，captcha验证码验证方法
         * 放行
         */
        if (url.indexOf("index")>=0||url.indexOf("login")>=0||url.indexOf("captcha")>=0){
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("sessionUser");
        /**
         * 用户不为空 表示已登陆状态，可以访问全部页面
         */
        if (user!=null){
            return true;
        }
        /**
         * 下面代码为拦截部分
         * 返回false
         */
        httpServletRequest.setAttribute("msg","您还没有登陆，请先登陆后操作");
        httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
