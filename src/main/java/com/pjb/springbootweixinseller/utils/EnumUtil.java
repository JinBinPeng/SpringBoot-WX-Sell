package com.pjb.springbootweixinseller.utils;

import com.pjb.springbootweixinseller.enums.CodeEnum;


public class EnumUtil {

    private EnumUtil(){

    }
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
