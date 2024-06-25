package com.unicomer.pruebatecnica.unicomer.controladores;


import com.unicomer.pruebatecnica.unicomer.controladores.dto.TaskDTO;
import com.unicomer.pruebatecnica.unicomer.model.Assigned;
import com.unicomer.pruebatecnica.unicomer.model.Task;
import com.unicomer.pruebatecnica.unicomer.servicios.AssignedServiceImpl;
import com.unicomer.pruebatecnica.unicomer.servicios.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskControlador {

    private final TaskServiceImpl taskServiceImpl;
    private final AssignedServiceImpl assignedServiceImpl;

    public TaskControlador(TaskServiceImpl taskServiceImpl, AssignedServiceImpl assignedServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
        this.assignedServiceImpl = assignedServiceImpl;
    }

    @GetMapping("/all")
    public List<Task> getAllTask() {
        return taskServiceImpl.buscarTodos();
    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskServiceImpl.mapToTaskEntity(taskDTO);
        Assigned assigned = assignedServiceImpl.buscarPorId(taskDTO.getAssignedId());
        task.setAssigned(assigned);
        return taskServiceImpl.guardar(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task task = taskServiceImpl.mapToTaskEntity(taskDTO);
        Assigned assigned = assignedServiceImpl.buscarPorId(taskDTO.getAssignedId());
        task.setAssigned(assigned);
        task.setId(id);
        return taskServiceImpl.actualizar(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskServiceImpl.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Task findTask(@PathVariable Long id) {
        return taskServiceImpl.buscarPorId(id);
    }

}
