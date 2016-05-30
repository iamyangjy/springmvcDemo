package com.qiudao.demo.service;

import com.qiudao.demo.domain.Demo;
import com.qiudao.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hdfs on 2016/5/30.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public Demo queryDemo(int id) throws Exception{
        return demoMapper.query(id);
    }

}
