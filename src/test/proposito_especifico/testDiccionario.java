/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.proposito_especifico;
import Proposito_especifico.DiccionarioAVL;
/**
 *
 * @author repetto.francisco
 */
public class testDiccionario {
    public static void main(String[] args){
       
        DiccionarioAVL d = new DiccionarioAVL();
        
        

        String[] nombres = {"Edsger", "Turing", "Edwars", "Larson", "Tao", "Wallace",
           "Churhill", "Pepe", "Juan", "Gerard", "Messi", "Counter-Strike", "Jugador"};
        for(int i = 1; i <= 47; i++){

            int num = i;//(int) (Math.random() * 100)%10;

            int numero = d.insertar(num, nombres[0]) ? num : -1;

            //System.out.print(((numero == -1)?"":("\n"+numero+"\n")));
        }


        System.out.println("\n\n");
        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());

        for(int i = 1; i <= 15; i+=2){
            if(i != 9)
                d.eliminar(i);
        }

        System.out.println("\n\n");
        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());

        d.eliminar(12);

        System.out.println("\n\n");
        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());
//        
//        System.out.println(d.insertar(50, nombres[0]));
//        System.out.println(d.insertar(30, nombres[1]));
//        System.out.println(d.insertar(80, nombres[2]));
//        System.out.println(d.insertar(20, nombres[3]));
//        System.out.println(d.insertar(40, nombres[4]));
//        System.out.println(d.insertar(70, nombres[6]));
//        System.out.println(d.insertar(90, nombres[7]));
//         System.out.println(d.insertar(35, nombres[2]));
//        System.out.println(d.insertar(100, nombres[7]));
//        
//        
//        System.out.println("\n\n");
//        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());
//        
//        
//        
//        /*d.eliminar(100);
//        
//        System.out.println("\n\n");
//        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());
//        
//        
//        d.eliminar(90);
//        
//        System.out.println("\n\n");
//        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());*/
//        
//      /* d.eliminar(40);
//        
//        System.out.println("\n\n");
//        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());
//        */
//        
//        d.eliminar(80);
//        
//        System.out.println("\n\n");
//        System.out.println("\u001B[32mSTRING DEL DICCIONARIO: \n"+d.toString());
//        
//        System.out.println(d.existeClave(70));
        
        
    }
}
