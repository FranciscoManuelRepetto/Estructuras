/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liniales.estatica;

/**
 *
 * @author repetto.francisco
 */
public class Pila {

//Atributos//
private int tope;
private Object[] arreglo;
private static final int Tamanio=10;

//Constructor
public Pila(){
    this.arreglo=new Object[Tamanio];
    this.tope=-1;
    
}

//Modificadores//
public boolean apilar(Object nuevoElem){
    boolean apilado;
    
    if(this.tope+1>=Tamanio)
        /*Error si la pila esta llena*/
        apilado=false;
    else{
        /*Incrementa en uno el tope y pone el ultimo elemento en el tope de la pila*/
        this.tope++;
        this.arreglo[this.tope]=nuevoElem;
        apilado=true;
        }
    return apilado;
}

public boolean desapilar(){
    boolean desapilado;
    
    if(this.tope<=-1)
        /*Error si la pila esta vacia*/
        desapilado=false;
    else{
        /*Desapila el elemento que esta en el tope y lo pone nulo, el tope decrementa en uno*/ 
        this.arreglo[this.tope]=null;
        this.tope--;
        desapilado=true;
    }
    return desapilado;
}

//Observadores//
public Object obtenerTope(){
    Object datoTope;
    
    if(this.tope<=-1)
        /*Error si la pila esta vacia devuelve un valor nulo*/
        datoTope=null;
    else{
        /*Se le asigna a datoTope el valor del elemento que esta en el tope de la pila*/
        datoTope=this.arreglo[this.tope];
    }
    return datoTope;
}

public boolean esVacia(){
    /*Metodo que verifica si el arreglo tiene elementos*/
    boolean vacia;
    
    if(this.tope<=-1)
        vacia=true;
    else{
        vacia=false;
    }
    return vacia;
}

//Operaciones convenientes//
public void vaciar(){
    /*Metodo que vacia el arreglo*/
    for (int i=this.tope; i>-1; i--) {
        arreglo[i]=null;
        this.tope--;
    }
}

public Pila clone(){
    /*Metodo para clonar una pila*/
    Pila clon;
    clon=new Pila();
    clon.arreglo=this.arreglo.clone();
    clon.tope=this.tope;
    return clon;
}

public String toString(){
    /*Metodo para mostrar los valores de la pila*/
    String elem="";
        if(this.tope==-1)
            elem=null;
        else{
            elem="[";
            for (int i = this.tope; i >= 0; i--) {
                elem=elem+arreglo[i];
                if(i!=0)
                    elem=elem+",";
            }
            elem+="]";
        }
    return elem;

}

}























