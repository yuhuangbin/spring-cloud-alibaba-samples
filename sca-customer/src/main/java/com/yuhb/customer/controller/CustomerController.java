package com.yuhb.customer.controller;

import com.yuhb.customer.feign.ProviderFeign2;
import com.yuhb.customer.feign.ProviderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yu.hb on 2019-10-30
 */
@RestController
@RefreshScope // 刷新配置
public class CustomerController {


    @Autowired
    private ProviderFeignService providerFeignService;

    @Autowired
    private ProviderFeign2 providerFeign2;

    @Value("${user.name:yuhb}")
    private String name;

    @Value("${user.age:18}")
    private Integer age;

    /**
     * Open Feign 方式调用
     * @param name
     * @return
     */
    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return providerFeign2.feignEcho(name);
    }
}
