/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

/**
 *
 * @author repetto.francisco
 */
public class Cliente {
    
    private ClaveCliente clave;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String domicilio;
    private int numTelefono;
    
    public Cliente(String tipo, String numDni,String nombre, String apellido, String fechaNacimiento, String domicilio, int numTelefono) {
        this.clave = new ClaveCliente(tipo,numDni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    
    

}
