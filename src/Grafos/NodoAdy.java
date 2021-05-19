    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author repetto.francisco
 */
public class NodoAdy {
    
    //Atributos
    private NodoVert vertice=null;
    private NodoAdy sigAdyacente=null;
    private int etiqueta = 0;
 
    //Contructores
    public NodoAdy(NodoVert vert,NodoAdy siguienteAdy,int etiqueta){
        this.vertice=vert;
        this.sigAdyacente=siguienteAdy;
        this.etiqueta = etiqueta;
    }
    
    //Observadores
    public NodoVert getVertice(){
        return this.vertice;
    }
    
    public NodoAdy getSigAdyacente(){
        return this.sigAdyacente;
    }

    public int getEtiqueta() {
        return etiqueta;
    }
    
    //Modificadores
    public void setVertice(NodoVert vert){
        this.vertice=vert;
    }
    
    public void setSigAdyacente(NodoAdy siguienteAdy){
        this.sigAdyacente=siguienteAdy;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    
    
}
