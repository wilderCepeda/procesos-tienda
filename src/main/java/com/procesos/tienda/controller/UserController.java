package com.procesos.tienda.controller;

import com.procesos.tienda.model.User;
import com.procesos.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
       return  ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user){

        return  new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping ("users/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable long id){

        return new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
    }
    @DeleteMapping ("users/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        return new ResponseEntity(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
    @GetMapping("users")
    public ResponseEntity<List<User>> findtAll(){
        return  ResponseEntity.ok(userService.findAllUsers());
    }
}
