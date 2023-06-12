/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import Liniales.dinamica.Pila;
import Liniales.dinamica.Lista;

/**
 *
 * @author repetto.francisco
 */
public class ProbarMale {
    public static void main(String[] args) {
        System.out.println("\n\n\nBOrarr esto");
        Lista list=new Lista();
        list.vaciar();
        list.insertar(0,1);
        list.insertar(1,2);
        list.insertar(2,3);
        list.insertar(3,4);
        list.insertar(4,5);
        list.insertar(5,6);
        list.insertar(6,7);
        list.insertar(7,8);
        list.insertar(8,9);
        list.insertar(9,10);
        System.out.println(list.toString());
        System.out.println("Pruebo metodo panchuli nacho");
        //Pila auxPila=list.franiNacho();
        //System.out.println(auxPila.toString());
    }
}
