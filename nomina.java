/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pood2.empleado;

/**
 *
 * @author ALUMNO#
 */
public class nomina {
       
    private final int VALORHORAEXTRA = 35000;

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
    
}
   
