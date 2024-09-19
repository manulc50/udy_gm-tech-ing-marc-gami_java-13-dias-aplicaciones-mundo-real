package mundopc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final int idOrder;
    private final List<Computadora> computadoras;
    private static int contadorOrdenes;

    public Orden() {
        idOrder = ++contadorOrdenes;
        computadoras = new ArrayList<>();
    }

    public void agregarComputadora(Computadora computadora) {
        computadoras.add(computadora);
    }

    public void mostrarOrden() {
        System.out.println("Orden #: " + idOrder);
        System.out.println("Total computadoras: " + computadoras.size());
        // Versión simplificada de la expresión "c -> System.out.println(c)"
        computadoras.forEach(System.out::println);
    }
}
