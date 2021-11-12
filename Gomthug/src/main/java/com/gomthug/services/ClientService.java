package com.gomthug.services;

import com.gomthug.entities.Client;
import com.gomthug.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client add(Client client) {
        return repository.save(client);
    }

    public Client update(Client client) {
        return repository.save(client);
    }

    public void delete(int client) {
        repository.deleteById(client);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }
}
