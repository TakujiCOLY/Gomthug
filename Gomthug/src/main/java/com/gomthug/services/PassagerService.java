package com.gomthug.services;

import com.gomthug.entities.Passager;
import com.gomthug.repositories.PassagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerService {
    private final PassagerRepository repository;

    public PassagerService(PassagerRepository repository) {
        this.repository = repository;
    }

    public Passager add(Passager passager) {
        return repository.save(passager);
    }

    public Passager update(Passager passager) {
        return repository.save(passager);
    }

    public void delete(int passager) {
        repository.deleteById(passager);
    }

    public List<Passager> findAll() {
        return repository.findAll();
    }
}
