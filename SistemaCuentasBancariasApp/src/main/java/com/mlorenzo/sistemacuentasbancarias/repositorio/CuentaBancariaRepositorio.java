package com.mlorenzo.sistemacuentasbancarias.repositorio;

import com.mlorenzo.sistemacuentasbancarias.modelo.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepositorio extends JpaRepository<CuentaBancaria, Integer> {
}
