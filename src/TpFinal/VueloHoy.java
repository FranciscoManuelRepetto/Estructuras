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
public class VueloHoy {
    
    private String fecha;
    private long cantAsTotales;
    private long cantAsVendidos;

    public VueloHoy(String fecha, long cantAsTotales) {
        this.fecha = fecha;
        this.cantAsTotales = cantAsTotales;
        this.cantAsVendidos = 0;
    }

    public VueloHoy(String fecha, long cantAsTotales,long cantAsVendidos) {
        /*Deberia ser usado solamente en la carga inicial*/
        this.fecha = fecha;
        this.cantAsTotales = cantAsTotales;
        this.cantAsVendidos = cantAsVendidos;
    }

    public String getFecha() {
        return fecha;
    }

    public long getCantAsTotales() {
        return cantAsTotales;
    }

    public long getCantAsVendidos() {
        return cantAsVendidos;
    }

    public void setCantAsVendidos(int cantAsVendidos) {
        this.cantAsVendidos = cantAsVendidos;
    }
    
    public void vendioPasaje(){
        this.cantAsVendidos +=1; 
    }
    
    public void canceloPasaje(){
        this.cantAsVendidos-=1;
        this.cantAsTotales+=1;
    }
    
    public String toString(){
        return "Fecha: "+fecha+"\n"+
               "Cantidad de Asientos Totales: "+cantAsTotales+"\n"+
               "Cantidad de Asientos Vendidos: "+cantAsVendidos+"\n";
    }
    
}
