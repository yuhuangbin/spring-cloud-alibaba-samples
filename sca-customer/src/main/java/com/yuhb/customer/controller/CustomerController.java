package com.yuhb.customer.controller;

import com.yuhb.common.dubbo.api.DubboEchoService;
import com.yuhb.customer.feign.ProviderFeignService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yu.hb on 2019-10-30
 */
@RestController
@RefreshScope // Nacos动态刷新配置
public class CustomerController {

    @Reference
    private DubboEchoService dubboEchoService;

    @Autowired
    private ProviderFeignService providerFeignService;

    /**
     * Nacos默认配置 dataid : ${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
     * 对应本项目即
     * Dataid : sca-customer.properties
     * Group : DEFAULT_GROUP
     */
    @Value("${user.name:yuhb}")
    private String name;

    @Value("${user.age:18}")
    private Integer age;

    /**
     * Dubbo 方式调用
     * @param name
     * @return
     */
    @GetMapping("/dubbo/echo/{name}")
    public String dubboEcho(@PathVariable("name") String name) {
        return dubboEchoService.echo(name);
    }

    /**
     * Open Feign 方式调用
     * @param name
     * @return
     */
    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return providerFeignService.feignEcho(name);
    }

    /**
     * Nacos 动态获取 ${user.name} 配置
     * @return
     */
    @GetMapping("/dubbo/dynamicConfig")
    public String dubboEcho() {
        return dubboEchoService.echo(String.format("my name is %s, age is %d", name, age));
    }
}
