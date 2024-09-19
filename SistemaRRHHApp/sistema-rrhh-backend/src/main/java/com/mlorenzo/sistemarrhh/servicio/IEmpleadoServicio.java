package com.mlorenzo.sistemarrhh.servicio;

import com.mlorenzo.sistemarrhh.modelo.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoServicio {
    List<Empleado> listarEmpleados();
    Optional<Empleado> buscarEmpleadoPorId(Integer id);
    Empleado guardarEmpleado(Empleado empleado);
    Optional<Empleado> actualizarEmpleado(Empleado empleado, Integer id);
    void eliminarEmpleado(Integer id);
}
