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
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private Date dteRes;
    private int nbPlace;
    @ManyToOne
    @JoinColumn(name = "Depart_idDep", referencedColumnName = "idDepart")
    private Depart depart;
    @ManyToOne
    @JoinColumn(name = "Client_idClient", referencedColumnName = "idClient")
    private Client client;
    @OneToMany(mappedBy = "reservation")
    private List<Passager> passagers;
}
