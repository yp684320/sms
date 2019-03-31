package com.itheima.utils;

import com.itheima.domain.Category;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONUtil {
    private static final JsonConfig initConfig = new JsonConfig();
    static{
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}), true);
    }
    public static JsonConfig getConfig(){
        return  initConfig;
    }
    public static JsonConfig getConfigWithDateProcessor(){
        return  getConfigWithDateProcessor("yyyy-MM-dd HH:mm:ss");
    }
    public static JsonConfig getConfigWithDateProcessor(String pattern){
        JsonConfig config = new JsonConfig();
        DateValueProcessor dateValueProcessor = new DateValueProcessor(pattern);
        config.registerJsonValueProcessor(Date.class, dateValueProcessor);
        return config;
    }

    private static class DateValueProcessor implements JsonValueProcessor {
        private DateFormat dateFormat;


        public DateValueProcessor(String datePattern) {
            dateFormat = new SimpleDateFormat(datePattern);
        }
        //processArrayValue:处理值并返回一个合适的JSON值。
        @Override
        public Object processArrayValue(Object value, JsonConfig jsonConfig) {
            return process(value);
        }
        //processObjectValue:处理值并返回一个合适的JSON值。
        @Override
        public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
            return process(value);
        }

        private Object process(Object value) {
            return dateFormat.format((Date) value);
        }


    }



}
