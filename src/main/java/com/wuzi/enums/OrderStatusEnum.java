package com.wuzi.enums;

import lombok.Getter;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 14:30
 * @description:
 **/
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
