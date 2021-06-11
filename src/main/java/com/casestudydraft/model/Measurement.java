package com.casestudydraft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="measurement")
public class Measurement extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @OneToMany(mappedBy="measurement", cascade = CascadeType.ALL)
    private List<Nutrient> nutrients;

    @OneToMany(mappedBy="measurement", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;
    public Measurement() {
    }

    public Measurement(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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