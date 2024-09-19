import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html'
})
export class AgregarProductoComponent {
  producto: Producto = new Producto();

  constructor(private productoServicio: ProductoService, private enrutador: Router) {}

  enviar(): void {
    this.productoServicio.agregarProducto(this.producto).subscribe(() => this.irListadoProductos());
  }

  private irListadoProductos(): void {
    this.enrutador.navigate(['/productos']);
  }

}
