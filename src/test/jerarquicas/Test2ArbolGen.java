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
import Liniales.dinamica.Lista;
public class Test2ArbolGen {

        public static final String ROJO = "\u001B[31m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static void main(String[] args) {
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


        
        
        Object padre=tree.padre(12);
        System.out.println(ROJO+padre);
    }
}
