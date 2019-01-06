package com.moe.bean;

public class GameResultBase {

    private String player_id;

    private String player_gexp;

    private String player_gmoney;

    private String card_gexp;

    private String message;

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_gexp(String player_gexp) {
        this.player_gexp = player_gexp;
    }

    public String getPlayer_gexp() {
        return player_gexp;
    }

    public void setPlayer_gmoney(String player_gmoney) {
        this.player_gmoney = player_gmoney;
    }

    public String getPlayer_gmoney() {
        return player_gmoney;
    }

    public void setCard_gexp(String card_gexp) {
        this.card_gexp = card_gexp;
    }

    public String getCard_gexp() {
        return card_gexp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
