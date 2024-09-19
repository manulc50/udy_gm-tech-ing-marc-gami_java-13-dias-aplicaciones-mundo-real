package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{
    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        if(peliculas.isEmpty()) {
            System.out.println("No hay películas...");
            return;
        }
        System.out.println("Listado de Películas...");
        // Versión simplificada de la expresión "pelicula -> System.out.println(pelicula)"
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la película: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1)
            System.out.println("No se encontró la película: " + pelicula);
        else
            System.out.println("Película encontrada en el índice: " + indice);
    }
}
