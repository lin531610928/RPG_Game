package com.moe.service;

import com.moe.model.Player_Task;
import com.moe.model.Task;

import java.util.List;

public interface TaskService {

    List<Player_Task> allTask(int player_id);

    Task selectByPrimaryKey(Integer task_id);

    boolean taskNowAdd(int player_id);

    boolean missionComplete(Player_Task record);

    boolean taskEventAdd(int player_id);

    boolean addEventCard(int player_id);

}
