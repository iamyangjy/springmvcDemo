package com.qiudao.demo.test.mvcModule;

import com.qiudao.demo.domain.PhoneNumberModel;
import com.qiudao.demo.mvcModule.converter.StringToPhoneNumberConvert;
import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * Created by hdfs on 2016/6/1.
 */
public class ConverterTest {

    @Test
    public void testStringToPhoneNumber(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToPhoneNumberConvert());
        String phoneNumberStr = "010-12345678";
        PhoneNumberModel phoneNumberModel = conversionService.convert(phoneNumberStr, PhoneNumberModel.class);
        System.out.println(phoneNumberModel.toString());



    }

}
