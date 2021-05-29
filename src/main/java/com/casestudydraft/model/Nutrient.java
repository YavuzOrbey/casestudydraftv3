package com.casestudydraft.model;

import javax.persistence.*;
import java.util.Set;

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
    private Set<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Measurement measurement;


    public Nutrient() {
        super();
    }


    public Nutrient(String name, Measurement measurement) {
        super();
        this.name = name;
        this.measurement = measurement;
    }



}
