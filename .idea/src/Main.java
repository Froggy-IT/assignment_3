import model.Graph;
import algorithms.PrimAlgorithm;
import algorithms.KruskalAlgorithm;
import util.JsonHandler;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputPath = "data/add_3_input.json";
        String outputPath = "data/ass3_output.json";

        List<Graph> graphs = JsonHandler.readGraphs(inputPath);
        List<MSTReport> results = new ArrayList<>();

        for (Graph g : graphs) {
            System.out.println("Processing Graph " + g.getId() + "...");

            MSTResult prim = PrimAlgorithm.run(g);
            MSTResult kruskal = KruskalAlgorithm.run(g);

            results.add(new MSTReport(g.getId(), g, prim, kruskal));
        }

        JsonHandler.writeResults(outputPath, results);
        System.out.println("✅ Results saved to " + outputPath);
    }
}
