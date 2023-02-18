package org.example;

public class Checks {
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
