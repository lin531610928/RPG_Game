package com.moe.dao;

import com.moe.model.Signin;

public interface SigninMapper {
    int insert(Signin record);

    int insertSelective(Signin record);

    Signin selectByPlayerid(int player_id);

    int updateByPlayerid(Signin record);
}