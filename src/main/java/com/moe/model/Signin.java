package com.moe.model;

import java.util.Date;

public class Signin {
    private Integer player_id;

    private Date chat_date;

    private Integer sign_type;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Date getChat_date() {
        return chat_date;
    }

    public void setChat_date(Date chat_date) {
        this.chat_date = chat_date;
    }

    public Integer getSign_type() {
        return sign_type;
    }

    public void setSign_type(Integer sign_type) {
        this.sign_type = sign_type;
    }
}