import java.io.*;

public class Toy implements Serializable {
    String name;
    double price;
    int minAge, maxAge;

    public Toy(String n, double p, int minA, int maxA) {
        name = n;
        price = p;
        minAge = minA;
        maxAge = maxA;
    }

    public boolean fits(int age) {
        return age >= minAge && age <= maxAge;
    }
}