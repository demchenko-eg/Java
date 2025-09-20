import java.util.Scanner;

public class B02_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                System.out.println("No!");
                return;
            }
            sum += 1.0 / arr[i];
        }
        double harm = n / sum;
        System.out.println(harm);
        sc.close();
    }
}