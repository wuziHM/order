package com.wuzi.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuzi.dataobject.OrderDetail;
import com.wuzi.dto.OrderDTO;
import com.wuzi.enums.ResultEnum;
import com.wuzi.exception.OrderException;
import com.wuzi.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-04-02 15:47
 * @description:
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {


    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO dto = new OrderDTO();
        Gson gson = new Gson();

        dto.setBuyerPhone(orderForm.getPhone());
        dto.setBuyerName(orderForm.getName());
        dto.setBuyerAddress(orderForm.getAddress());
        dto.setBuyerOpenid(orderForm.getOpenid());


        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误,String={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), ResultEnum.PARAM_ERROR.getMessage());
        }

        dto.setOrderDetails(orderDetailList);
        dto.setBuyerOpenid(orderForm.getOpenid());
        return dto;
    }

}
