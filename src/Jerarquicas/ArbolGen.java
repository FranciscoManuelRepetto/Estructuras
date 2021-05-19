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
import Liniales.dinamica.Cola;
import Liniales.dinamica.Lista;
public class ArbolGen {
    
    //Atributos//
    private NodoGen raiz;
    
    //Constructores//
    public ArbolGen(){
        raiz=null;
    }
    
    //Operaciones basicas//
    public boolean insertar(Object elemNuevo,Object elemPadre){
        /*Inserta elemNuevo con hijo del primer nodo encontrado en preOrden
          Igual a elemPadre,como hermano derecho del HI*/
        boolean exito=true;
        
        if(this.raiz==null){
          /*Si el arbol esta vacio, ponemos el elem en la nueva raiz*/
          this.raiz=new NodoGen(elemNuevo,null,null);
        }else{
          /*Si no esta vacio, se busca el padre*/
          NodoGen nodoPadre=obtenerNodo(this.raiz,elemPadre);
          if(nodoPadre!=null){
                /*Si el padre existe lo pone como hijo izquierdo*/
                if(nodoPadre.getHijoIzquierdo()==null){
                    nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo,null,null));
                }else{
                    /*Si ya tiene hijo izquierdo, lo coloca como ultimo hermano derecho*/
                    NodoGen aux=nodoPadre.getHijoIzquierdo(),hermano=null;
                    while(aux!=null){
                        hermano=aux;
                        aux=aux.getHermanoDerecho();
                    }
                    hermano.setHermanoDerecho(new NodoGen(elemNuevo,null,null));
                }
        }else{
        /*Error, si no existe padre con elemPadre*/
        exito=false;
        }
    }
        return exito;
    }
    
    
    private NodoGen obtenerNodo(NodoGen nodo,Object elemPadre){
        /*Metodo privado que busca un elemento y devuelve el nodo que
        lo contiene. Si no se encuentra buscado, devuelve null*/
        NodoGen resultado=null,hijo;
        if(nodo!=null){
            if(nodo.getElem().equals(elemPadre))
                /*Si n es el buscado, entonces lo devuelve*/
                resultado=nodo;
            else{
                if(nodo.getHijoIzquierdo()!=null){
                    /*No es el buscado: lo busca primero en HI*/
                    resultado=obtenerNodo(nodo.getHijoIzquierdo(),elemPadre);
                    if(resultado==null){
                        /*No es el buscado: lo busca en los hermanos*/
                        hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                        while(hijo!=null&&resultado==null){
                            resultado=obtenerNodo(hijo,elemPadre);
                            hijo=hijo.getHermanoDerecho();
                        }
                    }    
                }
            }
        }
        return resultado;
    }
    
    public boolean pertenece(Object elem){
        /*Metodo para verificar si elem pertenece al arbol,
        si no lo encontra devuelve false*/
        boolean pertenece;
        pertenece=perteneceAux(this.raiz,elem);
        return pertenece;
        }
        
    private boolean perteneceAux(NodoGen nodo, Object elem){
        /*Metodo privado para recorrer el arbol buscando elem*/
        boolean pertenece=false;
        NodoGen hijo;
        if(nodo!=null){
            if(nodo.getElem().equals(elem))
                /*Si el elem existe, cambia encontrado a true*/
                pertenece=true;
            else{
                if(nodo.getHijoIzquierdo()!=null){
                    /*No es el buscado: lo busca primero en HI*/
                    pertenece=perteneceAux(nodo.getHijoIzquierdo(),elem);
                    if(!pertenece){
                        /*No es el buscado: lo busca en los hermanos*/
                        hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                        while(hijo!=null&&!pertenece){
                            pertenece=perteneceAux(hijo,elem);
                            hijo=hijo.getHermanoDerecho();
                        }
                    }    
                }
            }
        }
        return pertenece;
    }
    
    public Lista ancestros(Object elem){
        Lista list=new Lista();
        if(this.raiz!=null)
        ancestrosAux(this.raiz,elem,list);
        
        return list;
    }
    
    
    private Boolean ancestrosAux(NodoGen nodo, Object elem, Lista list) {
        /*Metodo privado para encontrar un elem y devolver 
        una lista desde el elem hasta la raiz*/
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                /*Si el elem existe, cambia encontrado a true*/
                encontrado = true;
            }else{
                /*No es el buscado, lo busco en los hermanos*/
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    encontrado = ancestrosAux(hijo, elem, list);
                    hijo = hijo.getHermanoDerecho();
                }
                /*Agrego los ancestros a la lista*/
                if (encontrado) {
                    list.insertar(nodo.getElem(), 1);
                }
            }
        }
        if (!encontrado) {
            list.vaciar();
        }
        return encontrado;
    }

    
    public boolean esVacio(){
        /*Metodo para retornar si el arbol esta vacio*/
        boolean vacio=false;
        if(this.raiz==null)
            vacio=true;
        return vacio;
    }
     public int altura(){
        /*Metodo para devolver la longitud del camino más
        largo desde la raíz hasta una hoja*/
        int alturaFinal;
        if(this.raiz==null)
            alturaFinal=-1;
        else{
            alturaFinal=alturaAux(this.raiz);
        }
        return alturaFinal;
    }
     
     private int alturaAux(NodoGen nodo){
        /*Metodo privado que recorre en posOrden el arbol y obtiene el metodo
        con altura maxima desde la raiz hasta la hoja*/
        int aux=-1,altura;
         if (nodo != null) {
             if (nodo.getHijoIzquierdo() != null) {
                    /*Recorre a los hermanos derechos*/
                    NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                    if(hijo!=null)
                        aux =Math.max(alturaAux(hijo),alturaAux(hijo.getHermanoDerecho()));
                }
                altura=Math.max(alturaAux(nodo.getHijoIzquierdo()), aux)+1;
            }else
            altura=-1; 
         
            return altura;
        }
        
     
    
    public int nivel(Object elem){
        int nivel;
        nivel=nivelAux(this.raiz,elem,0);
        return nivel;
    }
    
    private int nivelAux(NodoGen nodo,Object elem,int nivel){
        int aux=-1;
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                /*Si lo encuentra devuelve el nivel*/
                aux=nivel;
            }else{
                /*Si no es el buscado, busca en el hijo izquierdo*/
                aux=nivelAux(nodo.getHijoIzquierdo(),elem,nivel+1);
                /*Si no es el buscado, busca en los hermanos derechos*/
                if(aux==-1){
                    if(nodo.getHijoIzquierdo()!=null){
                        NodoGen hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                        while(hijo!=null&&aux==-1){
                            aux=nivelAux(hijo,elem,nivel+1);
                            hijo=hijo.getHermanoDerecho();
                        }
                    }
                }
            }
        }    
        return aux;
    }
    
    public Object padre(Object elem){
        /*Metodo que devuelve el padre del elemento ingresado
        por parametro*/
        Object padre;
        if(this.raiz!=null)
            padre=padreAux(this.raiz,elem,null);
        else
            padre=null;
        return padre;
    }
    
    private Object padreAux(NodoGen nodo,Object elem,Object aux){
        /*Metodo recursivo para buscar padre de un elemento*/
        Object padre=null;
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                padre=aux;
            }else{
                /*Guarda al padre*/
                aux=nodo.getElem();
                if(nodo.getHijoIzquierdo()!=null){
                    /*No es el buscado: lo busca primero en HI*/
                    padre=padreAux(nodo.getHijoIzquierdo(),elem,aux);
                }
                    if(padre==null){
                        if(nodo.getHijoIzquierdo()!=null){
                            /*No es el buscado: lo busca en los hermanos del hijo*/
                            NodoGen hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                            while(hijo!=null&&padre==null){
                                padre=padreAux(hijo,elem,aux);
                                hijo=hijo.getHermanoDerecho();
                            }    
                        }
                    }    
                }
            }
        return padre;
    }
    
    
      public Lista listarPreorden(){
        /*Imprime los elementos por consola en preOrden*/
        Lista list=new Lista();
        list=preordenAux(list,this.raiz);
        return list;
    }
    
    private Lista preordenAux(Lista list,NodoGen nodo){
        /*Metodo privado porque su parametro es un tipo
        NodoArbol, recorrido Preorden*/
        if(nodo!=null){
            /*Visita cada nodo y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(),list.longitud()+1);
            if(nodo.getHijoIzquierdo()!=null){
                /*Recorrer al hijo izquierdo*/
                preordenAux(list,nodo.getHijoIzquierdo());
            }
            if(nodo.getHijoIzquierdo()!=null){   
                /*Llamado recursivo a los otros hijos de nodo*/
                NodoGen hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    preordenAux(list,hijo);
                    hijo=hijo.getHermanoDerecho();
                }   
            }
        }
        return list;
    }
    
    public Lista listarInorden(){
        /*Imprime los elementos por consola en Inorden*/
        Lista list=new Lista();
        list=inordenAux(list,this.raiz);
        return list;
    }
    
    private Lista inordenAux(Lista list,NodoGen nodo){
        /*Metodo privado porque su parametro es un tipo
        NodoArbol, recorrido Inorden*/
        if(nodo!=null){
            if(nodo.getHijoIzquierdo()!=null){
                /*Recorrer al hijo izquierdo*/
                inordenAux(list,nodo.getHijoIzquierdo());
            }
            /*Visita cada nodo y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(),list.longitud()+1);
            if(nodo.getHijoIzquierdo()!=null){   
                /*Llamado recursivo a los otros hijos de nodo*/
                NodoGen hijo=nodo.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    inordenAux(list,hijo);
                    hijo=hijo.getHermanoDerecho();
                }   
            }
        }
        return list;
    }
    
    public Lista listarPosorden(){
        /*Imprime los elementos por consola en PosOrden*/
        Lista list=new Lista();
        posordenAux(list,this.raiz);
        return list;
    }
    
    private Lista posordenAux(Lista list,NodoGen nodo){
        /*Metodo privado porque su parametro es un tipo
        NodoArbol, recorrido Posorden*/
        if (nodo != null) {
            if (nodo.getHijoIzquierdo() != null) {
                /*Recorrer al hijo izquierdo*/
                posordenAux(list, nodo.getHijoIzquierdo());
            }
            if (nodo.getHijoIzquierdo() != null) {
                /*Llamado recursivo a los otros hijos de nodo*/
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    posordenAux(list, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            /*Visita cada nodo y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(), list.longitud() + 1);
        }
        return list;
    }
    
    public Lista listarPorniveles(){
        /*Imprime los elementos por consola en recorrido
        por niveles*/
     NodoGen nodoActual;
     Lista list=new Lista();
     Cola q=new Cola();
     q.poner(this.raiz);
     int i=1;
     while(!q.esVacia()){
         nodoActual=(NodoGen)q.obtenerFrente();
         q.sacar();
         list.insertar(nodoActual.getElem(),i);
         if(nodoActual.getHijoIzquierdo()!=null){
             /*Inserta en la cola al hijo izquierdo*/
             q.poner(nodoActual.getHijoIzquierdo());
             /*Inserta a los hermanos del hijo izquierdo*/
             NodoGen hermano=nodoActual.getHijoIzquierdo().getHermanoDerecho();
             while(hermano!=null){
                 q.poner(hermano);
                 hermano=hermano.getHermanoDerecho();
                }
            }
         i++;
        }
     return list;
    }
    
    public void vaciar(){
        this.raiz=null;
    }
    
    public ArbolGen clone(){
        ArbolGen clon=new ArbolGen();
        if(this.raiz!=null)
            clon.raiz=cloneAux(this.raiz);
        else
            clon=null;
        return clon;
    }
    
    private NodoGen cloneAux(NodoGen nodo){
        NodoGen clon=null;
        if(nodo!=null)
            clon=new NodoGen(nodo.getElem(),cloneAux(nodo.getHijoIzquierdo()),cloneAux(nodo.getHermanoDerecho()));
        return clon;
    }

    
    public String toString(){
        return toStringAux(this.raiz);
    }
    
    private String toStringAux(NodoGen nodo){
        String s=" ";
        if(nodo!=null){
            /*Visita a nodo*/
            s+=nodo.getElem().toString()+"->";
            NodoGen hijo=nodo.getHijoIzquierdo();
            while(hijo!=null){
                s+=hijo.getElem().toString()+", ";
                hijo= hijo.getHermanoDerecho();
            }
            
            /*Comienza recorrido de los hijos de nodo llamando recursivamente*/
            /*Para que cada agregue su subcadena a la general*/
            hijo=nodo.getHijoIzquierdo();
            while(hijo!=null){
                s+="\n"+toStringAux(hijo);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return s;
    }
    
    
    public Lista frontera(){
        Lista list=new Lista();
        fronteraAux(this.raiz,list,1);
        return list;
    }
    
    private int fronteraAux(NodoGen nodo,Lista list,int i){
        if (nodo != null) {
            if (nodo.getHijoIzquierdo() == null) {
                /*Si es un nodo hoja, lo agrego a la lista*/
                list.insertar(nodo.getElem(), i);
                i++;
            } else {
                /*Si no es una hoja, busco en los hijos del nodo*/
                /*Recorro el hijo izquierdo*/
                i=fronteraAux(nodo.getHijoIzquierdo(), list, i);
                /*Recorro los hermanos del hijo izquierdo*/
                NodoGen hermano = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hermano != null) {
                    i=fronteraAux(hermano, list, i);
                    hermano = hermano.getHermanoDerecho();
                }
            }
        }
        return i;
    }
}