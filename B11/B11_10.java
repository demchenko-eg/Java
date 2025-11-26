import java.io.*;
import java.net.*;
import java.util.*;

public class B11_10 {
    public static void main(String[] args) throws Exception {
        String city = "kyiv";

        URL url = new URL("https://www.timeanddate.com/weather/ukraine/" + city);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestProperty("User-Agent", "Mozilla");

        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) sb.append(line);
        in.close();

        String html = sb.toString();

        List<String> temp = new ArrayList<>();
        List<String> hum = new ArrayList<>();

        var m1 = java.util.regex.Pattern
                .compile("<td class=\"rbi\">(.*?)</td>")
                .matcher(html);
        while (m1.find()) {
            if (temp.size() == 14) break;
            temp.add(m1.group(1));
        }

        var m2 = java.util.regex.Pattern
                .compile("<td>(\\d+)%</td>")
                .matcher(html);
        while (m2.find()) {
            if (hum.size() == 14) break;
            hum.add(m2.group(1) + "%");
        }

        for (int i = 0; i < temp.size(); i++)
            System.out.println((i+1) + ") T=" + temp.get(i) + "  H=" + hum.get(i));
    }
}