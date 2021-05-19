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
import Jerarquicas.ArbolBin;
import Liniales.dinamica.Lista;

public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin tree = new ArbolBin();
        tree.insertar(1, null, 'I');
        tree.insertar(2, 1, 'I');
        tree.insertar(3, 1, 'D');
        tree.insertar(4, 2, 'I');
        tree.insertar(5, 2, 'D');
        tree.insertar(6,3,'D');
        tree.insertar(8, 6, 'I');
        tree.insertar(9,6, 'D');
        System.out.println(tree.toString());
    }
}
