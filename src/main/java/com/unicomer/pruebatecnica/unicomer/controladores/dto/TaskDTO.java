package com.unicomer.pruebatecnica.unicomer.controladores.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskDTO {
    private String name;
    private Date dueDate;
    private String priority;
    private String status;
    private Long assignedId;
}
