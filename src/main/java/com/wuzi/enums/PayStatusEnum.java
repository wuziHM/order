package com.wuzi.enums;

import lombok.Getter;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 14:30
 * @description:
 **/
@Getter
public enum PayStatusEnum implements CodeEnum {

        WAIT(0, "等待支付"),
        SUCCESS(1, "支付成功"),
        ;

        private Integer code;

        private String message;

        PayStatusEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
}
