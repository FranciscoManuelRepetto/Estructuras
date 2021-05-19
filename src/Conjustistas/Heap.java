/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjustistas;

/**
 *
 * @author repetto.francisco
 */
public class Heap {
    
    //Atributos//
    private int tamanio;
    private Comparable[] heap;
    private int ultimo;
    
    //Constructores//
    public Heap(){
        tamanio=20;
        heap=new Comparable[tamanio];
        ultimo=0;
    }
    
    //Operaciones basicas//
    
    public boolean insertar(Comparable elem){
        boolean exito=true;
        if(this.heap==null){
            /*Si heap esta vacio, se coloca en la raiz*/
            this.heap[this.ultimo+1]=elem;
            ultimo++;
        }else{
            /*Verifica que haya espacio en el heap*/
            if(this.ultimo < this.tamanio){
                /*Inserta el elemento como ultimo hijo del arbol*/
                this.heap[ultimo+1]=elem;
                ultimo++;
                int padre=ultimo/2;
                /*Ubica al elemento en la posicion*/
                hacerSubir(padre);
            }else{
                exito=false;
            }    
        }
        return exito;
    }
    
    private void hacerSubir(int padre){
        int hijo=this.ultimo;
        Comparable aux=this.heap[padre];
        boolean terminar=false;
        while(!terminar){
            /*Pregunta si no es un numero negativo y si el elemento
            colocado a lo ultimo del arbol es menor que su padre*/
            if(padre >=1 && this.heap[hijo].compareTo(this.heap[padre])<0){
                
                /*El elemento es menor a su padre y si el padre no es posicion 0, los intercambia*/
                this.heap[padre]=this.heap[hijo];
                this.heap[hijo]=aux;
                
                /*La nueva pos del elemento nuevo es la del padre*/ 
                hijo=padre;
                
                /*Guarda la pos y elemento del padre nuevo del elemento nuevo*/
                padre=padre/2;
                aux=this.heap[padre];
                
            }else{
                /*Si el elemento no es menor a su padre, termina
                el hacer subir*/
                terminar=true;
            }
        }
    }
    
    public Object recuperarCima(){
        Object cima=null;
        if(this.ultimo!=0){
            cima=(Object)this.heap[1];
        }else
            System.out.println("Heap vacio");
        return cima;
    }

    
    public boolean eliminarCima(){
        boolean exito;
        if(this.ultimo==0){
            /*Estructura vacia*/
            exito=false;
        }else{
            /*Saca la raiz y pone la ultima hoja en su lugar*/
            this.heap[1]=this.heap[ultimo];
            this.ultimo--;
            /*Restablece la propiedad del heap minimo*/
            hacerBajar(1);
            exito=true;
        }
        return exito;
    }
    
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp=this.heap[posPadre];
        boolean salir=false;
        
        while(!salir){
            posH= posPadre*2;
            if(posH <= this.ultimo){
                /*La nueva raiz tiene al menos un hijo (izq) y lo considera menor*/
                if(posH < this.ultimo){
                    /*HijoMenor tiene hermano derecho */
                    if(this.heap[posH + 1].compareTo(this.heap[posH]) < 0){
                        /*Preguna si hijo derecho es el menor de los dos*/
                        posH++;
                    }
                }
                /*Compara al hijo menor con el padre*/
                if(this.heap[posH].compareTo(temp)< 0){
                    /*El hijo es menor que el padre, los intercambia*/
                    this.heap[posPadre]=this.heap[posH];
                    this.heap[posH]=temp;
                    /*Guarda la nueva posicion del hijo*/
                    posPadre=posH;
                }else{
                    /*El padre es menor que sus hijos, esta bien ubicado*/
                    salir=true;
                }
            }else{
            /*El temp es hoja, esta bien ubicado*/
            salir=true;
            }
        }
    }
    
    public boolean esVacio(){
        /*Verifca si heap esta vacio o no*/
        boolean vacio=true;
        if(this.ultimo!=0)
            vacio=false;
        return vacio;
    }
    
    public Heap clone(){
        Heap clon=new Heap();
        if(this.heap!=null){
            Comparable aux;
            for (int i = 1; i <= this.ultimo; i++) {
                aux=this.heap[i];
                clon.heap[clon.ultimo+1]=aux;
                clon.ultimo++;
            }
        }
        return clon;
    }
    
    public String toString(){
        String arbolHeap="";
        for (int i = 1; i <= ultimo; i++) {
            arbolHeap+="Nodo "+ this.heap[i]+":";
            int aux=i*2;
            if(aux<=ultimo){
                arbolHeap+=" "+this.heap[i*2];
            }
            aux++;
            if(aux<=ultimo){
                arbolHeap+=" "+this.heap[i*2+1];
            }
            arbolHeap+="\n"; 
        }
        return arbolHeap;
    }
    
    public String recorrerArray(){
        String array="[";
        for (int i = 1; i <= this.ultimo; i++) {
            array+=this.heap[i]+",";
        }
        array+="]";
        return array;
    }

}


