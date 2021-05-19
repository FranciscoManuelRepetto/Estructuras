/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjustistas;

import Conjustistas.ABB;

/**
 *
 * @author repetto.francisco
 */
public class TestABB {

    public static void main(String[] args) {
        ABB tree = new ABB();
        tree.insertar(7);
        tree.insertar(8);
        tree.insertar(6);
        tree.eliminar(7);
        System.out.println(tree.toString());
        /*tree.insertar(2);
        tree.insertar(8);
        tree.insertar(1);
        tree.insertar(4);
        tree.insertar(3);
        tree.insertar(6);
        tree.insertar(9);
        tree.insertar(7);
        System.out.println(tree.toString());*/

    }
}
