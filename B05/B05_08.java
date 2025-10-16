import java.io.*;
import java.util.*;

public class B05_08 {
    static class Cube {
        private int size;
        private String color;
        private String material;

        public Cube(int size, String color, String material) {
            this.size = size;
            this.color = color.toLowerCase();
            this.material = material.toLowerCase();
        }

        public int getSize() {
            return size;
        }

        public String getColor() {
            return color;
        }

        public String toString() {
            return size + " см, " + color + ", " + material;
        }
    }

    public static void main(String[] args) {
        List<Cube> cubes = readCubesFromFile("cubes.txt");

        int targetSize = 5;
        List<Cube> foundCubes = findCubesBySize(cubes, targetSize);
        System.out.println("Кубики з ребром " + targetSize + " см:");
        for (Cube cube : foundCubes) {
            System.out.println(cube);
        }

        Map<String, Integer> colorCounts = countCubesByColor(cubes);
        System.out.println("\nКількість кубиків за кольором:");
        for (Map.Entry<String, Integer> entry : colorCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Cube> readCubesFromFile(String filename) {
        List<Cube> cubes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                if (parts.length == 3) {
                    int size = Integer.parseInt(parts[0]);
                    String color = parts[1];
                    String material = parts[2];
                    cubes.add(new Cube(size, color, material));
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка зчитування файлу: " + e.getMessage());
        }
        return cubes;
    }

    public static List<Cube> findCubesBySize(List<Cube> cubes, int size) {
        List<Cube> result = new ArrayList<>();
        for (Cube cube : cubes) {
            if (cube.getSize() == size) {
                result.add(cube);
            }
        }
        return result;
    }

    public static Map<String, Integer> countCubesByColor(List<Cube> cubes) {
        Map<String, Integer> colorCount = new HashMap<>();
        for (Cube cube : cubes) {
            colorCount.put(cube.getColor(), colorCount.getOrDefault(cube.getColor(), 0) + 1);
        }
        return colorCount;
    }
}