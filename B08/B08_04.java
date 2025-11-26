import java.util.*;

class Point {
    double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double dist() {
        return Math.sqrt(x*x + y*y);
    }
}

public class B08_04 {
    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(Point::dist));

        pq.add(new Point(3,4));
        pq.add(new Point(1,1));
        pq.add(new Point(-2,5));
        pq.add(new Point(0,7));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            System.out.println(p.x + " " + p.y);
        }
    }
}