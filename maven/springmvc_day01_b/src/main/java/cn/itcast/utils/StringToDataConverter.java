package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDataConverter implements Converter<String, Date> {
    @Override
    public Date convert(String value ) {
        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        try {
            if (value.contains("/")) {
                simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }

             date = simpleDateFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
