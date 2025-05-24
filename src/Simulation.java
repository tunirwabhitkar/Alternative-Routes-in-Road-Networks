import java.util.*;

public class Simulation {
    List<Vehicle> vehicles = new ArrayList<>();
    Graph roadGraph;

    public Simulation(Graph graph) {
        this.roadGraph = graph;
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void run() {
        // Main simulation loop
        for (Vehicle v : vehicles) {
            v.move();
            // check for collision with others
            // if close, reduce speed
        }
    }
}
