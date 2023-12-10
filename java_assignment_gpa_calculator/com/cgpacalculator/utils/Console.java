package com.cgpacalculator.utils;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPostiveValue(String prompt) {
        int value;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidNumber(inputValue)) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            value = Integer.parseInt(inputValue);
            if (value > 0) break;
        }
        return value;
    }

    public static String retrieveCourseTitle(String prompt) {
        String courseName;

        while (true) {
            System.out.print(prompt);
            courseName = scanner.nextLine();

            if (InputValidator.isValidCourse(courseName)) {
                break;
            }

            System.out.println("Invalid course title. Provide valid one (e.g: MAT101).");
        }
        return courseName;
    }

    public static int retrieveCourseScore(String prompt) {
        int courseScore;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidNumber(inputValue)) {
                System.out.println("Invalid score. Please enter a valid course score.");
                continue;
            }

            courseScore = Integer.parseInt(inputValue);
            
            if (!InputValidator.isValidScore(courseScore)) {
                System.out.printf("Course Score Should be between %d and %d\n", 0, 100);
                continue;
            }
            
            break;
        }
        
        return courseScore;
    }

    public static int retrieveCourseUnit(String prompt) {
        int courseUnit;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidNumber(inputValue)) {
                System.out.println("Invalid input, Please enter a valid course unit.");
                continue;
            }

            courseUnit = Integer.parseInt(inputValue);

            if (courseUnit < 1 || courseUnit > 10) {
                System.out.println("Course unit must be between 1 and 10. Please try again.");
                continue;
            }

            break;
        }

        return courseUnit;
    }
}