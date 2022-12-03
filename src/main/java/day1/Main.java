package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        solvePart1(getExampleInput());
        solvePart1(getTaskInput());


        solvePart2(getExampleInput());
        solvePart2(getTaskInput());
    }

    public static void solvePart1(List<String> input) {

        System.out.println(input);

        List<List<String>> elves = new ArrayList<>();
        int index = input.indexOf("");

        while (index != -1) {
            List<String> elve = new ArrayList<>(input.subList(0, index));
            elves.add(elve);

            input.removeAll(elve);
            input.remove(0);
            index = input.indexOf("");
        }
        elves.add(input);

        Integer mostCals = elves.stream()
                .map(e -> e.stream()
                        .map(Integer::parseInt)
                        .reduce(Integer::sum).get())
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        System.out.println(mostCals);
    }

    public static void solvePart2(List<String> input) {
        System.out.println(input);

        List<List<String>> elves = new ArrayList<>();
        int index = input.indexOf("");

        while (index != -1) {
            List<String> elve = new ArrayList<>(input.subList(0, index));
            elves.add(elve);

            input.removeAll(elve);
            input.remove(0);
            index = input.indexOf("");
        }

        elves.add(input);

        int combinedCals = elves.stream()
                .map(e -> e.stream()
                        .map(Integer::parseInt)
                        .reduce(Integer::sum).get())
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(combinedCals);
    }

    private static List<String> getTaskInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay1.txt"));
    }

    private static List<String> getExampleInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay1-example.txt"));
    }
}
