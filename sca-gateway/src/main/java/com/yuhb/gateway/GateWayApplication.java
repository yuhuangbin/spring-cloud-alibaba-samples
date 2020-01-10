package com.yuhb.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by yu.hb on 2020-01-09
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(TestConfig.class)
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }


    @Bean
    public ApplicationRunner runner(TestConfig testConfig) {
        return args -> {
            Integer integerVal = (Integer) testConfig.getMetadata().get("intKey");
            Boolean booleanVal = (Boolean) testConfig.getMetadata().get("booleanKey");

            System.out.println(integerVal);
            System.out.println(booleanVal);
            System.out.println(testConfig.toString());
        };
    }


}
