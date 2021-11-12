package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Compagnie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComp;
    private String nomComp;
    private String addrComp;
    private String contactComp;
    private String nomResponsable;
    private String prenomResponsable;
    @ManyToOne
    @JoinColumn(name = "User_idU", referencedColumnName = "idU")
    private User user;
    @OneToMany(mappedBy = "compagnie")
    private List<Depart> departs;
}
