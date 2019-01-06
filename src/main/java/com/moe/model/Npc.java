package com.moe.model;

public class Npc {
    private Integer npc_id;

    private String npc_name;

    private Integer npc_hp;

    private Integer npc_ability;

    private Integer npc_ability_d;

    private Integer npc_dropexp;

    private String npc_path;

    public Integer getNpc_id() {
        return npc_id;
    }

    public void setNpc_id(Integer npc_id) {
        this.npc_id = npc_id;
    }

    public String getNpc_name() {
        return npc_name;
    }

    public void setNpc_name(String npc_name) {
        this.npc_name = npc_name == null ? null : npc_name.trim();
    }

    public Integer getNpc_hp() {
        return npc_hp;
    }

    public void setNpc_hp(Integer npc_hp) {
        this.npc_hp = npc_hp;
    }

    public Integer getNpc_ability() {
        return npc_ability;
    }

    public void setNpc_ability(Integer npc_ability) {
        this.npc_ability = npc_ability;
    }

    public Integer getNpc_ability_d() {
        return npc_ability_d;
    }

    public void setNpc_ability_d(Integer npc_ability_d) {
        this.npc_ability_d = npc_ability_d;
    }

    public Integer getNpc_dropexp() {
        return npc_dropexp;
    }

    public void setNpc_dropexp(Integer npc_dropexp) {
        this.npc_dropexp = npc_dropexp;
    }

    public String getNpc_path() {
        return npc_path;
    }

    public void setNpc_path(String npc_path) {
        this.npc_path = npc_path == null ? null : npc_path.trim();
    }
}