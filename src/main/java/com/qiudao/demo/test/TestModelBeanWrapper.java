package com.qiudao.demo.test;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hdfs on 2016/6/1.
 */
public class TestModelBeanWrapper {

    public static void main(String[] args){
        TestModel testModel = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(testModel);
        bw.setPropertyValue("good", "on");
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        bw.setPropertyValue("birth", "2016-01-01");


        System.out.println(bw.getPropertyValue("birth"));
    }
}
