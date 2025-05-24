import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;

public class Renderer implements GLEventListener {

    private Graph graph;
    private Simulation simulation;
    private float[][] nodeCoords;  // Node positions for visualization

    public Renderer(Graph graph, Simulation simulation) {
        this.graph = graph;
        this.simulation = simulation;
        initializeNodeCoordinates();
    }

    private void initializeNodeCoordinates() {
        int n = graph.numVertices;
        nodeCoords = new float[n][2];
        // Place nodes in a circle layout
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            nodeCoords[i][0] = (float) (0.8 * Math.cos(angle));
            nodeCoords[i][1] = (float) (0.8 * Math.sin(angle));
        }
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        drawEdges(gl);
        drawNodes(gl);
        drawVehicles(gl);
    }

    private void drawNodes(GL2 gl) {
        gl.glColor3f(0.0f, 0.5f, 1.0f);
        for (float[] coord : nodeCoords) {
            drawCircle(gl, coord[0], coord[1], 0.05f);
        }
    }

    private void drawEdges(GL2 gl) {
        gl.glColor3f(0.6f, 0.6f, 0.6f);
        gl.glBegin(GL2.GL_LINES);
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = i + 1; j < graph.numVertices; j++) {
                if (graph.adjacencyMatrix[i][j] > 0) {
                    gl.glVertex2f(nodeCoords[i][0], nodeCoords[i][1]);
                    gl.glVertex2f(nodeCoords[j][0], nodeCoords[j][1]);
                }
            }
        }
        gl.glEnd();
    }

    private void drawVehicles(GL2 gl) {
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        for (Vehicle v : simulation.vehicles) {
            int[] path = v.path;
            int step = Math.min(v.currentPosition, path.length - 2);
            int from = path[step];
            int to = path[step + 1];

            float t = (float) (v.currentPosition % 100) / 100f;  // for movement between nodes
            float x = (1 - t) * nodeCoords[from][0] + t * nodeCoords[to][0];
            float y = (1 - t) * nodeCoords[from][1] + t * nodeCoords[to][1];

            drawRectangle(gl, x, y, 0.03f, 0.02f);
        }
    }

    private void drawCircle(GL2 gl, float x, float y, float r) {
        int segments = 30;
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            gl.glVertex2f(x + r * (float) Math.cos(angle), y + r * (float) Math.sin(angle));
        }
        gl.glEnd();
    }

    private void drawRectangle(GL2 gl, float x, float y, float width, float height) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(x - width, y - height);
        gl.glVertex2f(x + width, y - height);
        gl.glVertex2f(x + width, y + height);
        gl.glVertex2f(x - width, y + height);
        gl.glEnd();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1f, 1f, 1f, 1f);
        GLU glu = new GLU();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-1.2, 1.2, -1.2, 1.2);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup (not used here)
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        // Optional resizing logic
    }
}
