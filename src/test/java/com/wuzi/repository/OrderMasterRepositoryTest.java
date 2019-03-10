package com.wuzi.repository;

import com.wuzi.OrderApplicationTests;
import com.wuzi.dataobject.OrderMaster;
import com.wuzi.enums.OrderStatusEnum;
import com.wuzi.enums.PayStatusEnum;
import com.wuzi.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * @program: order
 * @author: HM
 * @create: 2019-03-10 12:09
 * @description:
 **/
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtil.genUniqueKey());
        orderMaster.setBuyerName("猴哥");
        orderMaster.setBuyerPhone("13000112233");
        orderMaster.setBuyerAddress("中山大学");
        orderMaster.setBuyerOpenid("1101001");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster t = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(t != null);
    }
}