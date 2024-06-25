package com.unicomer.pruebatecnica.unicomer.servicios;

import com.unicomer.pruebatecnica.unicomer.controladores.dto.AssignedDTO;
import com.unicomer.pruebatecnica.unicomer.model.Assigned;
import com.unicomer.pruebatecnica.unicomer.servicios.repositorio.AssignedRepositorio;
import com.unicomer.pruebatecnica.unicomer.servicios.repositorio.CrudRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignedServiceImpl implements CrudRepositorio<Assigned, Long>{
    private final AssignedRepositorio assignedRepositorio;

    public AssignedServiceImpl(AssignedRepositorio assignedRepositorio) {
        this.assignedRepositorio = assignedRepositorio;
    }

    @Override
    public Assigned guardar(Assigned entity) {
        return assignedRepositorio.save(entity);
    }

    @Override
    public Assigned actualizar(Assigned entity) {
        return assignedRepositorio.save(entity);
    }

    @Override
    public void eliminar(Long aLong) {
        assignedRepositorio.deleteById(aLong);
    }

    @Override
    public Assigned buscarPorId(Long aLong) {
        return assignedRepositorio.findById(aLong).orElse(null);
    }

    @Override
    public List<Assigned> buscarTodos() {
        return assignedRepositorio.findAll();
    }
    public Assigned mapToAssignedEntity(AssignedDTO assigned) {
        Assigned newAssigned = new Assigned();
        newAssigned.setFullName(assigned.getFullName());
        newAssigned.setEmail(assigned.getEmail());
        newAssigned.setPhoneNumber(assigned.getPhoneNumber());
        newAssigned.setPhoneExtension(assigned.getPhoneExtension());
        return newAssigned;
    }
}
