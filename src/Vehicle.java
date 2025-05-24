public class Vehicle {
    public int id;
    public int currentPosition; // Index in path
    public int[] path;
    public int speed;

    public Vehicle(int id, int[] path) {
        this.id = id;
        this.path = path;
        this.currentPosition = 0;
        this.speed = 1 + (int)(Math.random() * 3);
    }

    public void move() {
        if (currentPosition < (path.length - 1) * 100) {
            currentPosition += speed;
        }
    }

    public void adjustSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
