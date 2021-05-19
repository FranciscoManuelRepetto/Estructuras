/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

/**
 *
 * @author repetto.francisco
 */
import Liniales.dinamica.Cola;
import Utiles.TecladoIn;
public class TestCola {
    public static void main(String[] args) {
    Opciones();
    }
    
    public static void Opciones(){
        Cola col=new Cola();
        int opcion;
        boolean salir=false;
        do{
            opcion=menu();
            switch(opcion){
                case 1:
                    Poner(col);
                    break;
                case 2:
                    Sacar(col);
                    break;
                case 3:
                    System.out.println(col.obtenerFrente());
                    break;
                case 4:
                    esVacia(col);
                    break;
                case 5:
                    col.vaciar();
                    System.out.println("La pila se vacio");
                    break;
                case 6:
                    Cola col2=new Cola();
                    col2=col.clone();
                    System.out.println("Pila clonada: "+col2.toString());
                    break;
                case 7:
                    System.out.println("La cola es: "+col.toString());
                    break;
                case 8:
                    salir=true;
                    break;
                default:
                    System.out.println("No se eligio una opción");
                    break;
            }
        }while(salir!=true);
    }
    
    public static int menu(){
        int opcion;
        System.out.println("Opciones Pila");
        System.out.println("1.Poner elemento");
        System.out.println("2.Sacar elemento");
        System.out.println("3.Obtener dato");
        System.out.println("4.¿Es Vacio?");
        System.out.println("5.Vaciar");
        System.out.println("6.Clonar");
        System.out.println("7.To String");
        System.out.println("8.Salir");
        opcion = TecladoIn.readInt();
        return opcion;
    }
    
    public static void Poner(Cola col){
        int elem;
        boolean puesto;
        System.out.println("Ingrese numero a poner en la cola");
        elem=TecladoIn.readInt();
        puesto=col.poner(elem);
        if(puesto==false)
            System.out.println("Error, la pila esta llena");
        else
            System.out.println(col.toString());
    }
    
    public static void Sacar(Cola col){
        boolean sacado;
        sacado=col.sacar();
        if(sacado==false)
            System.out.println("Error la pila esta vacia");
        else
            System.out.println(col.toString());
    }
    
    public static void esVacia(Cola clon){
        if(clon.esVacia())
            System.out.println("La pila esta vacia");
        else
            System.out.println("La pila no esta vacia");
    }
    
    
    
}
