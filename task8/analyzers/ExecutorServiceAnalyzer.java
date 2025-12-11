package analyzers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import models.Result;
import utils.SegmentAnalyzer;

public class ExecutorServiceAnalyzer {
    private final int[] data;
    private final int segments;
    private final int segmentSize;
    private final int anomalyThreshold;
    
    public ExecutorServiceAnalyzer(int[] data, int segments, int anomalyThreshold) {
        this.data = data;
        this.segments = segments;
        this.segmentSize = data.length / segments;
        this.anomalyThreshold = anomalyThreshold;
    }
    
    public long analyze() throws Exception {
        System.out.println("=== Этап 2-3: ExecutorService ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(segments);
        List<Future<Result>> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < segments; i++) {
            final int segmentNum = i;
            final int start = i * segmentSize;
            final int end = (i + 1) * segmentSize;
            
            Callable<Result> task = () -> {
                Result result = SegmentAnalyzer.analyzeSegment(data, start, end, anomalyThreshold);
                
                System.out.printf("[Детектор-%d] Сектор %d–%d завершён. Сумма = %d, Аномалий = %d\n",
                    segmentNum + 1, start, end - 1, result.getSum(), result.getAnomalies());
                
                return result;
            };
            
            futures.add(executor.submit(task));
        }
        
        long totalSum = 0;
        int totalAnomalies = 0;
        
        for (Future<Result> future : futures) {
            Result result = future.get();
            totalSum += result.getSum();
            totalAnomalies += result.getAnomalies();
        }
        
        executor.shutdown();
        long duration = System.currentTimeMillis() - startTime;
        
        System.out.printf("[Центральный ИИ] Общая сумма = %d\n", totalSum);
        System.out.printf("[Центральный ИИ] Найдено аномалий = %d\n", totalAnomalies);
        System.out.printf("⏱ Время (ExecutorService): %d мс\n\n", duration);
        
        return duration;
    }
}