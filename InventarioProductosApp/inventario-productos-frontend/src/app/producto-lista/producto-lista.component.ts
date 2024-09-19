import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html'
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(private productoServicio: ProductoService, private enrutador: Router) {}

  ngOnInit(): void {
    this.obtenerProductos();
  }

  irEditarProducto(id: number): void {
    this.enrutador.navigate(['/editar-producto', id]);
  }

  eliminarProducto(id: number): void {
    this.productoServicio.eliminarProducto(id)
      .subscribe(() => this.productos = this.productos.filter(p => p.id != id));
  }

  private obtenerProductos(): void {
    this.productoServicio.obtenerProductosLista()
      .subscribe(productos => this.productos = productos);
  }
}
