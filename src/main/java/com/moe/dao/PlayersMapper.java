package com.moe.dao;

import com.moe.model.Players;

import java.util.List;

public interface PlayersMapper {
    int deleteByPrimaryKey(Integer player_id);

    int insert(Players record);

    int insertSelective(Players record);

    Players selectByPrimaryKey(Integer player_id);

    int updateByPrimaryKeySelective(Players record);

    int updateByPrimaryKey(Players record);

    Players selectByName(String player_name);

    List<Players> searchPlayers(String player_name);

    List<Players> selectPlayers(Integer player_id);

    List<Players> selectFriends(Integer player_id);
}