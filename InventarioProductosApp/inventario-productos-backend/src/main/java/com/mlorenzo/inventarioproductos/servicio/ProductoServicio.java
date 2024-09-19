package com.mlorenzo.inventarioproductos.servicio;

import com.mlorenzo.inventarioproductos.excepcion.ProductoNoEncontradoExcepcion;
import com.mlorenzo.inventarioproductos.modelo.Producto;
import com.mlorenzo.inventarioproductos.repositorio.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoServicio implements IProductoServicio {
    private final ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoExcepcion("No se encontró el producto con id " + id));
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto, Integer id) {
        Producto productoEncontrado = buscarProductoPorId(id);
        productoEncontrado.setDescripcion(producto.getDescripcion());
        productoEncontrado.setPrecio(producto.getPrecio());
        productoEncontrado.setExistencias(producto.getExistencias());
        return guardarProducto(productoEncontrado);
    }

    @Override
    public void eliminarProductoPorId(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
