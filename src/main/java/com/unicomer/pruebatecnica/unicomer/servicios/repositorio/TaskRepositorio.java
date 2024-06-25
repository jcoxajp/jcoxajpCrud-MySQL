package com.unicomer.pruebatecnica.unicomer.servicios.repositorio;

import com.unicomer.pruebatecnica.unicomer.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositorio extends JpaRepository<Task, Long> {

}
