package com.moe.dao;

import com.moe.model.Npc;

public interface NpcMapper {
    int deleteByPrimaryKey(Integer npc_id);

    int insert(Npc record);

    int insertSelective(Npc record);

    Npc selectByPrimaryKey(Integer npc_id);

    int updateByPrimaryKeySelective(Npc record);

    int updateByPrimaryKey(Npc record);
}