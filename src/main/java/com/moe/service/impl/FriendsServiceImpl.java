package com.moe.service.impl;

import com.moe.dao.FriendsMapper;
import com.moe.model.Friends;
import com.moe.model.MyFriends;
import com.moe.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsMapper FriendsDao;

    @Override
    public boolean addFriend(int player_id,int friend_id){
        Friends record = new Friends();
        record.setPlayer_id(friend_id);
        record.setFriend_id(player_id);
        Friends record2 = FriendsDao.selectByPFid(record);
        if(record2 == null) {
            record.setPlayer_id(player_id);
            record.setFriend_id(friend_id);
            record.setFriend_state(0);
            FriendsDao.insertSelective(record);
        }else {
            record.setFriend_state(1);
            FriendsDao.updateByPlayerid(record);
            record.setPlayer_id(player_id);
            record.setFriend_id(friend_id);
            FriendsDao.insertSelective(record);
        }
        return true;
    }

    @Override
    public boolean okFriend(int player_id,int friend_id){
        Friends record = new Friends();
        record.setPlayer_id(player_id);
        record.setFriend_id(friend_id);
        record.setFriend_state(1);
        FriendsDao.updateByPlayerid(record);
        record.setPlayer_id(friend_id);
        record.setFriend_id(player_id);
        FriendsDao.insertSelective(record);
        return true;
    }

    @Override
    public List<MyFriends> myFriends(Friends record){
        List<MyFriends> mreocrd = FriendsDao.selectByMyFriends(record);
        return mreocrd;
    }

    @Override
    public Friends selectByPFid(Friends record){
        return FriendsDao.selectByPFid(record);
    }

    @Override
    public List<MyFriends> selectWaitAgree(Friends record){
        return FriendsDao.selectWaitAgree(record);
    }

    @Override
    public int deleteFriend(Friends record){
        return FriendsDao.deleteFriend(record);
    }

}
