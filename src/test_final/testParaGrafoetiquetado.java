/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_final;

import Grafos.GrafoEtiquetado;

/**
 *
 * @author repetto.francisco
 */
public class testParaGrafoetiquetado {
    
    public static void main(String[] args) {
        GrafoEtiquetado grafo = new GrafoEtiquetado();
        grafo.insertarVertice("E");
        grafo.insertarVertice("G");
        grafo.insertarVertice("D");
        grafo.insertarVertice("F");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("H");
        grafo.insertarVertice("P");
        grafo.insertarArco("G", "E", 1);
        grafo.insertarArco("D", "E", 2);
        grafo.insertarArco("G", "D", 3);
        grafo.insertarArco("B", "F", 4);
        grafo.insertarArco("P", "C", 5);
        grafo.insertarArco("C", "F", 6);
        grafo.insertarArco("H", "C", 7);
        grafo.insertarArco("G", "B", 7);
        grafo.insertarArco("P", "D", 7);
        grafo.insertarArco("F", "P", 52);
        System.out.println(grafo.toString());
        System.out.println("La lista me quedo: "+(grafo.primerCaminoMenorPesoLong("G","F",10,2)).toString());
    }
    
}
