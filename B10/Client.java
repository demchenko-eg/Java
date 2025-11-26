import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println(5);

        out.println("10 3 25 14 50 7");
        System.out.println(in.readLine());

        out.println("1 5 15 20 40 4 100");
        System.out.println(in.readLine());

        out.println("END");

        s.close();
    }
}