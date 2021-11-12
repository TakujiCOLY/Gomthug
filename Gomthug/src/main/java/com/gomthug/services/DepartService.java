package com.gomthug.services;

import com.gomthug.entities.Depart;
import com.gomthug.repositories.DepartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartService {
    private final DepartRepository repository;

    public DepartService(DepartRepository repository) {
        this.repository = repository;
    }

    public Depart add(Depart depart) {
        return repository.save(depart);
    }

    public Depart update(Depart depart) {
        return repository.save(depart);
    }

    public void delete(int depart) {
        repository.deleteById(depart);
    }

    public List<Depart> findAll() {
        return repository.findAll();
    }
}
