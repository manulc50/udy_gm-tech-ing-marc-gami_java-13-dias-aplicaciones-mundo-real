package com.mlorenzo.sistemarrhh.servicio;

import com.mlorenzo.sistemarrhh.modelo.Empleado;
import com.mlorenzo.sistemarrhh.repositorio.EmpleadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmpleadoServicio implements IEmpleadoServicio {
    private final EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Optional<Empleado> buscarEmpleadoPorId(Integer id) {
        return empleadoRepositorio.findById(id);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public Optional<Empleado> actualizarEmpleado(Empleado empleado, Integer id) {
        return buscarEmpleadoPorId(id)
                .map(e -> {
                    e.setNombre(empleado.getNombre());
                    e.setDepartamento(empleado.getDepartamento());
                    e.setSueldo(empleado.getSueldo());
                    return guardarEmpleado(e);
                });
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        empleadoRepositorio.deleteById(id);
    }
}
