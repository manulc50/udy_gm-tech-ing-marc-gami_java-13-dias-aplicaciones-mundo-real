package com.mlorenzo.inventarioproductos.repositorio;

import com.mlorenzo.inventarioproductos.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
