package com.mlorenzo.inventarioproductos.controlador;

import com.mlorenzo.inventarioproductos.modelo.Producto;
import com.mlorenzo.inventarioproductos.servicio.IProductoServicio;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/productos")
public class ProductoControlador {
    private final IProductoServicio productoServicio;

    @GetMapping
    public List<Producto> obtenerProductos() {
        List<Producto> productos = productoServicio.listarProductos();
        log.info("Productos obtenidos: {}", productos);
        return productos;
    }

    @GetMapping("{productoId}")
    public Producto obtenerProductoPorId(@PathVariable("productoId") Integer id) {
        Producto producto = productoServicio.buscarProductoPorId(id);
        log.info("Productos obtenido: {}", producto);
        return producto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        Producto produtoGuardado = productoServicio.guardarProducto(producto);
        log.info("Producto guardado: {}", produtoGuardado);
        return produtoGuardado;
    }

    @PutMapping("{productoId}")
    public Producto actualizarProducto(@RequestBody Producto producto,
                                       @PathVariable(name = "productoId") Integer id) {
        Producto productoActualizado = productoServicio.actualizarProducto(producto, id);
        log.info("Producto Actualizado: {}", productoActualizado);
        return productoActualizado;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{productoId}")
    public void eliminarProducto(@PathVariable(value = "productoId") Integer id) {
        log.info("Eliminar producto con id: {}", id);
        productoServicio.eliminarProductoPorId(id);
    }
}
