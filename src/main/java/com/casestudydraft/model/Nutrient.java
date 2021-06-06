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

    @OneToMany(mappedBy = "nutrient", cascade = {
            CascadeType.ALL
    })
    private List<IngredientNutrient> ingredientNutrients = new ArrayList<>();;
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


    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public List<IngredientNutrient> getIngredientNutrients() {
        return ingredientNutrients;
    }

    public void setIngredientNutrients(List<IngredientNutrient> ingredientNutrients) {
        this.ingredientNutrients = ingredientNutrients;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurement=" + measurement +
                '}';
    }
}
