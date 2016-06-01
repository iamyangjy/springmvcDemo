package com.qiudao.demo.mvcModule.converter;

import com.qiudao.demo.domain.PhoneNumberModel;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by hdfs on 2016/6/1.
 */
public class PhoneNumberToStringConverter implements Converter<PhoneNumberModel, String> {
    @Override
    public String convert(PhoneNumberModel phoneNumberModel) {
        if(phoneNumberModel == null){
            return "";
        };

        return phoneNumberModel.getAreaCode() +
                "-" + phoneNumberModel.getPhoneNumber();
    }
}
