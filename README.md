Assignment 3: Optimization of a City Transportation Network (Minimum Spanning Tree)

Objective
The goal of this project is to optimize the city’s road network by connecting all districts with the minimum total cost. To achieve this, two Minimum Spanning Tree (MST) algorithms — Prim’s Algorithm and Kruskal’s Algorithm — were implemented and compared. The algorithms were tested on multiple city graphs to analyze efficiency and performance.

Input and Output Description

Input file:
src/input/ass3_input.json
The JSON file contains several graph objects. Each graph represents a city map where nodes represent districts and edges represent possible roads with construction costs.

Example of input structure:
{
"graphs": [
{
"id": 1,
"nodes": ["A", "B", "C", "D"],
"edges": [
{"from": "A", "to": "B", "weight": 4},
{"from": "A", "to": "C", "weight": 2},
{"from": "B", "to": "C", "weight": 5},
{"from": "B", "to": "D", "weight": 10},
{"from": "C", "to": "D", "weight": 3}
]
}
]
}

Output file:
src/output/ass_3_output.json
The JSON output contains MST results for each graph, including total cost, operations, and execution time for both algorithms.

Example of output structure:
{
"results": [
{
"graphId": 1,
"prim": {
"totalCost": 9,
"operationsCount": 10,
"executionTimeMs": 0.03,
"mstEdges": [
{"from": "A", "to": "C", "weight": 2},
{"from": "C", "to": "D", "weight": 3},
{"from": "A", "to": "B", "weight": 4}
]
},
"kruskal": {
"totalCost": 9,
"operationsCount": 8,
"executionTimeMs": 0.02,
"mstEdges": [
{"from": "A", "to": "C", "weight": 2},
{"from": "C", "to": "D", "weight": 3},
{"from": "A", "to": "B", "weight": 4}
]
}
}
]
}

Algorithms Implemented

a) Prim’s Algorithm
Prim’s algorithm starts from one vertex and grows the MST by continuously adding the smallest edge that connects a visited vertex to an unvisited one. It uses a priority queue (min-heap) to efficiently select the next smallest edge.
Time Complexity: O(E log V)
Space Complexity: O(V + E)

b) Kruskal’s Algorithm
Kruskal’s algorithm sorts all edges by weight and adds them one by one to the MST, skipping any edge that would form a cycle. It uses a Disjoint Set Union (Union-Find) data structure to detect cycles efficiently.
Time Complexity: O(E log E)
Space Complexity: O(V + E)

Implementation Structure

Package structure:
assignment3/
src/
algorithms/
PrimAlgorithm.java
KruskalAlgorithm.java
model/
Edge.java
Graph.java
MSTResult.java
MSTReport.java
util/
JsonHandler.java
input/
ass3_input.json
output/
ass_3_output.json
Main.java

Each class is responsible for a specific task:
Graph and Edge represent the structure of the city network.
PrimAlgorithm and KruskalAlgorithm implement the MST algorithms.
MSTResult and MSTReport store and format the results.
JsonHandler reads input and writes output JSON files.
Main coordinates the process and manages results.

Results and Comparison

After processing all graphs, both algorithms produced identical MSTs with the same total cost, confirming correctness. However, performance differences were observed:

Algorithm | Average Operations | Average Time (ms) | Result Quality
Prim’s | 10–15 | 0.03–0.05 | Optimal MST
Kruskal’s | 8–10 | 0.02–0.04 | Optimal MST

Observation
Kruskal’s algorithm performed slightly faster due to simpler edge sorting on small to medium graphs.
Prim’s algorithm becomes more efficient for dense graphs with many edges.
Both guarantee an optimal MST with minimum total road cost.

Conclusion

Both Prim’s and Kruskal’s algorithms effectively optimize city transportation networks by minimizing road construction costs. While Kruskal’s algorithm is more efficient for sparse graphs, Prim’s algorithm is better suited for dense networks. The implementation successfully demonstrated the algorithms’ correctness and efficiency, producing accurate MST results stored in a structured JSON format.

References
Cormen, T. H., Leiserson, C. E., Rivest, R. L., and Stein, C. (2009). Introduction to Algorithms, 3rd Edition. MIT Press.
GeeksforGeeks. Difference between Prim’s and Kruskal’s Algorithm.
CLRS Algorithm Visualization Resources.
