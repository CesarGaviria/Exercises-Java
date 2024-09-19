package Funciones;
import java.util.Scanner;
public class Ejercicio_2 {
    public class SuperMart {

        public static void verificarStock(int[] cantidades, int nivelMinimo) {
            for (int i = 0; i < cantidades.length; i++) {
                if (cantidades[i] < nivelMinimo) {
                    System.out.println("Producto " + (i + 1) + ": Necesita realizar un pedido. Stock actual: " + cantidades[i]);
                } else {
                    System.out.println("Producto " + (i + 1) + ": Stock suficiente. Stock actual: " + cantidades[i]);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el número de productos:");
            int numProductos = scanner.nextInt();

            int[] cantidades = new int[numProductos];

            for (int i = 0; i < numProductos; i++) {
                System.out.println("Ingrese la cantidad del producto " + (i + 1) + ":");
                cantidades[i] = scanner.nextInt();
            }

            System.out.println("Ingrese el nivel mínimo requerido de stock:");
            int nivelMinimo = scanner.nextInt();

            verificarStock(cantidades, nivelMinimo);
        }
    }
}
