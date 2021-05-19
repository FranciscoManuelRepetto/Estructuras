/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjustistas;
import Liniales.dinamica.Lista;
/**
 *
 * @author repetto.francisco
 */
public class ABB {
    
    //Atributos
    private NodoABB raiz;
    
    //Constructor
    public ABB(){
        raiz=null;
    }
    
    //Operaciones principales
    public boolean pertenece(Comparable elem){
       boolean pertenece=perteneceAux(this.raiz,elem);
       return pertenece;
    }
    
    private boolean perteneceAux(NodoABB nodo,Comparable elem){
        boolean pertenece=false;
        if(nodo!=null){
            if(elem.compareTo(nodo.getElem())== 0){
                /*Si elem es igual al elemento del nodo,
                entonces elem pertence a ABB*/
                pertenece=true;
            }else if(elem.compareTo(nodo.getElem())<0){
                /*Si el elemento es menor al elemento del nodo
                entonces lo busca en los hijos izquierdos*/
                pertenece=perteneceAux(nodo.getIzquierdo(),elem);
            }else{
                /*Si el elemento es mayor al elemento del nodo
                entonces lo busca en los hijos derechos*/
                pertenece=perteneceAux(nodo.getDerecho(),elem);
            }
        }
        return pertenece;
    }
    
    
    public boolean insertar(Comparable elem){
        boolean exito = true;
        if(this.raiz==null){
            this.raiz=new NodoABB(elem,null,null);
        }else{
        exito=insertarAux(this.raiz,elem);
        }
        return exito;
    }
    
    private boolean insertarAux(NodoABB n,Comparable elem){
        /*Precondicion n no es nulo*/
        boolean exito=true;
        
        if((elem.compareTo(n.getElem())==0)){
            /*Reportar error: Elemento repetido */
            exito=false;
        }else if(elem.compareTo(n.getElem())< 0){
            /*Elemento es menor que n.getElem()
            Si tiene HI baja a la izquierda, sino agrega elemento*/
            if(n.getIzquierdo()!=null){
                exito=insertarAux(n.getIzquierdo(),elem);
            }else{
                n.setIzquierdo(new NodoABB(elem,null,null));
            }
        }else{
            /*Elemento es mayor que n.getElem()
            si tiene HD baja a la derecha, sino agrega elemento*/
            if(n.getDerecho()!=null){
                exito=insertarAux(n.getDerecho(),elem);
            }else{
                n.setDerecho(new NodoABB(elem,null,null));
            }
        }
        return exito;
    }
    
    public boolean eliminar(Comparable elem){
       boolean elimino;
       elimino=eliminarAux(elem,this.raiz,null);
       return elimino;
    }
    
    private boolean eliminarAux(Comparable elem,NodoABB nodo,NodoABB padre){
        boolean exito=false;
        if(nodo!=null){
            /*Pregunto si es nodo.getElem() es que hay que eliminar*/
            if(elem.compareTo(nodo.getElem()) == 0){
                /*Llamo metodo que diferencia casos*/
                diferenciarCasos(nodo,padre);
                /*Si encontro el nodo, entonces se va a poder eliminar*/
                exito=true;
            }else{
                /*Si no es el elemento buscado, lo busco en los hijos*/
                /*Guardo al padre*/
                padre=nodo;
                /*Recorre la rama correspondiente*/
                if(elem.compareTo(nodo.getElem())<0){
                    if(nodo.getIzquierdo()!=null)
                        /*Recorre hijo izquierdo*/
                        exito=eliminarAux(elem,nodo.getIzquierdo(),padre);
                }else{
                    if(nodo.getDerecho()!=null)
                        /*Recorre los hijos derecho*/
                        exito=eliminarAux(elem,nodo.getDerecho(),padre);
                    } 
                }
           }
        
        return exito;
    }
    
    private void diferenciarCasos(NodoABB nodo,NodoABB padre){
        /*Metodo que diferencia los casos eliminar segun la
        cantidad de hijos del nodo*/
        if(nodo.getIzquierdo()!=null && nodo.getDerecho()!=null){
            /*LLamo al caso 3*/
            caso3(nodo.getDerecho(),nodo,nodo);
        }else if(nodo.getIzquierdo()!=null || nodo.getDerecho()!=null){
            /*Llamo al caso 2*/
            caso2(nodo,padre);
        }else{
            /*Llamo al caso 1*/
            caso1(nodo,padre);
        }
    }
    
    private void caso1(NodoABB nodo,NodoABB padre){
        /*Si no tiene hijos*/
        if(padre==null)
            /*Si el nodo es la raiz sin hijos*/
            this.raiz=null;
        else{
            /*Reconoce al hijo que tiene que setear a null
            y lo setea*/
            if(padre.getIzquierdo().equals(nodo))
                padre.setIzquierdo(null);
            else
                padre.setDerecho(null);
        }
        
    }
    
    private void caso2(NodoABB nodo,NodoABB padre){
        boolean ladoIzq=false;
        /*Si tiene un hijo*/
        if(padre==null){
            /*Si el nodo es la raiz, la nueva raiz
            es el hijo del nodo*/
            if(nodo.getIzquierdo()!=null)
                this.raiz=nodo.getIzquierdo();
            else
                this.raiz=nodo.getDerecho();
        }else{
            /*Reconoce el lado del padre que tiene que setear*/
            if(padre.getIzquierdo()!=null)
                ladoIzq=true;
            /*Reconoce donde esta el nieto del padre*/
            if(nodo.getIzquierdo()!=null){
                /*El nieto esta del lado izquierdo del nodo*/
                if(ladoIzq)
                    /*Setea el lado izquierdo del padre con 
                    el nieto*/
                    padre.setIzquierdo(nodo.getIzquierdo());
                else
                    /*Setea el lado derecho del padre con 
                    el nieto*/
                    padre.setDerecho(nodo.getIzquierdo());
            }else{
                /*El nieto esta del lado derecho del nodo*/
                if(ladoIzq)
                    /*Setea el lado izquierdo del padre con 
                    el nieto*/
                    padre.setIzquierdo(nodo.getDerecho());
                else
                    /*Setea el lado derecho del padre con 
                    el nieto*/
                    padre.setDerecho(nodo.getDerecho());
            }
        }
    }
    
    private NodoABB caso3(NodoABB nodo,NodoABB padre,NodoABB elim){
        /*Busco el candidato del nodo a elimnar*/
        /*Candidato: hijo menor del subarbol derecho*/
        NodoABB candi;
        if (nodo.getIzquierdo() != null){
            /*Recorre hasta el ultimo hijo izquierdo*/
            /*Guardo padre*/
            padre=nodo;
            candi=caso3(nodo.getIzquierdo(),padre,elim);
        } else{
            /*Inserta el ultimo hijo izquierdo*/
            candi = nodo;
            if(padre!=elim){
                if(candi.getDerecho()!=null){
                    /*Seteo el hijo del padre del candidato con el nieto
                    si es distinto de nulo*/
                    padre.setIzquierdo(candi.getDerecho());
                }else{
                    /*Si el candidato no tiene hijo derecho, al padre
                    el hijo izquierdo se lo setea a null*/
                    padre.setIzquierdo(null);
                }
            }else
                padre.setDerecho(null);
        }
        /*Seteo el nodo a eliminar por el candidato*/
        elim.setElem(candi.getElem());
        
      return candi;  
    }
    
    
    
    public Lista listar(){
        Lista list=new Lista();
        listarAux(list,this.raiz);
        return list;
    }
    
    private void listarAux(Lista list,NodoABB nodo){
        /*Metodo que devuelve una lista de todos los elementos
        del ABB en un recorrido Inorden*/
        if(nodo!=null){
            /*Recorre hasta al ultimo hijo izquierdo*/
            listarAux(list,nodo.getIzquierdo());
            /*Agrega el elemento en la lista*/
            list.insertar(nodo.getElem(), list.longitud()+1);
            /*Recorre a hasta el ultimo hijo derecho*/
            listarAux(list,nodo.getDerecho());
        }
    }
    
    public Lista listarRango(Comparable elemMinimo,Comparable elemMaximo){
        Lista list=new Lista();
        if(elemMinimo.compareTo(elemMaximo)<=0){
            listarRangoAux(elemMinimo,elemMaximo,this.raiz,list);
        }
        return list;
    }
    
    private void listarRangoAux(Comparable elemMinimo, Comparable elemMaximo, NodoABB nodo, Lista list) {
        if (nodo != null) {
            /*Recorro el arbol en inOrden para buscar los mayores o iguales a elemMinimo
                Y menores o iguales a elemMaximo*/
            if (elemMinimo.compareTo(nodo.getElem()) < 0 && nodo.getIzquierdo() != null) {
                listarRangoAux(elemMinimo, elemMaximo, nodo.getIzquierdo(), list);
            }
            /*Pregunto si el elemento del nodo es mayor o igual a elemMinimo
                    Y si el elemento es menor o igual a elemMaximo*/
            if (elemMinimo.compareTo(nodo.getElem()) <= 0 && elemMaximo.compareTo(nodo.getElem()) >= 0) {
                /*Si se cumple entonces lo inserto en la lista*/
                list.insertar(nodo.getElem(), list.longitud() + 1);
            }
            if (elemMaximo.compareTo(nodo.getElem()) > 0 && nodo.getDerecho() != null) {
                listarRangoAux(elemMinimo, elemMaximo, nodo.getDerecho(), list);
            }

        }
    } 
    
    public Comparable minimoElem(){
        /*Devuelve el minimo elemento del arbol*/
        NodoABB aux;
        Comparable elem=null;
        if(this.raiz!=null){
            aux=minimoElemAux(this.raiz);
            elem=aux.getElem();
        }
        return elem;
    }
    
    private NodoABB minimoElemAux(NodoABB nodo){
        NodoABB aux;
        if(nodo.getIzquierdo()!=null)
            /*Recorre hasta el ultimo hijo izquierdo*/
            aux=minimoElemAux(nodo.getIzquierdo());
        else
            /*Inserta el ultimo hijo izquierdo*/
            aux=nodo;
        return aux;
    }
    
    public boolean eliminarMinimo(){
        boolean exito;
        if(this.raiz==null)
            exito=false;
        else{
            eliminarMinimoAux(this.raiz,null);
            exito=true;
        }
        return exito;
    }
    
    private void eliminarMinimoAux(NodoABB nodo,NodoABB padre){
        /*Recorro el arbol hasta el ultimo hijo izquierdo*/
        if(nodo.getIzquierdo()!=null){
            /*Guardo el padre*/
            padre=nodo;
            eliminarMinimoAux(nodo.getIzquierdo(),padre);
        }else{
            if(padre!=null){
                if(nodo.getDerecho()==null)
                    /*Si el padre no tiene nieto, seteo su hijo a null*/
                    padre.setIzquierdo(null);
                else
                    /*Si el padre tiene nieto, seteo a su hijo por su nieto*/
                    padre.setIzquierdo(nodo.getDerecho());
            }else{
                if(nodo.getDerecho()!=null)
                    /*Si el nodo es la raiz y tiene un hijo mas grande,
                    el hijo es la nueva raiz*/
                    this.raiz=nodo.getDerecho();
                else
                    /*Si el nodo es la raiz, la seteo en null*/
                    this.raiz=null;
            }                
        }
    }
    
    public Comparable maximoElem(){
        /*Devuelve el maximo elemento del arbol*/
        NodoABB aux;
        Comparable elem=null;
        if(this.raiz!=null){
            aux=maximoElemAux(this.raiz);
            elem=aux.getElem();
        }
        return elem;
    }
    
    private NodoABB maximoElemAux(NodoABB nodo){
        NodoABB aux;
        if(nodo.getDerecho()!=null)
            /*Recorre hasta el ultimo hijo derecho del arbol*/
            aux=maximoElemAux(nodo.getDerecho());
        else
            /*Inserta el ultimo hijo derecho*/
            aux=nodo;
            
        return aux;
    }
    
    public boolean eliminarMaximo(){
        boolean exito;
        if(this.raiz==null)
            exito=false;
        else{
            eliminarMaximoAux(this.raiz,null);
            exito=true;
        }
        return exito;
    }
    
    private void eliminarMaximoAux(NodoABB nodo,NodoABB padre){
        /*Recorro el arbol hasta el ultimo hijo derecho*/
        if(nodo.getDerecho()!=null){
            /*Guardo el padre*/
            padre=nodo;
            eliminarMaximoAux(nodo.getDerecho(),padre);
        }else{
            if(padre!=null){
                if(nodo.getIzquierdo()==null)
                    /*Si el padre no tiene nieto, seteo su hijo a null*/
                    padre.setDerecho(null);
                else
                    /*Si el padre tiene nieto, seteo a su hijo por su nieto*/
                    padre.setDerecho(nodo.getIzquierdo());
            }else{
                if(nodo.getIzquierdo()!=null)
                    /*Si el nodo es la raiz y tiene un hijo mas chico,
                    el hijo es la nueva raiz*/
                    this.raiz=nodo.getIzquierdo();
                else
                    /*Si el nodo es la raiz, la seteo en null*/
                    this.raiz=null;
            }                
        }
    }
    
    public void vaciar(){
        this.raiz=null;
    }
    
    public boolean esVacio(){
        boolean vacio=true;
        if(this.raiz!=null)
            vacio=false;
        return vacio;
    }
    
    public ABB clone(){
        ABB clon=new ABB();
        clon.raiz=cloneAux(this.raiz);
        return clon;
    }
    
    private NodoABB cloneAux(NodoABB nodo){
        /*Recorre los elementos de los hijos de la raiz*/
        NodoABB clon=null;
        if(nodo!=null){
            clon=new NodoABB(nodo.getElem(),cloneAux(nodo.getIzquierdo()),cloneAux(nodo.getDerecho()));
        }
        return clon;
    }
    
    
    public String toString(){
        String arbol="null";
        if(this.raiz!=null)
            arbol=toStringAux(this.raiz);
        return arbol;
    }
    
    private String toStringAux(NodoABB nodo){
        String arbol="";
        if(nodo!=null){
            NodoABB hijoI=nodo.getIzquierdo(),hijoD=nodo.getDerecho();
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
    
    public boolean verificarSimetria(Comparable elem){
        boolean veri=false;
        NodoABB subRaiz=this.raiz;
        while(subRaiz!=null && elem.compareTo(subRaiz.getElem())!=0){
            /*Recorro el arbol hasta encontrar la subraiz del subarbol que 
            queremos verificar*/
            if(elem.compareTo(subRaiz.getElem())<0 && subRaiz.getIzquierdo()!=null)
                /*Busco la subRaiz en el lado izquierdo*/
                subRaiz=subRaiz.getIzquierdo();
            else
                /*Busco la subRaiz en el lado derecho*/
                subRaiz=subRaiz.getDerecho();
        }
        if (subRaiz!=null && elem.compareTo(subRaiz.getElem()) == 0) {
            if (subRaiz.getIzquierdo() == null && subRaiz.getDerecho() == null)
                /*El subarbol ya esta balanceado porque no tiene hijos la subRaiz*/ {
                veri = true;
            } else {
                if (subRaiz.getIzquierdo() != null && subRaiz.getDerecho() != null) {
                    /*Pregunta si los hijos mantienen la simetria*/
                    veri = verificarSimetriaAux(subRaiz.getIzquierdo(), subRaiz.getDerecho());
                }
            }
        }
        return veri;
    }
    
    private boolean verificarSimetriaAux(NodoABB subRaizIzq,NodoABB subRaizDer){
        boolean veri=false;
        if((subRaizIzq.getIzquierdo()!=null && subRaizIzq.getDerecho()!=null)
            && (subRaizDer.getIzquierdo()!=null && subRaizDer.getDerecho()!=null)){
                veri=(verificarSimetriaAux(subRaizIzq.getIzquierdo(),subRaizIzq.getDerecho())) &&
                (verificarSimetriaAux(subRaizDer.getIzquierdo(),subRaizDer.getDerecho()));
        }else{
            if((subRaizIzq.getIzquierdo()!=null && subRaizIzq.getDerecho()==null)
                &&(subRaizDer.getIzquierdo()!=null&& subRaizDer.getDerecho()==null)){
                /*Verifico si el hijo izquierdo de ambos hijos tienen simetria*/
                veri=((verificarSimetriaAux(subRaizIzq.getIzquierdo(),null))
                        &&(verificarSimetriaAux(subRaizDer.getIzquierdo(),null)));
            }else{
                if((subRaizIzq.getIzquierdo()==null && subRaizIzq.getDerecho()!=null)
                    &&(subRaizDer.getIzquierdo()==null&& subRaizDer.getDerecho()!=null)){
                    /*Verifico si el hijo derecho de ambos hijos tienen simetria*/
                    veri=((verificarSimetriaAux(null,subRaizIzq.getDerecho()))
                        &&(verificarSimetriaAux(null,subRaizDer.getDerecho())));
                }else{
                    if((subRaizIzq.getIzquierdo()==null && subRaizIzq.getDerecho()==null)
                    &&(subRaizDer.getIzquierdo()==null&& subRaizDer.getDerecho()==null)){
                        /*Como no tiene hijos las subraices estan balanceadas*/
                        veri=true;
                    }
                }
            }
        }
        return veri;
    }
    
    public ABB clonarParteInvertido(Comparable elem){
        ABB clon=new ABB();
        NodoABB subRaiz=this.raiz;
        if(subRaiz!=null && elem.compareTo(subRaiz.getElem())!=0){
            /*Recorro el arbol hasta llegar al subArbol con raiz de elemento igual
            a elem*/
            if(elem.compareTo(subRaiz.getElem())<0)
                subRaiz=subRaiz.getIzquierdo();
            else
                subRaiz=subRaiz.getDerecho();
        }
        if(subRaiz!=null && elem.compareTo(subRaiz.getElem())==0){
            clon.raiz=clonarParteInvertidoAux(subRaiz);
        }
        return clon;
    }
    
    private NodoABB clonarParteInvertidoAux(NodoABB subRaiz){
        /*Hago un recorrido en PreOrden invertido y los inserto*/
        NodoABB aux=null;
        if(subRaiz!=null){
            aux=new NodoABB(subRaiz.getElem(),clonarParteInvertidoAux(subRaiz.getDerecho())
                    ,clonarParteInvertidoAux(subRaiz.getIzquierdo()));
        }
        return aux;
    }
       
    public Lista listarMayoresIguales(Comparable elem){
        Lista list=new Lista();
        listarMayoresIgualAux(list,this.raiz,elem);
        return list;
    }
    
    private void listarMayoresIgualAux(Lista list,NodoABB nodo,Comparable elem){
        if (nodo != null) {
            /*Recorro el arbol en inOrden para buscar los mayores o iguales a elemMinimo
                Y menores o iguales a elemMaximo*/
            if (elem.compareTo(nodo.getElem()) > 0 && nodo.getIzquierdo() != null) {
                listarMayoresIgualAux(list, nodo.getIzquierdo(), elem);
            }
            /*Pregunto si el elemento del nodo es mayor o igual a elemMinimo
                    Y si el elemento es menor o igual a elemMaximo*/
            if (elem.compareTo(nodo.getElem()) <= 0) {
                /*Si se cumple entonces lo inserto en la lista*/
                list.insertar(nodo.getElem(), 1);
            }
            listarMayoresIgualAux(list, nodo.getDerecho(), elem);

        } 
    }
    
    //EJERCICIO DE CUESTIONARIO, eliminar n veces el elemento minimo y crear un nuevo arbol
    
    /*public ABB eliminarMinimoNveces(){
        ABB nuevo=new ABB();
        while (this.raiz!=null){
            nuevo.insertar(elimMiniNvecesAux(this.raiz,null).getElem());
        }
        return nuevo;
    }

    private NodoABB elimMiniNvecesAux(NodoABB nodo, NodoABB padre) {
        /*Recorro el arbol hasta el ultimo hijo izquierdo
        NodoABB aux=null;
        if (nodo.getIzquierdo() != null) {
            /*Guardo el padre
            padre = nodo;
            aux=elimMiniNvecesAux(nodo.getIzquierdo(), padre);
        } else {
            aux=nodo;
            if (padre != null) {
                if (nodo.getDerecho() == null) /*Si el padre no tiene nieto, seteo su hijo a null {
                    padre.setIzquierdo(null);
                } else /*Si el padre tiene nieto, seteo a su hijo por su nieto {
                    padre.setIzquierdo(nodo.getDerecho());
                }
            } else {
                if (nodo.getDerecho() != null) /*Si el nodo es la raiz y tiene un hijo mas grande,
                    el hijo es la nueva raiz {
                    this.raiz = nodo.getDerecho();
                } else /*Si el nodo es la raiz, la seteo en null {
                    this.raiz = null;
                }
            }
        }
        return aux;
    }
    */
    
}
