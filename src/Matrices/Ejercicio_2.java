package Matrices;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_2 {

    static class Huesped {
        String nombre;
        String apellido;
        String cedula;
        int numeroHabitacion;
        LocalDate fechaEntrada;
        LocalDate fechaSalida;
        double precioPorNoche;

        public Huesped(String nombre, String apellido, String cedula, int numeroHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida, double precioPorNoche) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.numeroHabitacion = numeroHabitacion;
            this.fechaEntrada = fechaEntrada;
            this.fechaSalida = fechaSalida;
            this.precioPorNoche = precioPorNoche;
        }

        public long calcularNoches() {
            return ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        }

        public double calcularCostoTotal() {
            return calcularNoches() * precioPorNoche;
        }

        @Override
        public String toString() {
            return "Huésped: " + nombre + " " + apellido + ", Cédula: " + cedula +
                    ", Habitación: " + numeroHabitacion + ", Fecha de entrada: " + fechaEntrada +
                    ", Fecha de salida: " + fechaSalida + ", Noches: " + calcularNoches() +
                    ", Costo total: $" + calcularCostoTotal();
        }
    }

    public class Hotel {
        private static ArrayList<Huesped> reservas = new ArrayList<>();

        public static void registrarReserva(String nombre, String apellido, String cedula, int numeroHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida, double precioPorNoche) {
            Huesped huesped = new Huesped(nombre, apellido, cedula, numeroHabitacion, fechaEntrada, fechaSalida, precioPorNoche);
            reservas.add(huesped);
            System.out.println("Reserva registrada: " + huesped);
        }

        public static void cancelarReserva(String cedula) {
            for (Huesped huesped : reservas) {
                if (huesped.cedula.equals(cedula)) {
                    reservas.remove(huesped);
                    System.out.println("Reserva cancelada: " + huesped);
                    return;
                }
            }
            System.out.println("No se encontró ninguna reserva con la cédula: " + cedula);
        }

        public static void mostrarReservas() {
            if (reservas.isEmpty()) {
                System.out.println("No hay reservas registradas.");
            } else {
                System.out.println("Reservas de huéspedes:");
                for (Huesped huesped : reservas) {
                    System.out.println(huesped);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Registrar nueva reserva");
                System.out.println("2. Cancelar reserva");
                System.out.println("3. Mostrar reservas");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del huésped: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del huésped: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese la cédula del huésped: ");
                        String cedula = scanner.nextLine();
                        System.out.print("Ingrese el número de habitación: ");
                        int numeroHabitacion = scanner.nextInt();
                        System.out.print("Ingrese el precio por noche: ");
                        double precioPorNoche = scanner.nextDouble();
                        System.out.print("Ingrese la fecha de entrada (aaaa-mm-dd): ");
                        LocalDate fechaEntrada = LocalDate.parse(scanner.next());
                        System.out.print("Ingrese la fecha de salida (aaaa-mm-dd): ");
                        LocalDate fechaSalida = LocalDate.parse(scanner.next());
                        registrarReserva(nombre, apellido, cedula, numeroHabitacion, fechaEntrada, fechaSalida, precioPorNoche);
                        break;
                    case 2:
                        System.out.print("Ingrese la cédula de la reserva a cancelar: ");
                        String cedulaCancelar = scanner.nextLine();
                        cancelarReserva(cedulaCancelar);
                        break;
                    case 3:
                        mostrarReservas();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
        }
    }

}
