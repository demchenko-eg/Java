import java.io.*;
import java.net.*;
import java.time.*;

public class B11_03 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://godinnik.com/time/київ/");
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestProperty("User-Agent", "Mozilla");

        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) sb.append(line);
        in.close();

        String html = sb.toString();
        int a = html.indexOf("<noscript>");
        int b = html.indexOf("</noscript>");
        String timeStr = html.substring(a + 10, b);

        LocalTime siteTime = LocalTime.parse(timeStr);
        LocalTime local = LocalTime.now();

        System.out.println("Сайт:  " + siteTime);
        System.out.println("Локально: " + local);
        System.out.println("Різниця секунд: " + Math.abs(siteTime.toSecondOfDay() - local.toSecondOfDay()));
    }
}