package com.wuzi.dto;

import lombok.Data;

/**
 * @program: product
 * @author: HM
 * @create: 2019-04-23 21:28
 * @description:
 **/
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
