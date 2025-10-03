class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    double distance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
}

class Quadrilateral {
    Point a, b, c, d;
    Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a; this.b = b; this.c = c; this.d = d;
    }
    double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(d) + d.distance(a);
    }
    String type() {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double cd = c.distance(d);
        double da = d.distance(a);
        double ac = a.distance(c);
        double bd = b.distance(d);
        boolean allSidesEqual = Math.abs(ab - bc) < 1e-6 && Math.abs(bc - cd) < 1e-6 && Math.abs(cd - da) < 1e-6;
        boolean oppositeSidesEqual = Math.abs(ab - cd) < 1e-6 && Math.abs(bc - da) < 1e-6;
        boolean diagonalsEqual = Math.abs(ac - bd) < 1e-6;
        if (allSidesEqual && diagonalsEqual) return "Квадрат";
        if (oppositeSidesEqual && diagonalsEqual) return "Прямокутник";
        if (allSidesEqual) return "Ромб";
        return "Довільний";
    }
}

public class B03_06 {
    public static void countTypes(Quadrilateral[] arr) {
        int squares = 0, rectangles = 0, rhombuses = 0, others = 0;
        for (Quadrilateral q : arr) {
            switch (q.type()) {
                case "Квадрат": squares++; break;
                case "Прямокутник": rectangles++; break;
                case "Ромб": rhombuses++; break;
                default: others++;
            }
        }
        System.out.println("Квадратів: " + squares);
        System.out.println("Прямокутників: " + rectangles);
        System.out.println("Ромбів: " + rhombuses);
        System.out.println("Довільних: " + others);
    }
    public static Quadrilateral maxPerimeter(Quadrilateral[] arr) {
        Quadrilateral maxQ = arr[0];
        for (Quadrilateral q : arr) {
            if (q.perimeter() > maxQ.perimeter()) {
                maxQ = q;
            }
        }
        return maxQ;
    }
    public static void main(String[] args) {
        Quadrilateral q1 = new Quadrilateral(new Point(0,0), new Point(0,2), new Point(2,2), new Point(2,0));
        Quadrilateral q2 = new Quadrilateral(new Point(0,0), new Point(0,3), new Point(4,3), new Point(4,0));
        Quadrilateral q3 = new Quadrilateral(new Point(0,0), new Point(1,2), new Point(3,2), new Point(2,0));
        Quadrilateral q4 = new Quadrilateral(new Point(0,0), new Point(1,1), new Point(2,0), new Point(1,-1));
        Quadrilateral[] arr = {q1, q2, q3, q4};
        countTypes(arr);
        Quadrilateral maxQ = maxPerimeter(arr);
        System.out.println("Найбільший периметр: " + maxQ.perimeter() + " (" + maxQ.type() + ")");
    }
}