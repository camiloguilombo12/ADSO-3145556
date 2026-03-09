/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.app.Service;

import com.sena.app.Entity.Person;
import com.sena.app.IRepository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUAN CAMILO
 */
@Service
public class PersonService {
    
    @Autowired
    private IPersonRepository personRepository;
    
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }
    
    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }
    
    public List<Person> getPersonByName(String name){
        return personRepository.findByName(name);
    }
    
    public List<Person> getPersonByLastName(String lastName){
        return personRepository.findByLastName(lastName);
    }
    
    public Optional<Person> getPersonByDocument(String document){
        return personRepository.findByDocument(document);
            
    }
    
    public Optional<Person> getPersonByPhone(String phone){
        return personRepository.findByPhone(phone);
    }
    
    public Optional<Person> getPersonByEmail(String email){
        return personRepository.findByEmail(email);
    }
    
    public Person save(Person person){
        return personRepository.save(person);
    }
    
    public Person update(Long id, Person person){
        Optional<Person> personData = personRepository.findById(id);
        
        if(personData.isPresent()){
            Person existingPerson=personData.get();
            
            existingPerson.setName(person.getName());
            
            existingPerson.setLastName(person.getLastName());
            
            existingPerson.setDocument(person.getDocument());
            
            existingPerson.setPhone(person.getPhone());
            
            existingPerson.setEmail(person.getEmail());
            
            existingPerson.setUpdateAt(person.getUpdateAt());
            
            existingPerson.setUpdateBy(person.getUpdateBy());
            
            
            return personRepository.save(existingPerson);
        }
        return null;
    }
    
    public void delete(Long id){
        personRepository.deleteById(id);
    }
    
}
