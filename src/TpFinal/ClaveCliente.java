/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

/**
 *
 * @author repetto.francisco
 */
public class ClaveCliente {

    private String tipo;
    private int numDni;

    public ClaveCliente(String tipo, int numeroDni) {
        this.tipo = tipo;
        this.numDni = numeroDni;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumDni() {
        return numDni;
    }

    public int compareTo(Object obj) {
        //se compara tomando en primer lugar el tipo y luego el numero de dni
        int resultado;
        ClaveCliente clave = (ClaveCliente) obj;
        if (this.tipo.compareTo(clave.tipo) < 0) {
            resultado = -1;
        } else if (this.tipo.compareTo(clave.tipo) > 0) {
            resultado = 1;
        } else // el tipo es igual, se compara el dni
        if (this.numDni < clave.numDni) {
            resultado = -2;
        } else if (this.numDni > clave.numDni) {
            resultado = 2;
        } else {
            resultado = 0;
        }
        return resultado;
    }

}
