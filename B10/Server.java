import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        int k = Integer.parseInt(in.readLine());

        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("END")) break;
            String[] arr = line.split("\\s+");
            int cnt = 0;
            for (String x : arr) {
                int v = Integer.parseInt(x);
                if (v % k == 0) cnt++;
            }
            out.println(cnt);
        }

        s.close();
        ss.close();
    }
}