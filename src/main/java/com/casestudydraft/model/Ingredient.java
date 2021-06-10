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

    @ManyToOne
    @JoinColumn(name="fk_servingSizeMeasurement")
    private Measurement measurement;


    @ManyToOne
    @JoinColumn(name="fk_categoryId")
    private Category category;

    @OneToMany(mappedBy = "ingredient", cascade = {
            CascadeType.ALL
    })
    private List<IngredientNutrient> ingredientNutrients = new ArrayList<>();

    @OneToMany(mappedBy = "ingredient", cascade = {
            CascadeType.ALL
    })
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

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

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
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