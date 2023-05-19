package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TEvaluation;

public interface TEvaluationMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TEvaluation record);

    TEvaluation selectByPrimaryKey(Integer id);

    List<TEvaluation> findPage(Page page);

    List<TEvaluation> findList(TEvaluation record);
    
    int updateByPrimaryKeySelective(TEvaluation record);


}