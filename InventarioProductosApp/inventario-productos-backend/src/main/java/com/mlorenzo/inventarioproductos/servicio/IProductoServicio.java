package com.mlorenzo.inventarioproductos.servicio;

import com.mlorenzo.inventarioproductos.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer id);
    Producto guardarProducto(Producto producto);
    Producto actualizarProducto(Producto producto, Integer id);
    void eliminarProductoPorId(Integer id);
}
