package Funciones;
import java.util.Scanner;
public class Ejercicio_3 {
    public class Fabrica {

        public static double calcularCostoTotal(double costoMateriales, double costoManoObra, double gastosGenerales) {
            return costoMateriales + costoManoObra + gastosGenerales;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el costo de materiales:");
            double costoMateriales = scanner.nextDouble();

            System.out.println("Ingrese el costo de mano de obra:");
            double costoManoObra = scanner.nextDouble();

            System.out.println("Ingrese los gastos generales:");
            double gastosGenerales = scanner.nextDouble();

            double costoTotal = calcularCostoTotal(costoMateriales, costoManoObra, gastosGenerales);

            System.out.println("El costo total de producción es: $" + costoTotal);
        }
    }
}
