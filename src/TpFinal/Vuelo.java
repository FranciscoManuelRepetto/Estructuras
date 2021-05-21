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
public class Vuelo {
    
    private String claveVuelo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String horaSalida;
    private String horaLlegada;
    private Lista listaVuelos;

    public Vuelo(String claveVuelo, Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, Lista listaVuelos) {
        this.claveVuelo = claveVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.listaVuelos = listaVuelos;
    }

    public String getClaveVuelo() {
        return claveVuelo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public Lista getListaVuelos() {
        return listaVuelos;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setListaVuelos(Lista listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
    
    
}
