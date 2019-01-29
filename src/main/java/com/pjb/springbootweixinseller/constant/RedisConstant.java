package com.pjb.springbootweixinseller.constant;

/**
 * redis常量
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200; //2小时
}
