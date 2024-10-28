package org.example;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.Map;

public class InfoDataListener implements ReadListener{

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        ReadListener.super.onException(exception, context);
    }

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        String a="";

        Map map= (Map) o;
        ((Map<?, ?>) o).clear();
        ((Map<String, String>) o).put("name","zhang");
        ((Map<String, String>) o).put("age","12");       String str= JSON.toJSONString(o);
        Info info= (Info) JSON.toJavaObject(str,Info.class);
        String as="";




        Info entity = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            entity = mapper.readValue(str, Info.class);



            System.out.println(entity.getAge());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }





    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHead(Map headMap, AnalysisContext context) {

    }



}
