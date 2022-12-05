package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        solvePart1(getExampleInput());
        solvePart1(getTaskInput());

        solvePart2(getExampleInput());
        solvePart2(getTaskInput());
    }

    public static void solvePart1(List<String> input) {
        System.out.println(input);

        int score = 0;

        for (String pair : input) {
            Elve elve1 = mapToElve(pair.split(",")[0]);
            Elve elve2 = mapToElve(pair.split(",")[1]);

            if (elve1.start() >= elve2.start() && elve1.end() <= elve2.end() ||
                    elve2.start() >= elve1.start() && elve2.end() <= elve1.end())   {
                score++;
            }
        }

        System.out.println(score);
    }

    public static Elve mapToElve(String input) {
        int start = Integer.parseInt(input.split("-")[0]);
        int end = Integer.parseInt(input.split("-")[1]);
        return new Elve(start, end);
    }

    public static void solvePart2(List<String> input) {
        System.out.println(input);
        int score = 0;

        for (String pair : input) {
            Elve elve1 = mapToElve(pair.split(",")[0]);
            Elve elve2 = mapToElve(pair.split(",")[1]);

            if (elve1.end() >= elve2.start() && elve1.start() <= elve2.end())   {
                score++;
            }
        }

        System.out.println(score);
    }

    private static List<String> getTaskInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay4.txt"));
    }

    private static List<String> getExampleInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay4-example.txt"));
    }
}
