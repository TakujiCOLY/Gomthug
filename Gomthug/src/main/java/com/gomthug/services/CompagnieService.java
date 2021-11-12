package com.gomthug.services;

import com.gomthug.entities.Compagnie;
import com.gomthug.repositories.CompagnieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompagnieService {
    private final CompagnieRepository repository;

    public CompagnieService(CompagnieRepository repository) {
        this.repository = repository;
    }

    public Compagnie add(Compagnie compagnie) {
        return repository.save(compagnie);
    }

    public Compagnie update(Compagnie compagnie) {
        return repository.save(compagnie);
    }

    public void delete(int compagnie) {
        repository.deleteById(compagnie);
    }

    public List<Compagnie> findAll() {
        return repository.findAll();
    }
}
