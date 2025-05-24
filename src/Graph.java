public class Graph {
    int[][] adjacencyMatrix; // Weighted matrix
    int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight;
    }

    public int[][] getMatrix() {
        return adjacencyMatrix;
    }
}
