package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPeliculasApp {

    public static void main(String... args) {
        var consola = new Scanner(System.in);
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        do {
            mostrarMenu();
        }
        while(!ejecutarOpciones(consola, servicioPeliculas));
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("""
                *** Catálogo de Películas ***
                1. Agregar Película
                2. Listar Películas
                3. Buscar Película
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas) {
        System.out.print("Selecciona una opción: ");
        var salir = false;
        try {
            var opcion = Integer.parseInt(consola.nextLine());
            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el nombre de la película: ");
                    var nombre = consola.nextLine();
                    servicioPeliculas.agregarPelicula(new Pelicula(nombre));
                }
                case 2 -> servicioPeliculas.listarPeliculas();
                case 3 -> {
                    System.out.print("Introduce el nombre de la película a buscar: ");
                    var nombre = consola.nextLine();
                    servicioPeliculas.buscarPelicula(new Pelicula(nombre));
                }
                case 4 -> {
                    System.out.println("Hasta pronto...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida: " + opcion);
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Debes introducir un número entero");
        }
        return salir;
    }
}
