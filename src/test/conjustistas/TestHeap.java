/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjustistas;

import Conjustistas.Heap;

/**
 *
 * @author repetto.francisco
 */
public class TestHeap {
        public static void main(String[] args) {
        Heap tree=new Heap();
        tree.insertar(8);
        tree.insertar(1);
        tree.insertar(14);
        tree.insertar(10);
        tree.insertar(2);
        tree.insertar(3);
        tree.insertar(16);
        tree.insertar(4);
        tree.insertar(5);
        tree.insertar(17);
        tree.insertar(6);
        tree.insertar(12);
        tree.insertar(7);
        tree.insertar(9);
        tree.insertar(11);
        tree.insertar(13);
        tree.insertar(15);

        Heap clon=tree.clone();
            System.out.println(clon.toString());
    }
}
