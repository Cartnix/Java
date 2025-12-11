package utils;

import models.Result;

public class SegmentAnalyzer {
    
    public static Result analyzeSegment(int[] data, int start, int end, int anomalyThreshold) {
        long sum = 0;
        int anomalyCount = 0;
        
        for (int i = start; i < end; i++) {
            sum += data[i];
            if (data[i] > anomalyThreshold) {
                anomalyCount++;
            }
        }
        
        return new Result(sum, anomalyCount);
    }
    
    public static long analyzeHalfSegment(int[] data, int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += data[i];
        }
        return sum;
    }
}