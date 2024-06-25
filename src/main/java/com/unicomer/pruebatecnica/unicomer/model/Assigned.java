package com.unicomer.pruebatecnica.unicomer.model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "assigned")
public class Assigned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private int phoneNumber;
    private int phoneExtension;
}
