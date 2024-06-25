package com.unicomer.pruebatecnica.unicomer.servicios;

import com.unicomer.pruebatecnica.unicomer.controladores.dto.TaskDTO;
import com.unicomer.pruebatecnica.unicomer.model.Task;
import com.unicomer.pruebatecnica.unicomer.servicios.repositorio.CrudRepositorio;
import com.unicomer.pruebatecnica.unicomer.servicios.repositorio.TaskRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements CrudRepositorio<Task, Long> {
    private final TaskRepositorio taskRepositorio;

    public TaskServiceImpl(TaskRepositorio taskRepositorio) {
        this.taskRepositorio = taskRepositorio;
    }

    @Override
    public Task guardar(Task entity) {
        return taskRepositorio.save(entity);
    }

    @Override
    public Task actualizar(Task entity) {
        return taskRepositorio.save(entity);
    }

    @Override
    public void eliminar(Long aLong) {
        taskRepositorio.deleteById(aLong);
    }

    @Override
    public Task buscarPorId(Long aLong) {
        return taskRepositorio.findById(aLong).orElse(null);
    }

    @Override
    public List<Task> buscarTodos() {
        return taskRepositorio.findAll();
    }

    public Task mapToTaskEntity(TaskDTO task) {
        Task newTask = new Task();
        newTask.setName(task.getName());
        newTask.setDueDate(task.getDueDate());
        newTask.setPriority(task.getPriority());
        newTask.setStatus(task.getStatus());
        return newTask;
    }
}
