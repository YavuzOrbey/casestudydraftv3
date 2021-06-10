package com.casestudydraft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="measurement")
public class Measurement extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false)
    private String name;
/*
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="measurement_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private List<Ingredient> ingredients;*/

    @OneToMany(mappedBy="measurement", orphanRemoval=true, cascade = CascadeType.ALL)
    private List<Nutrient> nutrients;

    @OneToMany(mappedBy="measurement", orphanRemoval=true, cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;
    public Measurement() {
    }

    public Measurement(String name) {
        super();
        this.name = name;
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

/*    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }*/

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}