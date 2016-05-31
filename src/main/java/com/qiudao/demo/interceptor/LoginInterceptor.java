package com.qiudao.demo.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hdfs on 2016/5/31.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LogManager.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LoginInterceptor preHandler");
        String uri = request.getRequestURI();
        // 判断路径是登出还是登录验证，是这两者之一的话执行Controller中定义的方法
        if(uri.endsWith("/login/auth") || uri.endsWith("/login/out")) {
            return true;
        }

        // 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
        if(uri.endsWith("/login/") || uri.endsWith("/login")) {
            if(request.getSession() != null && request.getSession().getAttribute("loginUser") != null) {
                response.sendRedirect(request.getContextPath() + "/index");
            } else {
                return true;
            }
        }

        // 其他情况判断session中是否有key，有的话继续用户的操作
        if(request.getSession() != null && request.getSession().getAttribute("loginUser") != null) {
            return true;
        }

        // 最后的情况就是进入登录页面
        //response.sendRedirect(request.getContextPath() + "/login");
        return true;
        //return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor postHandler");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("LoginInterceptor afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
