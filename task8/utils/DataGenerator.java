package utils;

import java.util.Random;

public class DataGenerator {
    private static final int MAX_VALUE = 10000;
    
    public static int[] generateData(int size, long seed) {
        Random random = new Random(seed);
        int[] data = new int[size];
        
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(MAX_VALUE);
        }
        
        return data;
    }
    
    public static int[] generateData(int size) {
        return generateData(size, 42);
    }
}