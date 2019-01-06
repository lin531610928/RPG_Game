package com.moe.dao;

import com.moe.model.Player_Items;

public interface Player_ItemsMapper {
    int insert(Player_Items record);

    int insertSelective(Player_Items record);

    Player_Items selectByPlayerid(Player_Items record);

    int updateByPlayerid(Player_Items record);
}