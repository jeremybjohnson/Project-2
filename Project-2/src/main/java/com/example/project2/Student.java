package com.example.project2;

public class Student {
    private String firstName;
    private double gpa;
    private String email;
    private String gender;

    public Student() {
    }

    public Student(String firstName, double gpa, String email, String gender) {
        this.firstName = firstName;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
