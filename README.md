# 🚦 Alternative Routes in Road Networks

## 📋 Project Overview

This project simulates traffic routing on a road network to find the fastest route between a source and destination using **Dijkstra’s shortest path algorithm**. It incorporates **dynamic, randomly generated traffic conditions** that affect route weights and vehicle speeds.

The simulation also includes **collision avoidance** by dynamically adjusting vehicle speeds during movement to prevent overlaps or crashes. Visualization of the road network and vehicle movement is done using **Java OpenGL (JOGL)**. 🎮🚗

---

## ⚙️ Features

- 🛣️ **Shortest Path Calculation:** Uses Dijkstra’s algorithm to find the optimal route in real-time.
- 🚦 **Dynamic Traffic Simulation:** Edge weights update randomly to simulate changing traffic conditions.
- 🚘 **Collision Avoidance:** Vehicles adjust speeds dynamically to avoid collisions.
- 🎨 **2D Visualization:** Render nodes, edges, and vehicles using JOGL for an interactive experience.

---

## 🧰 Technologies Used

| Technology     | Purpose                          |
|----------------|---------------------------------|
| 💻 Java           | Core simulation and logic        |
| 🎨 JOGL (OpenGL)  | Visualization of road network    |
| 🔍 Dijkstra’s Algorithm | Pathfinding between nodes     |
| 🖥️ Java AWT/Swing | GUI and window management        |

---

## 🏗️ System Components

- 🗺️ **Graph:** Represents the road network as nodes (intersections) and edges (roads with weights).
- 🚀 **Dijkstra’s Algorithm:** Calculates shortest path with dynamic traffic-based weights.
- 🚙 **Vehicle:** Simulates vehicle movement along paths with speed adjustments.
- 🖌️ **Renderer:** Handles OpenGL drawing of the network and vehicles.
- ▶️ **Main:** Initializes the simulation and OpenGL canvas, manages the main loop.

---

## ▶️ How to Run

1. Download and include JOGL libraries in your project.
2. Compile Java source files with JOGL jars in the classpath.
3. Run the Main class to start the simulation.

---

## 🎯 Outcome

This project demonstrates a prototype for intelligent traffic routing systems. It can be extended for real-world applications such as smart navigation, traffic management, and route optimization tools.

---

## 👤 Author

Your Name

---

Feel free to ask if you want me to add a build guide or screenshots to this README!
