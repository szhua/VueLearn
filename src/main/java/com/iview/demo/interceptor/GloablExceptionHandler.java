package com.iview.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author szhua
 * @Description:demo==
 * @Date 2019/3/22
 **/
@ControllerAdvice
public class GloablExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        String msg=e.getMessage() ;
        if (msg==null || msg.equals("")){
            msg ="服务器出错";
        }
        JSONObject jsonObject = new JSONObject() ;
        jsonObject.put("message",msg) ;
        return  jsonObject ;
    }

}
