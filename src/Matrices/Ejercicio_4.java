package Matrices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio_4 {
    static class Pedido {
        String nombreCliente;
        int numeroMesa;
        Map<String, Double> platos; // Plato -> Precio

        public Pedido(String nombreCliente, int numeroMesa) {
            this.nombreCliente = nombreCliente;
            this.numeroMesa = numeroMesa;
            this.platos = new HashMap<>();
        }

        public void agregarPlato(String plato, double precio) {
            platos.put(plato, precio);
        }

        public void eliminarPlato(String plato) {
            platos.remove(plato);
        }

        public double calcularTotal() {
            double total = 0;
            for (double precio : platos.values()) {
                total += precio;
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre del Cliente: ").append(nombreCliente)
                    .append(", Número de Mesa: ").append(numeroMesa)
                    .append("\nPlatos:");
            for (Map.Entry<String, Double> entry : platos.entrySet()) {
                sb.append("\n  ").append(entry.getKey()).append(": $").append(entry.getValue());
            }
            sb.append("\nTotal a Pagar: $").append(calcularTotal());
            return sb.toString();
        }
    }

    public class GestionPedidos {
        private static List<Pedido> pedidos = new ArrayList<>();

        public static void registrarPedido(String nombreCliente, int numeroMesa) {
            Pedido nuevoPedido = new Pedido(nombreCliente, numeroMesa);
            pedidos.add(nuevoPedido);
            System.out.println("Pedido registrado: " + nuevoPedido);
        }

        public static void agregarPlato(int numeroMesa, String plato, double precio) {
            for (Pedido pedido : pedidos) {
                if (pedido.numeroMesa == numeroMesa) {
                    pedido.agregarPlato(plato, precio);
                    System.out.println("Plato agregado: " + pedido);
                    return;
                }
            }
            System.out.println("No se encontró ningún pedido con el número de mesa: " + numeroMesa);
        }

        public static void eliminarPlato(int numeroMesa, String plato) {
            for (Pedido pedido : pedidos) {
                if (pedido.numeroMesa == numeroMesa) {
                    pedido.eliminarPlato(plato);
                    System.out.println("Plato eliminado: " + pedido);
                    return;
                }
            }
            System.out.println("No se encontró ningún pedido con el número de mesa: " + numeroMesa);
        }

        public static void mostrarPedidos() {
            if (pedidos.isEmpty()) {
                System.out.println("No hay pedidos registrados.");
            } else {
                System.out.println("Lista de pedidos:");
                for (Pedido pedido : pedidos) {
                    System.out.println(pedido);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Registrar nuevo pedido");
                System.out.println("2. Agregar plato a un pedido");
                System.out.println("3. Eliminar plato de un pedido");
                System.out.println("4. Mostrar pedidos");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreCliente = scanner.nextLine();
                        System.out.print("Ingrese el número de mesa: ");
                        int numeroMesa = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        registrarPedido(nombreCliente, numeroMesa);
                        break;
                    case 2:
                        System.out.print("Ingrese el número de mesa: ");
                        int mesaAgregar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        System.out.print("Ingrese el nombre del plato: ");
                        String platoAgregar = scanner.nextLine();
                        System.out.print("Ingrese el precio del plato: ");
                        double precioAgregar = scanner.nextDouble();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarPlato(mesaAgregar, platoAgregar, precioAgregar);
                        break;
                    case 3:
                        System.out.print("Ingrese el número de mesa: ");
                        int mesaEliminar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        System.out.print("Ingrese el nombre del plato a eliminar: ");
                        String platoEliminar = scanner.nextLine();
                        eliminarPlato(mesaEliminar, platoEliminar);
                        break;
                    case 4:
                        mostrarPedidos();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
        }
    }

}
