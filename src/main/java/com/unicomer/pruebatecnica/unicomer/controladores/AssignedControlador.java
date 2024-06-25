package com.unicomer.pruebatecnica.unicomer.controladores;


import com.unicomer.pruebatecnica.unicomer.controladores.dto.AssignedDTO;
import com.unicomer.pruebatecnica.unicomer.model.Assigned;
import com.unicomer.pruebatecnica.unicomer.servicios.AssignedServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assigned")
public class AssignedControlador {

    private final AssignedServiceImpl assignedServiceImpl;

    public AssignedControlador(AssignedServiceImpl assignedServiceImpl) {
        this.assignedServiceImpl = assignedServiceImpl;
    }

    @GetMapping("/all")
    public List<Assigned> getAllAssigned() {
        return assignedServiceImpl.buscarTodos();
    }

    @PostMapping("/save")
    public Assigned saveAssigned(@RequestBody AssignedDTO assignedDTO) {
        Assigned assigned = assignedServiceImpl.mapToAssignedEntity(assignedDTO);
        return assignedServiceImpl.guardar(assigned);
    }

    @PutMapping("/update/{id}")
    public Assigned updateAssigned(@PathVariable Long id, @RequestBody AssignedDTO assignedDTO) {
        Assigned assigned = assignedServiceImpl.mapToAssignedEntity(assignedDTO);
        assigned.setId(id);
        return assignedServiceImpl.actualizar(assigned);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssigned(@PathVariable Long id) {
        assignedServiceImpl.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Assigned findAssigned(@PathVariable Long id) {
        return assignedServiceImpl.buscarPorId(id);
    }
}
