package com.jgelpud.project.APIusersAccess.Controller;

import com.jgelpud.project.APIusersAccess.Models.Usuario;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.*;

import javax.sql.DataSource;
import java.util.Map;
import java.util.UUID;

@Service
@Repository
public class CreateNewUser {
    private final DataSource dataSource;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CreateNewUser(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void createUserInDb(Usuario user){
        UUID id = UUID.randomUUID();
        String username=user.getUsername();
        String name=user.getNames();
        String lastName=user.getLastname();
        String email=user.getEmail();
        String password=user.getPassword();
        Usuario usuario = new Usuario(
                id,
                username,
                name,
                lastName,
                email,
                password
        );
        createUser(usuario);
    }

    public void createUser(Usuario user){
        String sql = "INSERT INTO USUARIOS (id,name_user,name,last_name,email,password) VALUES (:id,:name_user,:name,:last_name,:email,:password)";
        Map<String, Object> param =Map.of(
                "id", user.getId().toString(),
                "name_user", user.getUsername(),
                "name", user.getNames(),
                "last_name", user.getLastname(),
                "email", user.getEmail(),
                "password", user.getPassword()
        );
        namedParameterJdbcTemplate.update(sql, param);
    }

}
