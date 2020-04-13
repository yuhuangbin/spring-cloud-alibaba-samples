package com.yuhb.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yu.hb on 2019-10-30
 */
@FeignClient(contextId = "sca-provider2", name = "sca-provider")
public interface ProviderFeignService {


    @GetMapping("/feign/user/add")
    String add(@RequestParam("name") String name);
}
