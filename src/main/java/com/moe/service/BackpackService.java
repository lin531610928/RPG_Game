package com.moe.service;

import com.moe.model.Backpack;
import com.moe.model.Team;

import java.util.List;

public interface BackpackService {

    int Backpackmax(int player_id);

    List<Backpack> selectByPlayerId(int player_id);

    int updateTeam(Backpack record);

    boolean deleteByCardbid(Backpack record);

    boolean cardUp(Backpack record,int getexp);

    List<Team> selectTeam(int player_id);

}
