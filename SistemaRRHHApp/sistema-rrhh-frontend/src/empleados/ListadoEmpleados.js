import React, { useEffect, useState } from 'react';
import { NumericFormat } from 'react-number-format';
import { Link } from 'react-router-dom';
import axios from 'axios';

function ListadoEmpleados() {
    const urlBase = "http://localhost:8080/api/empleados";

    const [ empleados, setEmpleados ] = useState([]);

    useEffect(() => {
        console.log('hola')
        cargarEmpleados();
    }, []);

    const cargarEmpleados = async () => {
        const resp = await axios.get(urlBase);
        setEmpleados(resp.data);
    };

    const eliminarEmpleado = async id => {
        await axios.delete(`${ urlBase }/${ id }`);
        setEmpleados(empleados.filter(e => e.id != id));
    };

    return (
        <>
            <h3 className="text-center" style={{ margin: "30px" }}>Listado de empleados</h3>
            {/* "table-striped" -> Separa cada registro de la tabla por colores */}
            {/* "table-hover" -> El registro cambia de color cuando pasamos el ratón por encima */}
            {/* "align-middle" -> Alinea los elementos verticalmente */}
            <table className="table table-striped table-hover align-middle">
                <thead className='table-dark'>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Empleado</th>
                        <th scope="col">Departamento</th>
                        <th scope="col">Sueldo</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    { empleados.map(e =>
                        <tr key={ e.id }>
                            <th scope="row">{ e.id }</th>
                            <td>{ e.nombre }</td>
                            <td>{ e.departamento }</td>
                            <td>
                                {/* Este componente NumericFormat es de la dependencia "react-number-format" */}
                                <NumericFormat value={ e.sueldo }
                                    displayType="text"
                                    thousandSeparator=","
                                    prefix="$"
                                    decimalScale={ 2 }
                                    fixedDecimalScale
                                />
                            </td>
                            <td className="text-center">
                                <Link className="btn btn-warning btn-sm me-3" to={ `editar-empleado/${ e.id }` }>Editar</Link>
                                <button className="btn btn-danger btn-sm" onClick={ () => eliminarEmpleado(e.id) }>Eliminar</button>
                            </td>
                        </tr>
                        )
                    }
                </tbody>
            </table>
        </>
  );
}

export default ListadoEmpleados;
