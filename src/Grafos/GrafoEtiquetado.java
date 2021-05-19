/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import Liniales.dinamica.Cola;
import Liniales.dinamica.Lista;

/**
 *
 * @author repetto.francisco
 */
public class GrafoEtiquetado {

    //Atributos
    private NodoVert inicio;

    //Constructores
    public GrafoEtiquetado() {
        inicio = null;
    }

    //Operaciones basicas
    public boolean insertarVertice(Object nuevoVertice) {
        boolean exito = false;
        NodoVert aux = this.ubicarVertice(nuevoVertice);
        if (aux == null) {
            this.inicio = new NodoVert(nuevoVertice, this.inicio, null);
            exito = true;

        }
        return exito;

    }

    private NodoVert ubicarVertice(Object buscado) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(buscado)) {
            aux = aux.getSigVertice();
        }
        return aux;
    }

    public boolean eliminarVertice(Object elemVertice) {
        boolean exito = false;
        NodoVert aux = null;
        if (inicio != null) {
            aux = this.desconectarVertice(elemVertice);
        }
        if (aux != null) {
            //Si lo encuentra, le desconecta los arcos
            NodoAdy auxArco = aux.getPrimerAdy();
            //Verifica que tenga arcos
            if (auxArco != null) {
                //Primero desconecta al nodo destino al de origen asi no pierde la referencia
                boolean desconecto = desconectarArco(auxArco.getVertice(), aux);
                //Si lo pudo desconectar del destino al origen, entonces lo desconecta del origen al destino
                if (desconecto) {
                    desconectarArco(aux, auxArco.getVertice());
                }
            }
            exito = true;
        }
        return exito;
    }

    private NodoVert desconectarVertice(Object buscado) {
        NodoVert aux = this.inicio, verticeBuscado = null;
        //Verifica si el vertice buscado esta en el inicio
        if (aux.getElem().equals(buscado)) {
            //Como esta en el inicio lo desconecta cambiando el inicio al vertice siguiente
            verticeBuscado = aux;
            this.inicio = aux.getSigVertice();
        } else {
            //Si no esta en el inicio los busca en los vertices siguientes
            while (aux.getSigVertice() != null && !aux.getSigVertice().getElem().equals(buscado)) {
                aux = aux.getSigVertice();
            }
            //Si lo encontro, lo desconecta
            if (aux.getSigVertice() != null) {
                verticeBuscado = aux.getSigVertice();
                //Cambia al vertice siguiente
                aux.setSigVertice(aux.getSigVertice().getSigVertice());
            }
        }
        //Retorna el vertice buscado para que desconecte los arcos
        return verticeBuscado;
    }

    private boolean desconectarArco(NodoVert vertActual, NodoVert vertADesconectar) {
        //Retorna si encontro a vertADesconectar en la lista adyacencia 
        boolean exito = false;
        //Busca el vertice de vertADesconectar en la lista de adyacencia de vertActual y lo elimina
        NodoAdy aux = vertActual.getPrimerAdy();
        //Verifica si el arco es el primero de la lista
        if (aux.getVertice().equals(vertADesconectar)) {
            //Como el arco es el primero lo desconecta 
            vertActual.setPrimerAdy(aux.getSigAdyacente());
            exito = true;
        } else {
            //Si no es el primero, busca en los arcos siguientes
            while (aux.getSigAdyacente() != null && !aux.getSigAdyacente().getVertice().equals(vertADesconectar)) {
                aux = aux.getSigAdyacente();
            }
            //Si encontro el arco, lo desconecta
            if (aux.getSigAdyacente() != null) {
                aux.setSigAdyacente(aux.getSigAdyacente().getSigAdyacente());
                exito = true;
            }
        }
        return exito;
    }

    public boolean existeVertice(Object vertice) {
        boolean encontrado = false;
        NodoVert aux = ubicarVertice(vertice);
        if (aux != null) {
            encontrado = true;
        }
        return encontrado;
    }

    public boolean insertarArco(Object origen, Object destino, int etiqueta) {
        /*ACLARACION: no hice un metodo aparte para buscar ambos vertices como el ubicar vertice
        del insertar vertice porque nada mas podria retornarme uno de los vertices*/
        boolean exito = false;
        //Busca los vertices en la lista de vertices
        NodoVert auxOrigen = null, auxDestino = null, i = this.inicio;
        while (i != null && (auxOrigen == null || auxDestino == null)) {
            if (i.getElem().equals(origen)) { //Si encontro el vertice origen en la lista, lo guarda
                auxOrigen = i;
            } else if (i.getElem().equals(destino)) { //Si encontro el vertice destino en la lista, lo guarda
                auxDestino = i;
            }
            i = i.getSigVertice();
        }
        //Verifica si encontro los dos
        if (auxOrigen != null && auxDestino != null) {
            //Como encontro los dos, se crea un arco
            auxOrigen.setPrimerAdy(new NodoAdy(auxDestino, auxOrigen.getPrimerAdy(), etiqueta));
            auxDestino.setPrimerAdy(new NodoAdy(auxOrigen, auxDestino.getPrimerAdy(), etiqueta));
            exito = true;
        }
        return exito;
    }

    public boolean eliminarArco(Object origen, Object destino) {
        boolean exito = false;
        //Busca el vertice origen en la lista de vertices
        NodoVert aux = ubicarVertice(origen);
        //Si lo encuentra, le desconecta los arcos
        if (aux != null) {
            NodoAdy auxArco = aux.getPrimerAdy();
            //Verifica que tenga arcos
            if (auxArco != null) {
                //Primero desconecta destino al de origen asi no pierde la referencia
                boolean desconecto = desconectarArco(auxArco.getVertice(), aux);
                //Si lo pudo desconectar del destino al origen, entonces lo desconecta del origen al destino
                if (desconecto) {
                    desconectarArco(aux, auxArco.getVertice());
                    exito = true;
                }
            }
        }
        return exito;
    }

    public boolean existeArco(Object origen, Object destino) {
        boolean exito = false;
        //Busca el vertice origen en la lista de vertices
        NodoVert aux = ubicarVertice(origen);
        if (aux != null) {
            //Busca el vertice destino en la lista de adyacencia
            NodoAdy auxArco = aux.getPrimerAdy();
            while (auxArco != null && !auxArco.getVertice().getElem().equals(destino)) {
                auxArco = auxArco.getSigAdyacente();
            }
            //Si lo encontro entonces es porque existe un arco
            if (auxArco != null) {
                exito = true;
            }
        }
        return exito;
    }

    public Lista listarEnProfundida() {
        Lista visitados = new Lista();
        /*Define un vertice donde comenzar a recorrer*/
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) < 0) {
                /*Si el vertice no fue visitado aun, avanza en profundidad*/
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }

    private void listarEnProfundidadAux(NodoVert n, Lista vis) {
        if (n != null) {
            /*marca el n como visitado*/
            vis.insertar(n.getElem(), vis.longitud() + 1);
            NodoAdy ady = n.getPrimerAdy();
            while (ady != null) {
                /*Visita en profundidad los adyacentes en n aun no visitados*/
                if (vis.localizar(ady.getVertice().getElem()) < 0) {
                    listarEnProfundidadAux(ady.getVertice(), vis);
                }
                ady = ady.getSigAdyacente();
            }
        }
    }

    public Lista listarEnAnchura(Object vertInicial) {
        Lista visitados = new Lista();
        NodoVert aux = ubicarVertice(vertInicial);
        if (aux != null) {
            visitados = anchuraDesde(aux, visitados);
        }
        //Verifica si todos los vertices fueron visitados
        NodoVert verificando = this.inicio;
        while (verificando != null) {
            if (visitados.localizar(verificando.getElem()) < 0) {
                /*Si no esta en la lista, lo inserta y agrega en anchura los que
                    no fueron visitados a partir de este vertice*/
                visitados = anchuraDesde(verificando, visitados);
            }
            verificando = verificando.getSigVertice();
        }
        return visitados;
    }

    private Lista anchuraDesde(NodoVert vertInicial, Lista visitados) {
        Cola cola = new Cola();
        //Se coloca al vertice en la lista de visitados y en la cola
        visitados.insertar(vertInicial.getElem(), visitados.longitud() + 1);
        cola.poner(vertInicial);
        while (!cola.esVacia()) {
            //Saca al vertice del frente de la cola 
            NodoVert aux = (NodoVert) cola.obtenerFrente();
            cola.sacar();
            NodoAdy arco = aux.getPrimerAdy();
            while (arco != null) {
                //Recorre todos los nodos adyacentes y los guarda en la lista y en la cola
                if (visitados.localizar(arco.getVertice().getElem()) < 0) {
                    visitados.insertar(arco.getVertice().getElem(), visitados.longitud() + 1);
                    cola.poner(arco.getVertice());
                }
                arco = arco.getSigAdyacente();
            }
        }
        return visitados;
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        /*Verifica si ambos vertices existen*/
        NodoVert auxO = encontrarDosVertices(origen, destino);
        if (auxO != null) {
            /*Si ambos vertices existen busca si existe camino entre ambos*/
            Lista visitados = new Lista();
            existeCaminoAux(auxO, destino, visitados);
        }
        return exito;
    }

    private NodoVert encontrarDosVertices(Object origen, Object destino) {
        /*Metodo que verifica si existen dos vertices, origen y destino, y retorna 
            vertice origen si encuentra los dos*/
        NodoVert auxO = null, auxD = null;
        NodoVert aux = this.inicio;
        //Busca ambos vertices
        while ((auxO == null || auxD == null) && aux != null) {
            if (aux.getElem().equals(origen)) {
                auxO = aux;
            }
            if (aux.getElem().equals(destino)) {
                auxD = aux;
            }
            aux = aux.getSigVertice();
        }
        if (auxO == null || auxD == null) {
            auxO = null;
        }
        return auxO;
    }

    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().equals(dest)) /*si vertice n es el destino: HAY CAMINO!*/ {
                exito = true;
            } else {
                /*Si no es el destino verifica  si hay camino entre n y destino*/
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getPrimerAdy();
                while (!exito && ady != null) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0) {
                        exito = existeCaminoAux(ady.getVertice(), dest, vis);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        Lista masCorto = new Lista();
        /*Verifica si ambos vertices existen*/
        NodoVert auxO = encontrarDosVertices(origen, destino);
        if (auxO != null) {
            /*Si ambos vertices existen busca el camino mas corto entre ambos*/
            Lista vis = new Lista();
            masCorto = caminoMasCortoAux(auxO, destino, vis, masCorto);
        }
        return masCorto;
    }

    private Lista caminoMasCortoAux(NodoVert n, Object dest, Lista vis, Lista masCorto) {
        //Verifica que el origen es el destino
        if (n != null) {
            if (n.getElem().equals(dest)) {
                //si vertice n es el destino: HAY CAMINO!
                vis.insertar(n.getElem(), vis.longitud() + 1);
                //Verifica si la lista de visitados es la mas corta hasta ahora
                if (masCorto.esVacia() || masCorto.longitud() > vis.longitud()) { //Como es la mas corta, la guarda
                    masCorto = vis.clone();
                }
            } else {
                /*Si no es el destino verifica  si hay camino entre n y destino*/
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0) {
                        masCorto = caminoMasCortoAux(ady.getVertice(), dest, vis, masCorto);
                        vis.eliminar(vis.longitud());
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return masCorto;
    }

    public Lista caminoMasLargo(Object origen, Object destino) {
        Lista masLargo = new Lista();
        /*Verifica si ambos vertices existen*/
        NodoVert auxO = encontrarDosVertices(origen,destino);
        if (auxO != null) {
            /*Si ambos vertices existen busca el camino mas largo entre ambos*/
            Lista vis = new Lista();
            masLargo = caminoMasLargoAux(auxO, destino, vis, masLargo);
        }
        return masLargo;
    }

    private Lista caminoMasLargoAux(NodoVert n, Object dest, Lista vis, Lista masLargo) {
        //Verifica que el origen es el destino
        if (n != null) {
            if (n.getElem().equals(dest)) {
                //si vertice n es el destino: HAY CAMINO!
                vis.insertar(n.getElem(), vis.longitud() + 1);
                //Verifica si la lista de visitados es la mas corta hasta ahora
                if (masLargo.esVacia() || masLargo.longitud() < vis.longitud()) { //Como es la mas corta, la guarda
                    masLargo = vis.clone();
                }
            } else {
                /*Si no es el destino verifica  si hay camino entre n y destino*/
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0) {
                        masLargo = caminoMasLargoAux(ady.getVertice(), dest, vis, masLargo);
                        vis.eliminar(vis.longitud());
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return masLargo;
    }

    public Lista caminoMasCortoEtiquetas(Object origen, Object destino) {
        Lista masCorto = new Lista();
        /*Verifica si ambos vertices existen*/
        NodoVert auxO = encontrarDosVertices(origen,destino);
        if (auxO != null) {
            /*Si ambos vertices existen busca el camino mas entre ambos*/
            Lista vis = new Lista();
            masCorto.insertar(vis, 1);
            masCorto.insertar(0, 2);
            masCorto = caminoMasCortoEtiquetasAux(auxO, destino, vis, masCorto, 0);
        }
        if (!masCorto.esVacia()) //Guarda la lista de los vertices para retornarla
        {
            masCorto = (Lista) masCorto.recuperar(1);
        }

        return masCorto;
    }

    private Lista caminoMasCortoEtiquetasAux(NodoVert n, Object dest, Lista vis, Lista masCorto, int etiqVis) {
        /*ACLARION: La lista masCorto guarda el camino por etiquetas mas corto en la posicion 1 y la suma
            de las etiquetas lo guarda en la posicion 2*/
        if (n != null) {
            //Verifica que el origen es el destino
            if (n.getElem().equals(dest)) {
                //si vertice n es el destino: HAY CAMINO!
                vis.insertar(n.getElem(), vis.longitud() + 1);
                //Recupera la suma de etiquetas de la lista 
                int i = (int) masCorto.recuperar(2);
                //Verifica si la lista de visitados sus etiquetas suman un numero menor 
                if ( i == 0 || i > etiqVis) { //Como es la mas corta, la guarda
                    //Elimina la lista anterior e inserta la nueva lista
                    masCorto.eliminar(1);
                    masCorto.insertar(vis.clone(), 1);
                    //Elimina la suma anterior e inserta la suma nueva 
                    masCorto.eliminar(2);
                    masCorto.insertar(etiqVis, 2);
                }
            } else {
                /*Si no es el destino verifica  si hay camino entre n y destino*/
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null) {
                    if (vis.localizar(ady.getVertice().getElem()) < 0) {
                        etiqVis = etiqVis + ady.getEtiqueta();
                        masCorto = caminoMasCortoEtiquetasAux(ady.getVertice(), dest, vis, masCorto, etiqVis);
                        vis.eliminar(vis.longitud());
                        etiqVis = etiqVis - ady.getEtiqueta();
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return masCorto;
    }

    public void vaciar() {
        this.inicio = null;
    }

    public boolean esVacio() {
        boolean vacio = false;
        if (this.inicio == null) {
            vacio = true;
        }
        return vacio;
    }

    public GrafoEtiquetado clone() {
        //Creo el clon
        GrafoEtiquetado clon = new GrafoEtiquetado();
        if (this.inicio != null) {
            //Clona el nodo inicio en el clon
            clon.inicio = new NodoVert(this.inicio.getElem(), null, null);
            NodoVert auxClon = clon.inicio;
            //Clona todos los vertices
            clonNodosVertice(auxClon);
            //Clona todos los arcos
            clonArcos(clon, auxClon);
        }
        return clon;
    }

    private void clonNodosVertice(NodoVert auxClon) {
        NodoVert auxOrig = this.inicio;
        while (auxOrig.getSigVertice() != null) {
            //Clona uno por uno los vertices
            auxOrig = auxOrig.getSigVertice();
            auxClon.setSigVertice(new NodoVert(auxOrig.getElem(), null, null));
            auxClon = auxClon.getSigVertice();
        }
    }

    private void clonArcos(GrafoEtiquetado clon, NodoVert auxClon) {
        NodoVert auxOrig = this.inicio;
        NodoAdy arcoOrig, arcoClon;
        //Recorre uno por uno los vertices
        while (auxOrig != null) {
            //Verifica que el vertice tenga arcos
            if (auxOrig.getPrimerAdy() != null) {
                //Clona el primer arco del vertice original en el vertice clon
                arcoOrig = auxOrig.getPrimerAdy();
                auxClon.setPrimerAdy(new NodoAdy(clon.ubicarVertice(auxOrig.getElem()), null, arcoOrig.getEtiqueta()));
                arcoClon = auxClon.getPrimerAdy();
                //Clona los arcos siguientes
                while (arcoOrig.getSigAdyacente() != null) {
                    arcoOrig = arcoOrig.getSigAdyacente();
                    arcoClon.setSigAdyacente(new NodoAdy(clon.ubicarVertice(auxOrig.getElem()), null, arcoOrig.getEtiqueta()));
                    arcoClon = arcoClon.getSigAdyacente();
                }
            }
            auxOrig = auxOrig.getSigVertice();
        }
    }

    public String toString() {
        String grafo = "";
        NodoVert aux = this.inicio;
        grafo = grafo + "VERTICE" + "     ADYACENTE" + "     ETIQUETA" + "\n";
        while (aux != null) {
            grafo = grafo + aux.getElem() + "     \t";
            NodoAdy auxArco = aux.getPrimerAdy();
            while (auxArco != null) {
                grafo = grafo + auxArco.getVertice().getElem() + "\t    ";
                grafo = grafo + auxArco.getEtiqueta();
                auxArco = auxArco.getSigAdyacente();
                if (auxArco != null) {
                    grafo = grafo + "\n " + "\t\t";
                }
            }
            grafo = grafo + "\n";
            aux = aux.getSigVertice();
        }
        return grafo;
    }

}
