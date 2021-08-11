package com.jgelpud.project.APIusersAccess.Controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Service
@Repository
public class DeleteUser {

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    private final ListUsersDb listUsersDb;

    public DeleteUser(DataSource dataSource, JdbcTemplate jdbcTemplate, ListUsersDb listUsersDb) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.listUsersDb = listUsersDb;
    }

    public void deleteUser(UUID id){
        String sql = "DELETE FROM USUARIOS WHERE id = ?;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id.toString());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Option delete error: " + id, throwables);
        }
    }



}
