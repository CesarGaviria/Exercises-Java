package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio_1 {


    static class Libro {
        String titulo;
        String autor;
        int cantidadEnStock;

        public Libro(String titulo, String autor, int cantidadEnStock) {
            this.titulo = titulo;
            this.autor = autor;
            this.cantidadEnStock = cantidadEnStock;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", Cantidad en stock: " + cantidadEnStock;
        }
    }

    public class Biblioteca {
        private static Libro[] inventario = {
                new Libro("El Quijote", "Miguel de Cervantes", 5),
                new Libro("1984", "George Orwell", 3),
                new Libro("Cien años de soledad", "Gabriel García Márquez", 4)
        };

        public static void mostrarInventario() {
            System.out.println("Inventario de libros:");
            for (Libro libro : inventario) {
                System.out.println(libro);
            }
        }

        public static void agregarCopias(String titulo, int cantidad) {
            for (Libro libro : inventario) {
                if (libro.titulo.equalsIgnoreCase(titulo)) {
                    libro.cantidadEnStock += cantidad;
                    System.out.println("Se han agregado " + cantidad + " copias de \"" + titulo + "\".");
                    return;
                }
            }
            System.out.println("El libro \"" + titulo + "\" no se encuentra en el inventario.");
        }

        public static void prestarLibro(String titulo) {
            for (Libro libro : inventario) {
                if (libro.titulo.equalsIgnoreCase(titulo)) {
                    if (libro.cantidadEnStock > 0) {
                        libro.cantidadEnStock--;
                        System.out.println("Se ha prestado una copia de \"" + titulo + "\".");
                    } else {
                        System.out.println("No hay copias disponibles de \"" + titulo + "\".");
                    }
                    return;
                }
            }
            System.out.println("El libro \"" + titulo + "\" no se encuentra en el inventario.");
        }

        public static void buscarLibro(String titulo) {
            for (Libro libro : inventario) {
                if (libro.titulo.equalsIgnoreCase(titulo)) {
                    System.out.println("Libro encontrado: " + libro);
                    return;
                }
            }
            System.out.println("El libro \"" + titulo + "\" no se encuentra en el inventario.");
        }

        public static void ordenarPorTitulo() {
            Arrays.sort(inventario, (a, b) -> a.titulo.compareToIgnoreCase(b.titulo));
            System.out.println("Inventario ordenado por título:");
            mostrarInventario();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar inventario");
                System.out.println("2. Agregar nuevas copias de un libro");
                System.out.println("3. Prestar un libro");
                System.out.println("4. Buscar un libro");
                System.out.println("5. Ordenar inventario por título");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarInventario();
                        break;
                    case 2:
                        System.out.print("Ingrese el título del libro: ");
                        String tituloAgregar = scanner.nextLine();
                        System.out.print("Ingrese la cantidad de copias a agregar: ");
                        int cantidadAgregar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarCopias(tituloAgregar, cantidadAgregar);
                        break;
                    case 3:
                        System.out.print("Ingrese el título del libro a prestar: ");
                        String tituloPrestar = scanner.nextLine();
                        prestarLibro(tituloPrestar);
                        break;
                    case 4:
                        System.out.print("Ingrese el título del libro a buscar: ");
                        String tituloBuscar = scanner.nextLine();
                        buscarLibro(tituloBuscar);
                        break;
                    case 5:
                        ordenarPorTitulo();
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
