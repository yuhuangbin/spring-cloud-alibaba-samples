package com.yuhb.provider.dubbo;

import com.yuhb.common.dubbo.api.DubboEchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yu.hb
 * @date 2020/4/14
 */
@Service
public class DubboEchoServiceImpl implements DubboEchoService {
    @Override
    public String echo(String name) {
        System.out.println(name);
        return "Call By Dubbo Request Message: " + name;
    }
}
