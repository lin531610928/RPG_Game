package com.moe.model;

public class MyFriends {
    private Integer player_id;

    private Integer friend_id;

    private Integer friend_state;

    private String player_name;

    private Integer player_level;

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

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name == null ? null : player_name.trim();
    }

    public Integer getPlayer_level() {
        return player_level;
    }

    public void setPlayer_level(Integer player_level) {
        this.player_level = player_level;
    }
}
