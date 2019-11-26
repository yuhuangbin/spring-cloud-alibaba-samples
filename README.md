# spring-cloud-alibaba-samples
## 一、准备环境
### 1、启动 Nacos server <br>
[Nacos Server 下载地址](https://github.com/alibaba/nacos/releases)
>下载最新版本Nacos Server, 本地启动Nacos

* 进入nacos/bin目录，执行以下命令启动

  ```sh startup.sh -m standalone``` 
  
  > -m standalone 表示启动单机版nacos
 
* 访问nacos控制台  

  控制台地址：`http://127.0.0.1:8848/nacos`
 
  用户名密码：`nacos/nacos`

### 2、启动Seata Server <br>
[Seata Server 下载地址](https://github.com/seata/seata/releases)
> 下载最新版本Seata Server, 本地启动Seata

* 进入seata/conf，修改 `nacos-config.txt `配置

```
service.vgroup_mapping.sca-provider-seata-tx-service-group=default
service.vgroup_mapping.sca-customer-seata-tx-service-group=default
```

> sca-provider-seata-tx-service-group 和 sca-customer-seata-tx-service-group 为项目注册的事务分组

* 进入seata/conf目录，执行以下命令，将seata配置信息推送到nacos

`sh nacos-config.sh 127.0.0.1`

> 127.0.0.1 为nacos ip地址

* 进入 seata/conf目录，修改 registry.conf 文件

```

registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"

  nacos {
    serverAddr = "127.0.0.1"
    namespace = ""
    cluster = "default"
  }
}

config {
  # file、nacos 、apollo、zk、consul、etcd3
  type = "nacos"

  nacos {
    serverAddr = "127.0.0.1"
    namespace = ""
  }
 
}

```


* 进入seata/bin目录，执行以下命令启动seata-server

```nohup sh seata-server.sh -m file & ```

* 初始化业务数据库undo_log表
```sql

-- the table to store seata xid data
-- 0.7.0+ add context
-- you must to init this sql for you business databese. the seata server not need it.
-- 此脚本必须初始化在你当前的业务数据库中，用于AT 模式XID记录。与server端无关（注：业务数据库）
-- 注意此处0.3.0+ 增加唯一索引 ux_undo_log
drop table `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

## 二、使用组件介绍
* Nacos 注册中心
* Nacos 配置中心
* Dubbo RPC 服务调用
* Open Feign REST 服务调用
* Sentinel 限流熔断
* Seata 分布式事务解决方案
## 三、项目目录介绍
* sca-common <br>
`项目公用模块（实体类，Dubbo Api等）`
* sca-customer 消费者
* sca-provider 服务提供者

