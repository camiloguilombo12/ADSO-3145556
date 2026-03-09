/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.app.Controller;

import com.sena.app.Entity.Person;
import com.sena.app.Service.PersonService;
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

/**
 *
 * @author JUAN CAMILO
 */
@RestController
@RequestMapping("/app/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    
    @GetMapping("/searchId")
    public Optional<Person> searchPeople(
            @RequestParam(required = false) Long id){
        
        if (id != null){
            return personService.getPersonById(id);
        }
        return null;
    }
    
    @GetMapping("/search")
    public List<Person> searchPeople(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String document,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String email){
        
        if(name != null){
            return personService.getPersonByName(name);
        }
        if(lastName != null){
            return personService.getPersonByLastName(lastName);
        }
        if(document != null){
            return List.of(personService.getPersonByDocument(document).orElse(null));
        }
        if(phone != null){
            return List.of(personService.getPersonByPhone(phone).orElse(null));
        }
        if(email != null){
            return List.of(personService.getPersonByEmail(email).orElse(null));
        }
        
        return personService.getAllPeople();
        
    }
    
    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.save(person);
    }
    
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.update(id, person);
    }
    
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.delete(id);
        return ("persona eliminada");
    }    
}
