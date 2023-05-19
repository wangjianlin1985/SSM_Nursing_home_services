package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TOld;

public interface TOldMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TOld record);

    TOld selectByPrimaryKey(Integer id);

    List<TOld> findPage(Page page);

    List findList(TOld record);
    
    List<TOld> findStatistical();
    
    List<TOld> findListAll();
    
    int updateByPrimaryKeySelective(TOld record);


}