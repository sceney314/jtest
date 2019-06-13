package jdk8.streams;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-11 14:43
 * Description:
 */
public class Dish {
    private String name;

    private Integer Calory;

    private String type;

    private Integer level;

    private Boolean vegetarian;

    public Dish() {
    }

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, Integer calory) {
        this.name = name;
        Calory = calory;
    }

    public Dish(String name, Integer calory, String type) {
        this.name = name;
        Calory = calory;
        this.type = type;
    }

    public Dish(String name, Integer calory, String type, Integer level) {
        this.name = name;
        Calory = calory;
        this.type = type;
        this.level = level;
    }

    public Dish(String name, Integer calory, String type, Integer level, Boolean vegetarian) {
        this.name = name;
        Calory = calory;
        this.type = type;
        this.level = level;
        this.vegetarian = vegetarian;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalory() {
        return Calory;
    }

    public void setCalory(Integer calory) {
        Calory = calory;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", Calory=" + Calory +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
