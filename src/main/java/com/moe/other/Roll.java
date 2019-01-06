package com.moe.other;

import java.util.Random;

public class Roll {
    public int roll(int max) {
        int min = 1;
        Random random = new Random();
        int pr = random.nextInt(max) % (max - min + 1) + min;
        return pr;
    }
}
