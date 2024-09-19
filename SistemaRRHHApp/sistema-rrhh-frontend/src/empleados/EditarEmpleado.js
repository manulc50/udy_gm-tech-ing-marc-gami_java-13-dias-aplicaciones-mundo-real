import React, { Fragment, useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

export default function EditarEmpleado() {
    const urlBase = "http://localhost:8080/api/empleados";

    const navegacion = useNavigate();

    const { id } = useParams();

    const [ empleado, setEmpleado ] = useState({
        nombre: "",
        departamento: "",
        sueldo: ""
    });

    const { nombre, departamento, sueldo } = empleado;

    useEffect(() => {
        cargarEmpleado();
    }, []);

    const cargarEmpleado = async () => {
        const resp = await axios.get(`${ urlBase }/${ id }`);
        setEmpleado(resp.data);
    };

    const onInputChange = e => setEmpleado({ ...empleado, [e.target.name]: e.target.value });

    const onSubmit = async e => {
        e.preventDefault();
        await axios.put(`${ urlBase }/${ id }`, empleado);
        navegacion("/");
    };

    return (
        <Fragment>
            <h3 className="text-center" style={{ margin: "30px" }}>Editar Empleado</h3>
            {/* Versión simplificada de la expresión "e => onSubmit(e)" */}
            <form onSubmit={ onSubmit }>
                <div className="mb-3">
                    <label htmlFor="nombre" className="form-label">Nombre</label>
                    {/* Versión simplificada de la expresión "e => onInputChange(e)" */}
                    <input type="text"
                        className="form-control"
                        id="nombre"
                        name="nombre"
                        value={ nombre }
                        onChange={ onInputChange }
                        required={ true } />
                </div>
                <div className="mb-3">
                    <label htmlFor="departamento" className="form-label">Departamento</label>
                    <input type="text"
                        className="form-control"
                        id="departamento"
                        name="departamento"
                        value={ departamento }
                        onChange={ onInputChange }
                        required={ true } />
                </div>
                <div className="mb-3">
                    <label htmlFor="sueldo" className="form-label">Sueldo</label>
                    {/* step="any" -> Para poder introducir números decimales */}
                    <input type="number"
                        step="any"
                        className="form-control"
                        id="sueldo"
                        name="sueldo"
                        value={ sueldo }
                        onChange={ onInputChange }
                        required={ true } />
                </div>
                <div className="text-center">
                    <button type="submit" className="btn btn-warning btn-sm me-3">Editar</button>
                    <Link className="btn btn-danger btn-sm" to={ "/" }>Volver</Link>
                </div>
            </form>
        </Fragment>
    );
}
