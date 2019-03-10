package com.wuzi.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-04-02 15:35
 * @description:
 **/
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必须填写")
    private String name;


    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必须填写")
    private String phone;


    /**
     * 买家地址
     */
    @NotEmpty(message = "收货地址必须填写")
    private String address;



    /**
     * 买家openid
     */
    @NotEmpty(message = "openid必须填写")
    private String openid;



    @ApiModelProperty(value = "购物车信息")
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
