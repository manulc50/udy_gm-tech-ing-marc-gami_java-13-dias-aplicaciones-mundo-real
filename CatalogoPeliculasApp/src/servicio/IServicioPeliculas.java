package servicio;

import dominio.Pelicula;

public interface IServicioPeliculas {
    void listarPeliculas();
    void agregarPelicula(Pelicula pelicula);
    void buscarPelicula(Pelicula pelicula);
}
