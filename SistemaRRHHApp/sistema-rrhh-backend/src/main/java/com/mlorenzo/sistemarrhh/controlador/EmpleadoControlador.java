package com.mlorenzo.sistemarrhh.controlador;

import com.mlorenzo.sistemarrhh.modelo.Empleado;
import com.mlorenzo.sistemarrhh.servicio.IEmpleadoServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoControlador {
    private final IEmpleadoServicio empleadoServicio;

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerEmpleados() {
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        log.info("Empleados obtenidos: {}", empleados);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id) {
        return empleadoServicio.buscarEmpleadoPorId(id)
                .map(empleado -> {
                    log.info("Empleado encontado: {}", empleado);
                    return ResponseEntity.ok(empleado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Empleado con id " + id + " no encontrado"));
    }

    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoGuardado = empleadoServicio.guardarEmpleado(empleado);
        log.info("Empleados guardado: {}", empleadoGuardado);
        return new ResponseEntity<>(empleadoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable Integer id) {
        Optional<Empleado> optionalEmpleado = empleadoServicio.actualizarEmpleado(empleado, id);
        if(optionalEmpleado.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado con id " + id + " no encontrado");
        Empleado empleadoActualizado = optionalEmpleado.get();
        log.info("Empleado Actualizado: {}", empleadoActualizado);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        log.info("Eliminar empleado con id: {}", id);
        empleadoServicio.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
