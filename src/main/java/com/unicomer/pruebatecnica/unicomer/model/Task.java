package com.unicomer.pruebatecnica.unicomer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date dueDate;
    private String priority;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_id")
    private Assigned assigned;

}
