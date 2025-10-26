package algorithms;

import model.Edge;
import model.Graph;

import java.util.*;

public class KruskalAlgorithm {
    static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        public String find(String x) {
            if (!parent.get(x).equals(x))
                parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(String a, String b) {
            String pa = find(a), pb = find(b);
            if (!pa.equals(pb)) parent.put(pa, pb);
        }

        public void makeSet(Collection<String> nodes) {
            for (String n : nodes) parent.put(n, n);
        }
    }

    public static MSTResult run(Graph graph) {
        long start = System.nanoTime();
        int operations = 0;
        List<Edge> mstEdges = new ArrayList<>();

        List<Edge> sortedEdges = new ArrayList<>(graph.getEdges());
        sortedEdges.sort(Comparator.comparingInt(Edge::getWeight));
        operations += sortedEdges.size();

        UnionFind uf = new UnionFind();
        uf.makeSet(graph.getNodes());

        int totalCost = 0;
        for (Edge e : sortedEdges) {
            String root1 = uf.find(e.getFrom());
            String root2 = uf.find(e.getTo());
            operations++;

            if (!root1.equals(root2)) {
                uf.union(root1, root2);
                mstEdges.add(e);
                totalCost += e.getWeight();
            }
        }

        double timeMs = (System.nanoTime() - start) / 1_000_000.0;
        return new MSTResult(mstEdges, totalCost, operations, timeMs);
    }
}