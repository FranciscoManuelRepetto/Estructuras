/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.grafos;

/**
 *
 * @author repetto.francisco
 */
import Grafos.GrafoEtiquetado;
import Liniales.dinamica.Lista;

public class TestGrafo {

    public static void main(String[] args) {
        GrafoEtiquetado grafo = new GrafoEtiquetado();
        /*grafo.insertarVertice("NQN");
        grafo.insertarVertice("ASD");
        grafo.insertarVertice("GFA");
        grafo.insertarVertice("FAW");
        grafo.insertarVertice("GAS");
        grafo.insertarVertice("FAS");
        System.out.println(grafo.insertarArco("NQN", "F", 2));
        System.out.println(grafo.insertarArco("NQN", "ASD", 6));
        System.out.println(grafo.insertarArco("NQN", "FAS", 2));
        System.out.println(grafo.insertarArco("FAS", "GFA", 2));
        System.out.println(grafo.insertarArco("GFA", "FAW", 2));
        System.out.println(grafo.insertarArco("FAW", "ASD", 1));
        System.out.println(grafo.toString());
        System.out.println("Pruebo camino mas corto por etiquetas");
        Lista list = grafo.caminoMasCortoEtiquetas("NQN", "ASD");
        System.out.println(list.toString());*/
        grafo.insertarVertice("E");
        grafo.insertarVertice("G");
        grafo.insertarVertice("D");
        grafo.insertarVertice("F");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("H");
        grafo.insertarVertice("A");
        grafo.insertarArco("G", "E", 0);
        grafo.insertarArco("D", "E", 0);
        grafo.insertarArco("G", "D", 0);
        grafo.insertarArco("B", "D", 0);
        grafo.insertarArco("A", "C", 0);
        grafo.insertarArco("C", "F", 0);
        grafo.insertarArco("H", "C", 0);
        System.out.println(grafo.toString());
        Lista list = grafo.listarEnAnchura("B");
        System.out.println("Lista por anchura : "+list.toString());
        
        
    }
}
