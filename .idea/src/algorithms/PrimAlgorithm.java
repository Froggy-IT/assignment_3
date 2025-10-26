package algorithms;

import model.Edge;
import model.Graph;

import java.util.*;

public class PrimAlgorithm {
    public static MSTResult run(Graph graph) {
        long start = System.nanoTime();
        int operations = 0;
        List<Edge> mstEdges = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        String startNode = graph.getNodes().get(0);
        visited.add(startNode);

        for (Edge e : graph.getEdges()) {
            if (e.getFrom().equals(startNode) || e.getTo().equals(startNode)) {
                pq.add(e);
                operations++;
            }
        }

        int totalCost = 0;
        while (!pq.isEmpty() && visited.size() < graph.getNodes().size()) {
            Edge edge = pq.poll();
            operations++;

            String next = null;
            if (visited.contains(edge.getFrom()) && !visited.contains(edge.getTo()))
                next = edge.getTo();
            else if (visited.contains(edge.getTo()) && !visited.contains(edge.getFrom()))
                next = edge.getFrom();

            if (next != null) {
                visited.add(next);
                mstEdges.add(edge);
                totalCost += edge.getWeight();

                for (Edge e : graph.getEdges()) {
                    if ((e.getFrom().equals(next) && !visited.contains(e.getTo())) ||
                            (e.getTo().equals(next) && !visited.contains(e.getFrom()))) {
                        pq.add(e);
                        operations++;
                    }
                }
            }
        }

        double timeMs = (System.nanoTime() - start) / 1_000_000.0;
        return new MSTResult(mstEdges, totalCost, operations, timeMs);
    }
}