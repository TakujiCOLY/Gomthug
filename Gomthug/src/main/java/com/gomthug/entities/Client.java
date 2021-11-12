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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String telClient;
    private String addrClient;
    private String mailClient;
    private Date dteInscription;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "User_idU", referencedColumnName = "idU")
    private User user;
}
