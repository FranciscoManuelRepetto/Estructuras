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
public class TestMaleABB {
    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] arg) {
        testABB();
    }

    public static void testABB() {
   System.out.println("COMIENZO TEST ABB");
        ABB a1 = new ABB();
        ABB a3 = new ABB();
        
        System.out.println("********************************");
        System.out.println("*     PRUEBA DE INSERCCION     *");
        System.out.println("********************************");
        System.out.println("Checkeo si es vacio " + ((  a1.esVacio()) ? sOk : sErr));  
        System.out.println("Inserto el 10 en raiz " + ((  a1.insertar(10)) ? sOk : sErr));
        System.out.println("Inserto el 9 " + ((  a1.insertar(9)) ? sOk : sErr));
        System.out.println("Inserto el 7 " + ((  a1.insertar(7)) ? sOk : sErr));
        System.out.println("Inserto el 3 " + ((  a1.insertar(3)) ? sOk : sErr));
        System.out.println("Inserto el 15 " + ((  a1.insertar(15)) ? sOk : sErr));
        System.out.println("Inserto el 12 " + ((  a1.insertar(12)) ? sOk : sErr));
        System.out.println("Inserto el 20 " + ((  a1.insertar(20)) ? sOk : sErr));    
        System.out.println("Inserto elemento duplicado. Tiene que dar " + sErr+" --> "  + ((  a1.insertar(10)) ? sOk : sErr));
        System.out.println("Checkeo si es vacio. Tiene que dar " + sErr+" --> "  +((  a1.esVacio()) ? sOk : sErr));  
        System.out.println(a1.toString());
        a3=a1.clone();
        System.out.println("\n");
        System.out.println("********************************");
        System.out.println("*    PRUEBA DE ELIMINACION     *");
        System.out.println("********************************");
        ABB a2 = new ABB();
        System.out.println("Elimino en Arbol Vacio. Tiene que dar " + sErr+" --> "  + ((  a2.eliminar(0) ? sOk : sErr)));
        System.out.println("Pruebo el caso 1 con Nodo Hoja 3. Tiene que dar "+ sOk+" --> "+((  a1.eliminar(3) ? sOk : sErr)));
        System.out.println("Pruebo el caso 2 con Nodo 9. Tiene que dar "+ sOk+" --> "+((  a1.eliminar(9) ? sOk : sErr)));
        //System.out.println("Pruebo el caso con Nodo 15. Tiene que dar "+ sOk+" --> "+((  a1.eliminar(15) ? sOk : sErr)));
        System.out.println("Pruebo eliminar elemento inexistente. Tiene que dar "+ sErr+" --> "+((  a1.eliminar(3) ? sOk : sErr)));
        
        System.out.println("\n\n");
       
        System.out.println("\n\n********************************");
        System.out.println("*      PRUEBA DE LISTADOS      *");
        System.out.println("********************************\n");
        
        System.out.println("Pruebo listar Arbol Vacio --> "+ a2.listar());
        System.out.println("Pruebo listar en el Arbol Original [7,10,12,20] --> "+a1.listar());
        a2=a1.clone();
        System.out.println("Clono el Arbol Original al Arbol vacio. Tiene que dar [7,10,12,20] --> "+a2.listar());
        System.out.println("Clono el arbol del comienzo sin eliminaciones. Tiene que dar [3,7,9,10,12,15,20] --> "+a3.listar());
        
        
        System.out.println("\n\n********************************");
        System.out.println("*  PRUEBA DE LISTAR POR RANGO  *");
        System.out.println("********************************\n");
         
        a2.vaciar();
       // System.out.println("Pruebo Listar por Rangos en Arbol vacio. Tiene que dar 'Lista vacia' --> "+ a2.listarRango(9,10));
        //System.out.println("Pruebo listar Por Rangos con min=10 y max=10 en Arbol Original. Tiene que dar [10] --> "+ a1.listarRango(10,10));
        //System.out.println("Pruebo listarRango con  rango minimo mayor a rango maximo. Tiene que dar 'Lista Vacia' "+a1.listarRango(15,7).toString());
        System.out.println("Inserto el 9 " + ((  a1.insertar(9)) ? sOk : sErr));
        System.out.println("Inserto el 3 " + ((  a1.insertar(3)) ? sOk : sErr));
        System.out.println("Inserto el 6 " + ((  a1.insertar(6)) ? sOk : sErr));
        //System.out.println("Pruebo el listarRango con min=3 max=12. Tiene que dar [3,6,7,9,10,12] --> "+a1.listarRango(3,12));
    
    
     
        System.out.println("\n\n********************************");
        System.out.println("*    PRUEBA DE MINIMO-MAXIMO    *");
        System.out.println("********************************\n");
        
        System.out.println("Busco elemento minimo del Arbol Original. Tiene que dar 3, da --> "+ a1.minimoElem());
       // System.out.println("Elimino el elemento minimo. Tiene que dar "+sOk+" --> "+((  a1.eliminarMinimo()) ? sOk : sErr));
        //System.out.println("Verifico que cambio el minimo. Tiene que dar 7, da ---> "+a1.minimoElem());
        System.out.println("Busco elemento maximo del Arbol Original. Tiene que dar 20, da --> "+a1.maximoElem());
        //System.out.println("Elimino el elemento minimo. Tiene que dar "+sOk+" --> "+((  a1.eliminarMaximo()) ? sOk : sErr));
        //System.out.println("Verifico que cambio el maximo. Tiene que dar 15, da --> "+a1.maximoElem());
        System.out.println("Busco minimo en Arbol vacio. Tiene que dar " + sOk+" --> "  + ((a2.minimoElem() == null) ? sOk : sErr));
        System.out.println("Busco maximo en Arbol vacio. Tiene que dar " + sOk+" --> "  + ((a2.maximoElem() == null) ? sOk : sErr));

    
    }
    
}

