package com.yuhb.customer.feign;

import com.yuhb.customer.config.ProviderFeign2Configuration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yu.hb
 * @date 2020/3/17
 */
@FeignClient(contextId = "sca-provider1", name = "sca-provider",configuration = ProviderFeign2Configuration.class)
public interface ProviderFeignService2 {

    @GetMapping("/feign/echo")
    String feignEcho(@RequestParam("name") String name);
}
