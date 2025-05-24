import java.util.*;

public class Dijkstra {
    public static int[] shortestPath(Graph graph, int startVertex) {
        int n = graph.numVertices;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < n - 1; i++) {
            int min = findMinVertex(distances, visited);
            visited[min] = true;

            for (int j = 0; j < n; j++) {
                if (graph.adjacencyMatrix[min][j] > 0 && !visited[j] &&
                    distances[min] + graph.adjacencyMatrix[min][j] < distances[j]) {
                    distances[j] = distances[min] + graph.adjacencyMatrix[min][j];
                }
            }
        }

        return distances;
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, vertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                vertex = i;
                min = distance[i];
            }
        }
        return vertex;
    }
}
