import java.util.Scanner;

public class CalculadoraApp {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var operacion = 1;
        do {
            mostrarMenu();
            try {
                operacion = Integer.parseInt(scanner.nextLine());
                if (operacion >= 1 && operacion < 5)
                    ejecutarOperacion(operacion, scanner);
                else if(operacion != 5)
                    System.out.println("Opción errónea: " + operacion);
            }
            catch(Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        while(operacion != 5);
        System.out.println("Hasta pronto...");
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("**** Aplicación Calulcadora ****");
        //System.out.println("1. Sumar\n2. Restar\n3. Multiplicación\n4. División\n5. Salir");
        System.out.println("""
                    1. Sumar
                    2. Restar
                    3. Multiplicación
                    4. División
                    5. Salir
                    """);
        System.out.print("Operación a realizar?: ");
    }

    private static void ejecutarOperacion(int operacion, Scanner scanner) {
        System.out.print("Ingrese el primer operando: ");
        var operando1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese el segundo operando: ");
        var operando2 = Double.parseDouble(scanner.nextLine());
        switch (operacion) {
            case 1 -> System.out.println("Resultado Suma: " + (operando1 + operando2));
            case 2 -> System.out.println("Resultado Resta: " + (operando1 - operando2));
            case 3 -> System.out.println("Resultado Multiplicación: " + (operando1 * operando2));
            case 4 -> System.out.println("Resultado División: " + (operando1 / operando2));
        }
    }
}
