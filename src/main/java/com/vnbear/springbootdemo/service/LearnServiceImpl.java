package com.vnbear.springbootdemo.service;

import com.vnbear.springbootdemo.bean.LearnResouce;
import com.vnbear.springbootdemo.dao.LearnResourceDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnResourceDao learnResourceDao;

    @Override
    public int add(LearnResouce learnResouce) {
        return learnResourceDao.insert(learnResouce);
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return learnResourceDao.updateByPrimaryKeySelective(learnResouce);
    }

    @Override
    public int deleteByIds(String id) {
        return learnResourceDao.deleteByPrimaryKey(id);
    }

    @Override
    public LearnResouce queryLearnResouceById(Long id) {
        return learnResourceDao.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public List<LearnResouce> queryLearnResouceList(Map<String, Object> params) {
       /* PageHelper.startPage(Integer.parseInt(params.get("page").toString()),
                Integer.parseInt(params.get("rows").toString()));*/
        //return learnResourceDao.selectByPrimaryKey(params);
        return new ArrayList<>();
    }
}
