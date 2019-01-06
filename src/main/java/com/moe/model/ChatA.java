package com.moe.model;

import java.util.Date;

public class ChatA {
    private String player_name;

    private String chat_message;

    private Date chat_date;

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name == null ? null : player_name.trim();
    }

    public String getChat_message() {
        return chat_message;
    }

    public void setChat_message(String chat_message) {
        this.chat_message = chat_message == null ? null : chat_message.trim();
    }

    public Date getChat_date() {
        return chat_date;
    }

    public void setChat_date(Date chat_date) {
        this.chat_date = chat_date;
    }
}
