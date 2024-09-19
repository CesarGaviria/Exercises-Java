package Funciones;
import java.util.Scanner;

public class Ejercicio_5 {

    public class Tecnologia {

        public static double calcularDepreciacionAnual(double valorInicial, double valorResidual, int vidaUtil) {
            return (valorInicial - valorResidual) / vidaUtil;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el valor inicial del activo:");
            double valorInicial = scanner.nextDouble();

            System.out.println("Ingrese el valor residual del activo:");
            double valorResidual = scanner.nextDouble();

            System.out.println("Ingrese la vida útil del activo (en años):");
            int vidaUtil = scanner.nextInt();

            double depreciacionAnual = calcularDepreciacionAnual(valorInicial, valorResidual, vidaUtil);

            System.out.println("La depreciación anual del activo es: $" + depreciacionAnual);
        }
    }

}
