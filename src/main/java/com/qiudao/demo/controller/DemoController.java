package com.qiudao.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiudao.demo.domain.Demo;
import com.qiudao.demo.service.DemoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hdfs on 2016/5/30.
 */

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    private static final Logger logger = LogManager.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/obj/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Demo getDemo(@PathVariable(value = "id") int id, HttpServletRequest request) throws Exception{
        //org.springframework.web.servlet.mvc.Controller
        logger.info("id:" + id);

        ServletContext servletContext = request.getServletContext();
        //JSONObject jsonObject = JSON.parseObject(body);
        //int id = jsonObject.getInteger("id");
        return demoService.queryDemo(id);
    }

    @RequestMapping(value = "/qiu", method = RequestMethod.POST)
    @ResponseBody
    public Demo queryDemo(@RequestBody String body) throws Exception{
        logger.info("jkjkjk");
        return new Demo();
    }

}
