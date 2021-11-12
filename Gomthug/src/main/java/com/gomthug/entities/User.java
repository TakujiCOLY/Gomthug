package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idU;
    private String loginU;
    private String mdpU;
    @OneToMany(mappedBy = "user")
    private List<Admin> admins;
    @OneToMany(mappedBy = "user")
    private List<Client> clients;
    @OneToMany(mappedBy = "user")
    private List<Compagnie> compagnies;
}
