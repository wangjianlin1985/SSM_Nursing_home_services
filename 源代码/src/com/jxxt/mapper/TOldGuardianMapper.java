package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TOldGuardian;

public interface TOldGuardianMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TOldGuardian record);

    TOldGuardian selectByPrimaryKey(Integer id);

    List<TOldGuardian> findPage(Page page);

    List findList(TOldGuardian record);
    
    int updateByPrimaryKeySelective(TOldGuardian record);


}