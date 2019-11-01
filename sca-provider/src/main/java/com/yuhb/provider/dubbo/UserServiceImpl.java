package com.yuhb.provider.dubbo;

import com.yuhb.common.domain.TbUser;
import com.yuhb.common.dubbo.api.UserService;
import com.yuhb.provider.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-11-01
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public void add(TbUser user) {
        log.info("add user:{}", user);

        user.setName("provider");
        userMapper.insert(user);
    }
}
