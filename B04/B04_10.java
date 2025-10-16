import java.util.*;


public class B04_10 {
    public static void main(String[] args) {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new BasicTariff("Start", 1000, 2000));
        tariffs.add(new PremiumTariff("Gold", 500, 10000));
        tariffs.add(new StudentTariff("StudentPack", 2000, 5000));
        tariffs.add(new BasicTariff("Econom", 700, 1000));
        int totalClients = tariffs.stream().mapToInt(Tariff::getClients).sum();
        System.out.println("Загальна кількість клієнтів: " + totalClients);
        Collections.sort(tariffs);
        System.out.println("\nСортування тарифів за абонентською платою:");
        for (Tariff t : tariffs) {
            System.out.println(t);
        }
        int minMb = 2000, maxMb = 6000;
        System.out.println("\nТарифи з інтернетом від " + minMb + " до " + maxMb + " MB:");
        for (Tariff t : tariffs) {
            if (t.getMb() >= minMb && t.getMb() <= maxMb) {
                System.out.println(t);
            }
        }
    }
}