package com.yuhb.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author yu.hb
 * @date 2020/4/17
 */
//@Component
public class HostAddrKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(buildKey(exchange));
    }

    private String buildKey(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        String hostAddress = request.getRemoteAddress().getAddress().getHostAddress();
        return path.concat(":").concat(hostAddress);
    }
}
