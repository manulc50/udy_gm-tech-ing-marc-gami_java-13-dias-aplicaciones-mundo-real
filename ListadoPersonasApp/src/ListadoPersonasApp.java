import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

    public static void main(String... args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        boolean salir = false;
        while(!salir) {
            mostrarMenu();
            salir = ejecutarOperacion(consola, personas);
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.print("""
                *** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opción?: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;
        switch(opcion) {
            case 1: {
                System.out.print("Proporcion el nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Proporcion el teléfono: ");
                String tel = consola.nextLine();
                System.out.print("Proporcion el email: ");
                String email = consola.nextLine();
                personas.add(new Persona(nombre, tel, email));
                System.out.println("La lista tiene " + personas.size() + " personas");
                break;
            }
            case 2: {
                System.out.println("Listado de personas:");
                for(Persona p: personas)
                    System.out.println(p);
                break;
            }
            case 3: {
                System.out.println("Hasta pronto...");
                salir = true;
                break;
            }
            default: {
                System.out.println("Opción errónea: " + opcion);
                break;
            }
        }
        return salir;
    }
}
