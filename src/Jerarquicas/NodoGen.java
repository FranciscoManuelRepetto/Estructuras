/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

/**
 *
 * @author repetto.francisco
 */
public class NodoGen {
    
    //Atributos//
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    //Constructor//
    public NodoGen(Object elem,NodoGen HI,NodoGen HD){
        this.elem=elem;
        this.hijoIzquierdo=HI;
        this.hermanoDerecho=HD;
    }
    
    //Observadores//
    public Object getElem(){
        return this.elem;
    }
    
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    
    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    
    //Modificadores//
    public void setElem(Object elem){
        this.elem=elem;
    }
    
    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
        this.hijoIzquierdo=hijoIzquierdo;
    }
    
    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.hermanoDerecho=hermanoDerecho;
    }
    
    
}
