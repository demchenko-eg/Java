public class B05_02 {
    public static void main(String[] args) {
        String input = "3abc";
        System.out.println(checkA(input));
        System.out.println(checkB(input));
        System.out.println(checkC(input));
    }

    public static boolean checkA(String s) {
        if (s.length() == 0 || !Character.isDigit(s.charAt(0)) || s.charAt(0) == '0') return false;
        int n = s.charAt(0) - '0';
        if (s.length() != n + 1) return false;
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) return false;
        }
        return true;
    }

    public static boolean checkB(String s) {
        int digitCount = 0;
        int digitValue = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                digitValue = c - '0';
            }
        }
        return digitCount == 1 && digitValue == s.length();
    }

    public static boolean checkC(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum == s.length();
    }
}