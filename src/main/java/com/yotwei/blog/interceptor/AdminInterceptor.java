package com.yotwei.blog.interceptor;

import com.yotwei.blog.dto.ResponseBean;
import com.yotwei.blog.enity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YotWei on 2018/3/12.
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object o) throws
            Exception {

        /*
        if (httpRequest.getRequestURI().equals("/admin/login")) {
            System.out.println("login");
            return true;
        }

        //need login
        Admin admin = (Admin) httpRequest.getSession().getAttribute("admin");
        if (admin == null) {
            httpResponse.getWriter().write(ResponseBean.error("No login").toString());
            return false;
        }
        */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
