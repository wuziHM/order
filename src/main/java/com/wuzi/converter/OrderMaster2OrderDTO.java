package com.wuzi.converter;

import com.wuzi.dataobject.OrderMaster;
import com.wuzi.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-30 14:14
 * @description:
 **/
public class OrderMaster2OrderDTO {



    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster, orderDTO);

//        List<OrderDetail> detail = orderDetailRepository.findByOrderId(orderId);

        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {

        return orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());

    }
}
