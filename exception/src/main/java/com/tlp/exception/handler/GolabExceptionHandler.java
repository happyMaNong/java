package com.tlp.exception.handler;

import com.tlp.exception.entity.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: GolabExceptionHandler
 * @description: 全局异常处理类
 * @author: tianlingpeng
 * @create: 2019-05-27 16:06
 */
@ControllerAdvice
public class GolabExceptionHandler {

    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }

    /**
     *  拦截MyException类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Map<String,Object> MyExceptionHandler(MyException e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", e.getCode());
        result.put("respMsg", e.getErrorMsg());
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }


    @ExceptionHandler({RuntimeException.class})
    public Map<String,Object> RunTimeExceptionHandler(RuntimeException e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "102");
        result.put("respMsg", e.getMessage());
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }

}
