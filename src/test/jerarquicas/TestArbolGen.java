/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

/**
 *
 * @author repetto.francisco
 */
import Jerarquicas.ArbolGen;
import Utiles.TecladoIn;
import Liniales.dinamica.Lista;
public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGen tree=new ArbolGen();
        tree=arbolHecho();
        Opciones(tree);
    }
    
    public static void Opciones(ArbolGen tree){
        
        int eleccion;
        boolean salir=false;
        do{
            eleccion=menu();
            switch(eleccion){
                case 1:
                    Insertar(tree);
                    break;
                case 2:
                    esVacio(tree);
                    break;
                case 3:
                    Padre(tree);
                    break;
                case 4:
                    Altura(tree);
                    break;
                case 5:
                    System.out.println("Todavia no tiene");
                    break;
                case 6:
                    Ancestros(tree);
                    break;
                case 7:
                    System.out.println("Todavia no esta");
                    break;
                case 8:
                    tree.vaciar();
                    break;
                case 9:
                    tree.listarPreorden();
                    break;
                case 10:
                    tree.listarInorden();
                    break;
                case 11:
                    tree.listarPosorden();
                    break;
                case 12:
                    tree.listarPorniveles();
                    break;
                case 13:
                    System.out.println(tree.toString());
                    break;
            }
        }while(!salir);
    }
    
    public static int menu(){
        int eleccion;
        System.out.println("1)Insertar");
        System.out.println("2)EsVacio");
        System.out.println("3)Padre");
        System.out.println("4)Altura");
        System.out.println("5)Nivel");
        System.out.println("6)Ancestros");
        System.out.println("7)Clone");
        System.out.println("8)Vaciar");
        System.out.println("9)Listar Preorden");
        System.out.println("10)Listar Inorden");
        System.out.println("11)Listar Posorden");
        System.out.println("12)ToString");
        eleccion=TecladoIn.readInt();
        return eleccion;
    }
    
    public static void Insertar(ArbolGen tree){
        Object elem,padre;
        System.out.println("Ingrese objeto a poner en el arbol");
        elem=TecladoIn.read();
        System.out.println("Ingrese el elemento padre");
        padre=TecladoIn.read();
        tree.insertar(elem, padre);
    }
    
    public static void esVacio(ArbolGen tree){
        boolean es=tree.esVacio();
        if(!es)
            System.out.println("El arbol no esta vacio");
        else
            System.out.println("El arbol esta vacio");
    }
    
    public static void Padre(ArbolGen tree){
        Object elem,padre;
        System.out.println("¿De que elemento va a querer buscar su padre?");
        elem=TecladoIn.read();
        padre=tree.padre(elem);
        if(padre!=null)
            System.out.println("Padre: "+padre);
        else
            System.out.println("El elemento no tiene padre");
    }
    
    public static void Altura(ArbolGen tree){
        int altura;
        altura=tree.altura();
        System.out.println("La altura del arbol es: "+altura);
    }
    
    public static void Ancestros(ArbolGen tree){
        Lista list=new Lista();
        Object elem;
        System.out.println("Ingrese elemento para buscar su camino desde la raiz");
        list=tree.ancestros(list);
        System.out.println("El camino desde la raiz es: ");
        list.toString();
    }
    
    public static ArbolGen arbolHecho(){
        ArbolGen tree=new ArbolGen();
        tree.insertar(1,null);
        tree.insertar(2,1);
        tree.insertar(3,1);
        tree.insertar(4,1);
        tree.insertar(5,2);
        tree.insertar(6,2);
        tree.insertar(7,6);
        tree.insertar(8,6);
        tree.insertar(9,6);
        tree.insertar(10,4);
        tree.insertar(11,4);
        tree.insertar(12,4);
        tree.insertar(13,10);
        tree.insertar(14,13);
        tree.insertar(15,13);
        tree.insertar(16,12);
        tree.insertar(17,12);
        return tree;
    }
   
}
