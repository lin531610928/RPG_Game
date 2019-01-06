package com.moe.dao;

import com.moe.model.Items;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer item_id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer item_id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}