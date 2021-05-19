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
public class Cola {
    
    //Atributos//
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO=10;
    
    //Constructor//
    public Cola(){
        this.arreglo=new Object[this.TAMANIO];
        this.frente=0;
        this.fin=0;
    }
    
    //Modificadores//
    public boolean poner(Object elem){
        /*Metodo para poner un elemento más en la cola*/
        boolean puesto=false;
        if((this.fin+1)%10==(this.frente))
            //Error de cola llena
            puesto=false;
        else{
            this.arreglo[this.fin]=elem;
            this.fin=(this.fin+1)%this.TAMANIO;
            puesto=true;
        }
        return puesto;
    }
    
    public boolean sacar(){
        /*Metodo para sacar un elemento de la cola*/
        boolean sacar=true;
        if(this.esVacia())
            //Error si la pila esta vacia
            sacar=false;
        else{
            this.arreglo[this.frente]=null;
            this.frente=(this.frente+1)%this.TAMANIO;
            sacar=true;
        }
        return sacar;
    }
    
 public Object obtenerFrente(){
     /*Metodo para saber el valor del elemento que esta en el frente de la cola*/
        Object datoFrente;
        if(this.frente==this.fin)
            datoFrente=null;
        else
            datoFrente=this.arreglo[this.frente];
        return datoFrente;
    }
    
    public boolean esVacia(){
        /*Metodo para verificar si la cola esta vacia*/
        boolean vacia;
        if(this.frente==this.fin)
            vacia=true;
        else
            vacia=false;
        return vacia;
    }
    
    public void vaciar(){
       /*Metodo para vaciar toda la cola*/
       this.frente=0;
        for (int i = 0; i <=this.fin ; i++) {
            this.arreglo[i]=null;
        }
       this.fin=this.frente;
    }
    
    public Cola clone(){
        /*Metodo para devolver una cola identica a la original*/
        Cola clon;
        clon=new Cola();
        clon.arreglo=this.arreglo.clone();
        clon.frente=this.frente;
        clon.fin=this.fin;
        return clon;
    }
    
    public String toString(){
        /*Metodo para mostrar todos los elementos de la cola*/
        String elem="";
            elem+="[";
            int i=this.frente;
            while(i!=this.fin){
                elem+=this.arreglo[i];
                if(i+1!=this.fin)
                elem+=",";;
                i=(i+1)%10;
            }
            elem+="]";
        return elem;
    }
}   
