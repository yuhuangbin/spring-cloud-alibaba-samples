package com.yuhb.customer.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

/**
 * @author yu.hb
 * @date 2020/3/17
 */
public class ProviderFeign2Configuration {

    @Bean
    public Retryer feignRetry() {
        return Retryer.NEVER_RETRY;
    }
}
