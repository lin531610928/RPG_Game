package com.moe.bean;

public class ItemBase {

    private String player_id;

    private String card_bid;

    private String item_id;

    private String item_num;

    private String message;

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setCard_bid(String card_bid) {
        this.card_bid = card_bid;
    }

    public String getCard_bid() {
        return card_bid;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_num(String item_num) {
        this.item_num = item_num;
    }

    public String getItem_num() {
        return item_num;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
