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
    private String numAsiento;
    private String estado;

    public Pasaje(Vuelo vuelo, String fecha, String numAsiento,String estado) {
        /*Solo para la carga de datos*/
        this.vuelo = vuelo;
        this.fecha = fecha;
        this.numAsiento = numAsiento;
        this.estado = estado;
    }
    
    public Pasaje(Vuelo vuelo, String fecha, String numAsiento) {
        this.vuelo = vuelo;
        this.fecha = fecha;
        this.numAsiento = numAsiento;
        this.estado = "Pendiente";
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString(){
        String info =   "\nPasaje del vuelo: "+vuelo.getClaveVuelo()+"\n"+
                        "Hora salida: "+vuelo.getHoraSalida()+"\n"+
                        "Hora llegada: "+vuelo.getHoraLlegada()+"\n"+
                        "Fecha: "+fecha+"\n"+
                        "Num Asiento: "+numAsiento+"\n"+
                        "Estado: "+estado+"\n";
        return info;
    }
}
