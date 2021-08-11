package com.jgelpud.project.APIusersAccess.Controller;

import com.jgelpud.project.APIusersAccess.Models.User;
import com.jgelpud.project.APIusersAccess.Models.Usuario;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Repository
public class UpdateUser {

    private final DataSource dataSource;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final ListUsersDb listUsersDb;

    public UpdateUser(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate, ListUsersDb listUsersDb) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.listUsersDb = listUsersDb;
    }

    public void actualizarUser(Usuario user){
        String sql = "UPDATE USUARIOS SET name_user= :name_user, name = :name , last_name = :last_name,email = :email, password= :password WHERE id = :id";
        Map<String, Object> param =Map.of(
                "id", user.getId().toString(),
                "name_user", user.getUsername(),
                "name", user.getNames(),
                "last_name", user.getLastname(),
                "email", user.getEmail(),
                "password", user.getPassword()
        );
        namedParameterJdbcTemplate.update(sql, param);
        new User(user);
    }

    public void updateUser(Usuario user){
        UUID idUser = user.getId();
        Optional<Usuario> userExists = listUsersDb.filterUserById(user.getId());
        if(userExists.isPresent()){
            Usuario usuarioDB = userExists.get();
            Usuario usuarioUpdate = new Usuario(
                    usuarioDB.getId(),
                    user.getUsername(),
                    user.getNames(),
                    user.getLastname(),
                    user.getEmail(),
                    user.getPassword()
            );
            actualizarUser(usuarioUpdate);
            new User(usuarioUpdate);
        } else{
            throw new IllegalArgumentException("User by id " + idUser + " does not exist.");
        }
    }


}
