import java.util.Scanner;

public class B01_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String l = scanner.nextLine();
        String[] ps = l.split(" ");
        int res = 1;
        for (String p : ps) {
            res *= Integer.parseInt(p);
        }
        System.out.println(res);
    }
}
