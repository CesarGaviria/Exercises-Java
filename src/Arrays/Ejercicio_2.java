package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio_2 {


    static class Vehiculo {
        String modelo;
        String matricula;
        double precioPorDia;
        boolean disponible;

        public Vehiculo(String modelo, String matricula, double precioPorDia, boolean disponible) {
            this.modelo = modelo;
            this.matricula = matricula;
            this.precioPorDia = precioPorDia;
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Modelo: " + modelo + ", Matrícula: " + matricula + ", Precio por día: $" + precioPorDia + ", Disponible: " + (disponible ? "Sí" : "No");
        }
    }

    public class AgenciaAlquiler {

        private static Vehiculo[] inventario = {
                new Vehiculo("Toyota Corolla", "ABC123", 30.0, true),
                new Vehiculo("Honda Civic", "XYZ789", 40.0, true),
                new Vehiculo("Ford Focus", "LMN456", 35.0, true)
        };

        public static void mostrarListaVehiculos() {
            System.out.println("Lista de vehículos:");
            for (Vehiculo vehiculo : inventario) {
                System.out.println(vehiculo);
            }
        }

        public static void alquilarVehiculo(String matricula) {
            for (Vehiculo vehiculo : inventario) {
                if (vehiculo.matricula.equalsIgnoreCase(matricula)) {
                    if (vehiculo.disponible) {
                        vehiculo.disponible = false;
                        System.out.println("Vehículo " + vehiculo.modelo + " con matrícula " + matricula + " ha sido alquilado.");
                    } else {
                        System.out.println("El vehículo con matrícula " + matricula + " no está disponible.");
                    }
                    return;
                }
            }
            System.out.println("El vehículo con matrícula " + matricula + " no se encuentra en el inventario.");
        }

        public static void devolverVehiculo(String matricula) {
            for (Vehiculo vehiculo : inventario) {
                if (vehiculo.matricula.equalsIgnoreCase(matricula)) {
                    if (!vehiculo.disponible) {
                        vehiculo.disponible = true;
                        System.out.println("Vehículo " + vehiculo.modelo + " con matrícula " + matricula + " ha sido devuelto.");
                    } else {
                        System.out.println("El vehículo con matrícula " + matricula + " ya está disponible.");
                    }
                    return;
                }
            }
            System.out.println("El vehículo con matrícula " + matricula + " no se encuentra en el inventario.");
        }

        public static void buscarVehiculo(String matricula) {
            for (Vehiculo vehiculo : inventario) {
                if (vehiculo.matricula.equalsIgnoreCase(matricula)) {
                    System.out.println("Vehículo encontrado: " + vehiculo);
                    return;
                }
            }
            System.out.println("El vehículo con matrícula " + matricula + " no se encuentra en el inventario.");
        }

        public static void ordenarPorPrecio() {
            Arrays.sort(inventario, (a, b) -> Double.compare(a.precioPorDia, b.precioPorDia));
            System.out.println("Lista de vehículos ordenada por precio:");
            mostrarListaVehiculos();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar lista de vehículos");
                System.out.println("2. Alquilar un vehículo");
                System.out.println("3. Devolver un vehículo");
                System.out.println("4. Buscar un vehículo");
                System.out.println("5. Ordenar lista de vehículos por precio");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarListaVehiculos();
                        break;
                    case 2:
                        System.out.print("Ingrese la matrícula del vehículo a alquilar: ");
                        String matriculaAlquilar = scanner.nextLine();
                        alquilarVehiculo(matriculaAlquilar);
                        break;
                    case 3:
                        System.out.print("Ingrese la matrícula del vehículo a devolver: ");
                        String matriculaDevolver = scanner.nextLine();
                        devolverVehiculo(matriculaDevolver);
                        break;
                    case 4:
                        System.out.print("Ingrese la matrícula del vehículo a buscar: ");
                        String matriculaBuscar = scanner.nextLine();
                        buscarVehiculo(matriculaBuscar);
                        break;
                    case 5:
                        ordenarPorPrecio();
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
