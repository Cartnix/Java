package utils;

public class PerformanceReporter {
    
    public static void printReport(long manualTime, long executorTime, long completionTime) {
        System.out.println("=== Этап 7: Анализ производительности ===");
        System.out.println("[ИИ-Аналитик] Время выполнения:");
        System.out.printf("  - Ручные потоки:      %4d мс\n", manualTime);
        System.out.printf("  - ExecutorService:    %4d мс\n", executorTime);
        System.out.printf("  - CompletionService:  %4d мс\n", completionTime);
        
        long fastest = Math.min(manualTime, Math.min(executorTime, completionTime));
        String method = fastest == manualTime ? "Ручные потоки" : 
                       fastest == executorTime ? "ExecutorService" : "CompletionService";
        
        System.out.printf("\n[ИИ-Аналитик] Самый быстрый метод: %s (%d мс)\n", method, fastest);
    }
}