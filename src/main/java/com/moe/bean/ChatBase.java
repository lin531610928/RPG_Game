package com.moe.bean;

public class ChatBase {

    private String player_id;

    private String player_name;

    private String chat_message;

    private String chat_date;

    private String message;

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setChat_message(String chat_message) {
        this.chat_message = chat_message;
    }

    public String getChat_message() {
        return chat_message;
    }

    public void setChat_date(String chat_date) {
        this.chat_date = chat_date;
    }

    public String getChat_date() {
        return chat_date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
