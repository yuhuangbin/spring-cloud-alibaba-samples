/*
package com.yuhb.customer.controller;

import com.yuhb.common.domain.TbUser;
import com.yuhb.customer.feign.ProviderFeignService;
import com.yuhb.customer.mapper.TbUserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Description:数据库新建表
 *
CREATE TABLE `tb_user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(25) NOT NULL,
 `age` int(3) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

 * author: yu.hb
 * Date: 2019-11-01
 *//*

@RestController
@Slf4j
public class UserController {

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private ProviderFeignService providerFeignService;

    */
/**
     * seata 全局事务控制
     * @param user
     *//*

    @PostMapping("/seata/user/add")
    @GlobalTransactional(rollbackFor = Exception.class) // 开启全局事务
    public void add(@RequestBody TbUser user) {
        log.info("globalTransactional begin, Xid:{}", RootContext.getXID());
        // local save
        localSave(user);

        // call provider save
        providerFeignService.add(user.getName());

        // test seata globalTransactional
        throw new RuntimeException("rollback test");
    }

    */
/**
     * 本地事务
     *//*

    @Transactional
    @RequestMapping("/local/save")
    public void localSave() {
        localSave(new TbUser("localTest", 1));
        throw new RuntimeException("rollback test");
    }

    private void localSave(TbUser user) {
        user.setName("customer");
        user.setAge(1);
        userMapper.insert(user);
//        userMapper.testUpdateForExists();
//        userMapper.updateTest();
//        userMapper.batchInsert();

//        TbUser u1 = new TbUser();
//        u1.setId(1);
//        u1.setName("test");
//        u1.setAge(100);
//
//        TbUser u2 = new TbUser();
//        u2.setId(1);
//        u2.setName("test");
//        u2.setAge(100);
//
//        List<TbUser> users = Arrays.asList(u1,u2);
//        userMapper.batchUpdate(users);
    }
}
*/
