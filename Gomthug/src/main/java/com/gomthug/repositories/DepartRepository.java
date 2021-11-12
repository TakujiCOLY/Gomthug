package com.gomthug.repositories;

import com.gomthug.entities.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
