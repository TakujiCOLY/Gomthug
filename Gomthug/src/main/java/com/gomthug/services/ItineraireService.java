package com.gomthug.services;

import com.gomthug.entities.Itineraire;
import com.gomthug.repositories.ItineraireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraireService {
    private final ItineraireRepository repository;

    public ItineraireService(ItineraireRepository repository) {
        this.repository = repository;
    }

    public Itineraire add(Itineraire itineraire) {
        return repository.save(itineraire);
    }

    public Itineraire update(Itineraire itineraire) {
        return repository.save(itineraire);
    }

    public void delete(int itineraire) {
        repository.deleteById(itineraire);
    }

    public List<Itineraire> findAll() {
        return repository.findAll();
    }
}
