package com.yuhb.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.yuhb.common.api.ApiResponse;
import com.yuhb.common.api.ResponseInfo;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * token认证
 *
 * @author yu.hb
 * @date 2020/4/17
 */
//@Component
public class AuthFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> token = exchange.getRequest().getHeaders().get("token");
        if (CollectionUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            String authErrorStr = JSON.toJSONString(ApiResponse.of(ResponseInfo.AUTH_ERROR));
            response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            DataBuffer body = response.bufferFactory().wrap(authErrorStr.getBytes());
            return response.writeWith(Mono.just(body));
        }
        return chain.filter(exchange);
    }
}
