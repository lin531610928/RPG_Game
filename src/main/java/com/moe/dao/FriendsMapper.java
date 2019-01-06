package com.moe.dao;

import com.moe.model.Friends;
import com.moe.model.MyFriends;

import java.util.List;

public interface FriendsMapper {
    int insert(Friends record);

    int insertSelective(Friends record);

    int updateByPlayerid(Friends record);

    Friends selectByPFid(Friends record);

    List<MyFriends> selectByMyFriends(Friends record);

    List<MyFriends> selectWaitAgree(Friends record);

    int deleteFriend(Friends record);
}