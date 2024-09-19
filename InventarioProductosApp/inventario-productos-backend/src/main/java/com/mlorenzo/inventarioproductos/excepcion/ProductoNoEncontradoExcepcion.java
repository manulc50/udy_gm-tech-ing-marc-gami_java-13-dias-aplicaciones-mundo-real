package com.mlorenzo.inventarioproductos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNoEncontradoExcepcion extends RuntimeException {

    public ProductoNoEncontradoExcepcion(String message) {
        super(message);
    }
}
