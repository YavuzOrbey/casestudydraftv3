package com.casestudydraft.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ingredient")
public class Ingredient extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="serving_size")
    private int servingSize;

    @Column(name="calories")
    private int calories;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Measurement> measurements;

    @ManyToMany(mappedBy = "ingredients")
    private List<Nutrient> nutrients;


    public Ingredient() {
        super();
    }

    public Ingredient(String name, int servingSize, int calories) {
        super();
        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }


}