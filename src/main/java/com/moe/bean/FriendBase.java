package com.moe.bean;

public class FriendBase {

    private String player_id;

    private String friend_id;

    private String friend_state;

    private String player_name;

    private String player_level;

    private String message;

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_state(String friend_state) {
        this.friend_state = friend_state;
    }

    public String getFriend_state() {
        return friend_state;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_level(String player_level) {
        this.player_level = player_level;
    }

    public String getPlayer_level() {
        return player_level;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
