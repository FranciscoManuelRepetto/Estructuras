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
public class Lista {
   
    //Atributos//
    private Nodo cab;
    private int longitud=0;
    
    //Constructor//
    public Lista(){
        this.cab=null;
        this.longitud=0;
    }
    
    //Metodos//
    public boolean insertar(Object nuevoElem,int pos){
        //Metodo para inserta un nuevo en la posicion pos
        boolean exito=true;
        
        if(pos<1||pos>this.longitud+1)
            /*Error de posicion invalida*/
            exito=false;
        else{
            if(pos==1){
                /*Crea un nuevo nodo y se enlaza en la cabecera*/
                this.cab=new Nodo(nuevoElem,this.cab);
            }else{
                /*Avanza hasta el elemento en posicion pos-1*/
                Nodo aux=this.cab;
                int i=1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                Nodo nuevo=new Nodo(nuevoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
            }
        return exito;
    }
    
    public boolean eliminar(int pos){
        //Metodo para eliminar un elemento en la posicio pos
        boolean exito=true;
        if(pos<1||pos>this.longitud)
            /*Error de posicion invalida*/
            exito=false;
        else{
            if(pos==1){
               this.cab=this.cab.getEnlace();
            }else{
                /*Avanza hasta el elemento en posicion pos-1*/
                Nodo aux=this.cab;
                int i=1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
        }

    return exito;  
    }
    
    
    public Object recuperar(int pos){
     /*Metodo para devolver el elemento en la posicion pos*/
     Object elem=null;
     if(pos<1||pos>this.longitud+1)
         /*Error de posicion invalida*/
         elem=null;
     else{
         Nodo aux=this.cab;    
         int i=1;
         while(i<pos){
                aux=aux.getEnlace();
                i++;
            }
         if(aux!=null)
         elem=aux.getElem();
        }   
     return elem;
    }
    
    public int localizar(Object elem){
     /*Metodo para devolver la posicion del objeto elem*/
     int pos=-1;
     Nodo aux=this.cab;
     int i=1;
     while(aux!=null){
         if(aux.getElem().equals(elem)){
             /*Encuentra el elemento entonces a pos le asigno la posicion
               Y aux le asigno null para cortar while*/
             pos=i;
             aux=null;
         }else{
             /*Avanza el aux y el contador aumenta en uno*/
             aux=aux.getEnlace();
             i++;
         }
     }
     return pos;
    }
    
    public int longitud(){
        /*Metodo para devolver la longitud de la lista*/
        int longitud;
        longitud=this.longitud;
        return longitud;
    }
    
    public boolean esVacia(){
        /*Metodo para ver si la lista esta vacia o no*/
        boolean vacia=false;
        if(this.cab==null)
            vacia=true;
        return vacia;
    }
    
    public void vaciar(){
        /*Metodo para vaciar la lista*/
        this.cab=null;
        longitud=0;
    }
    
    public Lista clone(){
        Lista clon=new Lista();
        if(this.cab==null)
            clon.cab=null;
        else{
            clon.cab=new Nodo(this.cab.getElem(),null);
            Nodo aux,aux2;
            /*Aux apunta al primer nodo de la lista y despues al nodo siguiente*/
            aux=this.cab;
            aux=aux.getEnlace();
            /*Aux2 apunta al primer nodo de la lista clon*/
            aux2=clon.cab;
            /*Aux avanza hasta pasarse de la ultima posicion*/
            while(aux!=null){
                aux2.setEnlace(new Nodo(aux.getElem(),null));
                aux=aux.getEnlace();
                aux2=aux2.getEnlace();
            }
            clon.longitud=this.longitud;
        }
        return clon;
        
    }
    
    public String toString(){
        /*Metodo para mostrar todo los elementos de la lista*/
        String elem="";
        Nodo aux=this.cab;
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
    
    /*EJERCICIO PRACTICA PARA PARCIAL*/
    
    /*Agregar a TDA Lista el método agregarElemento(Object nuevo, int x),
    que recorre la lista una sola vez y agregando el elemento nuevo en la
    primer posición y lo agrega cada x posiciones. Ejemplo: Sea la lista
    [1,2,3,4,5,6,7], nuevo= 0 y x = 2 modifica la lista para que quede
    [0,1,2,0,3,4,0,5,6,0,7]*/
    
    public boolean agregarElemento(Object elem,int x){
        boolean puesto;
        if(x<1||x>this.longitud+1)
            /*Ingreso una posicion invalida*/
            puesto=false;
        else{
            int i=0;
            this.cab=new Nodo(elem,this.cab);
            Nodo aux=this.cab,nuevo;
            while(aux!=null){
                if(i==x){
                    /*Busco las posiciones multiplos de x*/
                    nuevo=new Nodo(elem,aux.getEnlace());
                    aux.setEnlace(nuevo);
                    i=-1;
                }
                aux=aux.getEnlace();
                i++;
            }
            puesto=true;
        }
        return puesto;
    }
    
    public Pila estudiandoParaParcial1(){
        Pila pil = new Pila();
        if(this.cab!=null){
            Pila pilAux = new Pila(), pilAux2 = new Pila();
            Cola col = new Cola();
            int pos = 1, i = 0;
            Object elem;
            Nodo aux=this.cab;
            while(pos <= this.longitud){
                if(i<2){
                    elem=aux.getElem();
                    pilAux.apilar(elem);
                    col.poner(elem);
                    pilAux2.apilar(elem);
                    i++;
                    pos++;
                    aux=aux.getEnlace();
                }else{
                    while(!pilAux.esVacia()){
                        elem=pilAux.obtenerTope();
                        pilAux.desapilar();
                        pil.apilar(elem);
                    }
                    while(!col.esVacia()){
                        elem=col.obtenerFrente();
                        col.sacar();
                        pil.apilar(elem);
                    }
                    while(!pilAux2.esVacia()){
                        elem=pilAux2.obtenerTope();
                        pilAux2.desapilar();
                        pil.apilar(elem);
                    }
                    i=0;
                }
            }
            /*Vacio las pilas y colas por si quedaron llenas*/
            while (!pilAux.esVacia()) {
                elem = pilAux.obtenerTope();
                pilAux.desapilar();
                pil.apilar(elem);
            }
            while (!col.esVacia()) {
                elem = col.obtenerFrente();
                col.sacar();
                pil.apilar(elem);
            }
            while (!pilAux2.esVacia()) {
                elem = pilAux2.obtenerTope();
                pilAux2.desapilar();
                pil.apilar(elem);
            }
            pil.apilar('$');
        }
        return pil;
    }
    
    
    
    public void intercalar(Lista list) {
        if (this.cab != null && list != null) {
            int i =1;
            Nodo aux = this.cab, auxList = list.cab;
            Object elem;
            while (aux.getEnlace() != null) {
                if (i == 1 && auxList != null) {
                    elem = auxList.getElem();
                    aux.setEnlace(new Nodo(elem, aux.getEnlace()));
                    i = 0;
                    auxList = auxList.getEnlace();
                    aux = aux.getEnlace();
                    this.longitud++;
                } else {
                    i++;
                    aux = aux.getEnlace();
                }
            }
            while (auxList != null) {
                elem = auxList.getElem();
                Nodo nodo=new Nodo(elem,null);
                aux.setEnlace(nodo);
                auxList = auxList.getEnlace();
                aux=aux.getEnlace();
            }
        }
    }
    
    /*Metodo de male*/
    public  Pila estudiandoParaParcial2(){
      Pila nueva= new Pila();
      if(this.cab!=null){
        int cont=0,fijo=2;
        Pila pilis=new Pila();
        Pila aux=new Pila();
        Cola coli= new Cola();
        Nodo n=this.cab;
        Object elem;
        while(n!=null){
            if(cont<fijo){
                elem=n.getElem();
                aux.apilar(elem);
                pilis.apilar(elem);
                coli.poner(elem);
                n=n.getEnlace();
                cont++;
            }else{
                while(!aux.esVacia()){
                    elem=aux.obtenerTope();
                    nueva.apilar(elem);
                    aux.desapilar();
                }
                while(!coli.esVacia()){
                    elem=coli.obtenerFrente();
                    nueva.apilar(elem);
                    coli.sacar();
                }
                while(!pilis.esVacia()){
                    elem=pilis.obtenerTope();
                    nueva.apilar(elem);
                    pilis.desapilar();
                }
                cont=0;
                }
            }
         while(!aux.esVacia()){
                    elem=aux.obtenerTope();
                    nueva.apilar(elem);
                    aux.desapilar();
                }
                while(!coli.esVacia()){
                    elem=coli.obtenerFrente();
                    nueva.apilar(elem);
                    coli.sacar();
                }
                while(!pilis.esVacia()){
                    elem=pilis.obtenerTope();
                    nueva.apilar(elem);
                    pilis.desapilar();
                }
                nueva.apilar('$');
       
        }
      return nueva;
    }
}
