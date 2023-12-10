package com.cgpacalculator.utils;

public class InputValidator {
    public static boolean isValidScore(int courseScore) {
        return courseScore >= 0 && courseScore <= 100;
    }

    public static boolean isValidCourse(String courseName) {

        return courseName != null && !courseName.trim().isEmpty();
    }

    public static boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
