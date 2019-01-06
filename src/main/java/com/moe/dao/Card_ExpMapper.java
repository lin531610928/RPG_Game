package com.moe.dao;

import com.moe.model.Card_Exp;

public interface Card_ExpMapper {
    int deleteByPrimaryKey(Integer card_level);

    int insert(Card_Exp record);

    int insertSelective(Card_Exp record);

    Card_Exp selectByPrimaryKey(Integer card_level);

    int updateByPrimaryKeySelective(Card_Exp record);

    int updateByPrimaryKey(Card_Exp record);
}