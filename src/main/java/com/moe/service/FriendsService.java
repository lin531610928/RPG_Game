package com.moe.service;

import com.moe.model.Friends;
import com.moe.model.MyFriends;

import java.util.List;

public interface FriendsService {

    boolean addFriend(int player_id,int friend_id);

    boolean okFriend(int player_id,int friend_id);

    List<MyFriends> myFriends(Friends record);

    Friends selectByPFid(Friends record);

    List<MyFriends> selectWaitAgree(Friends record);

    int deleteFriend(Friends record);

}
