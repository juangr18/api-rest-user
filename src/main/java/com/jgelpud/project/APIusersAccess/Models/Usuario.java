package com.jgelpud.project.APIusersAccess.Models;

import java.util.UUID;

public class Usuario {

    private final UUID id;

    private final String username;

    private final String names;

    private final String lastname;

    private final String email;

    private final String password;

    public Usuario(UUID id, String username, String names, String lastname, String email, String password) {
        this.id = id;
        this.username = username;
        this.names = names;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNames() {
        return names;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", names='" + names + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
