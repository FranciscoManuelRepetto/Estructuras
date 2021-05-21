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
public class Pasaje {
    
    private Vuelo vuelo;
    private String fecha;
    private int numAsiento;
    private String estado;

    public Pasaje(Vuelo vuelo, String fecha, int numAsiento, String estado) {
        this.vuelo = vuelo;
        this.fecha = fecha;
        this.numAsiento = numAsiento;
        this.estado = estado;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getFecha() {
        return fecha;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
