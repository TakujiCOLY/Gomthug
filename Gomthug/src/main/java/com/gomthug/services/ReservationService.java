package com.gomthug.services;

import com.gomthug.entities.Reservation;
import com.gomthug.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation add(Reservation reservation) {
        return repository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        return repository.save(reservation);
    }

    public void delete(int reservation) {
        repository.deleteById(reservation);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }
}
