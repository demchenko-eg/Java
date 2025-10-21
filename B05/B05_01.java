public class B05_01 {
    public static void main(String[] args) {
        String input = "GDGhbndg (RGBFgfshgh) FVEWC (rDHfg)";
        if (isValid(input)) {
            String result = input.replaceAll("\\([^()]*\\)", "").replaceAll(" +", " ").trim();
            System.out.println(result);
        } else {
            System.out.println("Fu");
        }
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) return false;
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
