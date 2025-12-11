package models;

public class Result {
    private final long sum;
    private final int anomalies;
    
    public Result(long sum, int anomalies) {
        this.sum = sum;
        this.anomalies = anomalies;
    }
    
    public long getSum() {
        return sum;
    }
    
    public int getAnomalies() {
        return anomalies;
    }
    
    @Override
    public String toString() {
        return String.format("Result{sum=%d, anomalies=%d}", sum, anomalies);
    }
}