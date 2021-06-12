package com.casestudydraft.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "pantry", cascade = {
            CascadeType.ALL
    })
    private List<PantryIngredient> pantryIngredients = new ArrayList<>();

    public Pantry() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PantryIngredient> getPantryIngredients() {
        return pantryIngredients;
    }

    public void setPantryIngredients(List<PantryIngredient> pantryIngredients) {
        this.pantryIngredients = pantryIngredients;
    }
}
