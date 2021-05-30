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
    private int id;


    @Column(name="email")
    @Email
    private String email;

    @Column(name="password")
    @NotBlank(message="Password is required")
    @Size(message ="Password must be at least 6 characters in length")
    private String password;



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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}