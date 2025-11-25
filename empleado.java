/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pood2.empleado;

/**
 *
 * @author ALUMNO#
 */
public class Empleado {

    
    private String nombre;
    private String cargo;
    private double sueldoBase;
    private int horasExtras;

    public Empleado(String nombre, String cargo, double sueldoBase, int horasExtras) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCargo(){
     
        return cargo; 
    }
    public double getSueldoBase(){ 
        
        return sueldoBase;
    }
    public int getHorasExtras(){
        
        return horasExtras;
    }
}
    
