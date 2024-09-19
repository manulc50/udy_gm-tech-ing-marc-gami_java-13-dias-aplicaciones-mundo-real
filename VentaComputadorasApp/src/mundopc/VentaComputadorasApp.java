package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.modelo.Orden;

public class VentaComputadorasApp {

    public static void main(String[] args) {
        var ratonLenovo = new Raton("bluetooth", "Lenovo");
        var tecladoLenvovo = new Teclado("bluetooth", "Lenovo");
        var monitorLenovo = new Monitor("Lenovo", 27);
        var computadoraLenovo = new Computadora("Computadora Lenovo", monitorLenovo,
                tecladoLenvovo, ratonLenovo);

        var moitorDell = new Monitor("Dell", 15);
        var tecladoDell = new Teclado("usb", "Dell");
        var ratonDell = new Raton("usb", "Dell");
        var computadoraDell = new Computadora("Computadora Dell", moitorDell,
                tecladoDell, ratonDell);

        var orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        var monitorMac = new Monitor("Mac", 27);
        var tecladoMac = new Teclado("bluetooth", "Mac");
        var ratonMac = new Raton("usb", "Mac");
        var computadoraIMac = new Computadora("ComputadoraIMac", monitorMac,
                tecladoMac, ratonMac);

        System.out.println();

        var orden2 = new Orden();
        orden2.agregarComputadora(computadoraIMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraLenovo);
        orden2.mostrarOrden();
    }
}
