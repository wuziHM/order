package com.wuzi.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 14:40
 * @description: CREATE TABLE `order_detail` (
 * `detail_id` varchar(32) NOT NULL,
 * `order_id` varchar(32) NOT NULL,
 * `product_id` varchar(32) NOT NULL,
 * `product_name` varchar(64) NOT NULL COMMENT '商品名称',
 * `product_price` decimal(8,2) NOT NULL COMMENT '商品价格',
 * `product_quantity` int(11) NOT NULL COMMENT '商品数量',
 * `product_icon` varchar(512) DEFAULT NULL COMMENT '商品小图',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`detail_id`),
 * KEY `idx_order_id` (`order_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表'
 **/
@Entity
@Data
public class OrderDetail {

    /**
     * 订单详情id
     */
    @Id
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private int productQuantity;


    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    private Date updateTime;


}
