/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import Liniales.dinamica.Lista;
import java.io.IOException;

/** 
 *
 * @author repetto.francisco
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*Hice este clase aparte porque sino me generaba problemas hacer el main
        en la clase entrada y salida en las variables estaticas
         */
        EntradaSalida sistema = new EntradaSalida();
        sistema.ejecutar();
    }
}
