package com.mlorenzo.sistemacuentasbancarias.servicio;

import com.mlorenzo.sistemacuentasbancarias.modelo.CuentaBancaria;

import java.util.List;

public interface ICuentaBancariaServicio {
    List<CuentaBancaria> listarCuentas();
    CuentaBancaria buscarCuentaBancariaPorId(Integer id);
    void guardarCuentaBancaria(CuentaBancaria cuentaBancaria);
    void eliminarCuentaBancaria(CuentaBancaria cuentaBancaria);
}
