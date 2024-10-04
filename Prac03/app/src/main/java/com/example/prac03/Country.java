package com.example.prac03;

public class Country {
    private String name;
    private String capital;
    private String population;
    private String area;
    private int flag;

    public Country(String name, String capital, String population, String area, int flag) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public int getFlag() {
        return flag;
    }
}
