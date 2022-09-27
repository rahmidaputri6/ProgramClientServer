/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mida.user.sevice.CONTROLLER;

import com.mida.user.sevice.service.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author asus
 */
public class UserController {
    private UserService userService;
    
    @GetMapping("/user")
    public List<User> getAllUsers(){
         return userService.getAllUsers(); 
    }
    
    @GetMapping("/user/(id)")
    public List<User> getUsers(@PathVariable String id) {
        return userService.getAllUsers(); 
    }
    @PostMapping("/user")
    public ResponseEntity<Object> addUser(User user){
        userService.addUser(user);
        URI path;
        path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/(id)")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    
    @DeleteMapping("/user/id")
    public User deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
