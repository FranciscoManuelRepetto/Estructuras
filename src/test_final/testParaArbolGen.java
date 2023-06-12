/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_final;

import Jerarquicas.ArbolGen;
import Liniales.dinamica.Lista;

/**
 *
 * @author repetto.francisco
 */
public class testParaArbolGen {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        arbol.insertar(1, null);
        arbol.insertar(2,1);
        arbol.insertar(3,1);
        arbol.insertar(4,1);
        arbol.insertar(5,4);
        arbol.insertar(6,5);
        arbol.insertar(7,4);
        arbol.insertar(8,2);
     /*   System.out.println("El arbol quedo: \n"+arbol.toString());
        System.out.println("Camino mas largo desde raiz a hoja: "+arbol.listaQueJustificaLaAltura().toString());
        System.out.println("PRUEBO descendienteMasCercano:");
        arbol.insertar(8,6);
        System.out.println("Nivel del descendiente mas cercano: "+arbol.descendienteMasCercano(8));
        Lista list = new Lista();
        System.out.println(list.toString());
*/
    }
}
