/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import java.util.Objects;

/**
 *
 * @author repetto.francisco
 */
public class Aeropuerto {
    
    private String nomAeronautico;
    private String ciudad;
    private long numTelefono;

    public Aeropuerto(String nomAeronautico) {
        this.nomAeronautico = nomAeronautico;
    }

    public Aeropuerto(String nomAeronautico, String ciudad, long numTelefono) {
        this.nomAeronautico = nomAeronautico;
        this.ciudad = ciudad;
        this.numTelefono = numTelefono;
    }
    
    public String getNomAeronautico() {
        return nomAeronautico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    public boolean equals(Object unAeropuerto){
        boolean esIgual = false;
        Aeropuerto aux = (Aeropuerto) unAeropuerto;
        if(this.nomAeronautico.equals(aux.nomAeronautico))
            esIgual = true;
        return esIgual;   
    }
    
    public String toString(){
        String info =   "Nombre Aeronautico: "+nomAeronautico;
//                        " Ciudad: "+ciudad+
//                        " Numero Telefono: "+numTelefono;
        return info;
    }
    
}
