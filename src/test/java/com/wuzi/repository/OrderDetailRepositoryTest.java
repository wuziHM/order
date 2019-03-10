package com.wuzi.repository;

import com.wuzi.OrderApplicationTests;
import com.wuzi.dataobject.OrderDetail;
import com.wuzi.utils.KeyUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @program: order
 * @author: HM
 * @create: 2019-03-10 12:18
 * @description:
 **/
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.genUniqueKey());
        orderDetail.setOrderId("000999");
        orderDetail.setProductIcon("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=20b7522c4c4a20a425133495f13bf347/dc54564e9258d109d07fa38cd258ccbf6c814d6b.jpg");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(32.80));
        orderDetail.setProductQuantity(2);
        OrderDetail t = orderDetailRepository.save(orderDetail);
        assertNotNull(t);
    }

}