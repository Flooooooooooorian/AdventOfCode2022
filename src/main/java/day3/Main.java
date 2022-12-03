package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        for (String content : input) {
            String compartmentOne = content.substring(0, content.length() / 2);
            String compartmentTwo = content.substring(content.length() / 2);

            score += findWrongItem(compartmentOne, compartmentTwo);
        }

        System.out.println(score);
    }

    public static void solvePart2(List<String> input) {
        System.out.println(input);
        int score = 0;

        for (int i = 0; i < input.size(); i += 3) {
            String firstBag = input.get(i);
            String secondBag = input.get(i + 1);
            String thirdBag = input.get(i + 2);

            char item = findBadgeItem(firstBag, secondBag, thirdBag);
            score += priorityOf(item);
        }
        System.out.println(score);
    }

    public static char findBadgeItem(String firstBag, String secondBag, String thirdBag) {
        char[] firstItems = firstBag.toCharArray();

        for (char firstItem : firstItems) {
            if (secondBag.contains(String.valueOf(firstItem)) && thirdBag.contains(String.valueOf(firstItem))) {
                return firstItem;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int findWrongItem(String compartmentOne, String compartmentTwo) {
        char[] items = compartmentOne.toCharArray();

        for (char item : items) {
            if (compartmentTwo.contains(String.valueOf(item))) {
                return priorityOf(item);
            }
        }
        throw new IllegalArgumentException();
    }

    private static int priorityOf(char item) {
        if (item > 96) {
            return item - 96;
        }

        return item - 38;
    }

    private static List<String> getTaskInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay3.txt"));
    }

    private static List<String> getExampleInput() throws IOException {
        return Files.readAllLines(Path.of("./src/main/resources/inputDay3-example.txt"));
    }
}
