import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private urlBase: string = "http://localhost:8080/api/productos";

  constructor(private clienteHttp: HttpClient) { }

  obtenerProductosLista(): Observable<Producto[]> {
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }

  obtenerProductoPorId(id: number): Observable<Producto> {
    return this.clienteHttp.get<Producto>(`${this.urlBase}/${id}`);
  }

  agregarProducto(producto: Producto): Observable<Producto> {
    return this.clienteHttp.post(this.urlBase, producto).pipe(map(resp => resp as Producto));
  }

  editarProducto(producto: Producto): Observable<Producto> {
    return this.clienteHttp.put(`${this.urlBase}/${producto.id}`, producto).pipe(map(resp => resp as Producto));
  }

  eliminarProducto(id: number): Observable<void> {
    return this.clienteHttp.delete<void>(`${this.urlBase}/${id}`);
  }
}
