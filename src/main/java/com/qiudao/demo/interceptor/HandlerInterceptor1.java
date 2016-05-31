package com.qiudao.demo.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hdfs on 2016/5/31.
 */
public class HandlerInterceptor1 extends HandlerInterceptorAdapter {
    private static Logger logger = LogManager.getLogger(HandlerInterceptor1.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("HandlerInterceptor1 preHandle");
        return true;
        //return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("HandlerInterceptor1 postHandle");
        //super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("HandlerInterceptor1 afterCompletion");
        //super.afterCompletion(request, response, handler, ex);
    }
}
