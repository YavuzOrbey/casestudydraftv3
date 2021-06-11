package com.casestudydraft.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name="email")
    @Email
    @NotBlank(message="Required")
    private String email;

    @Column(name="password")
    @NotBlank(message="Password is required")
    @Size(min=6, message ="Password must be at least 6 characters in length")
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToOne(mappedBy = "user")
    private Pantry pantry;

    @ManyToMany(mappedBy = "rUsers")
    private List<Role> userRoles;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id")
    )
    private Set<Recipe> recipe;


    public User() {
    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return userRoles;
    }

    public void setRoles(List<Role> roles) {
        this.userRoles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}