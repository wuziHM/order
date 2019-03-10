package com.wuzi.service;

import com.wuzi.dto.OrderDTO;

/**
 * @program: order
 * @author: HM
 * @create: 2019-02-23 11:37
 * @description:
 **/
public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
