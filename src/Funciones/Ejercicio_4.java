package Funciones;
import java.util.Scanner;

public class Ejercicio_4 {
    public class FinTech {

        public static int determinarMejorRendimiento(double[] ganancias) {
            int indiceMejor = 0;
            for (int i = 1; i < ganancias.length; i++) {
                if (ganancias[i] > ganancias[indiceMejor]) {
                    indiceMejor = i;
                }
            }
            return indiceMejor;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el número de departamentos:");
            int numDepartamentos = scanner.nextInt();

            double[] ganancias = new double[numDepartamentos];

            for (int i = 0; i < numDepartamentos; i++) {
                System.out.println("Ingrese las ganancias del departamento " + (i + 1) + ":");
                ganancias[i] = scanner.nextDouble();
            }

            int departamentoMejorRendimiento = determinarMejorRendimiento(ganancias);

            System.out.println("El departamento con el mejor rendimiento es el departamento " + (departamentoMejorRendimiento + 1) + " con ganancias de $" + ganancias[departamentoMejorRendimiento]);
        }
    }

}
