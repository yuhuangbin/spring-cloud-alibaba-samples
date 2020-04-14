package com.yuhb.customer.controller;

import com.yuhb.common.domain.TbUser;
import com.yuhb.customer.feign.ProviderFeignService1;
import com.yuhb.customer.mapper.TbUserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class UserController {

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private ProviderFeignService1 providerFeignService1;


    /**
     * seata 全局回滚
     * @param user
     */
    @PostMapping("/seata/user/add")
    @GlobalTransactional(rollbackFor = Exception.class) // 开启全局事务
    public void add(@RequestBody TbUser user) {
        log.info("globalTransactional begin, Xid:{}", RootContext.getXID());
        // local save
        localSave(user);

        // call provider save
        providerFeignService1.add(user.getName());

        // test seata globalTransactional
        throw new RuntimeException("rollback test");
    }


    private void localSave(TbUser user) {
        user.setName("customer");
        user.setAge(1);
        userMapper.insert(user);
    }
}
