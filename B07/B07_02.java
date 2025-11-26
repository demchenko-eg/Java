import java.io.*;
import java.util.*;

public class B07_02 {
    public static void createFile(String file, List<Toy> toys) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (Toy t : toys) out.writeObject(t);
        out.close();
    }

    public static List<Toy> readFile(String file) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        List<Toy> list = new ArrayList<>();
        try {
            while (true) list.add((Toy) in.readObject());
        } catch (EOFException e) {}
        in.close();
        return list;
    }

    public static void main(String[] args) throws Exception {
        List<Toy> toys = Arrays.asList(
                new Toy("М'яч", 150, 3, 12),
                new Toy("Лялька", 300, 4, 10),
                new Toy("Конструктор", 500, 6, 14),
                new Toy("Пазл", 120, 5, 99)
        );

        createFile("toys.bin", toys);
        List<Toy> all = readFile("toys.bin");

        int age = 7;
        List<Toy> fit = new ArrayList<>();
        for (Toy t : all) if (t.fits(age)) fit.add(t);

        createFile("toys_age.bin", fit);
    }
}