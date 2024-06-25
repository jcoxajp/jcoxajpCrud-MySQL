package com.unicomer.pruebatecnica.unicomer.servicios.repositorio;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CrudRepositorio<T, ID> {
    T guardar(T entity);
    T actualizar(T entity);
    void eliminar(ID id);
    T buscarPorId(ID id);
    List<T> buscarTodos();

}
