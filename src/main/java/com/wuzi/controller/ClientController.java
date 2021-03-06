package com.wuzi.controller;

import com.wuzi.client.ProductClient;
import com.wuzi.dataobject.ProductInfo;
import com.wuzi.dto.CartDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

//    @PostMapping("/getProductList")
//    public List<ProductInfo> getProductList(@RequestParam(value = "productIds") List<String> ids) {
//        List<ProductInfo> productInfoList = productClient.productInfo(ids);
//        return productInfoList;
//    }

    @GetMapping("/getProductList")
    public List<ProductInfo> getProductList() {
        List<ProductInfo> productInfoList = productClient.productInfo(Arrays.asList("123456", "123457"));
        return productInfoList;
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("123456", 5)));
        return "修改成功";
    }
}
