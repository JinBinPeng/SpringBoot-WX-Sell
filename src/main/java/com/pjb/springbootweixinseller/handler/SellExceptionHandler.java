package com.pjb.springbootweixinseller.handler;

import com.pjb.springbootweixinseller.config.ProjectUrlConfig;
import com.pjb.springbootweixinseller.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {

    private final ProjectUrlConfig projectUrlConfig;
    @Autowired
    public SellExceptionHandler(ProjectUrlConfig projectUrlConfig) {
        this.projectUrlConfig = projectUrlConfig;
    }

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }
}
