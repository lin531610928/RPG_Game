package com.moe.model;

public class Cards {
    private Integer card_id;

    private String card_rare;

    private String card_name;

    private Integer card_ability_min;

    private Integer card_ability_max;

    private String card_skill_desc;

    private String card_skill_type;

    private String card_path;

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

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name == null ? null : card_name.trim();
    }

    public Integer getCard_ability_min() {
        return card_ability_min;
    }

    public void setCard_ability_min(Integer card_ability_min) {
        this.card_ability_min = card_ability_min;
    }

    public Integer getCard_ability_max() {
        return card_ability_max;
    }

    public void setCard_ability_max(Integer card_ability_max) {
        this.card_ability_max = card_ability_max;
    }

    public String getCard_skill_desc() {
        return card_skill_desc;
    }

    public void setCard_skill_desc(String card_skill_desc) {
        this.card_skill_desc = card_skill_desc == null ? null : card_skill_desc.trim();
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
}