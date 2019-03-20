package com.wuzi.controller;

import com.wuzi.client.ProductClient;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: order
 * @author: HM
 * @create: 2019-02-23 19:06
 * @description:
 **/
@Api(description = "测试测试RestTemplate")
@Slf4j
@RestController
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

//        第三种方式（利用@LoadBalanced，可在restTemplate里使用应用名字）
        String response = restTemplate.getForObject("http://PRODUCT/seller/order/msg", String.class);


        log.info("response={}", response);

        return response;
    }

    @GetMapping("/getProductMsg1")
    public String getProductMsg1() {

//        第三种方式（利用@LoadBalanced，可在restTemplate里使用应用名字）
//        String response = restTemplate.getForObject("http://PRODUCT/seller/order/msg", String.class);

        String response = productClient.productMsg();
        log.info("response={}", response);

        return response;
    }
}
