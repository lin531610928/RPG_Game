package com.moe.dao;

import com.moe.model.Chat;
import com.moe.model.ChatA;

import java.util.List;

public interface ChatMapper {
    int insert(Chat record);

    int insertSelective(Chat record);

    List<ChatA> selectHour();

    List<ChatA> selectSecond();
}