import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_01 {
    public static void main(String[] args) {
        String text = "Документ від 06.01.2020 та оновлено ___ . ___ . ____ повторно 12.05.2023.";
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        String regex = "\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b|_{3}\\. _{3}\\. _{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(formattedDate);
        System.out.println(result);
    }
}