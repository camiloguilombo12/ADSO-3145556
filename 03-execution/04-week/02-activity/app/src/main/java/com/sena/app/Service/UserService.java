/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.User;
import com.sena.app.IRepository.IUserRepository;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository userRepository;
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);      
    }
    
    public List<User> getUserByName(String name){
        return userRepository.findByName(name);      
    }
    
    public Optional<User> getUserByPassword(String password){
        return userRepository.findByPassword(password);      
    }
    
    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);      
    }
    
    public User save(User user){
        return userRepository.save(user);
    }
    
    public User update(Long id, User user){
        Optional<User> userData = userRepository.findById(id);
        
        if(userData.isPresent()){
            User existingUser=userData.get();
            
            existingUser.setName(user.getName());
            
            existingUser.setPassword(user.getPassword());
            
            existingUser.setEmail(user.getEmail());
            
            existingUser.setUpdateAt(user.getUpdateAt());
            
            existingUser.setUpdateBy(user.getUpdateBy());
            
            
            return userRepository.save(existingUser);
        } 
        
        return null;
    }
    
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
