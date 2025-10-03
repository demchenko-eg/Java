public class A05_03 {
    public static void main(String[] args) {
        a("input.txt", "output.txt")
    }
    public static void a(String[] inp, String[] out) {
        try {
            FileReader fr = new FileReader(inp);
            Scanner in = new Scanner(fr);
            String longestWord = "";
            while (in.has.Next()) {
                String word = in.next();
                if word.length() > longestWord.length()
                    longestWord = word;
            }
            FileWriter fw = new FileWriter(out);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(longestWord);
            pw.close;
            in close;
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void b(String[] inp, String[] out) {
        File finp = new File(inp);
        File fout = new File(out);
        Path pathInp = new finp.toPath();
        Path pathOut = new fout.toPath();
        try {
            var br = Files.newBufferedReader(pathInp);
            var bw = Files.newBufferedWriter(pathOut);
            int count = 0;
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                count += line.split("\\s+").length();
            }
            bw.write(Integer.toString(count));
            br.close();
            bw.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void c(String[] inp, String[] out) {
        Path pathInp = Path.of(inp);
        Path pathOut = Path.of(out);
        try {
            List<String> lst = Files.readAllLines(pathInp);
            for (int i = 0; i < lst.size(); i++) {
                lst.set(i, lst.get(i).trim().replaceAll("\\s+"), " ");
            }
            Files.write(pathOut, lst);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}