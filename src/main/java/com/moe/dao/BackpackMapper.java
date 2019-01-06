package com.moe.dao;

import com.moe.model.Backpack;
import com.moe.model.Team;

import java.util.List;

public interface BackpackMapper {
    int insert(Backpack record);

    int insertSelective(Backpack record);

    int selectCountByPlayerId(int player_id);

    int selectMBidByPlayerId(int player_id);

    List<Backpack> selectBidByPlayerId(int player_id);

    List<Backpack> selectByPlayerId(int player_id);

    Backpack selectStateByPlayerId(Backpack record);

    Backpack selectByCardBid(Backpack record);

    int updateByCardbidSelective(Backpack record);

    int deleteByCardbid(Backpack record);

    Team selectTeam(Backpack record);
}