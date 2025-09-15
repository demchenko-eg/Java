import java.util.Scanner;

public class B01_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть прізвище: ");
        String ss = scanner.nextLine();
        System.out.println("Привіт, " + ss);
    }
}