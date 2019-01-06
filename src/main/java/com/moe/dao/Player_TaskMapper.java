package com.moe.dao;

import com.moe.model.Player_Task;

import java.util.List;

public interface Player_TaskMapper {
    List<Player_Task> selectAllTask(int player_id);

    int insert(Player_Task record);

    int insertSelective(Player_Task record);

    int updateByPlayerid(Player_Task record);

    Player_Task selectTask(Player_Task record);
}