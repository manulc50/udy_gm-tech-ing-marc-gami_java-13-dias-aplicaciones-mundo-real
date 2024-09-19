package com.mlorenzo.sistemacuentasbancarias.servicio;

import com.mlorenzo.sistemacuentasbancarias.modelo.CuentaBancaria;
import com.mlorenzo.sistemacuentasbancarias.repositorio.CuentaBancariaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CuentaBancariaServicio implements ICuentaBancariaServicio {
    private final CuentaBancariaRepositorio cuentaBancariaRepositorio;

    @Override
    public List<CuentaBancaria> listarCuentas() {
        return cuentaBancariaRepositorio.findAll();
    }

    @Override
    public CuentaBancaria buscarCuentaBancariaPorId(Integer id) {
        return cuentaBancariaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        cuentaBancariaRepositorio.save(cuentaBancaria);
    }

    @Override
    public void eliminarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        cuentaBancariaRepositorio.delete(cuentaBancaria);
    }
}
