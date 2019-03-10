package com.wuzi.controller;

import com.wuzi.converter.OrderForm2OrderDTOConverter;
import com.wuzi.dto.OrderDTO;
import com.wuzi.enums.ResultEnum;
import com.wuzi.exception.OrderException;
import com.wuzi.form.OrderForm;
import com.wuzi.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @program: order
 * @author: HM
 * @create: 2019-02-23 11:36
 * @description:
 **/
@Api(description = "订单部分的接口")
@RestController
@Slf4j
@RequestMapping("/seller/order")
public class OrderController {

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车信息是空的");
            throw new OrderException(ResultEnum.CART_EMPTY.getCode(), ResultEnum.CART_EMPTY.getMessage());
        }

        return null;
    }

}
