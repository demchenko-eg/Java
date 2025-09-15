import java.util.Scanner;

public class B01_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double g = Math.cbrt(a * b * c);
        System.out.printf("%.4f\n", g);
    }
}