package com.vnbear.springbootdemo.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyBaseDao<T> extends Mapper<T>, MySqlMapper {
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
