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
public class ClientePromocion implements Comparable {
    /*Cree esta clase porque cuando uso un diccionario y la clave es la cantidad de pasajes,
    no me lo carga bien en la situacion de que dos clientes tengan la misma cantidad de pasajes
    */
    
    private int cantPasajes;
    private ClaveCliente clave;

    public ClientePromocion(int cantPasajes, ClaveCliente clave) {
        this.cantPasajes = cantPasajes;
        this.clave = clave;
    }

    @Override
    public int compareTo(Object obj) {
        //se compara tomando en primer lugar la cantidad de pasajes y luego la clave
        ClientePromocion cliente = (ClientePromocion) obj;
        int resultado;
        if (this.cantPasajes < cliente.cantPasajes) {
            resultado = -1;
        } else {
            if (this.cantPasajes == cliente.cantPasajes) {
                resultado = this.clave.compareTo(cliente.clave);
            }else
                resultado = 1;
        }
        return resultado;
    }
    
    public String toString(){
        return clave.toString()+" compro "+cantPasajes+" pasajes";
    }

}
