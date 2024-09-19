package com.mlorenzo.sistemarrhh.repositorio;

import com.mlorenzo.sistemarrhh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
