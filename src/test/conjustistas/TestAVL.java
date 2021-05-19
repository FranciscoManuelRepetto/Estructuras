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
    public static void main(String[] args) {
        AVL tree=new AVL();
        tree.insertar(26);
        tree.insertar(13);  
        tree.insertar(27);
        tree.insertar(7);
        tree.insertar(16);
        System.out.println(tree.toString());
        tree.eliminar(26);
        System.out.println(tree.toString());
        
        
    }
}
