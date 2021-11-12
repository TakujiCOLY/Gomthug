package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Itineraire implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iditineraire;
    private String libelleIt;
    @OneToMany(mappedBy = "itineraire")
    private List<Depart> departs;
}
