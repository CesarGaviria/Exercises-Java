package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_4 {
    static class Producto {
        String tipoRopa;
        int cantidadEnStock;
        double precio;

        public Producto(String tipoRopa, int cantidadEnStock, double precio) {
            this.tipoRopa = tipoRopa;
            this.cantidadEnStock = cantidadEnStock;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Tipo de ropa: " + tipoRopa + ", Cantidad en stock: " + cantidadEnStock + ", Precio: $" + precio;
        }
    }

    public class TiendaRopa {
        private static Producto[] inventario = {
                new Producto("Camisa", 10, 25.0),
                new Producto("Pantalón", 15, 40.0),
                new Producto("Chaqueta", 5, 75.0),
                new Producto("Zapatos", 8, 50.0),
                new Producto("Sombrero", 12, 15.0)
        };

        public static void mostrarInventario() {
            System.out.println("Inventario de productos:");
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        }

        public static void agregarUnidades(String tipoRopa, int cantidad) {
            for (Producto producto : inventario) {
                if (producto.tipoRopa.equalsIgnoreCase(tipoRopa)) {
                    producto.cantidadEnStock += cantidad;
                    System.out.println("Se han agregado " + cantidad + " unidades de " + tipoRopa + ".");
                    return;
                }
            }
            System.out.println("El producto " + tipoRopa + " no se encuentra en el inventario.");
        }

        public static void venderProducto(String tipoRopa, int cantidad) {
            for (Producto producto : inventario) {
                if (producto.tipoRopa.equalsIgnoreCase(tipoRopa)) {
                    if (producto.cantidadEnStock >= cantidad) {
                        producto.cantidadEnStock -= cantidad;
                        System.out.println("Se han vendido " + cantidad + " unidades de " + tipoRopa + ".");
                    } else {
                        System.out.println("No hay suficiente stock de " + tipoRopa + " para completar la venta.");
                    }
                    return;
                }
            }
            System.out.println("El producto " + tipoRopa + " no se encuentra en el inventario.");
        }

        public static void buscarProducto(String tipoRopa) {
            for (Producto producto : inventario) {
                if (producto.tipoRopa.equalsIgnoreCase(tipoRopa)) {
                    System.out.println("Producto encontrado: " + producto);
                    return;
                }
            }
            System.out.println("El producto " + tipoRopa + " no se encuentra en el inventario.");
        }

        public static void ordenarPorPrecio() {
            Arrays.sort(inventario, (a, b) -> Double.compare(a.precio, b.precio));
            System.out.println("Inventario ordenado por precio:");
            mostrarInventario();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar inventario");
                System.out.println("2. Agregar nuevas unidades");
                System.out.println("3. Vender productos");
                System.out.println("4. Buscar productos");
                System.out.println("5. Ordenar inventario por precio");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarInventario();
                        break;
                    case 2:
                        System.out.print("Ingrese el tipo de ropa a agregar: ");
                        String tipoRopaAgregar = scanner.nextLine();
                        System.out.print("Ingrese la cantidad de unidades a agregar: ");
                        int cantidadAgregar = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        agregarUnidades(tipoRopaAgregar, cantidadAgregar);
                        break;
                    case 3:
                        System.out.print("Ingrese el tipo de ropa a vender: ");
                        String tipoRopaVender = scanner.nextLine();
                        System.out.print("Ingrese la cantidad de unidades a vender: ");
                        int cantidadVender = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        venderProducto(tipoRopaVender, cantidadVender);
                        break;
                    case 4:
                        System.out.print("Ingrese el tipo de ropa a buscar: ");
                        String tipoRopaBuscar = scanner.nextLine();
                        buscarProducto(tipoRopaBuscar);
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