package com.qiudao.demo.mvcModule.formatter;

import com.qiudao.demo.domain.PhoneNumberModel;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hdfs on 2016/6/1.
 */
public class PhoneNumberFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<PhoneNumber> {

    private static final Set<Class<?>> FILED_TYPES;
    //private static final PhoneNumberFormatter formatter = new PhoneNumberFormatter();
    static {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(PhoneNumberModel.class);
        FILED_TYPES = set;
    }

    @Override
    public Set<Class<?>> getFieldTypes() {
        return FILED_TYPES;
    }

    @Override
    public Printer<?> getPrinter(PhoneNumber phoneNumber, Class<?> aClass) {
        return new PhoneNumberFormatter();
    }

    @Override
    public Parser<?> getParser(PhoneNumber phoneNumber, Class<?> aClass) {
        return new PhoneNumberFormatter();
    }
}
