package analyzers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import utils.SegmentAnalyzer;

public class CyclicBarrierAnalyzer {
    private final int[] data;
    private final int segments;
    private final int segmentSize;
    
    public CyclicBarrierAnalyzer(int[] data, int segments) {
        this.data = data;
        this.segments = segments;
        this.segmentSize = data.length / segments;
    }
    
    public void analyze() throws Exception {
        System.out.println("=== Этап 6: CyclicBarrier ===");
        
        final int phaseSize = segmentSize / 2;
        
        CyclicBarrier barrier = new CyclicBarrier(segments, () -> {
            System.out.println("[ИИ-координатор] Все детекторы завершили фазу. Переход к следующей.");
        });
        
        ExecutorService executor = Executors.newFixedThreadPool(segments);
        
        for (int i = 0; i < segments; i++) {
            final int segmentNum = i;
            final int start = i * segmentSize;
            final int end = (i + 1) * segmentSize;
            
            executor.submit(() -> {
                try {
                    long sum1 = SegmentAnalyzer.analyzeHalfSegment(data, start, start + phaseSize);
                    System.out.printf("[Детектор-%d] Фаза 1 завершена. Сумма = %d\n", segmentNum + 1, sum1);
                    
                    barrier.await();
                    
                    long sum2 = SegmentAnalyzer.analyzeHalfSegment(data, start + phaseSize, end);
                    System.out.printf("[Детектор-%d] Фаза 2 завершена. Сумма = %d\n", segmentNum + 1, sum2);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println();
    }
}