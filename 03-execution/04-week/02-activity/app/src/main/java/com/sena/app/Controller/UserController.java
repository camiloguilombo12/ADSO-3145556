/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.app.Entity.User;
import com.sena.app.Service.UserService;

@RestController
@RequestMapping("/app/user")
public class UserController {
   
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping("/searchId")
    public Optional<User> searchUsers(
            @RequestParam(required = false) Long id){
        
        if (id != null){
            return userService.getUserById(id);
        }
        
        return null;
    }
    
    @GetMapping("/search")
    public List<User> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        
        if (name != null){
            return userService.getUserByName(name);
        }
        
        if (email != null){
            return List.of(userService.getUserByEmail(email).orElse(null));
        }
        
        return userService.getAllUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ("Usuario eliminado correctamente");
    }  
}
