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
public class NodoVert {
    
    //Atributos
    private Object elem=null;
    private NodoVert sigVertice=null;
    private NodoAdy primerAdy=null;
    
    //Contructores
    public NodoVert(Object elemento,NodoVert siguienteVer,NodoAdy priAdyacente){
        this.elem=elemento;
        this.sigVertice=siguienteVer;
        this.primerAdy= priAdyacente;
    }
    
    //Observadores
    public Object getElem(){
        return this.elem;
    }
    
    public NodoVert getSigVertice(){
        return this.sigVertice;
    }
    
    public NodoAdy getPrimerAdy(){
        return this.primerAdy;
    }
    
    //Modificadores
    public void setElem(Object elemento){
        this.elem=elemento;
    }
    
    public void setSigVertice(NodoVert siguienteVer){
        this.sigVertice=siguienteVer;
    }
    
    public void setPrimerAdy(NodoAdy priAdyacente){
        this.primerAdy=priAdyacente;
    }
}
