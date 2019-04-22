package com.wuzi.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: product
 * @author: HM
 * @create: 2019-02-22 14:52
 * @description:
 **/
@Table(name = "product_info")
@Data
@Entity
@DynamicUpdate
public class ProductInfo {



    @Id
    private String productId;

    /**
     * 名字
     */
    private String productName;


    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态，0正常，1下架，2售罄
     */
    private Integer productStatus;


    /**
     * 类目编号
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

//    @JsonIgnore
//    public ProductStatusEnum getProductStatusEnum(){
//        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
//    }

}
