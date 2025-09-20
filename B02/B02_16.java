import java.util.Scanner;

public class B02_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short n1 = sc.nextShort();
        short n2 = sc.nextShort();
        short sp = (short) (n1 & n2);
        int count = 0;
        while (sp != 0) {
            count += sp & 1;
            sp >>= 1;
        }
        System.out.println(count);
        sc.close();
    }
}