package com.moe.model;

public class Task {
    private Integer task_id;

    private String task_name;

    private Integer task_aim;

    private Integer task_award;

    private String task_award_desc;

    private Integer task_type;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name == null ? null : task_name.trim();
    }

    public Integer getTask_aim() {
        return task_aim;
    }

    public void setTask_aim(Integer task_aim) {
        this.task_aim = task_aim;
    }

    public Integer getTask_award() {
        return task_award;
    }

    public void setTask_award(Integer task_award) {
        this.task_award = task_award;
    }

    public String getTask_award_desc() {
        return task_award_desc;
    }

    public void setTask_award_desc(String task_award_desc) {
        this.task_award_desc = task_award_desc == null ? null : task_award_desc.trim();
    }

    public Integer getTask_type() {
        return task_type;
    }

    public void setTask_type(Integer task_type) {
        this.task_type = task_type;
    }
}