import java.io.*;
import java.util.concurrent.*;

public class B09_01 {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> q = new LinkedBlockingQueue<>();
        int T1 = 500;
        int T2 = 700;
        int T3 = 900;

        Thread reader = new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new FileReader("F.txt"));
                String line;
                while ((line = in.readLine()) != null) {
                    q.put(line);
                    Thread.sleep(T1);
                }
                q.put("EOF");
                in.close();
            } catch (Exception e) {}
        });

        Thread worker1 = new Thread(() -> {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("out1.txt"));
                while (true) {
                    String s = q.take();
                    if (s.equals("EOF")) {
                        q.put("EOF");
                        break;
                    }
                    out.write(s);
                    out.newLine();
                    Thread.sleep(T2);
                }
                out.close();
            } catch (Exception e) {}
        });

        Thread worker2 = new Thread(() -> {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("out2.txt"));
                while (true) {
                    String s = q.take();
                    if (s.equals("EOF")) {
                        q.put("EOF");
                        break;
                    }
                    out.write(s);
                    out.newLine();
                    Thread.sleep(T3);
                }
                out.close();
            } catch (Exception e) {}
        });

        reader.start();
        worker1.start();
        worker2.start();

        reader.join();
        worker1.join();
        worker2.join();
    }
}