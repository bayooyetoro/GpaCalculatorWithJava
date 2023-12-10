package com.cgpacalculator.services;

import com.cgpacalculator.models.Course;

public class GpaCalculationService {
    public static String convertToLetterGrade(double score) {
        if (score >= 70 && score <= 100) {
            return "A";
        } else if (score >= 60 && score < 70) {
            return "B";
        } else if (score >= 50 && score < 60) {
            return "C";
        } else if (score >= 45 && score < 50) {
            return "D";
        } else if (score >= 40 && score < 45) {
            return "E";
        } else if (score >= 0 && score < 40) {
            return "F";
        } else {
            return "Invalid Score";
        }
    }

    public static int convertToNumericGrade(double score) {
        String letterGrade = convertToLetterGrade(score);

        return switch (letterGrade.toUpperCase()) {
            case "A" -> 5;
            case "B" -> 4;
            case "C" -> 3;
            case "D" -> 2;
            case "E" -> 1;
            default -> 0;
        };
    }

    public static double calculateGPA(Course[] courses) {
        double totalGradePoints = 0;
        double totalUnits = 0;

        for (Course course : courses) {
            double gradePoint = convertToNumericGrade(course.getScore());
            int units = course.getUnits();

            totalGradePoints += gradePoint * units;
            totalUnits += units;
        }

        if (totalUnits == 0) {
            return 0.0;
        }

        return totalGradePoints / totalUnits;
    }
}
