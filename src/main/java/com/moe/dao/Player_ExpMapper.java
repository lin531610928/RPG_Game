package com.moe.dao;

import com.moe.model.Player_Exp;

public interface Player_ExpMapper {
    int deleteByPrimaryKey(Integer player_level);

    int insert(Player_Exp record);

    int insertSelective(Player_Exp record);

    Player_Exp selectByPrimaryKey(Integer player_level);

    int updateByPrimaryKeySelective(Player_Exp record);

    int updateByPrimaryKey(Player_Exp record);
}