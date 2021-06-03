package com.casestudydraft.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="nutrient")
public class Nutrient extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false)
    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="nutrient_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Measurement measurement;


    public Nutrient() {
    }


    public Nutrient(String name, Measurement measurement) {
        super();
        this.name = name;
        this.measurement = measurement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", measurement=" + measurement +
                '}';
    }
}
