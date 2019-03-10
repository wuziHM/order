package com.wuzi.utils;

import java.util.Random;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 18:19
 * @description:
 **/
public class KeyUtil {


    /**
     * 生成唯一的主键
     * 时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }


}

