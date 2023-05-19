package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TGuardian;

public interface TGuardianMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TGuardian record);

    TGuardian selectByPrimaryKey(Integer id);

    List<TGuardian> findPage(Page page);

    List findList(TGuardian record);
    List<TGuardian>  findListAll();
    int updateByPrimaryKeySelective(TGuardian record);


}