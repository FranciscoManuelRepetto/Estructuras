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
public class Cola {
    
    //Atributos//
    private Nodo frente;
    private Nodo fin;
    
    //Constructor//
    public Cola(){
       this.frente=null;
       this.fin=null;
    }
    
    //Modificadores//
    public boolean poner(Object elem){
        boolean puesto;
        /*Crea un nuevo nodo delante del antiguo tope*/
        Nodo nuevo=new Nodo(elem,null);
        /*Actualiza fin para que apunte al nuevo nodo
        this.fin=nuevo;
        */
        /*Engancha el nuevo nodo a frente si la cola esta vacia*/
        if(this.frente==null){
            this.frente=nuevo;

        }else{
            this.fin.setEnlace(nuevo);
            
        }
        this.fin=nuevo;
            
        /*Nunca hay error de cola llena entonces devuelve true*/
        puesto=true;
        
        return puesto;
    }
    
    public boolean sacar(){
        boolean sacar=true;
        if(this.frente==null)
            /*Error porque la pila esta vacia*/
            sacar=false;
        else{
            /*Engancha frente al nodo siguiente*/
            this.frente=this.frente.getEnlace();
            /*Si se saca el ultimo elemento, fin queda null*/
            if(this.frente==null)
                this.fin=null;
            sacar=true;
        }
        return sacar;
    }
    
    //Observadores//
    public Object obtenerFrente(){
     /*Metodo para saber el valor del elemento que esta en el frente de la cola*/
        Object datoFrente;
        if(this.frente==null)
            datoFrente=null;
        else
            datoFrente=this.frente.getElem();
        return datoFrente;
    }
    
    public boolean esVacia(){
        /*Metodo para verificar si la cola esta vacia*/
        boolean vacio;
        if(this.frente==null)
            vacio=true;
        else
            vacio=false;
        return vacio;
    }
    
    //Operaciones convenientes//
    public void vaciar(){
        /*Metodo para vaciar toda la cola*/
        this.frente=null;
        this.fin=null;
        
    }
    
    public Cola clone(){
        /*Metodo para devolver una cola identica a la original*/
        Cola clon=new Cola();
        Nodo aux1=this.frente;
        if(aux1==null)
            clon.frente=null;    
        else{
            clon.frente=new Nodo(aux1.getElem(),null);
            aux1=aux1.getEnlace();
            Nodo aux2=clon.frente;
            while(aux1!=null){
                aux2.setEnlace(new Nodo(aux1.getElem(),null));
                aux1=aux1.getEnlace();
                aux2=aux2.getEnlace();
            }
            clon.fin=this.fin;
        }   
        return clon;
    }
    
    public String toString(){
        /*Metodo para mostrar todos los elementos de la cola*/
     String elem="";
     Nodo aux=this.frente;
     if(aux==null)
         elem=null;
     else{
         elem+="[";
         while(aux!=null){
         elem+=aux.getElem().toString();
         aux=aux.getEnlace();
         if(aux!=null)
             elem+=",";
         }
         elem+="]";
     }
     return elem;
    }
    
    
}
