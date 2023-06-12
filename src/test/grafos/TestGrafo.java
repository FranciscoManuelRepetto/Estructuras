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
        System.out.println("Toy buscando camino mas corto de F hasta P");
        System.out.println(grafo.caminoMasCorto("F", "P").toString());
        System.out.println("Camino mas corto por etiquetas: "+grafo.caminoMasCortoEtiquetas("F","P").toString());
        System.out.println("Camino mas corto pasando por un nodo: "+grafo.caminoTresVertices("F", "P", "C").toString());
        
        
    }
}
