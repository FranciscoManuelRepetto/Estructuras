package test.lineales;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author repetto.francisco
 */
import Liniales.estatica.Pila;
import Liniales.estatica.Pila;
import Utiles.TecladoIn;

public class TestPilaEstatica {

    public static void main(String[] args) {
        Pila pila;
        pila = new Pila();
        Opciones(pila);

    }

    public static void Opciones(Pila pila) {
        int opcion;
        boolean salir = false;
        do {
            opcion = Menu();
            switch (opcion) {
                case 1:
                    Apilar(pila);
                    break;
                case 2:
                    Desapilar(pila);
                    break;
                case 3:
                    System.out.println("El ultimo elemento es: " + pila.obtenerTope());
                    break;
                case 4:
                    if (pila.esVacia()) {
                        System.out.println("La pila esta vacia");
                    } else {
                        System.out.println("La pila no esta vacia");
                    }
                    break;
                case 5:
                    pila.vaciar();
                    break;
                case 6:
                    Object pilaClon;
                    pilaClon = pila.clone();
                    System.out.println("La pila clonada es: " + pilaClon.toString());
                    break;
                case 7:
                    System.out.println("La pila es: " + pila.toString());
                    break;
                case 8:
                    Capicúa(pila);
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("No se elegió una opción");
                    break;
            }
        } while (salir == false);
    }

    public static int Menu() {
        int opcion;
        System.out.println("Opciones Pila");
        System.out.println("1.Apilar");
        System.out.println("2.Desapilar");
        System.out.println("3.Obtener dato");
        System.out.println("4.¿Es Vacio?");
        System.out.println("5.Vaciar");
        System.out.println("6.Clonar");
        System.out.println("7.To String");
        System.out.println("8.Capicua");
        System.out.println("9.Salir");
        opcion = TecladoIn.readInt();
        return opcion;
    }

    public static void Apilar(Pila pila) {
        boolean verifi;
        int numEle = 0;
        System.out.println("Escriba numero a apilar");
        numEle = TecladoIn.readInt();
        verifi = pila.apilar(numEle);
        if (verifi == false) {
            System.out.println("Error, la pila esta llena");
        }

    }

    public static void Desapilar(Pila pila) {
        boolean verifi;
        verifi = pila.desapilar();
        if (verifi == false) {
            System.out.println("Error, la pila esta vacia");
        }
    }


    public static void Capicúa(Pila pila){
        boolean capicua,desapilado=true;
        Pila aux;
        Pila aux2;
        aux=new Pila();
        aux2=new Pila();
        aux=pila.clone()   
;        while(desapilado){
            aux2.apilar(aux.obtenerTope());
            desapilado=aux.desapilar();
        }
        if(pila.equals(aux2))
            System.out.println("La pila es Capicua");
        else
            System.out.println(pila.toString());
            System.out.println(aux2.toString());
            System.out.println("La pila no es Capicua");
    }
}
