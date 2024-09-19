package Funciones;
import java.util.Scanner;
public class Ejercicio_1 {
    public class GlobalTech {

        public static double[] calcularSalarioYRetencion(double salarioMensual, double porcentajeRetencion) {
            double salarioAnual = salarioMensual * 12;
            double retencionFuente = salarioAnual * (porcentajeRetencion / 100);
            double salarioAnualNeto = salarioAnual - retencionFuente;

            return new double[]{salarioAnualNeto, retencionFuente};
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el salario mensual del empleado:");
            double salarioMensual = scanner.nextDouble();

            System.out.println("Ingrese el porcentaje de retención en la fuente:");
            double porcentajeRetencion = scanner.nextDouble();

            double[] resultados = calcularSalarioYRetencion(salarioMensual, porcentajeRetencion);

            System.out.println("Salario anual después de la retención: $" + resultados[0]);
            System.out.println("Monto de la deducción por retención en la fuente: $" + resultados[1]);
        }
    }
}
