package com.vnbear.springbootdemo.service;

import com.vnbear.springbootdemo.bean.LearnResouce;

import java.util.List;
import java.util.Map;

public interface LearnService {
    int add(LearnResouce learnResouce);

    int update(LearnResouce learnResouce);

    int deleteByIds(String id);

    LearnResouce queryLearnResouceById(Long learnResouce);

    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);
}

