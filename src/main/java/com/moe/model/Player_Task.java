package com.moe.model;

import java.util.Date;

public class Player_Task {
    private Integer player_id;

    private Integer task_id;

    private Integer task_now;

    private Date task_date;

    private Integer task_complete;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getTask_now() {
        return task_now;
    }

    public void setTask_now(Integer task_now) {
        this.task_now = task_now;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

    public Integer getTask_complete() {
        return task_complete;
    }

    public void setTask_complete(Integer task_complete) {
        this.task_complete = task_complete;
    }
}