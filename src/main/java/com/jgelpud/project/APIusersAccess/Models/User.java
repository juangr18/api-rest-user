package com.jgelpud.project.APIusersAccess.Models;


import com.jgelpud.project.APIusersAccess.Commons.Validate;

public class User {

    private final Usuario usuario;

    public User(Usuario usuario) {
        Validate.checkNotNull(usuario);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
