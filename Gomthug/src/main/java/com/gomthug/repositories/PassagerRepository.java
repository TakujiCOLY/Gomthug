package com.gomthug.repositories;

import com.gomthug.entities.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRepository extends JpaRepository<Passager, Integer> {
}
