package com.gomthug.services;

import com.gomthug.entities.User;
import com.gomthug.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User add(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
