package com.casestudydraft.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="role_user",
            joinColumns = @JoinColumn(name="role_id",  referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id",  referencedColumnName="id")
    )

    private List<User> rUsers;

    public Role() {
    }



    public Role(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.rUsers = users;
    }
    public List<User> getUsers() {
        return rUsers;
    }

    public void setUserEntity(List<User> users) {
        this.rUsers = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
