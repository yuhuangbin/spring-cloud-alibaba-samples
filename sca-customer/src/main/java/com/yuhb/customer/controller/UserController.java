package com.yuhb.customer.controller;

import com.yuhb.common.domain.TbUser;
import com.yuhb.common.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-11-01
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;

    @PostMapping("/user/add")
    public String add(@RequestBody TbUser user) {
        userService.add(user);
        return "success";
    }
}
