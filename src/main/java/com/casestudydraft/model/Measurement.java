package com.casestudydraft.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="measurement")
public class Measurement extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false)
    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="measurement_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy="measurement")
    private Set<Nutrient> nutrients;

    public Measurement() {
    }

    public Measurement(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Set<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString() {
        return this.name;
    }
}