public class MSTResult {
    public java.util.List<model.Edge> mstEdges;
    public int totalCost;
    public int operationsCount;
    public double executionTimeMs;

    public MSTResult(java.util.List<model.Edge> mstEdges, int totalCost,
                     int operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
    }
}
