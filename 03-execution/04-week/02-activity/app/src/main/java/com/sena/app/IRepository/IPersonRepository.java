/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sena.app.IRepository;

import com.sena.app.Entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN CAMILO
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
    
    @Override
    Optional<Person>  findById(Long id);
    
    List<Person> findByName(String name);
    
    List<Person> findByLastName(String lastName);
    
    Optional<Person> findByDocument(String document);
    
    Optional<Person> findByPhone(String phone);
    
    Optional<Person> findByEmail(String email);
}
