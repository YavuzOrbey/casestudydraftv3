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

    public Measurement(String name) {
        super();
        this.name = name;
    }



}