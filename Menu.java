package pood2.main;

import java.util.Scanner;
import pood2.empleado.Empleado;
import pood2.empleado.nomina;

public class Menu {

    private Scanner sc = new Scanner(System.in);
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
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    nomina.mostrarNomina();
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
        nomina.agregarEmpleado(emp);

        System.out.println("Empleado registrado correctamente.");
    }
}
