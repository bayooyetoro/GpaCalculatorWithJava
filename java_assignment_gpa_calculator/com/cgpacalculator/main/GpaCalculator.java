/* This is java terminal/console program that takes in users' defined:
1. Number of courses taken
2. courseTitle
3. Positive Score from 0 to 100
4. Grade Points (positive numbers between 1-10 Points Max according to NUC)

It takes all these and calculate the GPA. VOLAA!!!!
*/


package com.cgpacalculator.main;


import com.cgpacalculator.models.Course;
import com.cgpacalculator.services.GpaCalculationService;
import com.cgpacalculator.utils.Console;

public class GpaCalculator {

    public static void main(String[] args) {
        System.out.println("Welcome. Let's help you calculate your GPA");

        int numberOfCourses = Console.getPostiveValue("How many courses did you take?: ");
        Course[] courses = new Course[numberOfCourses];


        for (int i = 0; i < numberOfCourses; i++) {
            Course course = captureCourseInput(i);
            courses[i] = course;
        }

        printCourseInfo(courses);

        double gpa = GpaCalculationService.calculateGPA(courses);
        System.out.printf("\nYour GPA is: %.2f\n", gpa);
    }

    private static void printCourseInfo(Course[] courses) {
        System.out.println("\nCourse details and grades:\n");

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (Course course : courses) {
            String grade = GpaCalculationService.convertToLetterGrade(course.getScore());
            int gradePoint = GpaCalculationService.convertToNumericGrade(course.getScore());

            System.out.format("| %-27s| %-21s | %-10s | %-19s |\n",
            course.getCourseTitle(), course.getUnits(), grade, gradePoint);
        }
        System.out.println("|---------------------------------------------------------------------------------------|");
    }

    private static Course captureCourseInput(int index) {
        int count = index + 1;
        System.out.println("\nEnter details for Course number" + count);

        String courseTitle = Console.retrieveCourseTitle("Course Title (e.g MAT101): ");
        int units = Console.retrieveCourseUnit("Units (1 to 10): ");
        double score = Console.retrieveCourseScore("Score (1 to 100): ");

        return new Course(courseTitle, units, score);
    }
}