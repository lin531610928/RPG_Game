package com.moe.model;

public class Team {
    private Integer player_id;

    private Integer card_id;

    private String card_rare;

    private String card_skill_type;

    private String card_path;

    private Integer card_bid;

    private Integer card_ability;

    private Integer card_state;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_rare() {
        return card_rare;
    }

    public void setCard_rare(String card_rare) {
        this.card_rare = card_rare == null ? null : card_rare.trim();
    }

    public String getCard_skill_type() {
        return card_skill_type;
    }

    public void setCard_skill_type(String card_skill_type) {
        this.card_skill_type = card_skill_type == null ? null : card_skill_type.trim();
    }

    public String getCard_path() {
        return card_path;
    }

    public void setCard_path(String card_path) {
        this.card_path = card_path == null ? null : card_path.trim();
    }

    public Integer getCard_bid() {
        return card_bid;
    }

    public void setCard_bid(Integer card_bid) {
        this.card_bid = card_bid;
    }

    public Integer getCard_ability() {
        return card_ability;
    }

    public void setCard_ability(Integer card_ability) {
        this.card_ability = card_ability;
    }

    public Integer getCard_state() {
        return card_state;
    }

    public void setCard_state(Integer card_state) {
        this.card_state = card_state;
    }

}
