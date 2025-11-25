/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pood2.empleado;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ALUMNO#
 */
public class main {
    
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        nomina nomina = new nomina();
        boolean continuar = true;

        while (continuar) {

            System.out.println("\n--- REGISTRO DE EMPLEADO ---");
            System.out.print("Nombre del empleado: ");
            String nombre = sc.nextLine();

            System.out.print("Cargo del empleado: ");
            String cargo = sc.nextLine();

            System.out.print("Sueldo base: ");
            double sueldoBase = sc.nextDouble();

            System.out.print("Horas extras trabajadas: ");
            int horasExtras = sc.nextInt();
            sc.nextLine();

            Empleado emp = new Empleado(nombre, cargo, sueldoBase, horasExtras);
            empleados.add(emp);

            System.out.print("¿Desea registrar otro empleado? (s/n): ");
            String resp = sc.nextLine();
            if (!resp.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("\n\n RESULTADOS DE NÓMINA ");
        double totalNomina = 0;

        for (Empleado emp : empleados) {
            double pagoExtras = nomina.calPagoHorasEx(emp.getHorasExtras());
            double retencion = nomina.calcRetencion(emp.getSueldoBase());
            double seguridad = nomina.calcularSeguridadSocial(emp.getSueldoBase());
            double salarioNeto = nomina.calcularSalarioNeto(emp);

            totalNomina += salarioNeto;

            System.out.println("\nEmpleado: " + emp.getNombre());
            System.out.println("Cargo: " + emp.getCargo());
            System.out.println("Sueldo Base: $" + emp.getSueldoBase());
            System.out.println("Pago por Horas Extras: $" + pagoExtras);
            System.out.println("Descuento Retención: $" + retencion);
            System.out.println("Descuento Seguridad Social: $" + seguridad);
            System.out.println("Salario Neto: $" + salarioNeto);
        }

        System.out.println("\nTOTAL NÓMINA A PAGAR POR LA EMPRESA: $" + totalNomina);
    }
}   

