package com.example.bth3;

public class Student {
    private String id;
    private FullName full_name;
    private String gender;
    private String birth_date;
    private String email;
    private String address;
    private String major;
    private double gpa;
    private int year;

    public Student(String id, FullName full_name, String gender, String birth_date, String email, String address, String major, double gpa, int year) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.email = email;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFull_name(FullName full_name) {
        this.full_name = full_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getId() { return id; }
    public FullName getFull_name() { return full_name; }
    public String getGender() { return gender; }
    public double getGpa() { return gpa; }
}

class FullName {
    private String first;
    private String last;
    private String midd;

    public FullName(String first, String midd, String last) {
        this.first = first;
        this.midd = midd;
        this.last = last;
    }

    public String getFirst() { return first; }
    public String getMidd() { return midd; }
    public String getLast() { return last; }
}
