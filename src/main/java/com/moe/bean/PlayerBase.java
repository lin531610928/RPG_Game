package com.moe.bean;

public class PlayerBase {

    private String player_id;
    private String player_name;
    private String player_password;
    private String player_money;
    private String player_level;
    private String player_exp;
    private String player_needexp;
    private String message;

    public PlayerBase(){}

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

    public void setPlayer_password(String player_password) {
        this.player_password = player_password;
    }

    public String getPlayer_password() {
        return player_password;
    }

    public void setPlayer_money(String player_money) {
        this.player_money = player_money;
    }

    public String getPlayer_money() {
        return player_money;
    }

    public void setPlayer_level(String player_level) {
        this.player_level = player_level;
    }

    public String getPlayer_level() {
        return player_level;
    }

    public void setPlayer_exp(String player_exp) {
        this.player_exp = player_exp;
    }

    public String getPlayer_exp() {
        return player_exp;
    }

    public void setPlayer_needexp(String player_needexp) {
        this.player_needexp = player_needexp;
    }

    public String getPlayer_needexp() {
        return player_needexp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setInfo(String player_id,String player_name,String player_password,String player_money,String player_level,String player_exp,String player_needexp,String message){
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_password = player_password;
        this.player_money = player_money;
        this.player_level = player_level;
        this.player_exp = player_exp;
        this.player_needexp = player_needexp;
        this.message = message;
    }

}
