package pood2.empleado;

import java.util.ArrayList;

public class nomina {

    private final int VALORHORAEXTRA = 35000;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
    }

    public double calPagoHorasEx(int horas) {
        return horas * VALORHORAEXTRA;
    }

    public double calcRetencion(double sueldoBase) {
        double salarioMin = 1300000;

        if (sueldoBase >= 3 * salarioMin && sueldoBase <= 5 * salarioMin) {
            return sueldoBase * 0.10;
        } else if (sueldoBase > 5 * salarioMin) {
            return sueldoBase * 0.16;
        } else {
            return 0;
        }
    }

    public double calcularSeguridadSocial(double sueldoBase) {
        return sueldoBase * 0.04;
    }

    public double calcularSalarioNeto(Empleado emp) {
        double pagoExtras = calPagoHorasEx(emp.getHorasExtras());
        double retencion = calcRetencion(emp.getSueldoBase());
        double seguridad = calcularSeguridadSocial(emp.getSueldoBase());
        double salarioBruto = emp.getSueldoBase() + pagoExtras;
        double descuentos = retencion + seguridad;
        return salarioBruto - descuentos;
    }

    public void mostrarNomina() {

        if (empleados.isEmpty()) {
            System.out.println("\nNo hay empleados registrados.");
            return;
        }

        System.out.println("\n===== NOMINA GENERAL =====");
        double totalNomina = 0;

        for (Empleado emp : empleados) {

            double pagoExtras = calPagoHorasEx(emp.getHorasExtras());
            double retencion = calcRetencion(emp.getSueldoBase());
            double seguridad = calcularSeguridadSocial(emp.getSueldoBase());
            double salarioNeto = calcularSalarioNeto(emp);

            totalNomina += salarioNeto;

            System.out.println("\nEmpleado: " + emp.getNombre());
            System.out.println("Cargo: " + emp.getCargo());
            System.out.println("Sueldo Base: $" + emp.getSueldoBase());
            System.out.println("Pago por Horas Extras: $" + pagoExtras);
            System.out.println("Descuento Retencion: $" + retencion);
            System.out.println("Descuento Seguridad Social: $" + seguridad);
            System.out.println("Salario Neto: $" + salarioNeto);
        }

        System.out.println("\nTOTAL NOMINA A PAGAR POR LA EMPRESA: $" + totalNomina);
    }
}
