package com.mlorenzo.sistemacuentasbancarias.controlador;

import com.mlorenzo.sistemacuentasbancarias.modelo.CuentaBancaria;
import com.mlorenzo.sistemacuentasbancarias.servicio.ICuentaBancariaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Getter @Setter
@Component
public class IndexControlador {
    private final ICuentaBancariaServicio cuentaBancariaServicio;
    private List<CuentaBancaria> cuentasBancarias;
    private CuentaBancaria cuentaBancaria;

    @PostConstruct
    public void init() {
        cargarCuentas();
    }

    public void cargarCuentas() {
        cuentasBancarias = cuentaBancariaServicio.listarCuentas();
        log.info("Cuentas Bancarias obtenidas: {}", cuentasBancarias);
    }

    public void agregarCuenta() {
        cuentaBancaria = new CuentaBancaria();
    }

    public void guardarCuenta() {
        log.info("Cuenta Bancaria a guardar: {}", cuentaBancaria);

        if(cuentaBancaria.getId() == null) {
            cuentaBancariaServicio.guardarCuentaBancaria(cuentaBancaria);
            cuentasBancarias.add(cuentaBancaria);

            // Creamos un mensaje
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta Agregada"));
        }
        else{
            cuentaBancariaServicio.guardarCuentaBancaria(cuentaBancaria);

            // Creamos un mensaje
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta Actualizada"));
        }

        // Se ocula la ventana o modal
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");

        // Actualizamos el mensaje y la tabla en la vista
        PrimeFaces.current().ajax().update("form-cuentas:mensaje", "form-cuentas:tabla-cuentas");
    }

    public void eliminarCuenta() {
        log.info("Cuenta a eliminar: {}", cuentaBancaria);

        cuentaBancariaServicio.eliminarCuentaBancaria(cuentaBancaria);
        cuentasBancarias.remove(cuentaBancaria);

        // Creamos un mensaje
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta eliminada"));

        // Actualizamos el mensaje y la tabla en la vista
        PrimeFaces.current().ajax().update("form-cuentas:mensaje", "form-cuentas:tabla-cuentas");
    }
}
