package com.vnbear.springbootdemo.dao;


import com.vnbear.springbootdemo.bean.LearnResouce;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LearnResourceDao {
    int deleteByPrimaryKey(String id);

    int insert(LearnResouce record);

    int insertSelective(LearnResouce record);

    LearnResouce selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LearnResouce record);

    int updateByPrimaryKey(LearnResouce record);
}