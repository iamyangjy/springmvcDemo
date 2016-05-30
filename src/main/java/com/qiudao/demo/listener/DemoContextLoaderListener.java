package com.qiudao.demo.listener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;

/**
 * Created by hdfs on 2016/5/30.
 */
public class DemoContextLoaderListener extends ContextLoaderListener{

    private static int licState = 0;
    public DemoContextLoaderListener(){
        super();
        System.out.println("调用自己的ContextListener:DemoContextLoaderListener");
    }

    public DemoContextLoaderListener(WebApplicationContext context){
        super(context);
        System.out.println("调用自己的ContextListener:DemoContextLoaderListener, 参数为:webApplicationContext");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("上下文初始化，ContextInitialized");
        if(licState == 0){
            System.out.println("调用上下文destroy");
            contextDestroyed(event);
        }else {
            super.contextInitialized(event);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("destroy上下文配置");
        super.contextDestroyed(event);
    }
}
