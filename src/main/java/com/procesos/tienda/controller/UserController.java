package com.procesos.tienda.controller;

import com.procesos.tienda.model.User;
import com.procesos.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable long id){
       return  userService.getUserById(id);
    }

    @PostMapping("users")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping ("users/{id}")
    public User update(@RequestBody User user,@PathVariable long id){

        return userService.updateUser(user,id);
    }
    @DeleteMapping ("users/{id}")
    public Boolean delete(@PathVariable Long id){

        return userService.deleteUser(id);
    }
    @GetMapping("users")
    public List<User> findtAll(){
        return userService.findAllUsers();
    }
}
