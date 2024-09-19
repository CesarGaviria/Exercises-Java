package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio_5 {
    static class Proyecto {
        String nombre;
        int duracionDias;
        boolean completado; // true si el proyecto está completado, false si está en progreso

        public Proyecto(String nombre, int duracionDias, boolean completado) {
            this.nombre = nombre;
            this.duracionDias = duracionDias;
            this.completado = completado;
        }

        @Override
        public String toString() {
            return "Nombre del proyecto: " + nombre + ", Duración: " + duracionDias + " días, Estado: " + (completado ? "Completado" : "En progreso");
        }
    }

    public class EmpresaDesarrollo {
        private static Proyecto[] proyectos = {
                new Proyecto("Desarrollo de Aplicación Web", 90, false),
                new Proyecto("Implementación de CRM", 120, true),
                new Proyecto("Migración a la Nube", 60, false),
                new Proyecto("Desarrollo de API", 45, true),
                new Proyecto("Optimización de Base de Datos", 30, false)
        };

        public static void mostrarProyectos() {
            System.out.println("Lista de proyectos:");
            for (Proyecto proyecto : proyectos) {
                System.out.println(proyecto);
            }
        }

        public static void agregarProyecto(String nombre, int duracionDias, boolean completado) {
            Proyecto[] nuevosProyectos = Arrays.copyOf(proyectos, proyectos.length + 1);
            nuevosProyectos[nuevosProyectos.length - 1] = new Proyecto(nombre, duracionDias, completado);
            proyectos = nuevosProyectos;
            System.out.println("Nuevo proyecto agregado: " + nombre);
        }

        public static void actualizarEstado(String nombre, boolean completado) {
            for (Proyecto proyecto : proyectos) {
                if (proyecto.nombre.equalsIgnoreCase(nombre)) {
                    proyecto.completado = completado;
                    System.out.println("Estado del proyecto '" + nombre + "' actualizado.");
                    return;
                }
            }
            System.out.println("El proyecto '" + nombre + "' no se encuentra en la lista.");
        }

        public static void buscarProyecto(String nombre) {
            for (Proyecto proyecto : proyectos) {
                if (proyecto.nombre.equalsIgnoreCase(nombre)) {
                    System.out.println("Proyecto encontrado: " + proyecto);
                    return;
                }
            }
            System.out.println("El proyecto '" + nombre + "' no se encuentra en la lista.");
        }

        public static void ordenarPorDuracion() {
            Arrays.sort(proyectos, (a, b) -> Integer.compare(a.duracionDias, b.duracionDias));
            System.out.println("Proyectos ordenados por duración:");
            mostrarProyectos();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar proyectos");
                System.out.println("2. Agregar nuevo proyecto");
                System.out.println("3. Actualizar estado de un proyecto");
                System.out.println("4. Buscar proyecto");
                System.out.println("5. Ordenar proyectos por duración");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarProyectos();
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del nuevo proyecto: ");
                        String nombreNuevo = scanner.nextLine();
                        System.out.print("Ingrese la duración en días del proyecto: ");
                        int duracion = scanner.nextInt();
                        System.out.print("¿Está completado? (true/false): ");
                        boolean completado = scanner.nextBoolean();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarProyecto(nombreNuevo, duracion, completado);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del proyecto a actualizar: ");
                        String nombreActualizar = scanner.nextLine();
                        System.out.print("Ingrese el nuevo estado (true para completado, false para en progreso): ");
                        boolean nuevoEstado = scanner.nextBoolean();
                        scanner.nextLine();  // Limpiar el buffer
                        actualizarEstado(nombreActualizar, nuevoEstado);
                        break;
                    case 4:
                        System.out.print("Ingrese el nombre del proyecto a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        buscarProyecto(nombreBuscar);
                        break;
                    case 5:
                        ordenarPorDuracion();
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
