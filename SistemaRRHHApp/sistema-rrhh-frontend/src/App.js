import { BrowserRouter, Route, Routes } from "react-router-dom";

import ListadoEmpleados from "./empleados/ListadoEmpleados";
import Navegacion from "./plantilla/Navegacion";
import AgregarEmpleado from "./empleados/AgregarEmpleado";
import EditarEmpleado from "./empleados/EditarEmpleado";

function App() {
  return (
    <BrowserRouter>
      <div className="container">
        <Navegacion />
        <Routes>
          <Route exact path="/" element={ <ListadoEmpleados /> } />
          <Route exact path="/agregar-empleado" element={ <AgregarEmpleado /> } />
          <Route exact path="/editar-empleado/:id" element={ <EditarEmpleado /> } />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
