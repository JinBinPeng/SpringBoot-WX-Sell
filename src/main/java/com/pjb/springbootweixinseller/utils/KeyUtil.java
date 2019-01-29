package com.pjb.springbootweixinseller.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class KeyUtil {
    private KeyUtil(){

    }
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
