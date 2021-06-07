package com.casestudydraft.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ingredient")
public class Ingredient extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="serving_size")
    @NotNull(message = "Required")
    @Min(1)
    private Integer servingSize;

    @Column(name="calories")
    @NotNull(message = "Required")
    @Min(0)
    private Integer calories;

    @Column(name="name")
    @NotEmpty(message="Required")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Measurement> measurements;
    
    @OneToMany(mappedBy = "ingredient", cascade = {
            CascadeType.ALL
    })
    private List<IngredientNutrient> ingredientNutrients = new ArrayList<>();

    public Ingredient() {
        super();
    }

    public Ingredient(String name, Integer servingSize, Integer calories) {
        super();
        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServingSize() {
        return servingSize;
    }

    public void setServingSize(Integer servingSize) {
        this.servingSize = servingSize;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<IngredientNutrient> getIngredientNutrients() {
        return ingredientNutrients;
    }

    public void setIngredientNutrients(List<IngredientNutrient> ingredientNutrients) {
        this.ingredientNutrients = ingredientNutrients;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", servingSize=" + servingSize +
                ", calories=" + calories +
                ", name='" + name + '\'' +
                '}';
    }
}