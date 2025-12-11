package analyzers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ManualThreadsAnalyzer {
    private final int[] data;
    private final int segments;
    private final int segmentSize;
    private final AtomicLong globalSum;
    
    public ManualThreadsAnalyzer(int[] data, int segments) {
        this.data = data;
        this.segments = segments;
        this.segmentSize = data.length / segments;
        this.globalSum = new AtomicLong(0);
    }
    
    public long analyze() throws InterruptedException {
        System.out.println("=== Этап 1: Ручные потоки ===");
        
        globalSum.set(0);
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < segments; i++) {
            final int segmentNum = i;
            final int start = i * segmentSize;
            final int end = (i + 1) * segmentSize;
            
            Thread thread = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += data[j];
                }
                globalSum.addAndGet(localSum);
                
                System.out.printf("[Детектор-%d] Сектор %d–%d просканирован. Сумма = %d\n",
                    segmentNum + 1, start, end - 1, localSum);
            });
            
            threads.add(thread);
            thread.start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        long duration = System.currentTimeMillis() - startTime;
        
        System.out.printf("[Центральный ИИ] Общая сумма данных = %d\n", globalSum.get());
        System.out.printf("⏱ Время (ручные потоки): %d мс\n\n", duration);
        
        return duration;
    }
}