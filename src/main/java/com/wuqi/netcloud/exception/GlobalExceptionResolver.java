package com.wuqi.netcloud.exception;

import com.wuqi.netcloud.commons.ResultWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        String message = "未知系统错误";
        int code = 400;
        if (e instanceof JsonResultException) {
            JsonResultException ex = (JsonResultException) e;
            code = ex.getCode();
            message = ex.getMessage();
            mv.setView(new MappingJackson2JsonView());
            mv.addObject(ResultWrapper.error(code, message));
        } else {
            mv.setView(new MappingJackson2JsonView());
            mv.addObject(ResultWrapper.error(code, message));
        }
        return mv;
    }
}
