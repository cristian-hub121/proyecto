package pood2.empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private nomina nomina = new nomina();

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Mostrar nomina");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    mostrarNomina();
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no valida, intente nuevamente.");
            }

        } while (opcion != 3);

    }

    private void registrarEmpleado() {
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

        System.out.println("Empleado registrado correctamente.");
    }

    private void mostrarNomina() {
        if (empleados.isEmpty()) {
            System.out.println("\nNo hay empleados registrados.");
            return;
        }

        System.out.println("\n===== NOMINA GENERAL =====");
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

        System.out.println("\nTOTAL NOMINA A PAGAR POR LA EMPRESA: $" + totalNomina);
    }
}
