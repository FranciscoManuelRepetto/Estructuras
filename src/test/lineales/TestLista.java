/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

/**
 *
 * @author repetto.francisco
 */
import Liniales.dinamica.Lista;
public class TestLista {
    public static void main(String[] args) {
        Lista list=new Lista();
        System.out.println("Inserto 1 "+list.insertar(1, 1));
        System.out.println("Inserto 2 "+list.insertar(2, 2));
        System.out.println("Inserto 3 "+list.insertar(3, 3));
        System.out.println("Inserto 4 "+list.insertar(4, 4));
        System.out.println("Inserto 5 "+list.insertar(5, 5));
        System.out.println("Inserto 6 "+list.insertar(6, 6));
        System.out.println("Inserto 7 "+list.insertar(7, 7));
        System.out.println("La lista: "+"\t"+list.toString());
        System.out.println("Inserto elemento 0 en posicion 2"+list.agregarElemento(0, 2));
        System.out.println("La lista: "+"\t"+list.toString());
    }
}
