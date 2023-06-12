/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpFinal;

import Liniales.dinamica.Lista;
import Proposito_especifico.DiccionarioAVL;
import Utiles.TecladoIn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author repetto.francisco
 */
public class EntradaSalida {

    private BufferedWriter bw;
    private SistemaViajes sistema;

    public EntradaSalida() throws IOException {
        /*Creo que documento LOG*/
        File log = new File("C:\\Users\\Usuario\\Documents\\Tp final Estructura\\ log.txt");
        FileWriter fw = new FileWriter(log.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        /*Creo el sistema*/
        sistema = new SistemaViajes();
    }

    public void ejecutar() throws IOException{
        bw.write("@@@@@@@@@@@@@@@@@@@@@@@@ SISTEMA DE VIAJES @@@@@@@@@@@@@@@@@@@@@@@@\n\n");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ SISTEMA DE VIAJES @@@@@@@@@@@@@@@@@@@@@@@@");
        /*Hace la carga inicial de los datos*/
        sistema.cargaInicial();
        bw.write(sistema.mostrarSistema());
        System.out.println("Se realizo carga inicial");
        /*LLama al menu*/
        bw.write("\n\n\n###################### OPERACIONES ######################\n");
        menu();
        bw.write("###################### FIN OPERACIONES ######################\n\n\n");
        bw.write(sistema.mostrarSistema());
        bw.close();
    }

    private void menu() throws IOException {
        boolean salir = false;
        System.out.println("''''''''MENU''''''''");
        while (!salir) {
            System.out.println("Seleccione una opcion:\n"
                    + "1. ABM (Altas-Bajas-Modificaciones) de aeropuertos\n"
                    + "2. ABM (Altas-Bajas-Modificaciones) de clientes\n"
                    + "3. ABM (Altas-Bajas-Modificaciones) de vuelos\n"
                    + "4. ABM (Altas-Bajas-Modificaciones) de pasajes\n"
                    + "5. Consultas sobre clientes\n"
                    + "6. Consultas sobre vuelos\n"
                    + "7. Consultas sobre tiempos de viaje\n"
                    + "8. Promocion\n"
                    + "9. Mostrar Sistema\n"
                    + "10. Salir\n");
            switch (leerNumero()) {
                case 1:
                    abmAeropuertos();
                    break;
                case 2:
                    abmClientes();
                    break;
                case 3:
                    abmVuelos();
                    break;
                case 4:
                    abmPasaje();
                    break;
                case 5:
                    consultasClientes();
                    break;
                case 6:
                    consultasVuelos();
                    break;
                case 7:
                    consultasTiempoViaje();
                    break;
                case 8:
                    promocion();
                    break;
                case 9:
                    System.out.println(sistema.mostrarSistema() + "\n");
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("No se selecciono ninguna opcion");
                    break;
            }
        }
    }

    private int leerNumero() {
        Integer i = null;
        while (i == null) {
            try {
                i = TecladoIn.readInt();
            } catch (Exception e) {
                System.err.println("Ingrese un valor numerico");
            }
        }
        return i;
    }

    private void abmAeropuertos() throws IOException {
        String nomAero;
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Alta Aeropuerto\n"
                    + "2. Baja Aeropuerto\n"
                    + "3. Modificar Aeropuerto\n"
                    + "4. Mostrar nombres Aeronauticos\n"
                    + "5. Salir");
            switch (leerNumero()) {
                case 1:
                    System.out.println("Ingrese nombre Aeronautico del nuevo Aeropuerto (3 caracteres)");
                    nomAero = ingresoNomAeronautico();
                    /*Verifico que el nombre aeronatico ingresado cumpla que tenga una longitud de 3 caracteres*/
                    if (!nomAero.equals("")) {
                        System.out.println("Ingrese ciudad del nuevo Aeropuerto");
                        String ciudad = TecladoIn.readLine();
                        System.out.println("Ingrese numero de telefono del Aeropuerto");
                        long numTelefono = TecladoIn.readLong();
                        if (sistema.altaAeropuerto(nomAero, ciudad, numTelefono)) {
                            System.out.println("Se creo el Aeropuerto " + nomAero + "\n");
                            bw.write("Se creo el Aeropuerto " + nomAero + "\n");
                        } else {
                            System.out.println("Ya existe un Aeropuerto con el nombre Aeronautico " + nomAero + "\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese nombre Aeronautico del Aeropuerto a borrar");
                    nomAero = ingresoNomAeronautico();
                    if (!nomAero.equals("")) {
                        if (sistema.bajaAeropuerto(nomAero)) {
                            System.out.println("Se elimino el Aeropuerto " + nomAero + "\n");
                            bw.write("Se elimino el Aeropuerto " + nomAero + "\n");
                        } else {
                            System.out.println("No existe un Aeropuerto con el nombre Aeronautico " + nomAero);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese nombre Aeronautico del Aeropuerto a modificar");
                    nomAero = ingresoNomAeronautico();
                    if (!nomAero.equals("")) {
                        System.out.println("Ingrese numero de telefono nuevo");
                        long numTelefono = TecladoIn.readLong();
                        if (sistema.modificarAeropuerto(nomAero, numTelefono)) {
                            System.out.println("Se modificó el Aeropuerto " + nomAero + " ,el numero de telefono a " + numTelefono + "\n");
                            bw.write("Se modificó el Aeropuerto " + nomAero + " ,el numero de telefono a " + numTelefono + "\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println(sistema.mostrarNombresAeronautico());
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("No se seleccionó una opcion");
                    break;
            }
        }
    }

    private String ingresoNomAeronautico() {
        String nom = TecladoIn.readLine();
        if (nom.length() == 3) {
            char[] ch = nom.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (Character.isDigit(ch[i])) {
                    nom = "";
                }
            }
            if(!nom.equals("")){
                nom = nom.toUpperCase();
            }else{
                System.out.println("El nombre Aeronatico ingresado tiene numeros");
            }
        } else {
            System.out.println("El nombre Aeronautico ingresado no tiene una longitud de 3 caracteres");
            nom = "";
        }
        return nom;
    }
    

    private void abmClientes() throws IOException {
        boolean salir = false;
        ClaveCliente clave;
        while (!salir) {
            System.out.println("1. Alta Cliente\n"
                    + "2. Baja Cliente\n"
                    + "3. Modificar Cliente\n"
                    + "4. Mostrar tipo y numero de DNI de los clientes\n"
                    + "5. Salir");
            switch (leerNumero()) {
                case 1:
                    clave = ingresoClaveCliente();
                    System.out.println("Ingrese el nombre del nuevo Cliente");
                    String nombre = TecladoIn.readLine();
                    System.out.println("Ingrese el apellido del nuevo Cliente");
                    String apellido = TecladoIn.readLine();
                    System.out.println("Ingrese la fecha de Nacimiento del nuevo Cliente (formato dd/mm/yyyy)");
                    String fechaNacimiento = TecladoIn.readLine();
                    if (esFecha(fechaNacimiento)) {
                        System.out.println("Ingrese el domicilio del nuevo Cliente");
                        String domicilio = TecladoIn.readLine();
                        System.out.println("Ingrese el nuevo numero de telefono del nuevo Cliente");
                        long numTelefono = TecladoIn.readLong();
                        if (sistema.altaCliente(clave, nombre, apellido, fechaNacimiento,
                                domicilio, numTelefono, new Lista())) {
                            System.out.println("Se creo el Cliente " + clave.getTipo() + " " + clave.getNumDni());
                            bw.write("Se creo el Cliente " + clave.getTipo() + " " + clave.getNumDni());
                        } else {
                            System.out.println("Ya existe un Cliente con tipo y numero de DNI " + clave.getTipo() + " " + clave.getNumDni());
                        }
                    } else {
                        System.out.println("No se ingreso una fecha de Nacimiento valida");
                    }
                    break;
                case 2:
                    clave = ingresoClaveCliente();
                    if (sistema.bajaCliente(clave)) {
                        System.out.println("Se elimino al Cliente " + clave.getTipo() + " " + clave.getNumDni());
                        bw.write("Se elimino al Cliente " + clave.getTipo() + " " + clave.getNumDni()+ "\n");
                    } else {
                        System.out.println("No existe un Cliente " + clave.getTipo() + " " + clave.getNumDni());
                    }
                    break;
                case 3:
                    clave = ingresoClaveCliente();
                    System.out.println("Que tipo de modificacion quiere hacer sobre el cliente: \n"
                            + "\t\t\t\t\t\t\t1. Nombre \n"
                            + "\t\t\t\t\t\t\t2. Apellido \n"
                            + "\t\t\t\t\t\t\t3. Domicilio \n"
                            + "\t\t\t\t\t\t\t4. Numero de Telefono \n");
                    ;
                    int opcion = leerNumero();
                    System.out.println("Ingrese la nueva informacion: ");
                    String modificacion = TecladoIn.readLine();
                    if (sistema.modificarCliente(clave, opcion, modificacion)) {
                        System.out.println("Se realizo al Cliente " + clave.getTipo() + " " + clave.getNumDni()+ " la modificacion: " + modificacion);
                        bw.write("Se realizo al Cliente " + clave.getTipo() + " " + clave.getNumDni()+ " la modificacion: " + modificacion);
                    } else {
                        System.out.println("No existe un Cliente " + clave.getTipo() + " " + clave.getNumDni());
                    }
                    break;
                case 4:
                    System.out.println(sistema.mostrarClavesCliente());
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("No se selecciono una opcion");
            }
        }
    }

    private ClaveCliente ingresoClaveCliente() {
        System.out.println("Ingrese el tipo de DNI del Cliente");
        String tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de DNI del Cliente");
        String numDni = TecladoIn.readLine();
        return new ClaveCliente(tipoDni,numDni);
    }

    private boolean esFecha(String fecha) {
        /*Metodo para verficar si el String ingresado es una fecha en formato dd/mm/yyyy*/
        boolean es = false;
        int dia, mes, año;
        dia = Integer.parseInt(fecha.substring(0, 2));
        mes = Integer.parseInt(fecha.substring(3, 5));
        año = Integer.parseInt(fecha.substring(6));
        if ((0 < dia && dia < 32) && (0 < mes && mes < 13) && (1900 < año && año <= LocalDate.now().getYear())) {
            es = true;
        }
        return es;
    }

    private void abmVuelos() throws IOException {
        boolean salir = false;
        String claveVuelo;
        while (!salir) {
            System.out.println("1. Alta Vuelo\n"
                    + "2. Baja Vuelo\n"
                    + "3. Modificar Vuelo\n"
                    + "4. Crear fecha de Salida de un Vuelo\n"
                    + "5. Mostrar las fechas de salida de un Vuelo\n"
                    + "6. Mostrar codigo de vuelo de los vuelos\n"
                    + "7. Salir");
            switch (leerNumero()) {
                case 1:
                    System.out.println("Ingrese el codigo del Vuelo nuevo (Dos letras y 4 numeros)");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        System.out.println("Ingrese el nombre Aeronautico del Aeropuerto Origen");
                        String a1 = ingresoNomAeronautico();
                        Aeropuerto aero1 = sistema.buscarAeropuerto(a1);
                        System.out.println("Ingrese el nombre Aeronautico del Aeropuerto Destino");
                        String a2 = ingresoNomAeronautico();
                        Aeropuerto aero2 = sistema.buscarAeropuerto(a2);
                        if (aero1 != null && aero2 != null) {
                            System.out.println("Ingrese la hora de salida");
                            String horaSal = TecladoIn.readLine();
                            System.out.println("Ingrese la hora de llegada");
                            String horaLlega = TecladoIn.readLine();
                            if (sonHora(horaSal, horaLlega)) {
                                if (sistema.altaVuelo(claveVuelo, aero1, aero2, horaSal, horaLlega, new Lista())) {
                                    System.out.println("Se creo el Vuelo " + claveVuelo);
                                    bw.write("Se creo el Vuelo " + claveVuelo);
                                } else {
                                    System.out.println("Ya existe un Vuelo con el codigo " + claveVuelo);
                                }
                            } else {
                                System.out.println("La hora " + horaSal + " o " + horaLlega + " no es valida");
                            }
                        } else {
                            System.out.println("El aeropuerto " + a1 + " o " + a2 + " no existe");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del Vuelo a borrar (Dos letras y 4 numeros)");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        if (sistema.bajaVuelo(claveVuelo)) {
                            System.out.println("Se elimino el Vuelo " + claveVuelo);
                            bw.write("Se elimino el Vuelo " + claveVuelo + "\n");
                        } else {
                            System.out.println("No existe el Vuelo " + claveVuelo);
                        }
                    }
                case 3:
                    System.out.println("Ingrese el codigo de vuelo a modificar");
                    claveVuelo = ingresarClaveVuelo();;
                    if (!claveVuelo.equals("")) {
                        System.out.println("Ingrese la nueva hora de salida");
                        String horaSalida = TecladoIn.readLine();
                        System.out.println("Ingrese la nueva hora de llegada");
                        String horaLlegada = TecladoIn.readLine();
                        if (sonHora(horaSalida, horaLlegada)) {
                            if (sistema.modificarVuelo(claveVuelo, horaSalida, horaLlegada)) {
                                System.out.println("Se realizo al Vuelo " + claveVuelo + " la modificacion de"
                                        + " la nueva hora de salida: " + horaSalida + " y la nueva hora de Llegada: " + horaLlegada);
                            }
                        } else {
                            System.out.println("La hora " + horaSalida + " o " + horaLlegada + " no es valida");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el codigo del Vuelo que quiere crear una fecha");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        System.out.println("Ingrese la fecha de salida en formato dd/mm/yyyy");
                        String fecha = TecladoIn.readLine();
                        if (esFecha(fecha)) {
                            System.out.println("Ingrese la cantidad de asientos totales que tiene el vuelo");
                            long cant = TecladoIn.readLong();
                            if (sistema.crearVueloHoy(claveVuelo, fecha, cant)) {
                                System.out.println("Se creo en el Vuelo " + claveVuelo + " la fecha de salida" + fecha);
                                bw.write("Se creo en el Vuelo " + claveVuelo + " la fecha de salida" + fecha);
                            } else {
                                System.out.println("No existe el Vuelo " + claveVuelo);
                            }
                        } else {
                            System.out.println("La fecha " + fecha + " no es valida");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el codigo del Vuelo que quiere ver sus fechas de Salida");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        String vuelosHoy = sistema.mostrarVuelosHoy(claveVuelo);
                        if (vuelosHoy.equals("")) {
                            System.out.println("El Vuelo " + claveVuelo + " no tiene fechas de vuelo");
                        } else {
                            System.out.println(vuelosHoy);
                        }
                    }
                    break;
                case 6:
                    System.out.println(sistema.mostrarClavesVuelo());
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("No se selecciono una opcion");
            }
        }
    }
    
    private String ingresarClaveVuelo(){
        String claveVuelo = TecladoIn.readLine();
        if(claveVuelo.length() == 6){
            claveVuelo = claveVuelo.toUpperCase();
             char[] ch = claveVuelo.toCharArray();
            //Verifica que sean 2 letras y 4 numeros despues de las dos letras
             for (int i = 0; i < ch.length; i++) {
                 if(i<2 && !Character.isDigit(ch[i])){
                     claveVuelo = "";
                 }else
                     System.out.println("No se ingreso con el formato solicitado");
                if(i>=2 && !Character.isDigit(ch[i])){
                    claveVuelo = "";
                }else
                    System.out.println("No se ingreso con el formato solicitado");
            }
        }else
           System.out.println("El codigo de Vuelo ingresado no tiene la longitud solicitada");
        return claveVuelo;
    }

    private boolean sonHora(String horaSalida, String horaLlegada) {
        /*Verifica si las horas ingresadas tienen el formato hh:mm*/
        boolean exito = false;
        if (horaSalida.length() == 5 && horaLlegada.length() == 5) {
            int horaSal, minSal, horaLle, minLle;
            /*Guarda la hora de salida*/
            horaSal = Integer.parseInt(horaSalida.substring(0, 2));
            /*Guarda los minutos de salida*/
            minSal = Integer.parseInt(horaSalida.substring(3));
            /*Guarda la hora de llegada*/
            horaLle = Integer.parseInt(horaLlegada.substring(0, 2));
            /*Guarda los minutos de llegada*/
            minLle = Integer.parseInt(horaLlegada.substring(3));
            if (-1 < horaSal && horaSal < 24 && -1 < horaLle && horaLle < 24
                    && -1 < minSal && minSal < 61 && -1 < minLle && minLle < 61 && horaSalida.contains(":") && horaLlegada.contains(":")) {
                exito = true;
            }
        }
        return exito;
    }

    private void abmPasaje() throws IOException {
        boolean salir = false;
        String tipo, num, claveVuelo, fecha;
        while (!salir) {
            System.out.println("1. Alta Pasaje\n"
                    + "2. Baja Pasaje\n"
                    + "3. Modificar Pasaje\n"
                    + "4. Mostrar Pasajes de Cliente\n"
                    + "5. Salir");
            switch (leerNumero()) {
                case 1:
                    System.out.println("Ingrese el tipo de DNI del cliente que va a comprar un pasaje");
                    tipo = TecladoIn.readLine();
                    System.out.println("Ingrese el DNI del cliente que va a comprar un pasaje ");
                    num = TecladoIn.readLine();
                    System.out.println("Ingrese el codigo de Vuelo (2 letras y 4 numeros)");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        String aux = sistema.mostrarVuelosHoyVigentes(claveVuelo);
                        if (!aux.equals("")) {
                            System.out.println("Estos son los fechas disponibles del Vuelo " + claveVuelo + "\n" + aux);
                            System.out.println("Ingrese la fecha del Vuelo");
                            fecha = TecladoIn.readLine();
                            System.out.println("Ingrese el num de asiento");
                            String numAsiento = TecladoIn.readLine();
                            if (sistema.altaPasaje(new ClaveCliente(tipo, num), fecha, claveVuelo, numAsiento)) {
                                System.out.println("Se creo Pasaje en el cliente " + tipo + " " + num + " del vuelo " + claveVuelo + " en la fecha " + fecha);
                                bw.write("Se creo Pasaje en el cliente " + tipo + " " + num + " del vuelo " + claveVuelo + " en la fecha " + fecha + "\n");
                            } else {
                                System.out.println("No se puede crear el Pasaje y puede ser porque:\n"
                                        + "- No existe el cliente\n"
                                        + "- No existe una fecha de Vuelo como la fecha Ingresada");
                            }
                        } else {
                            System.out.println("El vuelo " + claveVuelo + " no tiene fechas vigentes ");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el tipo de DNI del cliente que a va dar de baja el Pasaje");
                    tipo = TecladoIn.readLine();
                    System.out.println("Ingrese el DNI del cliente que a va dar de baja el Pasaje");
                    num = TecladoIn.readLine();
                    System.out.println("Ingrese el codigo de Vuelo (2 letras y 4 numeros)");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        System.out.println("Ingrese la fecha del Vuelo que tiene el Pasaje");
                        fecha = TecladoIn.readLine();
                        if (sistema.bajaPasaje(new ClaveCliente(tipo, num), claveVuelo, fecha)) {
                            System.out.println("Se dio de baja al Pasaje del cliente " + tipo + " " + num
                                    + " del vuelo " + claveVuelo + " en la fecha " + fecha);
                            bw.write("Se dio de baja al Pasaje del cliente " + tipo + " " + num
                                    + " del vuelo " + claveVuelo + " en la fecha " + fecha+"\n");
                        } else {
                            System.out.println("No se pudo dar de baja al Pasaje por una de estas opciones\n"
                                    + "\t\t\t\t- No existe el cliente " + tipo + " " + num
                                    + "\n\t\t\t\t- No existe el vuelo " + claveVuelo
                                    + "\n\t\t\t\t- No existe la fecha " + fecha + " del vuelo " + claveVuelo
                                    + "\n\t\t\t\t- El cliente no tiene un pasaje con el vuelo " + claveVuelo + " en la fecha " + fecha
                                    + "\n\t\t\t\t- El pasaje ya fue volado o ya habia sido cancelado\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de DNI del cliente que va a modificar el Pasaje");
                    tipo = TecladoIn.readLine();
                    System.out.println("Ingrese el DNI del cliente que va a modificar el Pasaje");
                    num = TecladoIn.readLine();
                    System.out.println("Ingrese el codigo de Vuelo (2 letras y 4 numeros)");
                    claveVuelo = ingresarClaveVuelo();
                    if (!claveVuelo.equals("")) {
                        claveVuelo = claveVuelo.substring(0, 2).toUpperCase() + claveVuelo.substring(2);
                        System.out.println("Ingrese la fecha del Vuelo que tiene el Pasaje");
                        fecha = TecladoIn.readLine();
                        System.out.println("Ingrese el nuevo Numero de Asiento del Pasaje");
                        String numAsiento = TecladoIn.readLine();
                        if (sistema.modificarPasaje(new ClaveCliente(tipo, num), claveVuelo, fecha, numAsiento)) {
                            System.out.println("Se modifico el numero de asiento a " + numAsiento + " del Pasaje de " + tipo + " " + num
                                    + " del vuelo " + claveVuelo + " en la fecha " + fecha);
                            bw.write("Se modifico el numero de asiento a " + numAsiento + " del Pasaje de " + tipo + " " + num
                                    + " del vuelo " + claveVuelo + " en la fecha " + fecha + "\n");
                        } else {
                            System.out.println("No se pudo modificar al Pasaje por una de estas opciones\n"
                                    + "\t\t\t\t- No existe el cliente " + tipo + " " + num
                                    + "\n\t\t\t\t- No existe el vuelo " + claveVuelo
                                    + "\n\t\t\t\t- No existe la fecha " + fecha + " del vuelo " + claveVuelo
                                    + "\n\t\t\t\t- El cliente no tiene un pasaje con el vuelo " + claveVuelo + " en la fecha " + fecha
                                    + "\n\t\t\t\t- El pasaje ya fue volado o ya habia sido cancelado\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el tipo de DNI del cliente que va a modificar el Pasaje");
                    tipo = TecladoIn.readLine();
                    System.out.println("Ingrese el DNI del cliente que va a modificar el Pasaje");
                    num = TecladoIn.readLine();
                    System.out.println("Los pasajes del cliente " + tipo + " " + num + "\n" + sistema.mostrarPasajes(new ClaveCliente(tipo, num)));
                case 5:
                    salir = true;
            }
        }
    }

    private void consultasClientes() {
        System.out.println("Ingrese el tipo de DNI del cliente que va a modificar el Pasaje");
        String tipo = TecladoIn.readLine();
        System.out.println("Ingrese el DNI del cliente que va a modificar el Pasaje");
        String num = TecladoIn.readLine();
        System.out.println("Seleccione una consulta: \n"
                + "1. Contacto del Cliente\n"
                + "2. Ciudades visitadas");
        switch (leerNumero()) {
            case 1:
                System.out.println(sistema.contactoCliente(new ClaveCliente(tipo, num)));
                break;
            case 2:
                System.out.println(sistema.ciudadesVisitadas(new ClaveCliente(tipo, num)));
                break;
            default:
                System.out.println("No se selecciono una opcion");
        }
    }


    private void consultasVuelos() {
        System.out.println("Seleccione una opcion: \n"
                + "1. Mostrar toda la información de un vuelo en una fecha\n"
                + "2. Rango de codigos de vuelo");
        String claveVuelo;
        switch (leerNumero()) {
            case 1:
                System.out.println("Ingrese el codigo del vuelo que quiere ver la informacion (2 letrsa y 4 numeros)");
                claveVuelo = ingresarClaveVuelo();
                if (!claveVuelo.equals("")) {
                    claveVuelo = claveVuelo.substring(0, 2).toUpperCase() + claveVuelo.substring(2);
                    System.out.println("Ingrese la fecha");
                    String fecha = TecladoIn.readLine();
                    System.out.println(sistema.informacionVueloHoy(claveVuelo, fecha));
                }else{
                    System.out.println("No se ingreso un codigo de vuelo con la longitud indicada");
                }

                break;
            case 2:
                System.out.println("Ingrese primer el codigo del vuelo (2 letras y 4 numeros)");
                claveVuelo = ingresarClaveVuelo();
                System.out.println("Ingrese el segundo codigo de vuelo (2 letras y 4 numeros)");
                String claveVuelo2 = ingresarClaveVuelo();
                if (!claveVuelo.equals("") && !claveVuelo2.equals("")) {
                    String sis = sistema.rangoVuelos(claveVuelo, claveVuelo2);
                    if (sis != null) {
                        System.out.println("Rango de vuelos desde "+claveVuelo+" hasta "+claveVuelo2+": "+sis);
                    } else {
                        System.out.println("No se pudo hacer el rango entre los vuelos "+claveVuelo+" y "+claveVuelo2+" porque:\n"
                                        +  "- El vuelo "+claveVuelo+" o el vuelo "+claveVuelo2+" no existe\n"
                                        +  "- El vuelo "+claveVuelo+" no es menor al vuelo "+claveVuelo2);
                    }
                }
                break;
            default:
                System.out.println("No se selecciono una opcion");
        }
        
    }

    private void consultasTiempoViaje() {
        System.out.println("Ingrese el nombre nautico del primer aeropuerto");
        String aero1 = ingresoNomAeronautico();
        System.out.println("Ingrese el nombre nautico del segundo aeropuerto");
        String aero2 = ingresoNomAeronautico();
        System.out.println("Seleccione una opcion: \n"
                        +  "1. Verificar si existe camino desde  "+aero1+" a "+aero2+" en menos escalas que un numero X\n"
                        +  "2. Buscar camino desde  "+aero1+" a "+aero2+" en menos tiempo\n"
                        +  "3. Buscar camino desde  "+aero1+" a "+aero2+" en menos escalas\n"
                        +  "4. Buscar camino desde  "+aero1+" a "+aero2+" pasando por un aeropuerto X\n");
        switch(leerNumero()){
            case 1:
                System.out.println("Ingrese el numero maximo de escalas entre los aeropuertos");
                int max = leerNumero();
                if(sistema.maximoXVuelos(aero1, aero2, max)){
                    System.out.println("SI existe un camino desde "+aero1+" a "+aero2+
                            " en menos o igual "+max+" escaladas");
                }else{
                    System.out.println("NO existe un camino desde "+aero1+" a "+aero2+""
                            + " en menos o igual "+max+" escaladas");
                }
                break;
            case 2:
                Lista list = sistema.menosTiempo(aero1, aero2);
                if(!list.esVacia()){
                    System.out.print("El camino en menos tiempo entre " + aero1 + " y " + aero2 + " es: [");
                    for (int i = 1; i <= list.longitud(); i++) {
                        System.out.print(" "+((Aeropuerto)list.recuperar(i)).getNomAeronautico()+",");
                    }
                    System.out.println(" ]");
                }else{
                    System.out.println("No se pudo hayar camino mas corto de " + aero1 + " a " + aero2
                            + " por alguna de estas razones\n"
                            + "- Uno o ambos aeropuertos no existen\n"
                            + "- No existe camino entre " + aero1 + " y " + aero2);
                }
                    break;
            case 3:
                Lista aux = sistema.caminoMasCorto(aero1, aero2);
                if (!aux.esVacia()) {
                    System.out.print("El camino en menos escalas entre " + aero1 + " y " + aero2 + " es: [");
                    for (int i = 1; i <= aux.longitud(); i++) {
                        System.out.print(" "+((Aeropuerto)aux.recuperar(i)).getNomAeronautico()+",");
                    }
                    System.out.println(" ]");
                } else {
                    System.out.println("No se pudo hayar camino de menos escalas de " + aero1 + " a " + aero2
                            + " por alguna de estas razones\n"
                            + "- Uno o ambos aeropuertos no existen\n"
                            + "- No existe camino entre " + aero1 + " y " + aero2);
                }
                break;
            case 4:
                System.out.println("Ingrese el nombre nautico por el tercer aeropuerto que tienen que pasar");
                String aero3 = ingresoNomAeronautico();
                list = sistema.caminoQuePasaPorAero(aero1, aero2, aero3);
                if (!list.esVacia()) {
                    System.out.print("El camino entre " + aero1 + " y " + aero2 + " que pasa por "+aero3+" es: [");
                    for (int i = 1; i <= list.longitud(); i++) {
                        System.out.print(" "+((Aeropuerto)list.recuperar(i)).getNomAeronautico()+",");
                    }
                    System.out.println(" ]");
                } else {
                    System.out.println("No se pudo hayar camino entre  " + aero1 + " a " + aero2
                            + " pasando por "+aero3+"  por alguna de estas razones\n"
                            + "- Almenos uno de estos aeropuertos no existen\n"
                            + "- No existe camino entre " + aero1 + " y " + aero2+" pasando por "+aero3);
                }
        }
    }

    private void promocion() {
        System.out.println("Promocion a clientes fieles: ");
        Lista list = sistema.promocion();
        /*Me da la lista ordenada de menor a mayor entonces la recorro en orden inverso*/
        for (int i = list.longitud(); i >= 1; i--) {
            System.out.println("\t\t\t\t"+list.recuperar(i));
        }
    }
    

    
}
