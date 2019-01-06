package com.moe.model;

public class Items {
    private Integer item_id;

    private String item_name;

    private Integer item_exp;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name == null ? null : item_name.trim();
    }

    public Integer getItem_exp() {
        return item_exp;
    }

    public void setItem_exp(Integer item_exp) {
        this.item_exp = item_exp;
    }
}