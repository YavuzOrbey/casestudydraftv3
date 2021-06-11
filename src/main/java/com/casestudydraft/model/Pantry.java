package com.casestudydraft.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="pantry")
public class Pantry extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable=false)
    private User user;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="pantry_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private Set<Ingredient> ingredients;

    public Pantry() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
