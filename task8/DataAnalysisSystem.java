import analyzers.ManualThreadsAnalyzer;
import analyzers.ExecutorServiceAnalyzer;
import analyzers.CompletionServiceAnalyzer;
import analyzers.CyclicBarrierAnalyzer;
import utils.DataGenerator;
import utils.PerformanceReporter;

public class DataAnalysisSystem {
    private static final int ARRAY_SIZE = 100_000;
    private static final int SEGMENTS = 20;
    private static final int ANOMALY_THRESHOLD = 9000;
    
    public static void main(String[] args) throws Exception {
        int[] data = DataGenerator.generateData(ARRAY_SIZE);
        
        ManualThreadsAnalyzer manualAnalyzer = new ManualThreadsAnalyzer(data, SEGMENTS);
        long time1 = manualAnalyzer.analyze();
        
        ExecutorServiceAnalyzer executorAnalyzer = 
            new ExecutorServiceAnalyzer(data, SEGMENTS, ANOMALY_THRESHOLD);
        long time2 = executorAnalyzer.analyze();
        
        CompletionServiceAnalyzer completionAnalyzer = 
            new CompletionServiceAnalyzer(data, SEGMENTS, ANOMALY_THRESHOLD);
        long time3 = completionAnalyzer.analyze();
        
        CyclicBarrierAnalyzer barrierAnalyzer = new CyclicBarrierAnalyzer(data, SEGMENTS);
        barrierAnalyzer.analyze();
        
        PerformanceReporter.printReport(time1, time2, time3);
    }
}