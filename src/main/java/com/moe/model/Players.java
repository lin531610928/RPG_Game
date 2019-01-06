package com.moe.model;

public class Players {
    private Integer player_id;

    private String player_name;

    private String player_password;

    private Integer player_money;

    private Integer player_level;

    private Integer player_exp;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name == null ? null : player_name.trim();
    }

    public String getPlayer_password() {
        return player_password;
    }

    public void setPlayer_password(String player_password) {
        this.player_password = player_password == null ? null : player_password.trim();
    }

    public Integer getPlayer_money() {
        return player_money;
    }

    public void setPlayer_money(Integer player_money) {
        this.player_money = player_money;
    }

    public Integer getPlayer_level() {
        return player_level;
    }

    public void setPlayer_level(Integer player_level) {
        this.player_level = player_level;
    }

    public Integer getPlayer_exp() {
        return player_exp;
    }

    public void setPlayer_exp(Integer player_exp) {
        this.player_exp = player_exp;
    }
}