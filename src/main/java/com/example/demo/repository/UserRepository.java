package com.example.demo.repository;

import com.example.demo.crud.UserCrudRepository;
import com.example.demo.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crud;

    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    public Optional<User> getUser(int id){
        return crud.findById(id);
    }
    public User save(User user){
        return crud.save(user);
    }
    public void update(User user){
        crud.save(user);
    }

    public void delete(User user){
        crud.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> usuario= crud.findByEmail(email);
        return usuario.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password){
        return crud.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUsersByNameOrEmail(String name, String email){
        return crud.findByNameOrEmail(name, email);
    }

}
