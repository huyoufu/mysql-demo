package com.itheima.batch;

import java.util.Random;

public class AgeGenerator {
    private static final Random RANDOM=new Random();
    public static int generate(){
        return 18+RANDOM.nextInt(82);
    }
}
