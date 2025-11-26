import java.io.*;
import java.util.*;

public class B07_01 {
    public static double[] readArray(String file) throws Exception {
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        List<Double> list = new ArrayList<>();
        while (in.available() > 0) list.add(in.readDouble());
        in.close();
        double[] a = new double[list.size()];
        for (int i = 0; i < a.length; i++) a[i] = list.get(i);
        return a;
    }

    public static void main(String[] args) throws Exception {
        double[] f = {3.1, -2.5, 7.0, 4.4, 1.2};
        DataOutputStream out = new DataOutputStream(new FileOutputStream("F.bin"));
        for (double v : f) out.writeDouble(v);
        out.close();

        double[] arr = readArray("F.bin");
        double a = 2.0;

        DataOutputStream g = new DataOutputStream(new FileOutputStream("G.bin"));
        for (double v : arr) if (v > a) g.writeDouble(v);
        g.close();
    }
}