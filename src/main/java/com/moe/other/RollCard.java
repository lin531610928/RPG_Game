package com.moe.other;

public class RollCard {
    public String[] rRare() {
        int max = 10000;
        int SSR = 3;
        int SR = 12;
        String[] rare = new String[2];
        Roll r = new Roll();
        int result = r.roll(max);
        if (result <= SSR * (max / 100)) {
            rare[0] = "SSR";
            rare[1] = "1";
            return rare;
        } else if (result <= (SSR + SR) * (max / 100)) {
            rare[0] = "SR";
            rare[1] = "2";
            return rare;
        } else {
            rare[0] = "R";
            rare[1] = "3";
            return rare;
        }
    }
}
