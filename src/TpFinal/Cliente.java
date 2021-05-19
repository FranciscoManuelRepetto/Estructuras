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
    
    public Cliente(String tipo, int numDni){
        this.clave = new ClaveCliente(tipo,numDni);
    }

    public Cliente(String tipo, int numDni,String nombre, String apellido, String fechaNacimiento, String domicilio, int numTelefono) {
        this.clave = new ClaveCliente(tipo,numDni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.numTelefono = numTelefono;
    }
    

}
