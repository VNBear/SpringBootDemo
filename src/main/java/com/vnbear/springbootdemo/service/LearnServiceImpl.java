package com.vnbear.springbootdemo.service;

import com.github.pagehelper.PageHelper;
import com.vnbear.springbootdemo.bean.LearnResource;
import com.vnbear.springbootdemo.dao.LearnResourceMapper;
import com.vnbear.springbootdemo.model.LeanQueryLeanListReq;
import com.vnbear.springbootdemo.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnServiceImpl extends BaseServiceImpl<LearnResource> implements LearnService {

    @Autowired
    private LearnResourceMapper learnResourceMapper;

    @Override
    public int add(LearnResource learnResource) {
        return save(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return updateNotNull(learnResource);
    }

    @Override
    public int deleteByIds(String id) {
        return delete(id);
    }

    @Override
    public LearnResource queryLearnResouceById(Long id) {
        return selectByKey(String.valueOf(id));
    }

    @Override
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceMapper.queryLearnResouceList(page.getCondition());
    }
}
