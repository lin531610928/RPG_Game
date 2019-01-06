package com.moe.service;

import com.moe.model.Player_Exp;
import com.moe.model.Players;

import java.util.List;

public interface PlayersService {

    Players selectByName(String player_name);

    Player_Exp getPlayerNeedExp(Integer player_level);

    int insertSelective(Players record);

    Players selectByPrimaryKey(Integer player_id);

    boolean levelUp(Integer player_id,Integer get_exp);

    List<Players> searchPlayers(String player_name);

    boolean addMoney(Integer player_id,Integer get_money);

    List<Players> selectPlayers(Integer player_id);

    List<Players> selectFriends(Integer player_id);

}
