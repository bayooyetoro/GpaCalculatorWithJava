package com.cgpacalculator.models;

public class Course {
    private String courseTitle;
    private int units;
    private double score;

    public Course(String courseTitle, int units, double score) {
        this.courseTitle = courseTitle;
        this.units = units;
        this.score = score;
    }

    public int getUnits() {
        return units;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public double getScore() {
        return score;
    }
}
