public class B01_05 {
    public static void main(String[] args) {
        int N, M;
        if (args.length >= 2) {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            N = scanner.nextInt();
            M = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int num = (int) (Math.random() * M);
            System.out.println(num);
        }
    }
}
