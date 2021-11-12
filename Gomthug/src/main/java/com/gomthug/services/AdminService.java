package com.gomthug.services;

import com.gomthug.entities.Admin;
import com.gomthug.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin add(Admin admin) {
        return repository.save(admin);
    }

    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    public void delete(int admin) {
        repository.deleteById(admin);
    }

    public List<Admin> findAll() {
        return repository.findAll();
    }
}
