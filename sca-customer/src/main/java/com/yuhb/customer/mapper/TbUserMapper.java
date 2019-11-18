package com.yuhb.customer.mapper;


import com.yuhb.common.domain.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    void testUpdateForExists();

    void updateTest();

    void batchInsert();

    void batchUpdate(@Param(value = "users") List<TbUser> users);
}