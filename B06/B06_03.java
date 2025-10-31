import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_03 {
    public static void main(String[] args) {
        String expression = "+2 - 57 * 33 + 25 / -4";
        String regex = "^[+-]?\\d+(\\s*[+\\-*/]\\s*[+-]?\\d+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()) {
            System.out.println("Yes");
        } else {
            System.out.println("AAAAAAAAA");
        }
    }
}