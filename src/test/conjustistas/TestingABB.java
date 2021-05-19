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
public class TestingABB {

    public static void main(String[] args) {
        ABB tree = new ABB();
        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");
        System.out.println("Pruebo metodo esVacio(),deberia dar true:   " + tree.esVacio());
        System.out.println("Inserto 15 en el arbol \t Deberia dar true:  " + tree.insertar(15));
        System.out.println("Inserto 9 en el arbol  \t Deberia dar true:  " + tree.insertar(9));
        System.out.println("Inserto 50 en el arbol \t Deberia dar true:  " + tree.insertar(50));
        System.out.println("Inserto 12 en el arbol \t Deberia dar true:  " + tree.insertar(12));
        System.out.println("Inserto 4 en el arbol  \t Deberia dar true:  " + tree.insertar(4));
        System.out.println("Inserto 24 en el arbol \t Deberia dar true:  " + tree.insertar(24));
        System.out.println("Inserto 57 en el arbol \t Deberia dar true:  " + tree.insertar(57));
        System.out.println("Inserto 3 en el arbol  \t Deberia dar true:  " + tree.insertar(3));
        System.out.println("Inserto 7 en el arbol  \t Deberia dar true:  " + tree.insertar(7));
        System.out.println("Inserto 17 en el arbol \t Deberia dar true:  " + tree.insertar(27));
        System.out.println("Inserto 53 en el arbol \t Deberia dar true:  " + tree.insertar(53));
        System.out.println("Inserto 67 en el arbol \t Deberia dar true:  " + tree.insertar(67));
        System.out.println("Inserto 24 en el arbol \t Deberia dar false: " + tree.insertar(24));
        System.out.println("Pruebo metodo esVacio(),deberia dar false:  " + tree.esVacio());
        System.out.println("\n El arbol quedo:");
        System.out.println(tree.toString());

        System.out.println("********************************");
        System.out.println("*      Eliminar: tres casos        *");
        System.out.println("********************************");
        //FALTAN PROBAR CASOS ESPECIALES
        ABB aux = new ABB();
        System.out.println("Pruebo eliminar en Arbol vacio \n Deberia dar false: " + aux.eliminar(1));
        System.out.println("Pruebo eliminar elemento que no existe \n Deberia dar false: " + tree.eliminar(88));
        System.out.println("Pruebo eliminar con un arbol clon");
        aux = tree.clone();
        System.out.println("\n" + "CASO 1:");
        System.out.println("Pruebo eliminar el nodo 7: " + aux.eliminar(7));
        System.out.println("Quedo asi el arbol");
        System.out.println(aux.toString());

        System.out.println("Pruebo eliminar el 24: " + aux.eliminar(24));
        System.out.println("Quedo asi el arbol");
        System.out.println(aux.toString());

        System.out.println("\n" + "CASO 3");
        System.out.println("Pruebo eliminar el 15: " + aux.eliminar(15));
        System.out.println("Quedo asi el arbol");
        System.out.println(aux.toString());
        System.out.println("Arbol original: \n" + tree.toString());
        System.out.println("Vacio arbol clon ");
        aux.vaciar();
        System.out.println("Verifico que el arbol clon este vacio: \n Deberia dar true: " + aux.esVacio());
        System.out.println("Verifico que el arbol original no esta vacio: \n Deberia dar false: " + tree.esVacio() + "\n");

        System.out.println("********************************************");
        System.out.println("*      Listar: listar - listarRango        *");
        System.out.println("********************************************");
        System.out.println("LISTAR");
        System.out.println("Pruebo listar: \n Deberia dar [3,4,7,9,12,15,24,27,50,57,53,67] \t\t\t " + tree.listar().toString());
        System.out.println("LISTAR POSORDEN");
        System.out.println("Pruebo listar: \n Deberia dar [3,4,7,9,12,15,24,27,50,57,53,67] \t\t\t " + tree.listar().toString());
        
        System.out.println("Pruebo con una arbol vacio: \n Deberia dar null \t\t\t\t\t\t " + aux.listar().toString());

        System.out.println("\nLISTAR RANGO");
        System.out.println("Pruebo listarRango entre 7 y 50: \n Deberia dar: [7,9,12,15,24,27,50]  \t\t\t\t " + tree.listarRango(7, 50).toString());
        System.out.println("Pruebo listarRango con elemento minimo mayor a elemento mayor: \n "
                + "Deberia dar: null \t\t\t\t\t\t " + tree.listarRango(50, 7).toString());
        System.out.println("Pruebo entre intervalos (80,100) que no existen: \n"
                + "Deberia dar: null \t\t\t\t\t\t " + tree.listarRango(80, 100));
        System.out.println("Pruebo con una arbol vacio: \n Deberia dar null \t\t\t\t\t\t " + aux.listarRango(4, 50));
        System.out.println("Pruebo listarRango con elementos 6 y 51:\n No estan en el arbol pero deberia dar: [7,9,12,15,24,27,50]\t" + tree.listarRango(6, 51));
        System.out.println("Pruebo listarRango con elementos 6 y 6: \n Deberia dar: null \t\t\t\t\t\t " + tree.listarRango(6, 6));
        System.out.println("Pruebo listarRango con 12 y 12: \n Deberia dar: [12] \t\t\t\t\t\t" + tree.listarRango(12, 12));
        System.out.println("Agrego 54 como hijo derecho de 53 "+tree.insertar(54));
        System.out.println("Pruebo listarRango entre 12 a 54: \nDeberia dar: [12,27,50,53,54]  \t\t\t\t\t"+tree.listarRango(12, 54));
        System.out.println("Pruebo listraRango entre 54 y 67: \nDeberia dar: [54,57,67] \t\t\t\t\t"+tree.listarRango(54,67));

        System.out.println("\n********************************");
        System.out.println("*       Minimo - Maximo        *");
        System.out.println("********************************");
        System.out.println("---------");
        System.out.println("MINIMO");
        System.out.println("---------");
        System.out.println("Pruebo minimo: \n Deberia dar: 3  \t\t\t\t\t\t " + tree.minimoElem());
        System.out.println("Pruebo metodo eliminarMinimo: \n Deberia dar: true \t\t\t\t\t\t" + tree.eliminarMinimo());
        System.out.println("Verifico que se elimino el elemento minimo en el arbol (3) \n" + tree.toString());
        System.out.println("Pruebo eliminar el elemento minimo pero con hijo derecho");
        System.out.println("Deberia dar: true  \t\t\t\t\t\t" + tree.eliminarMinimo());
        System.out.println("Verifico que se elimino el elemento maximo en el arbol (4) \nDeberia estar 7 en el arbol: \n" + tree.toString());
        System.out.println("Pruebo metodo con arbol vacio \n Deberia dar: false \t\t\t\t\t\t" + aux.eliminarMinimo());
        aux.insertar(1);
        System.out.println("Pruebo con un arbol de un elemento \n Deberia dar: true \t\t\t\t\t\t" + aux.eliminarMinimo());

        System.out.println("\n---------");
        System.out.println("MAXIMO");
        System.out.println("---------");
        System.out.println("Pruebo maximo: \n Deberia dar: 67 \t\t\t\t\t\t" + tree.maximoElem());
        System.out.println("Pruebo con arbol vacio: \n Deberia dar: null \t\t\t\t\t\t" + aux.maximoElem());
        System.out.println("Pruebo metodo eliminarMaximo: \n Deberia dar: true \t\t\t\t\t\t" + tree.eliminarMaximo());
        System.out.println("Verifico que se elimino el elemento maximo en el arbol (67) \n" + tree.toString());
        System.out.println("Pruebo eliminar el elemento maximo pero con hijo izquierdo");
        System.out.println("Deberia dar: true  \t\t\t\t\t\t" + tree.eliminarMaximo());
        System.out.println("Verifico que se elimino el elemento maximo en el arbol (57) \nDeberia estar 53 en el arbol: \n" + tree.toString());
        System.out.println("Pruebo metodo con arbol vacio \n Deberia dar: false \t\t\t\t\t\t" + aux.eliminarMaximo());
        aux.insertar(1);
        System.out.println("Pruebo con un arbol de un elemento \n Deberia dar: true \t\t\t\t\t\t" + aux.eliminarMaximo());
        
    }
    
}
