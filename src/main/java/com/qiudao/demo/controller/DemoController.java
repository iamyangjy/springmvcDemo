package com.qiudao.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiudao.demo.domain.Demo;
import com.qiudao.demo.domain.FormatterModel;
import com.qiudao.demo.domain.PhoneNumberModel;
import com.qiudao.demo.mvcModule.formatter.PhoneNumber;
import com.qiudao.demo.service.DemoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.beans.PropertyEditor;
import java.util.Date;

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
    public Demo getDemo(@PathVariable(value = "id") int id, HttpServletRequest request) throws Exception {
        FormattingConversionServiceFactoryBean formattingConversionServiceFactoryBean;
        ConfigurableWebBindingInitializer configurableWebBindingInitializer;
        logger.info("id:" + id);
        return demoService.queryDemo(id);
    }

    @RequestMapping(value = "/qiu", method = RequestMethod.POST)
    @ResponseBody
    public Demo queryDemo(@RequestBody String body) throws Exception {
        logger.info("jkjkjk");
        return new Demo();
    }

    @RequestMapping(value = "/getPhoneNumber/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public Demo queryPhone(@PathVariable(value = "phone") PhoneNumberModel phoneNumberModel) throws Exception {
        logger.info(phoneNumberModel.toString());
        return new Demo();
    }

    @RequestMapping(value = "/format2")
    @ResponseBody
    public Demo format(@PhoneNumber @RequestParam("phoneNumber") PhoneNumberModel phoneNumberModel,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") long date){
        logger.info(phoneNumberModel.toString());
        //logger.info(date.toString());
        logger.info(date);
        return new Demo();
    }

    @RequestMapping(value = "/format1")
    @ResponseBody
    public Demo format2(@ModelAttribute("model")FormatterModel formatterModel){
        AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter;
        logger.info(formatterModel.toString());
        return new Demo();
    }

}
