package com.wuzi.dataobject;

import com.wuzi.enums.OrderStatusEnum;
import com.wuzi.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 14:17
 * @description: CREATE TABLE `order_master` (
 * `order_id` varchar(32) NOT NULL,
 * `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
 * `buyer_phone` varchar(32) NOT NULL COMMENT '卖家电话',
 * `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
 * `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信的openid',
 * `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
 * `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认0新下单',
 * `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0是未支付',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`order_id`),
 * KEY `idx_buyer_openid` (`buyer_openid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表'
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 订单id
     */
    @Id
    private String orderId;
    /**
     * 购买人姓名
     */
    private String buyerName;

    /**
     * 购买人电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
