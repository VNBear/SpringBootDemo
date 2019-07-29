package com.vnbear.springbootdemo.service;

import com.vnbear.springbootdemo.bean.LearnResource;
import com.vnbear.springbootdemo.model.LeanQueryLeanListReq;
import com.vnbear.springbootdemo.utils.Page;

import java.util.List;

public interface LearnService extends IBaseService<LearnResource>{
    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    int deleteByIds(String id);

    LearnResource queryLearnResouceById(Long learnResouce);

    List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);
}

