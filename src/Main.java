import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create a road graph
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);

        // 2. Run Dijkstra’s algorithm from source 0
        int[] shortestDistances = Dijkstra.shortestPath(graph, 0);
        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("To " + i + ": " + shortestDistances[i]);
        }

        // 3. Create simulation and vehicles
        Simulation simulation = new Simulation(graph);
        // Dummy vehicle (real logic can be added later)
        Vehicle v1 = new Vehicle(1, new int[] {0, 1, 2, 4, 5});
        simulation.addVehicle(v1);

        // 4. Setup JOGL
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);

        Renderer renderer = new Renderer(graph, simulation);
        canvas.addGLEventListener(renderer);
        canvas.setSize(800, 600);

        final JFrame frame = new JFrame("Alternative-Routes Road Network Simulation");
        frame.getContentPane().add(canvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 5. Animation loop (basic)
        new Thread(() -> {
            while (true) {
                simulation.run();        // update vehicle positions
                canvas.display();        // render updated state
                try {
                    Thread.sleep(100);   // delay for 10 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
