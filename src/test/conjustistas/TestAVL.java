/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjustistas;
import Conjustistas.AVL;

/**
 *
 * @author repetto.francisco
 */
public class TestAVL {
   
    static String sOk = "OK!", sErr = "ERROR";
   
    public static void main(String[] args) {
        AVL tree=new AVL();
        System.out.println("#############ROTACION SIMPLE A IZQUIERDA#############");
        System.out.println("Ejemplo donde hay que hacer una ROTACION SIMPLE A IZQUIERDA cuando coloco 29\n");
        tree.insertar(8);
        tree.insertar(5);
        tree.insertar(15);
        tree.insertar(13);
        tree.insertar(20);
        System.out.println("Arbol antes de poner a 29\n"+tree.toString());
        tree.insertar(29);
        System.out.println("Arbol despues de poner a 29\n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();        
        System.out.println("#############ROTACION SIMPLE A DERECHA#############");
        System.out.println("Ejemplo donde hay que hacer una ROTACION SIMPLE A DERECHA cuando coloco 4");
        tree.insertar(10);
        tree.insertar(5);
        tree.insertar(15);
        tree.insertar(3);
        tree.insertar(7);
        System.out.println("Arbol antes de poner a 4\n"+tree.toString());
        tree.insertar(4);
        System.out.println("Arbol despues de poner a 4\n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("#############ROTACION DOBLE A DERECHA-IZQUIERDA#############");
        System.out.println("Ejemplo donde hay que hacer una ROTACION DOBLE DERECHA-IZQUIERDA cuando coloco 13");
        tree.insertar(10);
        tree.insertar(5);
        tree.insertar(15);
        tree.insertar(12);
        tree.insertar(17);
        System.out.println("Arbol antes de poner a 13\n"+tree.toString());
        tree.insertar(13);
        System.out.println("Arbol despues de poner a 13\n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("#############ROTACION DOBLE A IZQUIERDA-DERECHA#############");
        System.out.println("Ejemplo donde hay que hacer una ROTACION DOBLE IZQUIERDA-DERECHA cuando coloco 10");
        tree.insertar(12);
        tree.insertar(5);
        tree.insertar(23);
        tree.insertar(3);
        tree.insertar(8);
        System.out.println("Arbol antes de poner a 10\n"+tree.toString());
        tree.insertar(10);
        System.out.println("Arbol despues de poner a 10\n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("#############ELIMINACION CASO 1#############");
        System.out.println("Ejemplo donde hago una eliminacion CASO 1 donde el nodo es la raiz");
        tree.insertar(1);
        System.out.print("El arbol hasta ahora es: \n"+tree.toString());
        tree.eliminar(1);
        System.out.println("El arbol quedo: \n"+ tree.toString()+"\n");
        System.out.println("Ejemplo donde hago una eliminacion CASO 1 donde el nodo no es la raiz");
        tree.insertar(5);
        tree.insertar(4);
        tree.insertar(6);
        tree.insertar(8);
        System.out.println("El arbol hasta ahora antes de eliminar el 8 es: \n"+tree.toString());
        tree.eliminar(8);
        System.out.println("El arbol despues de eliminar el 8 quedo: \n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("#############ELIMINACION CASO 2#############");
        System.out.println("Ejemplo donde hago una eliminacion CASO 2 donde el nodo es la raiz");
        tree.insertar(1);
        tree.insertar(2);
        System.out.print("El arbol hasta ahora es: \n"+tree.toString());
        tree.eliminar(1);
        System.out.println("El arbol quedo: \n"+ tree.toString()+"\n");
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("Ejemplo donde hago una eliminacion CASO 2 donde el nodo no es la raiz");
        tree.insertar(5);
        tree.insertar(4);
        tree.insertar(6);
        tree.insertar(8);
        System.out.println("El arbol hasta ahora antes de eliminar el 6 es: \n"+tree.toString());
        tree.eliminar(6);
        System.out.println("El arbol despues de eliminar el 6 quedo: \n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("#############ELIMINACION CASO 3#############");
        System.out.println("Ejemplo donde hago una eliminacion CASO 3 donde el nodo es la raiz");
        tree.insertar(2);
        tree.insertar(1);
        tree.insertar(3);
        System.out.print("El arbol hasta ahora es: \n"+tree.toString());
        tree.eliminar(1);
        System.out.println("El arbol quedo: \n"+ tree.toString()+"\n");
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        System.out.println("Ejemplo donde hago una eliminacion CASO 3 donde el nodo no es la raiz");
        tree.insertar(10);
        tree.insertar(4);
        tree.insertar(15);
        tree.insertar(12);
        tree.insertar(16);
        System.out.println("El arbol hasta ahora antes de eliminar el 15 es: \n"+tree.toString());
        tree.eliminar(15);
        System.out.println("El arbol despues de eliminar el 15 quedo: \n"+tree.toString());
        System.out.println("-------Vacio el arbol------");
        tree.vaciar();
        //#######################ELIMINACION CASO 3 CON ROTACION AL ELIMINAR CANDIDATO#######################
        System.out.println("Ejemplo ELIMINACION CASO 3 CON ROTACION AL ELIMINAR CANDIDATO donde se elimina el 10 y eso genera que el candidato 12 genere una rotacion");
        tree.insertar(10);
        tree.insertar(5);
        tree.insertar(15);
        tree.insertar(4);
        tree.insertar(12);
        tree.insertar(16);
        tree.insertar(17);
        System.out.println("El arbol hasta ahora antes de elimianr el 10 es: \n"+tree.toString());
        System.out.println("Elimino el 10 ");
        tree.eliminar(10);
        System.out.println(tree.toString());
        
        String p = "02/12/02";
        System.out.println(p.length());
                
         System.out.println("$%$$PROBANDO LO DE MALE$%$%$%$");
         tree.vaciar();
        System.out.println("Checkeo si es vacio " + ((  tree.esVacio()) ? sOk : sErr));  
        System.out.println("Inserto el 10 en raiz " + ((  tree.insertar(10)) ? sOk : sErr));
        System.out.println("Inserto el 9 " + ((  tree.insertar(9)) ? sOk : sErr));
        System.out.println("Inserto el 7 " + ((  tree.insertar(7)) ? sOk : sErr));
        System.out.println("Inserto el 3 " + ((  tree.insertar(3)) ? sOk : sErr));
        System.out.println("Inserto el 15 " + ((  tree.insertar(15)) ? sOk : sErr));
        System.out.println("Inserto el 12 " + ((  tree.insertar(12)) ? sOk : sErr));
        System.out.println(tree.toString());
        System.out.println("Inserto el 20 " + ((  tree.insertar(20)) ? sOk : sErr));    
       System.out.println("Inserto elemento duplicado. Tiene que dar " + sErr+" --> "  + ((  tree.insertar(10)) ? sOk : sErr));
        System.out.println("Checkeo si es vacio. Tiene que dar " + sErr+" --> "  +((  tree.esVacio()) ? sOk : sErr));  ;
        System.out.println(tree.toString());
        
       
        /* Preguntar a gabi porque los string toma como mayor a 8 que a 15, 
        tendria que hacer rotacion a izquierda aca*/
        /*tree.insertar("8");
        tree.insertar("5");
        tree.insertar("15");
        tree.insertar("13");
        tree.insertar("20");
        tree.insertar("29");*/

        
        
    }
}
