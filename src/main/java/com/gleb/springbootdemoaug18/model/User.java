package com.gleb.springbootdemoaug18.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TOKEN")
    private String token;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String email, String token, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

   /* public static User of(RegisterUserDto userDto) {
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setToken(userDto.getToken());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        return user;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}