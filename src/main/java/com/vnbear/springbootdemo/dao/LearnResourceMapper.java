package com.vnbear.springbootdemo.dao;

import com.vnbear.springbootdemo.bean.LearnResource;
import com.vnbear.springbootdemo.utils.MyBaseDao;

import java.util.List;
import java.util.Map;


public interface LearnResourceMapper extends MyBaseDao<LearnResource> {
    List<LearnResource> queryLearnResouceList(Map<String,Object> map);
}