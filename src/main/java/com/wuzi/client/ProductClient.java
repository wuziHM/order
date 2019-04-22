package com.wuzi.client;

import com.wuzi.dataobject.ProductInfo;
import org.hibernate.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @program: order
 * @author: HM
 * @create: 2019-03-20 11:47
 * @description:
 *
 * Feign也是用了ribbon做负载均衡
 *
 * 可以达到像调用本地方法的体验，但是实际中还是用的http请求
 **/
@FeignClient(name = "product")
@Component
public interface ProductClient {

    //表示访问product下面的 msg方法
    @GetMapping("/seller/order/msg")
    String productMsg();

    //表示访问product下面的 msg方法
    @PostMapping("/buyer/product/listForOrder")
    List<ProductInfo> productInfo(@RequestBody List<String> productId);

}
