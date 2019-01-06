package com.moe.model;

public class Friends {
    private Integer player_id;

    private Integer friend_id;

    private Integer friend_state;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }

    public Integer getFriend_state() {
        return friend_state;
    }

    public void setFriend_state(Integer friend_state) {
        this.friend_state = friend_state;
    }
}