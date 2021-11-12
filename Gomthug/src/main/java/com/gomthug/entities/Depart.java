package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Depart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    private Date dteDepart;
    private Date heureDep;
    private Date heureConvocation;
    private String villeDep;
    private String villeDestination;
    @OneToMany(mappedBy = "depart")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "Compagnie_idComp", referencedColumnName = "idComp")
    private Compagnie compagnie;
    @ManyToOne
    @JoinColumn(name = "itineraire_iditineraire", referencedColumnName = "iditineraire")
    private Itineraire itineraire;
}
