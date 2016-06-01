package com.qiudao.demo.mvcModule.formatter;

import com.qiudao.demo.domain.PhoneNumberModel;
import org.omg.CORBA.MARSHAL;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.IllegalFormatCodePointException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hdfs on 2016/6/1.
 */
public class PhoneNumberFormatter implements Formatter<PhoneNumberModel> {

    Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

    @Override
    public PhoneNumberModel parse(String s, Locale locale) throws ParseException {
        if (!StringUtils.hasLength(s)) {
            return null;
        }
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            PhoneNumberModel phoneNumberModel = new PhoneNumberModel();
            phoneNumberModel.setAreaCode(matcher.group(1));
            phoneNumberModel.setPhoneNumber(matcher.group(2));
            return phoneNumberModel;
        } else {
            throw new IllegalArgumentException(String.format("格式化失败，需要格式[010-12345678]，但格式是[%s]", s));
        }
    }

    @Override
    public String print(PhoneNumberModel phoneNumberModel, Locale locale) {
        if (phoneNumberModel == null) {
            return "";
        }
        return phoneNumberModel.getAreaCode() + "-" + phoneNumberModel.getPhoneNumber();
    }
}
