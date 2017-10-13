package com.teamnine.carrepairs.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "access")
    private String access;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
