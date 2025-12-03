import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B12_01 {
    private static Student loadStudentAndOperations(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        String major = lines.get(0).trim().split("\\s+")[0];
        int requiredCredits = Integer.parseInt(lines.get(1).trim());
        int initialMoney = Integer.parseInt(lines.get(2).trim());
        Student student;
        switch (major) {
            case "humanitarian":
                student = new HumanitarianStudent(requiredCredits, initialMoney);
                break;
            case "natural":
                student = new NaturalStudent(requiredCredits, initialMoney);
                break;
            case "natural-humanitarian":
                student = new NaturalHumanitarianStudent(requiredCredits, initialMoney);
                break;
            default:
                throw new IllegalArgumentException("Невідомий напрям: " + major);
        }
        Pattern pattern = Pattern.compile("(?<action>teach (?:humanitarian|natural)|pay (?:canteen|hostel)|obtain (?:scholarship|help))\\s+(?<value>\\d+)");
        
        StudentActionVisitor visitor = new LifeAndStudyVisitor();

        for (int i = 3; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;
            
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String action = matcher.group("action");
                int value = Integer.parseInt(matcher.group("value"));
                student.accept(visitor, action, value);
                if (student.isExpelled()) {
                    break;
                }
            }
        }
        
        return student;
    }
    
    public static void main(String[] args) {
        String[] files = {"input01.txt", "input02.txt"};
        
        for (String file : files) {
            System.out.println("\n--- Симуляція для " + file + " ---");
            try {
                Student student = loadStudentAndOperations(file); 
                
                System.out.println("Результат симуляції:");
                System.out.println(student);
                
                if (student.getsDiploma()) {
                    System.out.println("Студент отримає диплом!");
                } else {
                    System.out.println("Студент не отримає диплом.");
                    if (student.isExpelled()) {
                         System.out.println("Причина: Відрахований через нестачу коштів на оплату.");
                    } else if (student.getCurrentCredits() < student.getRequiredCredits()) {
                         System.out.println("Причина: Не набрав необхідних кредитів.");
                    }
                }
                
            } catch (IOException e) {
                System.err.println("Помилка: Не вдалося знайти або прочитати файл " + file + ". Переконайтеся, що він знаходиться у кореневій директорії.");
                System.err.println("Деталі: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Невідома помилка симуляції: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}