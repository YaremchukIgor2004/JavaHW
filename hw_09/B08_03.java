package hw_09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B08_03 {
    private Map<String, Set<String>> adjacencyList;

    public B08_03() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void removeVertex(String vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public void addEdge(String vertex1, String vertex2) {
        adjacencyList.putIfAbsent(vertex1, new HashSet<>());
        adjacencyList.putIfAbsent(vertex2, new HashSet<>());
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(String vertex1, String vertex2) {
        Set<String> edgesFromV1 = adjacencyList.get(vertex1);
        Set<String> edgesFromV2 = adjacencyList.get(vertex2);
        if (edgesFromV1 != null) edgesFromV1.remove(vertex2);
        if (edgesFromV2 != null) edgesFromV2.remove(vertex1);
    }

    public void printGraph() {
        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
            System.out.println("Вершина " + entry.getKey() + " суміжна з: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
    	B08_03 graph = new B08_03();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        System.out.println("Граф після додавання вершин і ребер:");
        graph.printGraph();
        graph.removeEdge("A", "B");
        System.out.println("\nГраф після видалення ребра між A і B:");
        graph.printGraph();
        graph.removeVertex("C");
        System.out.println("\nГраф після видалення вершини C:");
        graph.printGraph();
    }
}
