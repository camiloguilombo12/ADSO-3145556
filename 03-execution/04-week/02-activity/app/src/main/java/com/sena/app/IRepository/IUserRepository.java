package com.sena.app.IRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.app.Entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Override
    Optional<User> findById(Long id);
    
    List<User> findByName(String name);
    
    Optional<User> findByPassword(String password);
    
    Optional<User> findByEmail(String email);
    
}

