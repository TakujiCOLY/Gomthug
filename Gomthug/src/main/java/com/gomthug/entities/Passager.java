package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPas;
    private String nomPas;
    private String prenomPass;
    private int agePas;
    @ManyToOne
    @JoinColumn(name = "Reservation_idReservation", referencedColumnName = "idReservation")
    private Reservation reservation;

}
