package com.moe.dao;

import com.moe.model.Cards;

public interface CardsMapper {
    int deleteByPrimaryKey(Integer card_id);

    int insert(Cards record);

    int insertSelective(Cards record);

    Cards selectByPrimaryKey(Integer card_id);

    int updateByPrimaryKeySelective(Cards record);

    int updateByPrimaryKey(Cards record);

    int selectCardCount(String card_rare);
}