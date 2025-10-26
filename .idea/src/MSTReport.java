import model.Graph;

public class MSTReport {
    public int graph_id;
    public InputStats input_stats;
    public MSTResult prim;
    public MSTResult kruskal;

    public static class InputStats {
        int vertices;
        int edges;
        public InputStats(int v, int e) { vertices = v; edges = e; }
    }

    public MSTReport(int id, Graph g, MSTResult prim, MSTResult kruskal) {
        this.graph_id = id;
        this.input_stats = new InputStats(g.getNodes().size(), g.getEdges().size());
        this.prim = prim;
        this.kruskal = kruskal;
    }
}
