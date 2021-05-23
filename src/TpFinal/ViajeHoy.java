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
public class ViajeHoy {
    
    private String fecha;
    private int cantAsTotales;
    private int cantAsVendidos;

    public ViajeHoy(String fecha, int cantAsTotales) {
        this.fecha = fecha;
        this.cantAsTotales = cantAsTotales;
        this.cantAsVendidos = 0;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantAsTotales() {
        return cantAsTotales;
    }

    public int getCantAsVendidos() {
        return cantAsVendidos;
    }

    public void setCantAsVendidos(int cantAsVendidos) {
        this.cantAsVendidos = cantAsVendidos;
    }
    
}
