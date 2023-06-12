/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import Conjustistas.AVL;
import Grafos.GrafoEtiquetado;
import Liniales.dinamica.Lista;
import Proposito_especifico.DiccionarioAVL;
import Utiles.TecladoIn;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author repetto.francisco
 */
public class SistemaViajes {
    
    //Atributos//
    private GrafoEtiquetado aeropuertos;
    private HashMap clienteYPasaje;
    private DiccionarioAVL clientes;
    private DiccionarioAVL vuelos;

    public SistemaViajes(){
        aeropuertos = new GrafoEtiquetado();
        clienteYPasaje = new HashMap();
        clientes = new DiccionarioAVL();
        vuelos = new DiccionarioAVL();
    }
    public void cargaInicial() {
        /*Le llega por parametro para escribir en el Log*/
        JSONParser parser = new JSONParser();

        try {
            /*Carga el archivo json*/
            Object obj = parser.parse(new FileReader("./src/TpFinal/Datos.json"));
            JSONObject objeto = (JSONObject) obj;

            //Carga datos de los aeropuertos 
            JSONArray array = (JSONArray) objeto.get("Aeropuerto");
            JSONObject obj1, obj2;
            for (int i = 0; i < array.size(); i++) {
                obj1 = (JSONObject) array.get(i);
                /*Carga los datos del json*/
                aeropuertos.toString();
                altaAeropuerto((String) obj1.get("nomAeronautico"),
                        (String) obj1.get("ciudad"),
                        (long)obj1.get("numTelefono"));
            }

            //Carga datos de los vuelos 
            array = (JSONArray) objeto.get("Vuelo");
            JSONArray arrayAux = (JSONArray) objeto.get("VueloHoy");
            for (int i = 0; i < array.size(); i++) {
                obj1 = (JSONObject) array.get(i);
                /*Carga cada lista de vueloHoy del json*/
                String clave = (String) obj1.get("claveVuelo");
                Lista vuelosHoy = new Lista();
                for (int j = 0; j < arrayAux.size(); j++) {
                    /*Busca los vuelos hoy que tengan la misma clave que el vuelo que vamos a cargar*/
                    obj2 = (JSONObject) arrayAux.get(j);
                    if (clave.equals((String) obj2.get("vuelo"))) {
                        VueloHoy aux = new VueloHoy((String)obj2.get("fecha"),
                                (long) obj2.get("cantAsTotales"),
                                (long) obj2.get("cantAsVendidos"));
                        vuelosHoy.insertar(aux, 1);
                    }
                }
                /*Carga el vuelo con todos sus datos y los vuelos hoy*/
                /*Busco los aeropuertos*/
                Aeropuerto aer1 = buscarAeropuerto((String) obj1.get("origen"));
                Aeropuerto aer2 = buscarAeropuerto((String) obj1.get("destino"));
                altaVuelo(clave,
                        aer1,
                        aer2,
                        (String) obj1.get("horaSalida"),
                        (String) obj1.get("horaLlegada"),
                        vuelosHoy);
            }
            
            
            //Carga de los clientes y su lista de pasajes
            array = (JSONArray) objeto.get("Cliente");
            arrayAux = (JSONArray) objeto.get("Pasaje");
            for (int i = 0; i < array.size(); i++) {
                obj1 = (JSONObject) array.get(i);
                ClaveCliente clave = new ClaveCliente((String)obj1.get("tipoDni"),
                                                        (String)obj1.get("dni"));
                /*Carga cada lista de vueloHoy del json*/
                Lista pasajesCliente = new Lista();
                for (int j = 0; j < arrayAux.size(); j++) {
                    /*Busca los pasajes que tengan la misma clave que el cliente que vamos a cargar*/
                    obj2 = (JSONObject) arrayAux.get(j);
                    ClaveCliente claveAux = new ClaveCliente((String)obj2.get("tipoDni"),
                                                        (String)obj2.get("dni"));
                    if (clave.equals(claveAux)) {
                        /*Busco el vuelo que va a tener el pasaje */
                        Vuelo vueloAux = (Vuelo) vuelos.obtenerDato((String)obj2.get("vuelo"));
                        Pasaje aux = new Pasaje(vueloAux,
                                                (String) obj2.get("fecha"),
                                                (String) obj2.get("numAsiento"),
                                                (String) obj2.get("estado"));
                        pasajesCliente.insertar(aux, 1);
                    }
                }
                /*Carga el cliente con todos sus datos y mapea a su lista de pasajes*/
                altaCliente( clave,
                            (String)obj1.get("nombre"),
                            (String)obj1.get("apellido"),
                            (String)obj1.get("fechaNacimiento"),
                            (String)obj1.get("domicilio"),
                            (long)obj1.get("numTelefono"),
                            pasajesCliente
                            );
            }
            
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }
    }

    public Aeropuerto buscarAeropuerto(String clave) {
        /*Creo un auxiliar de la clase aeropuerto con la misma clave*/
        Aeropuerto aux = new Aeropuerto(clave);
        return (Aeropuerto) aeropuertos.buscarElem(aux);
    }

    //ABM AEROPUERTOS
    public boolean altaAeropuerto(String nomAeronautico, String ciudad, long numTelefono) {
        /*Inserta nuevo aeropuerto al grafo de aeropuertos*/
        return aeropuertos.insertarVertice(new Aeropuerto(nomAeronautico, ciudad, numTelefono));
    }

    public boolean bajaAeropuerto(String nomAeronautico) {
        boolean exito = false;
        /*Crea un aeropuerto auxiliar con mismo nomAeronautico que se quiere borrar*/
        Aeropuerto aux = new Aeropuerto(nomAeronautico);
        /*Elimina el aeropuerto del grafo, si existe*/
        if (aeropuertos.eliminarVertice(aux)) {
            /*Elimina los vuelos con origen o destino del aeropuerto eliminado*/
            bajaVuelosAeropuerto(aux);
            exito = true;
        }
        return exito;
    }

    private void bajaVuelosAeropuerto(Aeropuerto aero) {
        /*Hago una lista de todos los vuelos*/
        Lista list = vuelos.listarDatos();
        Vuelo vuelo;
        /*Recorro la lista eliminando los vuelos que tengan origen o destino el aeropuerto eliminado*/
        for (int i = 1; i < list.longitud(); i++) {
            vuelo = (Vuelo) list.recuperar(i);
            if (vuelo.getOrigen().equals(aero) || vuelo.getDestino().equals(aero)) {
                /*Si encontro, entonces le da de baja al vuelo*/
                bajaVuelo(vuelo.getClaveVuelo());
            }
        }
    }

    public boolean modificarAeropuerto(String nomAeronautico, long numTelefono) {
        boolean exito = false;
        Aeropuerto aux = (Aeropuerto) aeropuertos.buscarElem((new Aeropuerto(nomAeronautico)));
        if (aux != null) {
            aux.setNumTelefono(numTelefono);
            exito = true;
        }
        return exito;
    }
    
    public String mostrarNombresAeronautico(){
        Lista list = aeropuertos.listarEnProfundida();
        String nombres = "Aeropuertos: \n";
        for (int i = 1; i < list.longitud(); i++) {
            nombres += "\t\t"+((Aeropuerto)list.recuperar(i)).getNomAeronautico()+"\n";
        }
        return nombres;
    }

    //ABM VUELOS 
    public boolean altaVuelo(String claveVuelo, Aeropuerto origen, Aeropuerto destino,
            String horaSalida, String horaLlegada, Lista list) {
        boolean exito;
        /*Inserta nuevo vuelo al diccionario AVL de vuelos*/
        int etiquetaDuracion = restarHoras(horaSalida, horaLlegada);
        exito = vuelos.insertar(claveVuelo, new Vuelo(claveVuelo, origen, destino,
                horaSalida, horaLlegada, list,etiquetaDuracion));
        if (exito) {
            aeropuertos.insertarArco(origen, destino, etiquetaDuracion);
        }
        return exito;
    }

    private int restarHoras(String horaSalida, String horaLlegada) {
        /*Los string ya vienen en formato 00:00*/
        int horaSal, minSal, horaLle, minLle, result;
        /*Guarda la hora de salida*/
        horaSal = Integer.parseInt(horaSalida.substring(0, 2));
        /*Guarda los minutos de salida*/
        minSal = Integer.parseInt(horaSalida.substring(3));
        /*Guarda la hora de llegada*/
        horaLle = Integer.parseInt(horaLlegada.substring(0, 2));
        /*Guarda los minutos de llegada*/
        minLle = Integer.parseInt(horaLlegada.substring(3));
        /*Resta las horas*/
        if (horaSal > horaLle) {
            result = Math.abs(horaSal - horaLle - 24);
        } else {
            result = horaLle - horaSal;
        }
        /*Calcula en min el resultado*/
        result = result * 60;
        /*Resta los minutos*/
        int minResult = minLle - minSal;
        result = result + minResult;
        return result;
    }

    public boolean bajaVuelo(String clave) {
        boolean exito = false;
        Vuelo vuelo = new Vuelo(clave);
        /*Elimino del diccionario al vuelo que tenga la misma clave, si existen*/
        if(vuelos.eliminar(clave)){
            /*Si lo encontro, elimina a los pasajes que estan relacionados con ese vuelo*/
            eliminarPasajesDeVuelo(vuelo);
            exito = true;
        }
        return exito;
    }
    
    public void eliminarPasajesDeVuelo(Vuelo unVuelo){
        /*Carga en una lista, la clave de todos los clientes*/
        Lista listClientes = clientes.listarClaves();
        Lista pasajes;
        for (int i = 1; i < listClientes.longitud(); i++) {
           /*Por cada cliente, pide su lista de pasajes*/
           pasajes =(Lista)clienteYPasaje.get(listClientes.recuperar(i));
           /*Cambia el pasaje a cancelado, nose si hay una forma mas eficiente de hacerlo*/
            for (int j = 1; j < pasajes.longitud(); j++) {
                Pasaje aux = (Pasaje)pasajes.recuperar(j);
                if(aux.getVuelo().equals(unVuelo) && !yaPasoFecha(aux.getFecha())){
                    aux.setEstado("Cancelado");
                }
            }
        }
    }

    public boolean modificarVuelo(String claveVuelo,String horaSalida, String horaLlegada) {
        boolean exito = false;
        /*Busca el vuelo*/
        Vuelo aux =(Vuelo) vuelos.obtenerDato(claveVuelo);
        if(aux != null){
            /*Cambia las horas de salida y llegada del vuelo*/
            aux.setHoraSalida(horaSalida);
            aux.setHoraLlegada(horaLlegada);
            /*Saca el arco y pone uno nuevo actualizando la etiqueta*/
            int duracionEstimada = restarHoras(horaSalida,horaLlegada);
            aeropuertos.eliminarArco(aux.getOrigen(), aux.getDestino());
            aeropuertos.insertarArco(aux.getOrigen(), aux.getDestino(),duracionEstimada);
            aux.setDuracionEstimada(duracionEstimada);
            exito = true;
        }
        return exito;
    }

    public boolean crearVueloHoy(String claveVuelo, String fechaSalida, long cantidadAsTotales) {
        boolean exito = false;
        Vuelo vuelo =(Vuelo) vuelos.obtenerDato(claveVuelo);
        if(vuelo != null){
           vuelo.getListaVuelos().insertar(new VueloHoy(fechaSalida,cantidadAsTotales), 1);
           exito = true;
        }
        return exito;
    }
    
    public String mostrarVuelosHoy(String clave){
        String vuelosHoy = "";
        Vuelo vuelo = (Vuelo) vuelos.obtenerDato(clave);
        Lista list = vuelo.getListaVuelos();
        if (!list.esVacia()) {
            vuelosHoy = list.toString();
        }
        return vuelosHoy;
    }

    public String mostrarVuelosHoyVigentes(String clave) {
        String vuelosHoy = "";
        Vuelo vuelo = (Vuelo) vuelos.obtenerDato(clave);
        if (vuelo != null) {
            Lista list = vuelo.getListaVuelos();
            if (!list.esVacia()) {
                for (int i = 1; i <= list.longitud(); i++) {
                    if (!yaPasoFecha(((VueloHoy) list.recuperar(i)).getFecha())) {
                        vuelosHoy += list.recuperar(i).toString();
                    }
                }
            }
        }
        return vuelosHoy;
    }

    public String mostrarClavesVuelo(){
        String claves;
        Lista aux = (Lista) vuelos.listarClaves();
        claves = "Vuelos: \n";
        for (int i = 1; i < aux.longitud(); i++) {
            claves+= "\t\t"+aux.recuperar(i)+"\n";
        }
        return claves; 
    }

    //ABM Cliente
    public boolean altaCliente(ClaveCliente clave, String nombre, String apellido,
            String fechaNacimiento, String domicilio, long numTelefono, Lista list) {
        boolean exito;
        /*Crea al cliente*/
        Cliente cliente = new Cliente(clave, nombre, apellido, fechaNacimiento, domicilio, numTelefono);
        /*Inserta nuevo cliente al diccionario AVL de clientes*/
        exito = clientes.insertar(clave, cliente);
        if (exito) /*Mapea al cliente con su lista de pasajes*/ {
            clienteYPasaje.put(clave, list);
        }
        return exito;
    }

    public boolean bajaCliente(ClaveCliente clave){
        boolean exito = false;
        /*Elimina al cliente de la lista*/
        if(clientes.eliminar(clave)){
            exito = true;
            bajarPasajesCliente(clave);
        }
        return exito;
    }
    
    private void bajarPasajesCliente(ClaveCliente clave) {
        boolean fechaEncontrada = false;
        Lista list = (Lista) clienteYPasaje.get(clave), aux;
        Vuelo vuelo;
        String fechaAux;
        int i = 1;
        while (!list.esVacia()) {
            /*Saca pasaje de la lista*/
            Pasaje pasaje = (Pasaje) list.recuperar(1);
            /*Elimina el pasaje*/
            list.eliminar(1);
            if (!(pasaje.getEstado().equals("Cancelado")) && !yaPasoFecha(pasaje.getFecha())) {
                /*Busca el vuelo del pasaje y suma asiento a su vuelo hoy*/
                vuelo = pasaje.getVuelo();
                aux = vuelo.getListaVuelos();
                while(!fechaEncontrada){
                    fechaAux = ((VueloHoy)aux.recuperar(i)).getFecha();
                    if(fechaAux.equals(pasaje.getFecha())){
                        ((VueloHoy)aux.recuperar(i)).canceloPasaje();
                        fechaEncontrada = true;
                    }
                    i++;
                }
            }
        }
        /*Elimina al cliente del hash*/
        clienteYPasaje.remove(clave);
    }
    
    public boolean modificarCliente(ClaveCliente clave,int opcion,Object modificacion){
        boolean exito = false;
        Cliente aux = (Cliente) clientes.obtenerDato(clave);
        if(aux != null){
            /*Cambia el dato del cliente segun la opcion elegida*/
            switch(opcion){
                case 1:
                    aux.setNombre((String) modificacion);
                break;
                case 2:
                    aux.setApellido((String) modificacion);
                break;
                case 3:
                    aux.setDomicilio((String) modificacion);
                break;
                case 4:
                    aux.setNumTelefono((long) modificacion);
            }
            exito = true;
        }
        return exito;
    }
    
    public String mostrarClavesCliente(){
        String claves;
        Lista aux = (Lista) clientes.listarClaves();
        claves = "Clientes: \n";
        for (int i = 1; i < aux.longitud(); i++) {
            claves+= "\t\t"+aux.recuperar(i)+"\n";
        }
        return claves;
    }
    
    //ABM Pasaje
    public boolean altaPasaje(ClaveCliente clave, String fecha, String claveVuelo, String numAsiento) {
        boolean exito = false;
        Vuelo vuelo = (Vuelo) vuelos.obtenerDato(claveVuelo);
        if (vuelo != null) {
            VueloHoy vueloHoy = buscarVueloHoy(vuelo, fecha);
            if (vueloHoy!=null && vueloHoy.getFecha().equals(fecha)) {
                /*Verifica que no se hayan vendido todos los vuelos*/
                if (vueloHoy.getCantAsTotales() - vueloHoy.getCantAsVendidos() > 0 && !yaPasoFecha(vueloHoy.getFecha())) {
                    Lista list = (Lista) clienteYPasaje.get(clave);
                    list.insertar(new Pasaje(vuelo, vueloHoy.getFecha(), numAsiento), 1);
                    vueloHoy.vendioPasaje();
                    exito = true;
                }
            }
        }
        return exito;
    }

    private VueloHoy buscarVueloHoy(Vuelo vuelo, String fecha) {
        Lista list = vuelo.getListaVuelos();
        VueloHoy vueloHoy = null;
        int i = 1;
        boolean encontrado = false;
        while (i < list.longitud() && !encontrado) {
            VueloHoy aux = (VueloHoy) list.recuperar(i);
            if (aux.getFecha().equals(fecha)) {
                vueloHoy = aux;
                encontrado = true;
            }
            i++;
        }
        return vueloHoy;
    }

    public boolean bajaPasaje(ClaveCliente claveCliente, String codVuelo, String fecha) {
        /*Verifica que no se haya volado el pasaje o que ya se haya cancelado*/
        boolean exito = false;
        Lista list = (Lista) clienteYPasaje.get(claveCliente);
        if (list != null) {
            Pasaje pasaje = buscarPasaje(claveCliente, codVuelo, fecha);
            if (pasaje !=null &&(!pasaje.getEstado().equals("Volado") || !pasaje.getEstado().equals("Cancelado"))) {
                if (!yaPasoFecha(pasaje.getFecha())) {
                    int i = 1;
                    Vuelo aux = pasaje.getVuelo();
                    pasaje.setEstado("Cancelado");
                    Lista listaVuelos = aux.getListaVuelos();
                    boolean encontrado = false;
                    /*Busca los vuelos de hoy de la lista de Vuelo*/
                    while (i <= listaVuelos.longitud() && !encontrado) {
                        VueloHoy vuelHoy = (VueloHoy) listaVuelos.recuperar(i);
                        if (vuelHoy.getFecha().equals(pasaje.getFecha())) {
                            vuelHoy.canceloPasaje();
                            encontrado = true;
                        }
                        i++;
                    }
                    exito = true;
                } else {
                    pasaje.setEstado("Volado");
                }
            }
        }
        return exito;
    }

    private Pasaje buscarPasaje(ClaveCliente claveCL,String vuelo,String fecha){
        Pasaje pasaje = null;
        Lista list = (Lista)clienteYPasaje.get(claveCL);
        if(list != null){
            boolean encontrado = false;
            int i = 1;
            while(i<= list.longitud()&& !encontrado){
                Pasaje aux =(Pasaje) list.recuperar(i);
                if(aux.getVuelo().getClaveVuelo().equals(vuelo) && aux.getFecha().equals(fecha)){
                    pasaje = aux;
                    encontrado = true;
                }
                i++;
            }
        }
        return pasaje;
    }

    private boolean yaPasoFecha(String fecha) {
        /*Metodo que devuelve si ya paso una fecha guardada como String en formato dd/mm/yyyy*/
        int dia, mes, año;
        dia = Integer.parseInt(fecha.substring(0, 2));
        mes = Integer.parseInt(fecha.substring(3, 5));
        año = Integer.parseInt(fecha.substring(6));
        LocalDate aux = LocalDate.of(año, mes, dia);
        return aux.isBefore(LocalDate.now());
    }

    public boolean modificarPasaje(ClaveCliente claveCliente, String codVuelo, String fecha, String modificacion) {
        boolean encontrado = false;
        Pasaje pasaje = buscarPasaje(claveCliente, codVuelo, fecha);
        if (pasaje != null && (!pasaje.getEstado().equals("Volado") || !pasaje.getEstado().equals("Cancelado"))) {
            if (!yaPasoFecha(pasaje.getFecha())) {
                pasaje.setNumAsiento(modificacion);
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    public String mostrarPasajes(ClaveCliente clave){
        Lista list = (Lista) clienteYPasaje.get(clave);
        return list.toString();
    }

    //Consultas clientes
    public String contactoCliente(ClaveCliente clave){
        String info = "No existe el cliente";
        Cliente cliente =(Cliente) clientes.obtenerDato(clave);
        if(cliente!=null){
            /*Carga la informacion de contacto del cliente*/
            info= "Informacion de contacto del cliente: "+cliente.getApellido()+" "+cliente.getNombre()+"\n";
            info+="Tipo DNI: "+clave.getTipo()+"\n";
            info+="Numero DNI: "+clave.getNumDni()+"\n";
            info+="Numero telefono: "+cliente.getNumTelefono()+"\n";
            info+="Pasajes pendientes a volar: \n";
            /*Carga la lista de pasajes del cliente*/
            Lista listaPasajes =(Lista) clienteYPasaje.get(clave);
            for (int i = 1; i < listaPasajes.longitud(); i++) {
                /*Busca cuales vuelos todavia estan pendientes*/
                Pasaje pasaje =(Pasaje) listaPasajes.recuperar(i);
                if(pasaje.getEstado().equals("Pendiente") && !yaPasoFecha(pasaje.getFecha())){
                    /*Verifica que los vuelos sigan pendientes y que su fecha no haya pasado*/
                    info+=pasaje.toString();
                }else{
                    if(pasaje.getEstado().equals("Pendiente") && yaPasoFecha(pasaje.getFecha()))
                        /*Si sigue pendiente pero su fecha ya paso entonces el vuelo fue Volado*/
                        pasaje.setEstado("Volado");
                }
            }
        }
        return info;
    }
    
    public String ciudadesVisitadas(ClaveCliente clave){
        String info = "No existe el cliente";
        Cliente cliente =(Cliente) clientes.obtenerDato(clave);
        if(cliente!=null){
            Lista listaPasajes = (Lista) clienteYPasaje.get(clave);
            info="Ciudades visitadas: ";
            /*Busca los pasajes que ya fueron volados*/
            for (int i = 1; i < listaPasajes.longitud(); i++) {
                Pasaje pasaje = (Pasaje) listaPasajes.recuperar(i);
                if(pasaje.getEstado().equals("Volado"))
                    /*Guarda la ciudad destino del vuelo*/
                    info += pasaje.getVuelo().getDestino().getCiudad() + ",";
            }
        }
        return info;
    }

    /*Consultas sobre vuelos*/
    public String informacionVueloHoy(String claveVuelo, String fecha) {
        String info = "No existe el Vuelo";
        Vuelo vuelo = (Vuelo) vuelos.obtenerDato(claveVuelo);
        if (vuelo != null) {
            info = "El vuelo: "+claveVuelo+" no hace vuelos en esa fecha";
            /*Uso una variable para saber si el vuelo tiene vuelos en esa fecha*/
            boolean tiene = false;
            Lista list = vuelo.getListaVuelos();
            for (int i = 1; i < list.longitud(); i++) {
                VueloHoy vueloHoy = (VueloHoy)list.recuperar(i);
                /*Verifica la fecha del vuelo hoy*/
                if(vueloHoy.getFecha().equals(fecha)){
                    info+= vueloHoy.toString();
                    tiene = true;
                }
            }
            if(tiene){
                /*Como tiene vuelos en la fecha, retorno la informacion del vuelo
                  con la info de los vuelos de ese dia
                */
                info = vuelo.toStringSinLista()+info;
            }
        }
        return info;
    }
    
    public String rangoVuelos(String clave1,String clave2){
        return ((Lista)(vuelos.listarRango(clave1, clave2))).toString();
    }
    
    /*Consultas sobre Aeropuertos*/
    public boolean maximoXVuelos(String aero1,String aero2,int max){
        Aeropuerto aeropuerto1 = new Aeropuerto(aero1);
        Aeropuerto aeropuerto2 = new Aeropuerto(aero2);
        boolean existe = aeropuertos.existeCaminoConX(aeropuerto1,aeropuerto2, max);
        return existe;
    }
    
    public Lista menosTiempo(String aero1,String aero2){
        Aeropuerto aeropuerto1 = new Aeropuerto(aero1);
        Aeropuerto aeropuerto2 = new Aeropuerto(aero2);
        return aeropuertos.caminoMasCortoEtiquetas(aeropuerto1, aeropuerto2);
    }
    
    public Lista caminoMasCorto(String aero1,String aero2){
        Aeropuerto aeropuerto1 = new Aeropuerto(aero1);
        Aeropuerto aeropuerto2 = new Aeropuerto(aero2);
        return aeropuertos.caminoMasCorto(aeropuerto1,aeropuerto2);
    }
    
    public Lista caminoQuePasaPorAero(String aero1,String aero2, String pasaPorAero){
        Lista list = new Lista();
        Aeropuerto origen = new Aeropuerto(aero1);
        Aeropuerto destino = new Aeropuerto(aero2);
        Aeropuerto medio = new Aeropuerto(pasaPorAero);
        return aeropuertos.caminoTresVertices(origen,destino,medio);
    }
    
    /*Promocion a clientes fieles*/
    public Lista promocion(){
        AVL aux = new AVL();
        int cantPasajes;
        Lista listClientes,listaPasajes;
        listClientes = clientes.listarClaves();
        ClaveCliente clave;
        for (int i = 1; i <= listClientes.longitud(); i++) {
            /*Calcula y guarda la cantidad de pasajes que tiene cada cliente*/
            clave = (ClaveCliente) listClientes.recuperar(i);
            /*Busca la lista de pasajes del cliente*/
            listaPasajes =(Lista) clienteYPasaje.get(clave);
            /*Guarda la cantidad de pasajes comprados*/
            cantPasajes = listaPasajes.longitud();
            aux.insertar(new ClientePromocion(cantPasajes,clave));
        }
        return aux.listar();
    }
    
    public String mostrarSistema(){
        String estado;
        estado = "===== ESTADO DEL SISTEMA =====\n";
        estado += "----AEROPUERTOS----\n";
        estado += aeropuertos.toString()+"\n";
        estado += "----VUELOS----\n";
        estado += vuelos.toStringConDatos()+"\n";
        estado += "----CLIENTES----\n";
        estado += clientes.toStringConDatos()+"\n";
        estado += "CLIENTE CON SUS PASAJES\n";
        estado+=clienteYPasaje.toString();
        
        return estado;
    }


}
