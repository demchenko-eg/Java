public class A05_01 {
    public static void main(String[] args) {
        String s = "buyg47+65             e+gb++7qyu7q  8vcihv  phphph re3hfbg";
        System.out.println(a(s));
        System.out.println(b(s));
        System.out.println(c(s));
        System.out.println(d(s))
    }
    static public String a(String s) {
        char[] result = new char[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            result[j++] = s.charAt(i);
            if (Character.isDigit(s.charAt(i)))
                result[j++] = s.charAt(i);
        }
        return new String(result);
    }
    static public String b(String s) {
        StringBuilder sb = new StringBuilder(s)
        int i = 0;
        while (true) {
            i = sb.indexOf("+", i);
            if (i == -1 || i + 1 == sb.length())
                break;
            if (Character.isDigit(sb.charAt(i + 1))) {
                sb.deleteCharAt(i);
                if (i > 0)
                    i--;
            }
            else
                i++;
        }
        return sb.toString();
    }
    static public String c(String s) {
        return s.replaceAll("ph", "f");
    }
    static public String d(String s) {
        return s.replaceAll("\\s+", " ");
    }
}