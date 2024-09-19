import React from 'react';
import { Link, useLocation } from 'react-router-dom';

function Navegacion() {
    const localizacion = useLocation(); 
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">Sistema de Recursos Humanos</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Link className={ `nav-link ${ localizacion.pathname == "/" ? "active" : "" }` } aria-current="page" to="/">Inicio</Link>
                        </li>
                        <li className="nav-item">
                            <Link className={ `nav-link ${ localizacion.pathname == "/agregar-empleado" ? "active" : "" }` } to="/agregar-empleado">Agregar Empleado</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
  );
}

export default Navegacion;
