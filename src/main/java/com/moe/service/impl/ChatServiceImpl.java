package com.moe.service.impl;

import com.moe.dao.ChatMapper;
import com.moe.model.Chat;
import com.moe.model.ChatA;
import com.moe.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper ChatDao;

    @Override
    public int insert(Chat record){
        java.util.Date d=new java.util.Date();
        java.sql.Date d2=new java.sql.Date(d.getTime());
        record.setChat_date(d2);
        return ChatDao.insert(record);
    }

    @Override
    public List<ChatA> selectHour(){
        return ChatDao.selectHour();
    }

    @Override
    public List<ChatA> selectSecond(){
        return ChatDao.selectSecond();
    }

}
