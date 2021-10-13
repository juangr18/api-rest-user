package com.jgelpud.project.APIusersAccess.View;

import com.jgelpud.project.APIusersAccess.Controller.*;
import com.jgelpud.project.APIusersAccess.Models.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class WebView {

    private final ListUsersDb listUsers;

    private final CreateNewUser createNewUser;

    private final DeleteUser deleteUser;

    private final UpdateUser updateUser;

    public WebView(ListUsersDb listUsers, CreateNewUser createNewUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.listUsers=listUsers;
        this.createNewUser = createNewUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public List<Usuario> listUsers(){
        return listUsers.listToDB();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> filterUserById(@PathVariable("id") UUID id){
        return listUsers.filterUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody Usuario user){
        createNewUser.createUserInDb(user);
    }

    @DeleteMapping("/del/{id}")
    public void deleteUserInDb(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        deleteUser.deleteUser(uuid);
    }

    @PutMapping
    public void updateUser(@RequestBody Usuario user){
        updateUser.updateUser(user);
    }
}
