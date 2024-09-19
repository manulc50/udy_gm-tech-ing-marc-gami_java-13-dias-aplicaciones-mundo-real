import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ProductoService } from '../producto.service';
import { Producto } from '../producto';

@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html'
})
export class EditarProductoComponent {
  producto: Producto;

  constructor(
    private productoServicio: ProductoService,
    private ruta: ActivatedRoute,
    private enrutador: Router) {}

    ngOnInit(): void {
      const id: number = this.ruta.snapshot.params['id'];
      this.productoServicio.obtenerProductoPorId(id).subscribe({
        next: p => this.producto = p,
        // Versión simplificada de la expresión "error => console.error(error)"
        error: console.error
      });
    }

    enviar(): void {
      this.productoServicio.editarProducto(this.producto)
        .subscribe(() => this.enrutador.navigate(['/productos']));
    }
}
