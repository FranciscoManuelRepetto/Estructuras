/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import Liniales.dinamica.Cola;
import Liniales.dinamica.Pila;
import Liniales.dinamica.Lista;

/**
 * #
 * @author repetto.francisco
 */
public class MixLineales {

    public static void main(String[] args) {
        Lista list = new Lista(), list2;
        System.out.println("**** PRIMER CASO CON '$' AL PRINCIPIO ****");
        System.out.println("Inserto elementos en la lista");
        System.out.println("Inserto *" + "\t" + list.insertar('*', 1));
        System.out.println("Inserto A" + "\t" + list.insertar('A', 2));
        System.out.println("Inserto B" + "\t" + list.insertar('B', 3));
        System.out.println("Inserto *" + "\t" + list.insertar('*', 4));
        System.out.println("Inserto C" + "\t" + list.insertar('C', 5));
        System.out.println("Inserto *" + "\t" + list.insertar('*', 6));
        System.out.println("Inserto D" + "\t" + list.insertar('D', 7));
        System.out.println("Inserto E" + "\t" + list.insertar('E', 8));
        System.out.println("Inserto F" + "\t" + list.insertar('F', 9));
        System.out.println("Lista 1: \n" + list.toString());
        System.out.println("Prueba metodo generarLista");
        System.out.println("Deberia dar:[*,A,B,B,A,A,B,*,C,C,C,*,D,E,F,F,E,D,D,E,F] \nLista nueva:" + generarLista(list).toString());
        System.out.println("\n**** SEGUNDO CASO CON '*' AL PRINCIPIO Y AL FINAL ****");
        System.out.println("Inserto *" + "\t" + list.insertar('*', 10));
        System.out.println("Lista 2: \n" + list.toString());
        System.out.println("Prueba metodo generarOtraLista");
        System.out.println("Deberia dar:[*,A,B,B,A,A,B,*,C,C,C*,D,E,F,F,E,D,D,E,F,*] \nLista nueva:" + generarLista(list).toString());
        System.out.println("\n**** TERCER CASO CON '*' AL FINAL ****");
        System.out.println("Elimino frente de la lista" + "\t" + list.eliminar(1));
        System.out.println("Lista 3: \n" + list.toString());
        System.out.println("Prueba metodo generarLista");
        System.out.println("Deberia dar:[A,B,B,A,A,B,*,C,C,C,*,D,E,F,F,E,D,D,E,F,*] \nLista nueva:" + generarLista(list).toString());
        System.out.println("\n**** CUARTO CASO SIN '*' al final ni al principio ****");
        System.out.println("Elimino * al final de la lista" + "\t" + list.eliminar(9));
        System.out.println("Lista 4: \n" + list.toString());
        System.out.println("Prueba metodo generarLista");
        System.out.println("Deberia dar:[A,B,B,A,A,B,*,C,C,C,*,D,E,F,F,E,D,D,E,F] \nLista nueva:" + generarLista(list).toString());
        System.out.println("\n**** QUINTO CASO SIN '*' ****");
        System.out.println("Elimino '*' en pos 3 \t\t " + list.eliminar(3));
        System.out.println("ELimino '*' en pos 4 \t\t " + list.eliminar(4));
        System.out.println("Lista 5: \n" + list.toString());
        System.out.println("Pruebo metodo generarLista");
        System.out.println("Deberia dar: [A,B,C,D,E,F,F,E,D,C,B,A,A,B,C,D,E,F]\n Lista nueva:" + generarLista(list));
        System.out.println("\n**** SEXTO CASO Lista CON '**' EN EL MEDIO ****");
        System.out.println("Inserto * en posicion del medio" + list.insertar('*', 4));
        System.out.println("Inserto * en posicion del medio" + list.insertar('*', 5));
        System.out.println("Lista 5: \n" + list.toString());
        System.out.println("Deberia dar: [A,B,C,C,B,A,A,B,C,*,*,D,E,F,F,E,D,D,E,F]\n Lista nueva:" + generarLista(list));
        System.out.println("\n**** SEPTIMO CASO LISTA VACIA ****");
        System.out.println("Vacio la Lista");
        list.vaciar();
        System.out.println("Lista vacia deberia dar true: " + list.esVacia());
        System.out.println("Pruebo metodo generar lista");
        System.out.println("Deberia dar null \n Lista nueva:" + generarLista(list).toString());
        System.out.println("\n**** OCTAVO CASO LISTA DE '*' ****");
        System.out.println("Inserto *" + "\t" + list.insertar('*', 1));
        System.out.println("Inserto *" + "\t" + list.insertar('*', 2));
        System.out.println("Inserto *" + "\t" + list.insertar('*', 3));
        System.out.println("Lista 8: \n" + list.toString());
        System.out.println("Pruebo metodo generar lista");
        System.out.println("Deberia dar:[*,*,*] \nLista nueva:" + generarLista(list).toString());

        System.out.println("\n\n\nBOrarr esto");
        list.vaciar();
        list.insertar(0, 1);
        list.insertar(1, 2);
        list.insertar(2, 3);
        list.insertar(3, 4);
        list.insertar(4, 5);
        list.insertar(5, 6);
        list.insertar(6, 7);
        list.insertar(7, 8);
        list.insertar(8, 9);
        list.insertar(9, 10);
        System.out.println(list.toString());
        System.out.println("Pruebo metodo");
        Cola auxx = listaToCola(list, 3);
        System.out.println(auxx.toString());

        System.out.println("\n\n\nBOrarr esto");
        auxx.vaciar();
        auxx.poner('0');
        auxx.poner('1');
        auxx.poner('2');
        auxx.poner('3');
        auxx.poner('4');
        auxx.poner('5');
        auxx.poner('6');
        auxx.poner('7');
        auxx.poner('8');
        auxx.poner('9');
        System.out.println(auxx.toString());
        System.out.println("Pruebo metodo");
        list.vaciar();
        list = colaToLista(auxx, 4);
        System.out.println(list.toString());

        System.out.println("\n\n\nBOrarr esto");
        list.vaciar();
        list.insertar(0, 1);
        list.insertar(1, 2);
        list.insertar(2, 3);
        list.insertar(3, 4);
        list.insertar(4, 5);
        list.insertar(5, 6);
        list.insertar(6, 7);
        list.insertar(7, 8);
        list.insertar(8, 9);
        list.insertar(9, 10);
        System.out.println(list.toString());
        System.out.println("Pruebo metodo estudiandoParaParcial1");
        Pila auxPila = list.estudiandoParaParcial1();
        System.out.println("Deberia dar: [1,0,0,1,1,0,3,2,2,3,3,2,5,4,4,5,5,4,7,6,6,7,7,6,9,8,8,9,9,8,$]");
        System.out.println(auxPila.toString());
        System.out.println("\n\n\n\n\n\n\n\nPruebo metodo maleQuiereAIngrid");
        list.vaciar();
        list.insertar('A', 1);
        list.insertar('B', 2);
        list.insertar('C', 3);
        list.insertar('A', 4);
        list.insertar('B', 5);
        list.insertar('A', 6);
        list.insertar('B', 7);
        list.insertar('C', 8);
        list.insertar('A', 9);
        System.out.println("Lista: " + list.toString());
        Lista nuevaList = maleQuiereAIngrid(list, 2);
        System.out.println("Da: " + nuevaList.toString());
        nuevaList.vaciar();
        for (int i = 1; i < 5; i++) {
            nuevaList.insertar(i, i);
        }
        System.out.println("Lista pa intercalar " + nuevaList.toString());
        System.out.println("Lista original "+list.toString());
        list.intercalar(nuevaList);
        System.out.println("Pruebo intercalar");
        System.out.println(list.toString());

    }

    /*Consigna 3. En la clase MixLineales en del paquete test.lineales, agregar el método: generarLista(Lista lis) que recibe
    por parámetro una estructura de tipo Lista lis con elementos de tipo char que tiene el siguiente formato:
    a1 ∗ a2 ∗ a3 ∗ . . . ∗ an, donde cada ai en una sucesión de letras mayúsculas y a partir de lis debe generar
    como salida otra Lista de la forma: a1a1”a1 ∗ a2a2”a2 ∗ . . . . ∗ anan”an donde cada ai” es la secuencia de
    letras de ai
    invertida. Ejemplo: Si lis es AB*C*DEF, la operación generarOtraLista devolverá una Lista
    con el siguiente formato: ABBAAB*CCC*DEFFEDDEF*/
    public static Lista generarLista(Lista lis) {
        char elem;
        Cola col = new Cola();
        Pila pil = new Pila();
        Lista lis2 = new Lista(), clon = lis.clone();
        int longitud = lis.longitud(), i2 = 1;
        while (!clon.esVacia()) {
            elem = (char) clon.recuperar(1);
            if (elem != '*') {
                /*Coloco el elemento en la nueva cola y
                y lo apilo en la pila*/
                pil.apilar(elem);
                col.poner(elem);
                lis2.insertar(elem, i2);
                i2++;
            } else {
                /*Desapilo la pila y pongo en orden invertido los
                elementos hasta el $ */
                while (!pil.esVacia()) {
                    /*Vacio la pila*/
                    lis2.insertar(pil.obtenerTope(), i2);
                    i2++;
                    pil.desapilar();
                }
                while (!col.esVacia()) {
                    /*Vacio la cola*/
                    lis2.insertar(col.obtenerFrente(), i2);
                    i2++;
                    col.sacar();
                }
                lis2.insertar('*', i2);
                i2++;
            }
            clon.eliminar(1);
        }
        /*Si la lista no termina en $, le coloco los elementos
        que quedaron apilados y colocados en la pila y cola respectivamente*/
        while (!pil.esVacia()) {
            lis2.insertar(pil.obtenerTope(), i2);
            i2++;
            pil.desapilar();
        }
        while (!col.esVacia()) {
            lis2.insertar(col.obtenerFrente(), i2);
            i2++;
            col.sacar();
        }

        return lis2;
    }

    /*Consigna: implementar el método generarOtraCola(Cola
    c1) que recibe por parámetro una estructura de tipo Cola c1 con elementos de tipo
    char que tiene el siguiente formato: a1$a2$a3$. . . .$an, donde cada ai en una sucesión
    de letras mayúsculas y a partir de c1 debe generar como salida otra Cola de la 
    forma: a1a1$a2a2$ . . . .$anan donde cada ai es la secuencia de letras de ai invertida*/
    public static Cola generarOtraCola(Cola c1) {
        /*Creo una cola clon de la original*/
        char elem;
        Cola c2 = c1.clone(), c3 = new Cola();
        Pila aux = new Pila();
        while (!c2.esVacia()) {
            elem = (char) c2.obtenerFrente();
            c2.sacar();
            if (elem != '$') {
                /*Coloco el elemento en la nueva cola y
                y lo apilo en la pila*/
                aux.apilar(elem);
                c3.poner(elem);
            } else {
                /*Desapilo la pila y pongo en orden invertido los
                elementos hasta el $ */
                while (!aux.esVacia()) {
                    c3.poner(aux.obtenerTope());
                    aux.desapilar();
                }
                c3.poner(elem);
            }
        }
        /*Si la cola no termina en $, le coloco los elementos
        que quedaron a  lo ultimo*/
        while (!aux.esVacia()) {
            c3.poner(aux.obtenerTope());
            aux.desapilar();
        }

        return c3;
    }

    public static Cola listaToCola(Lista list, int t) {
        Pila pil = new Pila();
        Cola col = new Cola(), aux = new Cola(), aux2 = new Cola();
        int i = 1, longi = list.longitud(), i2 = 1;
        while (i <= longi) {
            if (i2 % (t + 1) != 0) {
                Object elem = list.recuperar(i);
                pil.apilar(elem);
                aux.poner(elem);
                aux2.poner(elem);
                i++;
                i2++;
            } else {
                Object elemAux;
                while (!pil.esVacia()) {
                    elemAux = pil.obtenerTope();
                    pil.desapilar();
                    col.poner(elemAux);
                }
                while (!aux.esVacia()) {
                    elemAux = aux.obtenerFrente();
                    aux.sacar();
                    col.poner(elemAux);
                }
                while (!aux2.esVacia()) {
                    elemAux = aux2.obtenerFrente();
                    aux2.sacar();
                    col.poner(elemAux);
                }
                col.poner('*');
                col.poner('*');
                i2 = 1;
            }
        }
        return col;
    }

    public static Lista colaToLista(Cola col, int t) {
        Lista list = new Lista();
        if (!col.esVacia() && t<0) {
            Cola clon = col.clone(), colAux = new Cola();
            Pila pil = new Pila();
            int i = 0, i2 = 1;
            char elem;
            while (!clon.esVacia()) {
                if (i < t) {
                    elem = (char) clon.obtenerFrente();
                    pil.apilar(elem);
                    colAux.poner(elem);
                    i++;
                    list.insertar(elem, i2);
                    i2++;
                    clon.sacar();
                } else {
                    while (!pil.esVacia()) {
                        elem = (char) pil.obtenerTope();
                        list.insertar(elem, i2);
                        i2++;
                        pil.desapilar();
                    }
                    while (!colAux.esVacia()) {
                        elem = (char) colAux.obtenerFrente();
                        list.insertar(elem, i2);
                        i2++;
                        colAux.sacar();
                    }
                    list.insertar('$', i2);
                    i2++;
                    i = 0;
                }
            }
            /*Vacio la pila y la cola que quedaron sin vaciar*/
            while (!pil.esVacia()) {
                elem = (char) pil.obtenerTope();
                list.insertar(elem, i2);
                i2++;
                pil.desapilar();
            }
            while (!colAux.esVacia()) {
                elem = (char) colAux.obtenerFrente();
                list.insertar(elem, i2);
                i2++;
                colAux.sacar();
            }
        }
        return list;
    }

    public static Lista maleQuiereAIngrid(Lista list, int t) {
        /*Devuelve una lista nueva con los elementos de la
        lista original pero sin los elementos en las posiciones multiplas de t*/
        Lista list2 = new Lista();
        if (list != null) {
            int i = 1, i2 = 1, longi = list.longitud();
            Object elem;
            while (i <= longi) {
                if (i % t != 0) {
                    elem = list.recuperar(i);
                    list2.insertar(elem, i2);
                    i2++;
                }
                i++;
            }
        }
        return list2;
    }
}
