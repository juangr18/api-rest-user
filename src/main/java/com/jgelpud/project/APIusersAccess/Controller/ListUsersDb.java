package com.jgelpud.project.APIusersAccess.Controller;

import com.jgelpud.project.APIusersAccess.Models.Usuario;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Repository
public class ListUsersDb {

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    public ListUsersDb(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Usuario> listToDB(){
        String sql = "SELECT * FROM USUARIOS;";
        return jdbcTemplate.query(sql, this::getUser);
    }

    private Usuario getUser(ResultSet resultSet, int rowNum)throws SQLException {
        String uuid=resultSet.getString("id");
        String nameUser=resultSet.getString("name_user");
        String name=resultSet.getString("name");
        String last=resultSet.getString("last_name");
        String email=resultSet.getString("email");
        String pwd=resultSet.getString("password");
        UUID id = UUID.fromString(uuid);
        return new Usuario(id,nameUser,name,last,email,pwd);
    }

    public Optional<Usuario> filterUserById(UUID id){
        String sql = "SELECT * FROM USUARIOS WHERE id = ?;";
        PreparedStatementSetter setter = ps -> ps.setString(1, id.toString());
        List<Usuario> usuarios = jdbcTemplate.query(sql, setter, this::getUser);
        Usuario unsafeUsuario = DataAccessUtils.singleResult(usuarios);
        return Optional.ofNullable(unsafeUsuario);
    }
}
