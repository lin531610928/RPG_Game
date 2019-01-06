package com.moe.dao;

import com.moe.model.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer task_id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer task_id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    int selectNum();

    List<Task> selectAll();
}