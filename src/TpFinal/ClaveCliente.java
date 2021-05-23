/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import java.util.Objects;

/**
 *
 * @author repetto.francisco
 */
public class ClaveCliente implements Comparable {

    private String tipo;
    private String numDni;

    public ClaveCliente(String tipo, String numeroDni) {
        this.tipo = tipo;
        this.numDni = numeroDni;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumDni() {
        return numDni;
    }

    @Override
    public int compareTo(Object obj) {
        //se compara tomando en primer lugar el tipo y luego el numero de dni
        ClaveCliente clave = (ClaveCliente) obj;
        int resultado = this.tipo.compareTo(clave.tipo);
        if(resultado == 0)
            resultado = this.numDni.compareTo(clave.numDni);
        return resultado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + Objects.hashCode(this.numDni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClaveCliente other = (ClaveCliente) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.numDni, other.numDni)) {
            return false;
        }
        return true;
    }


    
    

}
