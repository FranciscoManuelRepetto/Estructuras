/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import Liniales.dinamica.Lista;

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
    private long numTelefono;
    
    public Cliente(ClaveCliente clave,String nombre, String apellido, String fechaNacimiento, 
            String domicilio, long numTelefono) {
        this.clave = clave;
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

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    public boolean equals(Cliente cliente){
        return clave.equals(cliente.clave);
    }
    
    public String toString(){
        String aux =    "Tipo Documento: "+this.clave.getTipo()+"\n"+
                        "DNI: "+this.clave.getNumDni()+"\n"+
                        "Nombre: "+this.nombre+"\n"+
                        "Apellido: "+this.apellido+"\n"+
                        "Domicilio: "+this.domicilio+"\n"+
                        "Fecha Nacimiento: "+this.fechaNacimiento+"\n";
        return aux;
    }
    

}
