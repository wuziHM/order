package com.wuzi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
public interface ProductClient {

    //表示访问product下面的 msg方法
    @GetMapping("/seller/order/msg")
    String productMsg();

}
