package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TOldDetails;

public interface TOldDetailsMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TOldDetails record);

    TOldDetails selectByPrimaryKey(Integer id);

    List<TOldDetails> findPage(Page page);

    List findList(TOldDetails record);
    
    int updateByPrimaryKeySelective(TOldDetails record);


}