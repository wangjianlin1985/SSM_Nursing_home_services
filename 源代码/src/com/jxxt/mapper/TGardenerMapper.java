package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TGardener;

public interface TGardenerMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(TGardener record);

    TGardener selectByPrimaryKey(Integer id);

    List<TGardener> findPage(Page page);

    List findList(TGardener record);
    
    List<TGardener> findOrderby();
    
    int updateByPrimaryKeySelective(TGardener record);


}