package Matrices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio_3 {
    static class Estudiante {
        String nombre;
        String apellido;
        String numeroIdentificacion;
        String curso;
        Map<String, Double> notas; // Asignatura -> Nota

        public Estudiante(String nombre, String apellido, String numeroIdentificacion, String curso) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.numeroIdentificacion = numeroIdentificacion;
            this.curso = curso;
            this.notas = new HashMap<>();
        }

        public void agregarNota(String asignatura, double nota) {
            notas.put(asignatura, nota);
        }

        public double calcularPromedio() {
            if (notas.isEmpty()) return 0;
            double suma = 0;
            for (double nota : notas.values()) {
                suma += nota;
            }
            return suma / notas.size();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(nombre).append(" ").append(apellido)
                    .append(", ID: ").append(numeroIdentificacion)
                    .append(", Curso: ").append(curso)
                    .append("\nNotas:");
            for (Map.Entry<String, Double> entry : notas.entrySet()) {
                sb.append("\n  ").append(entry.getKey()).append(": ").append(entry.getValue());
            }
            sb.append("\nPromedio: ").append(calcularPromedio());
            return sb.toString();
        }
    }

    public class RegistroNotas {
        private static ArrayList<Estudiante> estudiantes = new ArrayList<>();

        public static void registrarEstudiante(String nombre, String apellido, String numeroIdentificacion, String curso) {
            Estudiante estudiante = new Estudiante(nombre, apellido, numeroIdentificacion, curso);
            estudiantes.add(estudiante);
            System.out.println("Estudiante registrado: " + estudiante);
        }

        public static void agregarNota(String numeroIdentificacion, String asignatura, double nota) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.numeroIdentificacion.equals(numeroIdentificacion)) {
                    estudiante.agregarNota(asignatura, nota);
                    System.out.println("Nota agregada: " + estudiante);
                    return;
                }
            }
            System.out.println("No se encontró ningún estudiante con el ID: " + numeroIdentificacion);
        }

        public static void mostrarEstudiantes() {
            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes registrados.");
            } else {
                System.out.println("Registro de estudiantes:");
                for (Estudiante estudiante : estudiantes) {
                    System.out.println(estudiante);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Registrar nuevo estudiante");
                System.out.println("2. Agregar nota a un estudiante");
                System.out.println("3. Mostrar estudiantes");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del estudiante: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese el número de identificación del estudiante: ");
                        String numeroIdentificacion = scanner.nextLine();
                        System.out.print("Ingrese el curso del estudiante: ");
                        String curso = scanner.nextLine();
                        registrarEstudiante(nombre, apellido, numeroIdentificacion, curso);
                        break;
                    case 2:
                        System.out.print("Ingrese el número de identificación del estudiante: ");
                        String idEstudiante = scanner.nextLine();
                        System.out.print("Ingrese la asignatura: ");
                        String asignatura = scanner.nextLine();
                        System.out.print("Ingrese la nota: ");
                        double nota = scanner.nextDouble();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarNota(idEstudiante, asignatura, nota);
                        break;
                    case 3:
                        mostrarEstudiantes();
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
