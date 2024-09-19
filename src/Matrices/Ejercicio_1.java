package Matrices;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_1 {

    static class Libro {
        String titulo;
        String autor;
        String isbn;
        double precio;
        int cantidadEnStock;

        public Libro(String titulo, String autor, String isbn, double precio, int cantidadEnStock) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.precio = precio;
            this.cantidadEnStock = cantidadEnStock;
        }

        public double valorTotal() {
            return precio * cantidadEnStock;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn +
                    ", Precio: $" + precio + ", Cantidad en stock: " + cantidadEnStock +
                    ", Valor total en stock: $" + valorTotal();
        }
    }

    public class Libreria {
        private static ArrayList<Libro> inventario = new ArrayList<>();

        public static void agregarLibro(String titulo, String autor, String isbn, double precio, int cantidadEnStock) {
            Libro libro = new Libro(titulo, autor, isbn, precio, cantidadEnStock);
            inventario.add(libro);
            System.out.println("Libro agregado: " + libro);
        }

        public static void eliminarLibro(String isbn) {
            for (Libro libro : inventario) {
                if (libro.isbn.equals(isbn)) {
                    inventario.remove(libro);
                    System.out.println("Libro eliminado: " + libro);
                    return;
                }
            }
            System.out.println("No se encontró ningún libro con ISBN " + isbn);
        }

        public static double calcularValorTotalInventario() {
            double total = 0;
            for (Libro libro : inventario) {
                total += libro.valorTotal();
            }
            return total;
        }

        public static void mostrarInventario() {
            System.out.println("Inventario de libros:");
            for (Libro libro : inventario) {
                System.out.println(libro);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Calcular valor total del inventario");
                System.out.println("4. Mostrar inventario");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ingrese el ISBN del libro: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Ingrese el precio del libro: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Ingrese la cantidad en stock del libro: ");
                        int cantidadEnStock = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarLibro(titulo, autor, isbn, precio, cantidadEnStock);
                        break;
                    case 2:
                        System.out.print("Ingrese el ISBN del libro a eliminar: ");
                        String isbnEliminar = scanner.nextLine();
                        eliminarLibro(isbnEliminar);
                        break;
                    case 3:
                        System.out.println("Valor total del inventario: $" + calcularValorTotalInventario());
                        break;
                    case 4:
                        mostrarInventario();
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
