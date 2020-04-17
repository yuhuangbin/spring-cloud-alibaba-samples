package com.yuhb.customer.controller;

import com.yuhb.common.dubbo.api.DubboEchoService;
import com.yuhb.customer.feign.ProviderFeignService2;
import com.yuhb.customer.feign.ProviderFeignService1;
import org.apache.dubbo.config.annotation.Reference;
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
    private ProviderFeignService1 providerFeignService1;

    @Autowired
    private ProviderFeignService2 providerFeignService2;

    @Reference(timeout = 5000, async = true)
    private DubboEchoService dubboEchoService;

    @Value("${user.name:yuhb}")
    private String name;

    @Value("${user.age:18}")
    private Integer age;

    @Value("${server.port}")
    private Integer port;

    /**
     * Open Feign 方式调用
     * @param name
     * @return
     */
    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return providerFeignService2.feignEcho(name);
    }

    /**
     * dubbo 调用
     * @param name
     * @return
     */
    @GetMapping("/dubbo/echo")
    public String dubboEcho(String name) {
        return dubboEchoService.echo(name);
    }

    @GetMapping("/sca-customer/port")
    public Integer port() {
        return port;
    }
}
