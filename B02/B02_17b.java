import java.util.Scanner;

public class B02_17b  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double eps = 0.00001;
        double x = sc.nextDouble();
        if (Math.abs(x) >= 1) {
            System.out.println("No!");
            return;
        }
        double sum = 0.0;
        int k = 0;
        double t;
        while (Math.abs(t) >= eps) {
            sum += t;
            k++;
            t = Math.pow(x, 2 * k + 1) / (2 * k + 1);
        }
        System.out.println(sum);
        sc.close();

    }
}