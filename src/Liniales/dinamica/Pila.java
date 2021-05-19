/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liniales.dinamica;

/**
 *
 * @author repetto.francisco
 */
public class Pila {
 
    //Atributos//
    private Nodo tope;
    
    //Contructores//
    public Pila(){
            this.tope=null;
    }
    
    //Modificadores//
    public boolean apilar(Object nuevoElem){
        boolean apilado;
        /*Crea un nuevo nodo delante del antiguo tope*/
        Nodo nuevo=new Nodo(nuevoElem,this.tope);
      
        /*Actualiza el nuevo tope para que apunte al nuevo nodo*/
        this.tope=nuevo;
        
        /*Nunca hay error de pila llena entonces devuelve true*/
        apilado=true;
        
        return apilado;
    }
    
    public boolean desapilar(){
        /*Desapila el nodo al que esta apuntando el tope*/
        boolean desapilado;
        
        if(this.tope==null)
            //Error, la pila esta vacia
            desapilado=false;
        else{
           this.tope=tope.getEnlace();
            desapilado=true;
        }
        return desapilado;
    }
    
    //Observadores//
    public Object obtenerTope(){
        /*Devuelve el valor que esta en el tope de la pila*/
        Object datoTope;
        if(this.tope==null)
            //Error, si la pila esta vacia devuelve un valor nulo
            datoTope=null;
        else
            datoTope=tope.getElem();
        
        return datoTope;
    }
    
    public boolean esVacia(){
        /*Verifica si el arreglo tiene elementos*/
        boolean vacia;
        if(this.tope==null)
            vacia=true;
        else
            vacia=false;
        
        return vacia;
    }
    
    //Operaciones//
    public void vaciar(){
        /*Vacia la pila hasta que el enlace es nulo*/ 
        while(this.tope!=null){
            this.tope=tope.getEnlace();
        }
    }
    
    public Pila clone(){
        /*Clona la pila y retorna una nueva con los mismos elementos*/
        Pila clon;
        clon=new Pila();
        Nodo aux=this.tope;
        if(aux==null)
            clon.tope=null;    
        else{
            clon.tope=new Nodo(aux.getElem(),null);
            aux=aux.getEnlace();
            Nodo aux2=clon.tope;
            while(aux!=null){
                aux2.setEnlace(new Nodo(aux.getElem(),null));
                aux=aux.getEnlace();
                aux2=aux2.getEnlace();
            }
        }
        return clon;
    }
    
    public String toString(){
        String s="";
        if(this.tope == null)
            s="Pila vacia";
        else {
            //Se ubica para recorrer la pila
            Nodo aux=this.tope;
            s="["; 
           while(aux!=null){
                //Agrega el texto del elem y avanza
                s+=aux.getElem().toString();
                aux=aux.getEnlace();
                if(aux!=null)
                    s+=",";
            }
            s+="]";
        }
        return s;
    }
}
    
    
    
