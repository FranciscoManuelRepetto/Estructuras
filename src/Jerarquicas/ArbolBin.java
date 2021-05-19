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

public class ArbolBin {
    
    //Atributos//
    private NodoArbol raiz;
    
    //Constructor//
    public ArbolBin(){
        raiz=null;
    }
    
    //Modificadores//
    public boolean insertar (Object elemNuevo,Object elemPadre,char posicion){
        /*Inserta elemNuevo con hijo del primer nodo encontrado en preOrden
          Igual a elemPadre,como hijo izquierdo(I) o derecho (D),segun lo 
          indique el parametro lugar*/
          boolean exito=true;
          
          if(this.raiz==null){
              /*Si el arbol esta vacio,ponemos el elem en la nueva raiz*/
              this.raiz=new NodoArbol(elemNuevo,null,null);
          }else{
          /*Si no esta vacio, se busca el padre*/
          NodoArbol nodoPadre=obtenerNodo(this.raiz,elemPadre);
          if(nodoPadre!=null){
              if(posicion=='I'&& nodoPadre.getIzquierdo()==null){
                  /*Si el padre existe y no tiene HI, se lo agrega*/
                  nodoPadre.setIzquierdo(new NodoArbol(elemNuevo,null,null));
                }else{
                  if(posicion=='D' && nodoPadre.getDerecho()==null){
                      /*Si el padrre existe y no tiene HD, se lo agrega*/
                      nodoPadre.setDerecho(new NodoArbol(elemNuevo,null,null));
                  }else
                      /*Error porque el padre no existe o ya tiene ese hijo*/
                      exito=false;
              }
          }else
              exito=false;
          }
          return exito;
    }
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
       /*Metodo privado que busca un elemento y devuelve el nodo que
        lo contiene. Si no se encuentra buscado, devuelve null*/
        NodoArbol resultado=null;
        if(n!= null)
            if(n.getElem().equals(buscado))
                /*Si n es el buscado, entonces lo devuelve*/
                resultado=n;
            else{
                /*No es el buscado: lo busca primero en HI*/
                resultado=obtenerNodo(n.getIzquierdo(),buscado);
                /*No es el buscado: lo busca en el HD*/
                if(resultado==null)
                    resultado=obtenerNodo(n.getDerecho(),buscado);
            }
        return resultado;
       }
    
    public boolean esVacio(){
        /*Metodo para saber si el arbol no tiene raiz*/
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
        else
            alturaFinal=alturaAux(this.raiz);
        return alturaFinal;
    }
    
    private int alturaAux(NodoArbol nodo){
        /*Metodo privado que recorre el arbol y obtiene el metodo
        mas largo desde la raiz hasta una hoja*/
        int altura;
        if(nodo!=null){
            altura=Math.max(alturaAux(nodo.getIzquierdo()),alturaAux(nodo.getDerecho()))+1; 
        }else{
            altura=-1;
        }
        return altura;
    } 
    
    public int nivel(Object elem){
        int nivel=nivelAux(elem,this.raiz,0,-1);
        return nivel;
        
    }
    
    private int nivelAux(Object elem,NodoArbol nodo,int nivel,int aux){
        /*Recorre el arbol en preOrden y si lo encuentra devuevle el nivel*/
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){/*Visita al nodo*/
                aux=nivel;
            }else{
                /*Si no lo encuentra, busca al hijo izquierdo*/
                aux=nivelAux(elem,nodo.getIzquierdo(),nivel+1,aux);
                /*Si no lo encuentra, busca al hijo derecho*/
                aux=nivelAux(elem,nodo.getDerecho(),nivel+1,aux);
            }
        }
     return aux;
    }

    
    public Object padre(Object elem){
        /*Metodo que devuelve el padre del elemento ingresado
        por parametro*/
        Object padre=null;
        if(this.raiz!=null){
            padre=padreAux(this.raiz,elem,null);
        }
        return padre;
    }
    
    
    private Object padreAux(NodoArbol nodo,Object elem,Object padre){
        /*Metodo que recorre buscando el elemento y devuelve su padre*/
        Object aux=null;
        if(nodo!=null){
            if(nodo.getElem().equals(elem))
                /*Si el elemento es el buscado, entonces lo devuelve*/
                aux=padre;
            else{
                /*No es el buscado: lo busca primero en HI*/
                aux=padreAux(nodo.getIzquierdo(),elem,nodo.getElem());
                /*No es el buscado: lo busca en el HD*/
                if(aux==null)
                    aux=padreAux(nodo.getDerecho(),elem,nodo.getElem());
            }
        }
        return aux; 
    }
    
    public Lista listarPreorden(){
        /*Imprime los elementos por consola en preOrden*/
        Lista list=new Lista();
        preordenAux(list,this.raiz);
        return list;
    }
    
    private void preordenAux(Lista list,NodoArbol nodo){
        /*Metodo recursivo privado porque su parametro es un tipo
        NodoArbol*/
        if(nodo!=null){
            /*Visita cada nodo y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(),list.longitud()+1);
            
            /*Recorre sus hijos en preorden*/
            preordenAux(list,nodo.getIzquierdo());
            preordenAux(list,nodo.getDerecho());
        }
    }
    
    public Lista listarInorden(){
        /*Imprime los elementos por consola en Inorden*/
        Lista list=new Lista();
        inordenAux(list,this.raiz);
        return list;
    }
    
    private void inordenAux(Lista list,NodoArbol nodo){
        /*Metodo recursivo privado porque su parametro es un tipo
        NodoArbol*/
        if(nodo!=null){
            /*Recorrer al hijo izquierdo*/
            inordenAux(list,nodo.getIzquierdo());
            /*Visita cada nodo y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(),list.longitud()+1);
            /*Recorre al hijo derecho*/
            inordenAux(list,nodo.getDerecho());
        }
    }
    
    public Lista listarPosorden(){
        /*Imprime los elementos por consola en PosOrden*/
        Lista list=new Lista();
        posordenAux(list,this.raiz);
        return list;
    }
    
    private void posordenAux(Lista list,NodoArbol nodo){
        /*Metodo recursivo privado porque su parametro es un tipo
        NodoArbol*/
        if(nodo!=null){
            /*Recorre al hijo izquierdo*/
            posordenAux(list,nodo.getIzquierdo());
            /*Recorre al hijo derecho*/
            posordenAux(list,nodo.getDerecho());
            /*Visita a los nodos y inserta el elemento en la lista*/
            list.insertar(nodo.getElem(),list.longitud()+1);
        }
    }
    
    public Lista listarPorniveles(){
        /*Imprime los elementos por consola en recorrido
        por niveles*/
     NodoArbol nodoActual;
     Lista list=new Lista();
     Cola q=new Cola();
     q.poner(this.raiz);
     int i=1;
     while(!q.esVacia()){
         nodoActual=(NodoArbol)q.obtenerFrente();
         q.sacar();
         list.insertar(nodoActual.getElem(), i);
         i++;
         if(nodoActual.getIzquierdo()!=null)
             q.poner(nodoActual.getIzquierdo());
         if(nodoActual.getDerecho()!=null)
             q.poner(nodoActual.getDerecho());
        }
     return list;
    }
    
    public ArbolBin clone(){
        /*Metodo que devuelve un Arbol clon*/
        ArbolBin clon=new ArbolBin();
        clon.raiz=cloneAux(this.raiz);
        return clon;
    }
    
    private NodoArbol cloneAux(NodoArbol nodo){
        /*Recorre los elementos de los hijos de la raiz*/
        NodoArbol clon=null;
        if(nodo!=null){
            clon=new NodoArbol(nodo.getElem(),cloneAux(nodo.getIzquierdo()),cloneAux(nodo.getDerecho()));
        }
        return clon;
    }
    
    public void vaciar(){
        /*Metodo para vaciar el arbol*/
        this.raiz=null;
    }
    
    public String toString(){
        String arbol="null";
        if(this.raiz!=null)
            arbol=toStringAux(this.raiz);
        return arbol;
    }
    
    private String toStringAux(NodoArbol nodo){
        String arbol="";
        if(nodo!=null){
            NodoArbol hijoI=nodo.getIzquierdo(),hijoD=nodo.getDerecho();
            if(hijoI!=null)
                arbol+=nodo.getElem()+" HI: "+hijoI.getElem();
            else
                arbol+=nodo.getElem()+" HI: null";
            if(hijoD!=null)
                arbol+=" HD: "+hijoD.getElem();
            else
                arbol+=" HD: null";
            arbol+="\n";
            arbol+=toStringAux(nodo.getIzquierdo());
            arbol+=toStringAux(nodo.getDerecho());
        }
        return arbol;
    }
    
    
    public Lista obtenerAncestros(Object elem){
        Lista list=new Lista();
        obtenerAncestrosAux(this.raiz,elem,list);
        return list;
    }
    
    private boolean obtenerAncestrosAux(NodoArbol nodo,Object elem,Lista list){
        boolean pertenece=false;
        if(nodo!=null){
            if(nodo.getElem().equals(elem))
                /*Si elem existe, se cambia pertenece a true*/
                pertenece=true;
            else{
                /*Si no es el buscado, lo busca en los hijos*/
                /*Lo busca en el hijo derecho*/
                if(nodo.getIzquierdo()!=null){
                    pertenece=obtenerAncestrosAux(nodo.getIzquierdo(),elem,list);   
                }
                /*Lo busca en el hijo derecho*/
                if(!pertenece){
                    if(nodo.getDerecho()!=null){
                        pertenece=obtenerAncestrosAux(nodo.getDerecho(),elem,list);
                    }
                }
                /*Si ya encontro el elemento, agrega a los ancestros a lista*/
                if(pertenece){
                    list.insertar(nodo.getElem(), 1);
                }
            }
        }
        return pertenece;
    }
    
    public Lista obtenerDescendientes(Object elem){
        Lista list=new Lista();
        list=obtenerDescendientesAux(this.raiz,elem,list,false);
        return list;
    }
    
    private Lista obtenerDescendientesAux(NodoArbol nodo,Object elem,Lista list,boolean pertenece){
        if(nodo!= null){
            if(nodo.getElem().equals(elem))
            /*Si nodo es el buscado, entonces setea pertenece a true*/
                pertenece=true;
            /*Recorre HI*/
            if(pertenece)
                /*Si encontro el elemento, inserta en las listas a sus descendientes*/
                list.insertar(nodo.getElem(), 1);
            obtenerDescendientesAux(nodo.getIzquierdo(),elem,list,pertenece);
            /*Recorre HD*/
            obtenerDescendientesAux(nodo.getDerecho(),elem,list,pertenece);
        }
    return list;
    }

}
        



    
