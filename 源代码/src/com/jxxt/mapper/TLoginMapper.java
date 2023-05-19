package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TLogin;

public interface TLoginMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TLogin record);

    TLogin selectByPrimaryKey(Integer id);

    List<TLogin> findPage(Page page);

    TLogin login(TLogin record);
    
    List findList();
    
    int updateByPrimaryKeySelective(TLogin record);


}