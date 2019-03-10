package com.wuzi.utils;

import com.wuzi.enums.CodeEnum;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 17:55
 * @description:
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> tClass){
        for (T each: tClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
