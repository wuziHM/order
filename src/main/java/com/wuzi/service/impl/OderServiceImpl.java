package com.wuzi.service.impl;

import com.wuzi.dataobject.OrderMaster;
import com.wuzi.dto.OrderDTO;
import com.wuzi.enums.OrderStatusEnum;
import com.wuzi.enums.PayStatusEnum;
import com.wuzi.repository.OrderDetailRepository;
import com.wuzi.repository.OrderMasterRepository;
import com.wuzi.service.OrderService;
import com.wuzi.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @program: order
 * @author: HM
 * @create: 2019-02-23 11:41
 * @description:
 **/
@Service
public class OderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        /**
         * 1、 TODO: 19/2/23  查询商品信息
         2、计算总价
         3、扣库存
         4、订单入库
         */
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return null;
    }
}
