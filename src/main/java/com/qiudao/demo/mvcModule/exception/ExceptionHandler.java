package com.qiudao.demo.mvcModule.exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hdfs on 2016/5/30.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static Logger logger = LogManager.getLogger(ExceptionHandler.class);

    @Override
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();

      /*  System.out.println( "【抛出异常】--异常路径为：" +
        		httpServletRequest.getServletPath() + "\n【异常信息】--" + e.getMessage() ) ;*/
        String message = null;

        JSONObject resJson = new JSONObject();
        resJson.put("code", 103);
        resJson.put("desc", message);
        resJson.put("content", "");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/plain");
        try {
            httpServletResponse.getWriter().write(resJson.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        logger.error(e.getMessage());
        //  return new ModelAndView("exceptionView");

        return new ModelAndView();
    }
}
