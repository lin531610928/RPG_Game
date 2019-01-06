package com.moe.service;

import com.moe.model.Chat;
import com.moe.model.ChatA;

import java.util.List;

public interface ChatService {

    int insert(Chat record);

    List<ChatA> selectHour();

    List<ChatA> selectSecond();

}
