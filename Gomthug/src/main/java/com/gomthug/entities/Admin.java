package com.gomthug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private String mailAdmin;
    @ManyToOne
    @JoinColumn(name = "User_idU", referencedColumnName = "idU")
    private User user;
}
