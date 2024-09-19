package Matrices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Ejercicio_5 {
     static class Actividad {
        String tipo;
        int duracion; // en minutos
        String fecha;

        public Actividad(String tipo, int duracion, String fecha) {
            this.tipo = tipo;
            this.duracion = duracion;
            this.fecha = fecha;
        }

        @Override
        public String toString() {
            return tipo + " - " + duracion + " min - " + fecha;
        }
    }

    class Socio {
        String nombre;
        String apellido;
        String numeroIdentificacion;
        String tipoMembresia;
        List<Actividad> actividades;

        public Socio(String nombre, String apellido, String numeroIdentificacion, String tipoMembresia) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.numeroIdentificacion = numeroIdentificacion;
            this.tipoMembresia = tipoMembresia;
            this.actividades = new ArrayList<>();
        }

        public void agregarActividad(Actividad actividad) {
            actividades.add(actividad);
        }

        public Map<String, Integer> calcularTiempoPorActividad() {
            Map<String, Integer> tiempoPorActividad = new HashMap<>();
            for (Actividad actividad : actividades) {
                tiempoPorActividad.put(actividad.tipo, tiempoPorActividad.getOrDefault(actividad.tipo, 0) + actividad.duracion);
            }
            return tiempoPorActividad;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(nombre).append(" ").append(apellido)
                    .append("\nNúmero de Identificación: ").append(numeroIdentificacion)
                    .append("\nTipo de Membresía: ").append(tipoMembresia)
                    .append("\nActividades:");
            for (Actividad actividad : actividades) {
                sb.append("\n  ").append(actividad);
            }
            Map<String, Integer> tiempoPorActividad = calcularTiempoPorActividad();
            sb.append("\nTiempo Total por Actividad:");
            for (Map.Entry<String, Integer> entry : tiempoPorActividad.entrySet()) {
                sb.append("\n  ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" min");
            }
            return sb.toString();
        }
    }

    public class GestionSociosGimnasio {
        private static List<Socio> socios = new ArrayList<>();

        public  void registrarSocio(String nombre, String apellido, String numeroIdentificacion, String tipoMembresia) {
            Socio nuevoSocio = new Socio(nombre, apellido, numeroIdentificacion, tipoMembresia);
            socios.add(nuevoSocio);
            System.out.println("Socio registrado: " + nuevoSocio);
        }

        public static Socio buscarSocio(String numeroIdentificacion) {
            for (Socio socio : socios) {
                if (socio.numeroIdentificacion.equals(numeroIdentificacion)) {
                    return socio;
                }
            }
            return null;
        }

        public  void agregarActividad(String numeroIdentificacion, String tipo, int duracion, String fecha) {
            Socio socio = buscarSocio(numeroIdentificacion);
            if (socio != null) {
                socio.agregarActividad(new Actividad(tipo, duracion, fecha));
                System.out.println("Actividad agregada: " + socio);
            } else {
                System.out.println("No se encontró ningún socio con el número de identificación: " + numeroIdentificacion);
            }
        }

        public static void mostrarSocios() {
            if (socios.isEmpty()) {
                System.out.println("No hay socios registrados.");
            } else {
                System.out.println("Lista de socios:");
                for (Socio socio : socios) {
                    System.out.println(socio);
                }
            }
        }

        public  void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Registrar nuevo socio");
                System.out.println("2. Agregar actividad a un socio");
                System.out.println("3. Mostrar socios");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del socio: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del socio: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese el número de identificación: ");
                        String numeroIdentificacion = scanner.nextLine();
                        System.out.print("Ingrese el tipo de membresía: ");
                        String tipoMembresia = scanner.nextLine();
                        registrarSocio(nombre, apellido, numeroIdentificacion, tipoMembresia);
                        break;
                    case 2:
                        System.out.print("Ingrese el número de identificación del socio: ");
                        String idSocio = scanner.nextLine();
                        System.out.print("Ingrese el tipo de actividad: ");
                        String tipoActividad = scanner.nextLine();
                        System.out.print("Ingrese la duración de la actividad (en minutos): ");
                        int duracion = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        System.out.print("Ingrese la fecha de la actividad: ");
                        String fecha = scanner.nextLine();
                        agregarActividad(idSocio, tipoActividad, duracion, fecha);
                        break;
                    case 3:
                        mostrarSocios();
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
