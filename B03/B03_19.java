import java.util.*;

class Flight {
    String destination;
    String flightNumber;
    String departureTime;
    List<String> days;
    Flight(String destination, String flightNumber, String departureTime, List<String> days) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.days = days;
    }
    int getMinutes() {
        String[] parts = departureTime.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
    public String toString() {
        return "Рейс " + flightNumber + " -> " + destination + " | Виліт: " + departureTime + " | Дні: " + days;
    }
}

public class B03_19 {
    public static Flight[] filterByDestination(Flight[] flights, String dest) {
        List<Flight> list = new ArrayList<>();
        for (Flight f : flights) {
            if (f.destination.equalsIgnoreCase(dest)) {
                list.add(f);
            }
        }
        list.sort(Comparator.comparingInt(Flight::getMinutes));
        return list.toArray(new Flight[0]);
    }
    public static Flight[] filterByDay(Flight[] flights, String day) {
        List<Flight> list = new ArrayList<>();
        for (Flight f : flights) {
            if (f.days.contains(day)) {
                list.add(f);
            }
        }
        return list.toArray(new Flight[0]);
    }
    public static void main(String[] args) {
        Flight f1 = new Flight("Київ", "PS101", "08:30", Arrays.asList("Пн", "Ср", "Пт"));
        Flight f2 = new Flight("Львів", "PS202", "12:45", Arrays.asList("Вт", "Чт", "Сб"));
        Flight f3 = new Flight("Київ", "PS103", "06:15", Arrays.asList("Пн", "Вт", "Ср"));
        Flight f4 = new Flight("Одеса", "PS304", "18:00", Arrays.asList("Пт", "Нд"));
        Flight f5 = new Flight("Київ", "PS105", "14:10", Arrays.asList("Пн", "Чт", "Нд"));
        Flight[] flights = {f1, f2, f3, f4, f5};
        System.out.println("Рейси до Києва:");
        for (Flight f : filterByDestination(flights, "Київ")) {
            System.out.println(f);
        }
        System.out.println("\nРейси у Понеділок:");
        for (Flight f : filterByDay(flights, "Пн")) {
            System.out.println(f);
        }
    }
}