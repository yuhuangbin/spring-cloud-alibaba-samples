package com.yuhb.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.yuhb.common.api.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author yu.hb
 * @date 2020/4/17
 */
@Configuration
public class SCGConfig {
    @Bean
    public BlockRequestHandler blockRequestHandler() {

        return new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
                return ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .bodyValue(ApiResponse.LIMIT);
            }
        };
    }
}
