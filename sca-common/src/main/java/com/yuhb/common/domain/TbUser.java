package com.yuhb.common.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class TbUser implements Serializable{
    /**
     *  
     */
    private Integer id;

    /**
     *  
     */
    private String name;

    /**
     *  
     */
    private Integer age;

    public TbUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}