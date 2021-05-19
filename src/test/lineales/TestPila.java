/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import Liniales.dinamica.Pila;
import static test.lineales.TestingPila.sOk;

/**
 *
 * @author repetto.francisco
 */
public class TestPila {
    public static void main(String[] args) {
        Pila p1 = new Pila();
        System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());
        System.out.println("Apila 1:\t\t\t\t\t\t" + ((p1.apilar(1))));
        System.out.print("Apila 2:\t\t\t\t\t\t" + ((p1.apilar(2))));
        System.out.println("\t--> " + p1.toString());
        System.out.println("Apila 3:\t\t\t\t\t\t" + ((p1.apilar(3))));
        System.out.println("Apila 4:\t\t\t\t\t\t" + ((p1.apilar(4))));
        System.out.println("Apila 5:\t\t\t\t\t\t" + ((p1.apilar(5))));
        System.out.println("Apila 6:\t\t\t\t\t\t" + ((p1.apilar(6))));
        System.out.println("Apila 7:\t\t\t\t\t\t" + ((p1.apilar(7))));
        System.out.println("Apila 8:\t\t\t\t\t\t" + ((p1.apilar(8))));
        System.out.println("Apila 9:\t\t\t\t\t\t" + ((p1.apilar(9))));
        System.out.println("Muestro la pila: "+"\t\t\t\t\t"+p1.toString());
        System.out.println("Creo clon: ");
        Pila clon=p1.clone();
        System.out.println("Clon creado: "+"\t\t\t\t\t"+clon.toString());
        clon.desapilar();
        System.out.println("Elimino tope: "+"\t\t\t\t\t"+clon.toString());
    }
}
