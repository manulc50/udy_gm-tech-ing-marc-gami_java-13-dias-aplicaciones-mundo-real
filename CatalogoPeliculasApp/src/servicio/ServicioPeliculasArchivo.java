package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas {
    private static final String NOMBRE_ARCHIVO = "peliculas.txt";
    private final File archivo;

    public ServicioPeliculasArchivo() {
        archivo = new File(NOMBRE_ARCHIVO);
        if(archivo.exists())
            System.out.println("El archivo \"" + NOMBRE_ARCHIVO + "\" ya existe!");
        else {
            try {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
            catch(IOException e) {
                System.out.println("Ocurrió un error al abrir el archivo \"" + NOMBRE_ARCHIVO + "\": "
                        + e.getMessage());
            }
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lineas = entrada.lines().toList();
            entrada.close();
            if(lineas.isEmpty())
                System.out.println("No hay películas...");
            else {
                System.out.println("Listado de películas...");
                // Versión simplificada de la expresión "(linea -> System.out.println(linea)"
                lineas.forEach(System.out::println);
            }

        }
        catch(IOException e) {
            System.out.println("Ocurrió un error al leer el archivo \"" + NOMBRE_ARCHIVO + "\": " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        try {
            var salida = new PrintWriter(new FileWriter(archivo, archivo.exists()));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agregó al archivo \"" + NOMBRE_ARCHIVO + "\" la películas: " + pelicula);
        }
        catch(IOException e) {
            System.out.println("Ocurrió un error al agregar una película al archivo \"" + NOMBRE_ARCHIVO + "\": "
                    + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();
            var encontrada = false;
            var numLinea = 1;
            while(linea != null && !encontrada) {
                if(linea.equalsIgnoreCase(pelicula.getNombre()))
                    encontrada = true;
                else {
                    linea = entrada.readLine();
                    numLinea++;
                }
            }
            entrada.close();
            if(encontrada)
                System.out.println("Película: \"" + pelicula.getNombre() + "\" encontrada en la línea: " + numLinea);
            else
                System.out.println("Película: \"" + pelicula.getNombre() + "\" no encontrada");
        }
        catch(IOException e) {
            System.out.println("Ocurrió un error al leer el archivo \"" + NOMBRE_ARCHIVO + "\": " + e.getMessage());
        }
    }
}
