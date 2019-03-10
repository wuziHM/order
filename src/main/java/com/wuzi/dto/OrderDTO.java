package com.wuzi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuzi.dataobject.OrderDetail;
import com.wuzi.enums.OrderStatusEnum;
import com.wuzi.enums.PayStatusEnum;
import com.wuzi.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: order
 * @author: HM
 * @create: 2019-02-23 11:38
 * @description:
 **/
@Data
public class OrderDTO {


//    @Transient

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;


    //    @JsonSerialize(using = Date2LongSerializer.class)
    @JsonIgnore
    private Date createTime;

    //    @JsonSerialize(using = Date2LongSerializer.class)
    @JsonIgnore
    private Date updateTime;

    /**
     * 这里赋值一个初始值，json格式里就是[]   格式统一 前端比较好解析
     */
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
