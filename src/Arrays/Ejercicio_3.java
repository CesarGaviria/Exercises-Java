package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio_3 {


    static class Mesa {
        int numero;
        int capacidad;
        boolean disponible;

        public Mesa(int numero, int capacidad, boolean disponible) {
            this.numero = numero;
            this.capacidad = capacidad;
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Mesa número: " + numero + ", Capacidad: " + capacidad + ", Disponible: " + (disponible ? "Sí" : "No");
        }
    }

    public class Restaurante {
        private static Mesa[] mesas = {
                new Mesa(1, 4, true),
                new Mesa(2, 2, true),
                new Mesa(3, 6, true),
                new Mesa(4, 4, true),
                new Mesa(5, 8, true)
        };

        public static void mostrarDisponibilidad() {
            System.out.println("Disponibilidad de mesas:");
            for (Mesa mesa : mesas) {
                System.out.println(mesa);
            }
        }

        public static void realizarReserva(int numeroMesa) {
            for (Mesa mesa : mesas) {
                if (mesa.numero == numeroMesa) {
                    if (mesa.disponible) {
                        mesa.disponible = false;
                        System.out.println("Reserva realizada en la mesa número " + numeroMesa + ".");
                    } else {
                        System.out.println("La mesa número " + numeroMesa + " ya está ocupada.");
                    }
                    return;
                }
            }
            System.out.println("La mesa número " + numeroMesa + " no se encuentra en el restaurante.");
        }

        public static void cancelarReserva(int numeroMesa) {
            for (Mesa mesa : mesas) {
                if (mesa.numero == numeroMesa) {
                    if (!mesa.disponible) {
                        mesa.disponible = true;
                        System.out.println("Reserva cancelada en la mesa número " + numeroMesa + ".");
                    } else {
                        System.out.println("La mesa número " + numeroMesa + " ya está disponible.");
                    }
                    return;
                }
            }
            System.out.println("La mesa número " + numeroMesa + " no se encuentra en el restaurante.");
        }

        public static void buscarMesa(int numeroMesa) {
            for (Mesa mesa : mesas) {
                if (mesa.numero == numeroMesa) {
                    System.out.println("Mesa encontrada: " + mesa);
                    return;
                }
            }
            System.out.println("La mesa número " + numeroMesa + " no se encuentra en el restaurante.");
        }

        public static void ordenarPorCapacidad() {
            Arrays.sort(mesas, (a, b) -> Integer.compare(b.capacidad, a.capacidad));
            System.out.println("Mesas ordenadas por capacidad:");
            mostrarDisponibilidad();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar disponibilidad de mesas");
                System.out.println("2. Realizar una nueva reserva");
                System.out.println("3. Cancelar una reserva");
                System.out.println("4. Buscar una mesa");
                System.out.println("5. Ordenar mesas por capacidad");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarDisponibilidad();
                        break;
                    case 2:
                        System.out.print("Ingrese el número de la mesa para reservar: ");
                        int numeroReserva = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        realizarReserva(numeroReserva);
                        break;
                    case 3:
                        System.out.print("Ingrese el número de la mesa para cancelar la reserva: ");
                        int numeroCancelar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        cancelarReserva(numeroCancelar);
                        break;
                    case 4:
                        System.out.print("Ingrese el número de la mesa a buscar: ");
                        int numeroBuscar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        buscarMesa(numeroBuscar);
                        break;
                    case 5:
                        ordenarPorCapacidad();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
        }
    }

}
